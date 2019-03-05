package com.ngm.mfea;

import com.ngm.utils.Function;

public class Task {
    private static int taskCount = 0;
    private int taskId;
    private Function objectiveFunction;
    private Individual bestIndividual;
    private Double bestFitnessValue;

    public Task(Function objectiveFunction) {
        taskCount++;
        taskId = taskCount;
        this.objectiveFunction = objectiveFunction;
        bestIndividual  = new Individual();
        bestFitnessValue = Double.MAX_VALUE;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Function getObjectiveFunction() {
        return objectiveFunction;
    }

    public void setObjectiveFunction(Function objectiveFunction) {
        this.objectiveFunction = objectiveFunction;
    }

    public Individual getBestIndividual() {
        return bestIndividual;
    }

    public void setBestIndividual(Individual bestIndividual) {
        this.bestIndividual = bestIndividual;
    }

    public Double getBestFitnessValue() {
        return bestFitnessValue;
    }

    public void setBestFitnessValue(Double bestFitnessValue) {
        this.bestFitnessValue = bestFitnessValue;
    }
}
