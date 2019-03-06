package com.ngm.tsp;

import com.ngm.mfea.Population;
import com.ngm.mfea.Task;
import com.ngm.utils.ConstantString;
import com.ngm.utils.TSPFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CityMap {
    private static final int DOMAIN = 250; //Coordinates domain.
    private int cityCount;  //Number of cities.
    private ArrayList<City> map; //City map.
    private ArrayList<Double> aX;   //X-coordinate list.
    private ArrayList<Double> aY;   //Y-coordinate list.
    private String distanceType;
    private Task task;

    public CityMap(String filename) {
        cityCount = 0;
        map = new ArrayList<>();
        aX = new ArrayList<>();
        aY = new ArrayList<>();
        initializeMap(filename);
        createTask();
//      printMap();
    }

    public ArrayList<City> getMap() {
        return map;
    }

    public static int getDOMAIN() {
        return DOMAIN;
    }

    public int getCityCount() {
        return cityCount;
    }

    public void setCityCount(int cityCount) {
        this.cityCount = cityCount;
    }

    public ArrayList<Double> getaX() {
        return aX;
    }

    public void setaX(ArrayList<Double> aX) {
        this.aX = aX;
    }

    public ArrayList<Double> getaY() {
        return aY;
    }

    public void setaY(ArrayList<Double> aY) {
        this.aY = aY;
    }

    public double getaX(int index) {
        return aX.get(index);
    }

    public void setaX(int index, double value) {
        if(index > aX.size() - 1) aX.add(value);
        else aX.set(index, value);
    }

    public double getaY(int index) {
        return aY.get(index);
    }

    public void setaY(int index, double value) {
        if(index > aY.size() - 1) aY.add(value);
        else aY.set(index, value);
    }

    public String getDistanceType() {
        return distanceType;
    }

    public void setDistanceType(String distanceType) {
        this.distanceType = distanceType;
    }

    public Task getTask() { return task; }

    //Initialize a map with cities.
    private void initializeMap(String filename) {
        if(filename != null) {
            TSPFile.readFile(filename, this);
        }
        else {
            System.out.print("Number of Cities: ");
            Scanner sc = new Scanner(System.in);
            cityCount = sc.nextInt();
            int randomX, randomY;

            //Create city list without concurrent points.
            boolean duplicate;
            int count = 0;
            while(aX.size() < cityCount) {
                do {
                    randomX = new Random().nextInt(DOMAIN);
                    if (aX.indexOf(randomX) == -1) {
                        duplicate = false;
                        setaX(count, randomX);
                        randomY = new Random().nextInt(DOMAIN);
                        setaX(count, randomY);
                        count++;
                    } else duplicate = true;
                } while (duplicate);
            }
        }

        //Add city into the map.
        for (int i = 0; i < cityCount; i++) {
            City city = new City();
            city.setcX(aX.get(i));
            city.setcY(aY.get(i));
            map.add(city);
        }
    }

    //Show location of cities (their coordinates).
    public void printMap() {
        for (int i = 0; i < cityCount; i++) {
            System.out.print("City " + i + ": [" + map.get(i).getcX()
                    + ", " + map.get(i).getcY() + "] \n");
        }
    }

    private void createTask() {
        if(distanceType.equals(ConstantString.EUC_2D)) {
            task = new Task(new EuclidDistance());
            //Euclid distance.
        }
        else if(distanceType.equals(ConstantString.ATT)) {
            task = new Task(new PseudoEuclidDistance());
            //Pseudo Euclid distance.
        }
    }

    private double getDistance(String distanceType, int firstCity, int secondCity) {
        ArrayList<Double> variables = new ArrayList<>();
        City cityA = map.get(firstCity);
        City cityB = map.get(secondCity);
        double xd = cityA.getcX()-cityB.getcX();
        double yd = cityA.getcY()-cityB.getcY();
        variables.add(xd);
        variables.add(yd);
        if(distanceType.equals(ConstantString.EUC_2D)) {
            return task.getObjectiveFunction().fitnessFunction(variables);
            //Euclid distance.
        }
        else if(distanceType.equals(ConstantString.ATT)) {
            return task.getObjectiveFunction().fitnessFunction(variables);
            //Pseudo Euclid distance.
        }
        else return -1;
    }
}
