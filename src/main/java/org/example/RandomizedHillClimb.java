package org.example;

import java.util.Random;

public class RandomizedHillClimb {
    public double[] RHC(double[] sp, int p, double z, Random rand){
        double[] currentSolution = sp;
        double currentValue = evaluateFunction(sp[0], sp[1]);
        int solutionsGenerated = 1;

        while (true) {
            double bestNeighborValue = Double.NEGATIVE_INFINITY;
            double[] bestNeighborSolution = currentSolution.clone();

            for (int i = 0; i < p; i++) {
                double neighborX = currentSolution[0] + (rand.nextDouble() * z - z / 2.0);
                double neighborY = currentSolution[1] + (rand.nextDouble() * z - z / 2.0);

                // Ensure that the generated neighbor is within the specified range
                neighborX = Math.max(-4.2, Math.min(4.2, neighborX));
                neighborY = Math.max(-4.2, Math.min(4.2, neighborY));

                double neighborValue = evaluateFunction(neighborX, neighborY);

                if (neighborValue > bestNeighborValue) {
                    bestNeighborValue = neighborValue;
                    bestNeighborSolution[0] = neighborX;
                    bestNeighborSolution[1] = neighborY;
                }
                solutionsGenerated++;
            }

            if (bestNeighborValue > currentValue) {
                currentSolution = bestNeighborSolution;
                currentValue = bestNeighborValue;
            } else {
                // No better neighbor found, terminate
                break;
            }
        }

        return new double[]{currentSolution[0], currentSolution[1], currentValue, solutionsGenerated};
    }

    public static double evaluateFunction(double x, double y) {
        return Math.pow(1.5 + x + x * y, 2) + Math.pow(2.25 + x - x * y * y, 2) + Math.pow(2.625 + x - x * y * y * y, 2);
    }

    public static void printSolution(double[] solution) {
        System.out.println("Best Solution (x, y): (" + solution[0] + ", " + solution[1] + ")");
        System.out.println("Function Value: " + solution[2]);
        System.out.println("Solutions Generated: " + solution[3]);
    }


}
