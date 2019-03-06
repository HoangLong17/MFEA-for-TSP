package com.ngm.mfea;

import java.util.ArrayList;

public class UnifiedMultitaskingEnvironment {
    private static int unifiedTaskDimension = 0;
    private ArrayList<Task> taskList;
    private Population currentPopulation,
            offspringPopulation,
            intermediatePopulation;
    private Individual optimumIndividual;
    private ArrayList<Double> optimumFitnessValues;

    public UnifiedMultitaskingEnvironment() {
        taskList = new ArrayList<>();
        currentPopulation = new Population();
        offspringPopulation = new Population();
        intermediatePopulation = new Population();
        optimumIndividual = new Individual();
        optimumFitnessValues = new ArrayList<>();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public Task getTaskList(int index) {
        return taskList.get(index);
    }

    public void setTaskList(int index, Task task) {
        if(index > taskList.size() - 1) taskList.add(task);
        else taskList.set(index, task);
    }

    public Population getCurrentPopulation() {
        return currentPopulation;
    }

    public void setCurrentPopulation(Population currentPopulation) {
        this.currentPopulation = currentPopulation;
    }

    public Population getOffspringPopulation() {
        return offspringPopulation;
    }

    public void setOffspringPopulation(Population offspringPopulation) {
        this.offspringPopulation = offspringPopulation;
    }

    public Population getIntermediatePopulation() {
        return intermediatePopulation;
    }

    public void setIntermediatePopulation(Population intermediatePopulation) {
        this.intermediatePopulation = intermediatePopulation;
    }

    public Individual getOptimumIndividual() {
        return optimumIndividual;
    }

    public void setOptimumIndividual(Individual optimumIndividual) {
        this.optimumIndividual = optimumIndividual;
    }

    public ArrayList<Double> getOptimumFitnessValues() {
        return optimumFitnessValues;
    }

    public void setOptimumFitnessValues(ArrayList<Double> optimumFitnessValues) {
        this.optimumFitnessValues = optimumFitnessValues;
    }

    public Double getOptimumFitnessValues(int index) {
        return optimumFitnessValues.get(index);
    }

    public void setOptimumFitnessValues(int index, Double value) {
        if(index > optimumFitnessValues.size() - 1) optimumFitnessValues.add(value);
        else optimumFitnessValues.set(index, value);
    }
    public int getUnifiedTaskDimension() {
        return unifiedTaskDimension;
    }

    public void updateUnifiedTaskDimension() {
        for (Task task : taskList) {
            if(task.getDimension() > unifiedTaskDimension)
                unifiedTaskDimension = task.getDimension();
        }
    }

    public void MFEAlgorithm() {

    }
}
