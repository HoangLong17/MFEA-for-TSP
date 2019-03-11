package com.ngm.utils;

import com.ngm.mfea.Task;
import com.ngm.tsp.EuclidDistance;
import com.ngm.tsp.PseudoEuclidDistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TSPFile {
    //Read a TSP file.
    public static void readFile(String filename, Task cp) {
        File file = new File(filename);
        Scanner sc;
        StringTokenizer st;
        try {
            sc = new Scanner(file);
            System.out.println(sc.nextLine()); //File name.
            System.out.println(sc.nextLine()); //File type: TSP.
            System.out.println(sc.nextLine()); //Comment for file.
            //Get problem dimension.
            st = new StringTokenizer(sc.nextLine());
            while(st.hasMoreTokens()) {
                st.nextToken(": ");
                cp.setDimension(Integer.parseInt(st.nextToken()));
            }
            //Get problem's fitness value type.
            st = new StringTokenizer(sc.nextLine());
            while(st.hasMoreTokens()) {
                st.nextToken(": ");
                cp.setDistanceType(st.nextToken());

                if (cp.getDistanceType().equals(ConstantString.EUC_2D)) {
                    cp.setObjectiveFunction(new EuclidDistance());
                    //Euclid distance.
                } else if (cp.getDistanceType().equals(ConstantString.ATT)) {
                    cp.setObjectiveFunction(new PseudoEuclidDistance());
                    //Pseudo Euclid distance.
                }
            }
            //Type of weight.
            if(sc.nextLine().equals(ConstantString.NODE_COORD_SECTION)) {
                //Get point coordinate.
                for (int i = 0; i < cp.getDimension(); i++) {
                    sc.nextInt();
                    cp.setaX(i, sc.nextDouble());
                    cp.setaY(i, sc.nextDouble());
                }
            }
            //else..

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
