package com.ngm.utils;

import com.ngm.mfea.Individual;
import com.ngm.mfea.Task;

import java.util.ArrayList;

public class Sorting {
    //Merge sort, for particle list.
    public static void mergeSort(int p, int r, ArrayList<Individual> individuals, Task task) {
        if(p < r) {
            int  q = Math.floorDiv((p + r), 2);
            mergeSort(p, q, individuals, task);
            mergeSort(q + 1, r, individuals, task);
            merge(p, q, r, individuals, task);
        }
    }

    private static void merge(int p, int q, int r, ArrayList<Individual> individuals, Task task) {
        Individual maxIndividual = new Individual();
        int h = 0;
        while (h < task.getTaskId()) {
            h++;
            maxIndividual.setFactorialCosts(h, Double.MAX_VALUE);
        }
        ArrayList<Individual> lIndividuals
                = new ArrayList<>(individuals.subList(p, q + 1));
        lIndividuals.add(maxIndividual);
        ArrayList<Individual> rIndividuals
                = new ArrayList<>(individuals.subList(q + 1, r + 1));
        rIndividuals.add(maxIndividual);
        int i = 0;
        int j = 0;
        for (int k = p; k < r + 1; k++) {
            if (lIndividuals.get(i).compareTo(rIndividuals.get(j), task.getTaskId()) != 1) {
                individuals.set(k, lIndividuals.get(i));
                i++;
            }
            else {
                individuals.set(k, rIndividuals.get(j));
                j++;
            }
        }
    }
}
