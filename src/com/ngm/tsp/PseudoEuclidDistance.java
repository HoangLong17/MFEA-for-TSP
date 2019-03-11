package com.ngm.tsp;

import com.ngm.utils.Function;

import java.util.ArrayList;

public class PseudoEuclidDistance extends Function {

    public double pseudoEuclidDistance(ArrayList<Double> x) {
        //Euclid distance
        Double sum = 0.0;
        for (Double var : x) {
            sum += var*var;
        }
        return Math.sqrt(sum/10);
    }

    @Override
    public double fitnessFunction(ArrayList<Double> distances) {
        double fitnessValue = 0.0;
        for (Double distance : distances) {
            fitnessValue += distance;
        }
        return fitnessValue;
    }
}
