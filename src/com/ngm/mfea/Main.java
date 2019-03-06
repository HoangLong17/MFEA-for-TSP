package com.ngm.mfea;

import com.ngm.tsp.CityMap;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            CityMap cp1 = new CityMap("input\\st70.tsp");
            CityMap cp2 = new CityMap("input\\bier127.tsp");
            System.out.println("Attemp #" + i + ":");
            UnifiedMultitaskingEnvironment ume = new UnifiedMultitaskingEnvironment();
        }
    }
}
