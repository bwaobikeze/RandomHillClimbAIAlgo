package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Define the parameters for RHC runs
        double[][] startingPoints = {{2, 2}, {1, 4}, {-2, -3}, {1, -2},{-2.03,-3.09}};
        int[] pValues = {65, 400};
        double[] zValues = {0.2, 0.01};
        int[] seedValues = {42, 43};

        for (double[] sp : startingPoints) {
            for (int p : pValues) {
                for (double z : zValues) {
                    for (int seed : seedValues) {
                        double[] result = RHC(sp, p, z, seed);
                        double x = result[0];
                        double y = result[1];
                        double fxy = result[2];
                        int solutionsGenerated = (int) result[3];

                        System.out.println("Starting Point: (" + sp[0] + ", " + sp[1] + ")");
                        System.out.println("p: " + p);
                        System.out.println("z: " + z);
                        System.out.println("Seed: " + seed);
                        System.out.println("Final Solution: (" + x + ", " + y + ")");
                        System.out.println("f(x, y): " + fxy);
                        System.out.println("Solutions Generated: " + solutionsGenerated);
                        System.out.println();
                    }
                }
            }
        }
    }
    public static double[] RHC(double[] sp, int p, double z, int seed) {
        Random random = new Random(seed);
        double x = sp[0];
        double y = sp[1];
        double fxy = calculateObjectiveFunction(x, y);
        int solutionsGenerated = 0;

        while (solutionsGenerated < p) {
            double z1 = (2 * z * random.nextDouble()) - z;
            double z2 = (2 * z * random.nextDouble()) - z;
            double neighborX = x + z1;
            double neighborY = y + z2;

            neighborX = Math.max(-4.2, Math.min(4.2, neighborX));
            neighborY = Math.max(-4.2, Math.min(4.2, neighborY));
            double neighborFxy = calculateObjectiveFunction(neighborX, neighborY);

            if (neighborFxy > fxy) {
                x = neighborX;
                y = neighborY;
                fxy = neighborFxy;
            }

            solutionsGenerated++;
        }

        return new double[]{x, y, fxy, solutionsGenerated};
    }

    public static double calculateObjectiveFunction(double x, double y) {
        double term1 = 1.5 + x + x * y;
        double term2 = 2.25 + x - x * y * y;
        double term3 = 2.625 + x - x * y * y * y;
        return (term1 * term1) + (term2 * term2) + (term3 * term3);
    }
}