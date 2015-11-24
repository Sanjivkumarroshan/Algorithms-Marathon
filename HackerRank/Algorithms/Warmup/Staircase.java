/*
Problem Statement

Your teacher has given you the task of drawing a staircase structure. Being an expert programmer, you decided to make a program to draw it for you instead. Given the required height, can you print a staircase as shown in the example?

Input 
You are given an integer N depicting the height of the staircase.

Output 
Print a staircase of height N that consists of # symbols and spaces. For example for N=6, here's a staircase of that height:

     #
    ##
   ###
  ####
 #####
######
Note: The last line has 0 spaces before it.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // Draw Staircase
        drawStaircase(n);
    }
    
    static void drawStaircase(int height) {
        for (int row = height - 1; row >= 0; row--) {
            for(int block = 0; block < height; block++) {
                if (block >= row) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            // Break line
            System.out.println("");
        }
    }
}
