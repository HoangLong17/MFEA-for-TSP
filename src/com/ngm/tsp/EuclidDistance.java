package com.ngm.tsp;

import com.ngm.utils.Function;

import java.util.ArrayList;

public class EuclidDistance extends Function {

    @Override
    public double fitnessFunction(ArrayList<Double> x) {
        //Euclid distance
        Double sum = 0.0;
        for (Double var : x) {
            sum += var*var;
        }
        return Math.sqrt(sum);
    }
}
