package com.ngm.mfea;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        double[] task1 = new double[10];
        double[] task2 = new double[10];
        double[] totalTimes = new double[10];
        double argTask1 = 0.0;
        double argTask2 = 0.0;
        double argTime = 0.0;
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(new Task("input\\berlin52.tsp", 0.0));
        taskList.add(new Task("input\\st70.tsp", 0.0));
        UnifiedMultitaskingEnvironment ume = new UnifiedMultitaskingEnvironment(taskList);
        for (int i = 0; i < 10; i++) {
            System.out.println("Attemp #" + (i + 1) + ":");
            long startTime = System.nanoTime();
            ume.MFEAlgorithm();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            totalTimes[i] = (double) totalTime / 1000000000;
            System.out.println("Total Time: " + totalTimes[i] + " second(s).");
            argTime += totalTimes[i];
            for (Task task : taskList) {
                if (task.getTaskId() == 0) {
                    task1[i] = ume.printBestSolution(task);
                } else {
                    task2[i] = ume.printBestSolution(task);
                }
            }
            argTask1 += task1[i];
            argTask2 += task2[i];
        }
        System.out.println(argTask1 / 10);
        System.out.println(argTask2 / 10);
        System.out.println(argTime / 10);
    }
}
