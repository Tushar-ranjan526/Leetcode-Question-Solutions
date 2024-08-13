package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalArea {
    public static void main(String[] args) {
        int[][] points={
                {3,1},
                {9,0},
                {1,0},
                {1,4},
                {5,3},
                {8,8}
        };
        System.out.println(maxWidthOfVerticalArea(points));
    }
    public static void printArray(int[][] points){
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                System.out.print(points[i][j]+",");
            }
            System.out.println("");
        }
    }
    public static int maxWidthOfVerticalArea(int[][] points) {
//        int[] xcordinate=new int[points.length];
        Arrays.sort(points, Comparator.comparingInt(a->a[0]));
        int width=0;
        int j=0;
        for (int i = 0; i < points.length-1 ; i++) {
            width=Math.max(width,points[i+1][j]-points[i][j]);
        }
        return width;
    }
}
