package org.example;

import java.util.Random;

public class RandomizedHillClimb {
    public double f( double firstx, double firsty){
        return Math.pow(1.5 + firstx + firstx * firsty, 2) + Math.pow(2.25 + firstx - firstx * firsty * firsty, 2) + Math.pow(2.625 + firstx - firstx * Math.pow(firsty, 3), 2);
    }
    public double[] RHC(double[] sp, int p, double z, long seed){
        Random randomSeed = new Random(seed);
        double[] currentsol = sp;
        double currentValue = f(currentsol[0],currentsol[1]);
        int numSolutionGen = 0;
        while(true){
            double[][] neighbors = new double[p][2];

            for(int i = 0; i< p; i++){
                double z1 = randomSeed.nextDouble() * z - z / 2;
                double z2 = randomSeed.nextDouble() * z - z /2;
                neighbors[i][0] = currentsol[0] + z1;
                neighbors[i][1] = currentsol[1] + z2;
                double neighborValue = f(neighbors[i][0], neighbors[i][1]);

                numSolutionGen++;

                if(neighborValue > currentValue){
                    currentValue = neighborValue;
                    currentsol[0] = neighbors[i][0];
                    currentsol[1] = neighbors[i][1];
                }
            }
            boolean improved = false;
            for(int i = 0; i < p; i++){
                double neighborValue = f(neighbors[i][0], neighbors[i][1]);
                if(neighborValue > currentValue){
                    improved = true;
                    break;
                }
            }
            if(!improved){
                break;
            }
        }
        return new double[]{currentsol[0], currentsol[1], currentValue, numSolutionGen};
    }
}
