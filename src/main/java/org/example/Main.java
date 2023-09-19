package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        RandomizedHillClimb randomHil = new RandomizedHillClimb();
        Double [] xValues = {2.0,1.0,-2.0,1.0};
        Double [] yValues = {2.0,4.0,-3.0,-2.0};

            for(int i =0; i< xValues.length; i++){
                double[] sp = {xValues[i], yValues[i]};
                int p = 400; // Number of neighbors
                double z = 0.01; // Neighborhood size
                int seed = 42;
                // First run of RHC
                System.out.println("For: ("+xValues[i]+","+yValues[i]+")");
                System.out.println("First run of RHC: With Seed = 42 ");
                Random rand1 = new Random(seed);
                double[] solution1 = randomHil.RHC(sp, p, z, rand1);
                randomHil.printSolution(solution1);
                System.out.println("=============");
                System.out.println("Second run of RHC: With Seed = 43 ");
                seed = 43;
                Random rand2 = new Random(seed);
                double[] solution2 = randomHil.RHC(sp, p, z, rand2);
                randomHil.printSolution(solution2);
                System.out.println("================================================");
            }
    }
}