package org.example;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        double[] sp = {2,2};
        int p = 65;
        double z = 0.2;
        long Seed = 42;
        RandomizedHillClimb randomClimb = new RandomizedHillClimb();
        double[] result =randomClimb.RHC(sp,p,z,Seed);
        System.out.println("Optimal Solution (x, y): (" + result[0] + ", " + result[1] + ")");
        System.out.println("Optimal Value of f(x, y): " + result[2]);
        System.out.println("Number of Generated Solutions: " + result[3]);
    }
}