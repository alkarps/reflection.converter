/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alkarps.lib.converter.B;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alkarps
 */
public class ListSub {

    private List<Sub> list;

    public List<Sub> getList() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }
    
    @Override
    public String toString(){
        String result = "list: [";
        for(Sub sub : list){
            result += "[" + sub.toString() + "]; ";
        }
        return result + "];";
    }
}
