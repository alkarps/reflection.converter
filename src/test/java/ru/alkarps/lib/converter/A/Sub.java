/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alkarps.lib.converter.A;

/**
 *
 * @author alkarps
 */
public class Sub {

    private int v;

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
    
    @Override
    public String toString(){
        return "v: " + Integer.toString(v);
    }
}
