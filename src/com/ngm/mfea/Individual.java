package com.ngm.mfea;


import java.util.ArrayList;

public class Individual implements Comparable<Individual> {
    protected ArrayList<Integer> chromosome; //Chromosome's data.
    protected ArrayList<Double> factorialCosts;
    protected ArrayList<Integer> factorialRanks;
    protected int skillFactor;
    protected Double scalarFitness;

    public Individual() {
        chromosome = new ArrayList<>();
        factorialCosts = new ArrayList<>();
        factorialRanks = new ArrayList<>();
        skillFactor = 0;
        scalarFitness = 0.0;
    }

    public ArrayList<Integer> getChromosome() {
        return chromosome;
    }

    public void setChromosome(ArrayList<Integer> chromosome) {
        this.chromosome = chromosome;
    }

    public int getChromosome(int index) {
        return chromosome.get(index);
    }

    public void setChromosome(int index, int value) {
        if (index > chromosome.size() - 1) chromosome.add(value);
        else chromosome.set(index, value);
    }

    public ArrayList<Double> getFactorialCosts() {
        return factorialCosts;
    }

    public void setFactorialCosts(ArrayList<Double> factorialCosts) {
        this.factorialCosts = factorialCosts;
    }

    public Double getFactorialCosts(int index) {
        return factorialCosts.get(index);
    }

    public void setFactorialCosts(int index, Double value) {
        if(index > factorialCosts.size() - 1) factorialCosts.add(value);
        else factorialCosts.set(index, value);
    }

    public ArrayList<Integer> getFactorialRanks() {
        return factorialRanks;
    }

    public void setFactorialRanks(ArrayList<Integer> factorialRanks) {
        this.factorialRanks = factorialRanks;
    }

    public Integer getFactorialRanks(int index) {
        return factorialRanks.get(index);
    }

    public void setFactorialRanks(int index, int value) {
        if(index > factorialRanks.size() - 1) factorialRanks.add(value);
        else factorialRanks.set(index, value);
    }

    public int getSkillFactor() {
        return skillFactor;
    }

    public void setSkillFactor(int skillFactor) {
        this.skillFactor = skillFactor;
    }

    public Double getScalarFitness() {
        return scalarFitness;
    }

    public void setScalarFitness(Double scalarFitness) {
        this.scalarFitness = scalarFitness;
    }

    @Override
    public int compareTo(Individual that) {
        return Double.compare(this.getScalarFitness(), that.getScalarFitness());
        //this < that ? -1 : this > that ? 1 : 0.
    }

    public int compareTo(Individual that, int taskId) {
        return Double.compare(this.getFactorialCosts().get(taskId),
                that.getFactorialCosts().get(taskId));
    }

    public ArrayList<Integer> encoding() {
        ArrayList<Integer> returnChromosome = new ArrayList<>(chromosome);
        int dimension = UnifiedMultitaskingEnvironment.getUnifiedTaskDimension();
        while (returnChromosome.size() != dimension) {
            returnChromosome.add(0);
        }
        return returnChromosome;
    }

    public ArrayList<Integer> decoding(Task task) {
        ArrayList<Integer> returnChromosome = new ArrayList<>(chromosome);
        int taskDimension = task.getDimension();
        int size = returnChromosome.size();
        int i = 0;
        while (returnChromosome.size() > taskDimension) {
            if (returnChromosome.get(i) == 0) returnChromosome.remove(i);
            i++;
        }
        return returnChromosome;
    }
}
