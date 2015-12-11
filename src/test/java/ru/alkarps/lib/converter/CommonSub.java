package ru.alkarps.lib.converter;

/**
 * Created by alkarps on 11.12.2015.
 */
public class CommonSub {
    private String commonString;

    public String getCommonString() {
        return commonString;
    }

    public void setCommonString(String commonString) {
        this.commonString = commonString;
    }

    @Override
    public String toString(){
        return "commonString: " + commonString;
    }
}
