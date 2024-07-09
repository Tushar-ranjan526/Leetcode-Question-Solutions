package Leetcode;

public class AverageWaitTime {
    public static void main(String[] args) {
        int[][] customers={
                {5,2},
                {5,4},
                {10,3},
                {20,1}
        };
        System.out.println(averageWaitingTime(customers));
    }
    public static double averageWaitingTime(int[][] customers) {
        int totalTime=0;
        double wait=0.0d;
        for (int i = 0; i < customers.length; i++) {
            if(totalTime<customers[i][0])totalTime=customers[i][0];
            totalTime+=customers[i][1];
            wait+=totalTime-customers[i][0];
        }
        return wait/customers.length;
    }
}
