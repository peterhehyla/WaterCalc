package com.hylamobile.test.watercalc;

import java.util.ArrayList;
import java.util.List;

public class CalcApp {

    public static void main(String[] args){
        List<Long> inputList = new ArrayList<Long>();
        inputList.add(0L);
        inputList.add(2L);
        inputList.add(1L);
        inputList.add(3L);
        inputList.add(3L);
        inputList.add(1L);
        inputList.add(1L);
        inputList.add(4L);
        inputList.add(0L);
        inputList.add(1L);

        CalcWater calcWater = new CalcWater(inputList);

        System.out.println("total water is: " + calcWater.calculateWater());
    }
}
