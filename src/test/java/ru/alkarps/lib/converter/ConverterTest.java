package ru.alkarps.lib.converter;

import org.junit.Test;
import ru.alkarps.lib.converter.A.ExtendA;
import ru.alkarps.lib.converter.A.ListSub;
import ru.alkarps.lib.converter.A.Sub;
import ru.alkarps.lib.converter.B.ExtendB;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alkarps on 11.12.2015.
 */
public class ConverterTest {

    @Test
    public void test(){
        ExtendA a = new ExtendA();
        a.setA("a");
        a.setB("b");
        Sub sub = new Sub();
        sub.setV(1);
        a.setSub(sub);
        CommonSub commonSub = new CommonSub();
        commonSub.setCommonString("comA");
        a.setCommonSub(commonSub);
        a.setList(new ListSub());
        a.getList().getList().add(sub);
        try {
            ExtendB b = Converter.convert(a, ExtendB.class);
            a.getCommonSub().setCommonString("c");
            System.out.println("Original: ".concat(a.toString()));
            System.out.println("Copy:" + b.toString());
        } catch (Converter.ConverterException ex) {
            Logger.getLogger(ConverterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}