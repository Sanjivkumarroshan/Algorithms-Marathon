/*
Problem Statement

Given an array of integers, calculate which fraction of the elements are positive, negative, and zeroes, respectively. Print the decimal value of each fraction. You may either round or truncate your answers.

Input Format

The first line, N, is the size of the array. 
The second line contains N space-separated integers describing the array of numbers (A1,A2,A3,⋯,AN).

Output Format

Print each value on its own line with the fraction of positive numbers first, negative numbers second, and zeroes third. Scale the fractions to 3 decimal places.

Sample Input

6
-4 3 -9 0 4 1         
Sample Output

0.500
0.333
0.167
Explanation

There are 3 positive numbers, 2 negative numbers, and 1 zero in the array. 
The fraction of the positive numbers, negative numbers and zeroes are 36=0.500, 26=0.333 and 16=0.167, respectively.

Note: This challenge introduces precision problems. You can print the output to 4 decimal places and above, but only the difference at the 3rd decimal digit is noted. That is the reason you'll notice testcases have much higher scale (more places to the right of the decimal) than required by the problem. 
Answers with absolute error of up to 10−4 will be accepted.
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
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        double result[]  = getFractions(arr);
        for(int i = 0; i < result.length; i++) {
            System.out.printf("%.6f", result[i]);
            System.out.println("");
        }
    }
    
    static double[] getFractions(int[] arr) {
        double fractions[] = new double[]{0, 0 ,0};
        for(int i = 0; i < arr.length; i++) {
            int number = arr[i];
            
            if (number > 0) {
                fractions[0] += 1;
            }
            if (number < 0) {
                fractions[1] += 1;
            }
            if (number == 0) {
                fractions[2] += 1;
            }
        }
        
        for(int i = 0; i < fractions.length; i++) {
            fractions[i] /= arr.length;
        }
        
        return fractions;
    }
}
