package com.ngm.mfea;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(new Task("input\\st70.tsp", 675.0));
        taskList.add(new Task("input\\bier127.tsp", 118282.0));
        UnifiedMultitaskingEnvironment ume = new UnifiedMultitaskingEnvironment(taskList);
        for (int i = 0; i < 10; i++) {
            System.out.println("Attemp #" + i + ":");
        }
    }
}
