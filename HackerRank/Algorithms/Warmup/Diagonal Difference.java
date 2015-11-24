import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        
        int primaryDiagonalLength = getDiagonalLength(a, n, true);
        int optionalDiagonalLength = getDiagonalLength(a, n, false);

        int difference = Math.abs(primaryDiagonalLength - optionalDiagonalLength);
        //Print Result
        System.out.println(difference);
    }
    
    static int getDiagonalLength(int[][] matrix, int matrixSize, boolean isPrimaryDiagonal) {
        int column = 0, row = 0, length = 0;
        if (!isPrimaryDiagonal) {
            row = matrixSize - 1;
        }

        do {
            int matrixPoint = matrix[row][column];
            length += matrixPoint;
            
            // Increase or decrease index
            if (isPrimaryDiagonal) {
                row++;
                if(row >= matrixSize) {
                    break;
                }
            } else {
                row--;
                if(row < 0) {
                    break;
                }
            }
            column++;

            if (column >= matrixSize) {
                break;
            }
        } while(true);
        
        return length;
    }
}
