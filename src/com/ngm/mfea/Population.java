package com.ngm.mfea;

import java.util.ArrayList;

public class Population {
    private ArrayList<Individual> individuals;

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
