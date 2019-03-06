package com.ngm.mfea;


import java.util.ArrayList;

public class Individual implements Comparable<Individual> {
    private ArrayList<Integer> chromosome; //Chromosome's data.
    private ArrayList<Double> factorialCosts;
    private ArrayList<Integer> factorialRanks;
    private ArrayList<Double> skillFactors;
    private Double scalarFitness;

    public Individual() {
        chromosome = new ArrayList<>();
        factorialCosts = new ArrayList<>();
        factorialRanks = new ArrayList<>();
        skillFactors = new ArrayList<>();
        scalarFitness = 0.0;
    }

    public ArrayList<Integer> getChromosome() {
        return chromosome;
    }

    public void setChromosome(ArrayList<Integer> chromosome) {
        this.chromosome = chromosome;
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

    public ArrayList<Double> getSkillFactors() {
        return skillFactors;
    }

    public void setSkillFactors(ArrayList<Double> skillFactors) {
        this.skillFactors = skillFactors;
    }

    public Double getSkillFactors(int index) {
        return skillFactors.get(index);
    }

    public void setSkillFactors(int index, Double value) {
        if(index > skillFactors.size() - 1) skillFactors.add(value);
        else skillFactors.set(index, value);
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

    public int compareTo(int taskId, Individual that) {
        return Double.compare(this.getFactorialCosts().get(taskId),
                that.getFactorialCosts().get(taskId));
    }

    public void encoding() {

    }

    public void decoding(Task task) {

    }
}
