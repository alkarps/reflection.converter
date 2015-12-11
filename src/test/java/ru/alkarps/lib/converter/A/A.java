/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alkarps.lib.converter.A;

import ru.alkarps.lib.converter.CommonSub;

/**
 *
 * @author alkarps
 */
public class A extends AbstractA {

    private String a;
    private String b;
    private int c;
    private Integer d;
    private Sub sub;
    private ListSub list;
    private CommonSub commonSub;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Sub getSub() {
        return sub;
    }

    public void setSub(Sub sub) {
        this.sub = sub;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public ListSub getList() {
        return list;
    }

    public void setList(ListSub list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "a: " + a
                + "; b: " + b
                + "; c: " + Integer.toString(c)
                + (commonSub == null ? "" : "; commonSub: ".concat(commonSub.toString()))
                + (d == null ? "" : ("; d: " + d.toString()))
                + (sub == null ? "" : ("; sub: [" + sub.toString()))
                + (list == null ? "" : ("]; list: [" + list.toString()))
                + "]";
    }

    public CommonSub getCommonSub() {
        return commonSub;
    }

    public void setCommonSub(CommonSub commonSub) {
        this.commonSub = commonSub;
    }
}
