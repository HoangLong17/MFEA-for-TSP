package com.ngm.mfea;

import java.util.ArrayList;

public class Population {
    private ArrayList<Individual> individuals;
    static final int INDIVIDUAL_COUNT = 100;
    static final double SELECTION_PROBABILITY = 0.3;
    static final double RMP = 0.05;
    static final long MAX_ITERATIONS = 10000;
    static final long MAX_LAPSE = 100;

    public Population() {
        individuals = new ArrayList<>();
    }

    public ArrayList<Individual> getIndividuals() {
        return individuals;
    }

    public void setIndividuals(ArrayList<Individual> individuals) {
        this.individuals = individuals;
    }

    public Individual getIndividuals(int index) {
        return individuals.get(index);
    }

    public void setIndividuals(int index, Individual individual) {
        if(index > individuals.size() - 1) individuals.add(individual);
        else individuals.set(index, individual);
    }
}
