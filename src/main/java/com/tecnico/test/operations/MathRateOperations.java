package com.tecnico.test.operations;

import com.tecnico.test.Constants;

public class MathRateOperations {

    public static double calculateDiscount(double value, double percentageBaseHundred){
        return value - (value * percentageBaseHundred / Constants.MAX_PERCENTAGE);

    }

}
