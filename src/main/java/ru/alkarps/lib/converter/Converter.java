package ru.alkarps.lib.converter;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alkarps on 11.12.2015.
 */
public class Converter {

    public static <T> T convert(Object in, Class<T> outClass) throws ConverterException {
        try {
            Object out = outClass.newInstance();
            return convert(in, in.getClass(), out, outClass);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ConverterException(e.getMessage(), e);
        }
    }

    private static <In, Out> Out convert(Object in, Class<In> inClass,
                                         Object out, Class<Out> outClass) throws ConverterException {
        if (!inClass.getSuperclass().equals(Object.class) && !outClass.getSuperclass().equals(Object.class)) {
            out = outClass.cast(convert(inClass.getSuperclass().cast(in),
                    inClass.getSuperclass(), outClass.getSuperclass().cast(out), outClass.getSuperclass()));
        }
        for (Field inField : inClass.getDeclaredFields()) {
            try {
                Field outField = outClass.getDeclaredField(inField.getName());
                inField.setAccessible(true);
                outField.setAccessible(true);
                if (inField.getType().equals(List.class) && inField.get(in) != null) {
                    outField.set(out, new ArrayList());
                    for (Object ob : (ArrayList) inField.get(in)) {
                        ((ArrayList) outField.get(out)).add(convert(getGenericClass(inField).cast(ob),
                                getGenericClass(outField)));
                    }
                } else {
                    if (inField.getType().equals(outField.getType())) {
                        if (inField.getType().getCanonicalName().startsWith("java.lang")
                                || inField.getType().isPrimitive()) {
                            outField.set(out, inField.get(in));
                        } else {
                            outField.set(out, convert(inField.get(in), outField.getType()));
                        }
                    } else {
                        outField.set(out, outField.getType().cast(convert(inField.get(in), outField.getType()))
                        );
                    }
                }
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(Converter.class.getName()).log(Level.INFO, "{0} not have field with name {1}",
                        new Object[]{outClass.getSimpleName(), inField.getName()});
            } catch (IllegalAccessException e) {
                throw new ConverterException(e.getMessage(), e);
            }
        }
        return (Out) out;
    }

    private static Class<?> getGenericClass(Field field) {
        return (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
    }

    public static class ConverterException extends Exception {
        public ConverterException(String msg, Throwable throwable) {
            super(msg, throwable);
        }
    }

}
