/*
Problem Statement

You are given a square map of size n×n. Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).

You need to find all the cavities on the map and depict them with the uppercase character X.

Input Format

The first line contains an integer, n, denoting the size of the map. Each of the following n lines contains n positive digits without spaces. Each digit (1-9) denotes the depth of the appropriate area.

Constraints 
1≤n≤100
Output Format

Output n lines, denoting the resulting map. Each cavity should be replaced with character X.

Sample Input

4
1112
1912
1892
1234
Sample Output

1112
1X12
18X2
1234
Explanation

The two cells with the depth of 9 fulfill all the conditions of the Cavity definition and have been replaced by X.
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
        String grid[] = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        String[] cavityMap = depictCavity(grid);
        for(int i = 0; i < cavityMap.length; i++) {
            System.out.println(cavityMap[i]);
        }
    }
    
    static String[] depictCavity(String[] map) {
        if (map.length <= 2 || map[0].toCharArray().length <= 2) {
            return map;
        }
        
        for (int m_row = 1; m_row < map.length - 1; m_row++) {
            for (int m_col = 1; m_col < map[m_row].toCharArray().length - 1; m_col++) {
                int current = getNumberInMap(map, m_row, m_col);
                int top = getNumberInMap(map, m_row - 1, m_col);
                int right = getNumberInMap(map, m_row, m_col + 1);
                int bottom = getNumberInMap(map, m_row + 1, m_col);
                int left = getNumberInMap(map, m_row, m_col - 1);
                
                if (checkCavity(current, top, right, bottom, left)) {
                    String line = map[m_row];
                    line = line.substring(0, m_col) + 'X' + line.substring(m_col + 1);
                    map[m_row] = line;
                }
            }
        }
        return map;
    }
    
    static boolean checkCavity(int current, int top, int right, int bottom, int left) {
        return (current > top 
                && current > right 
                && current > bottom 
                && current > left);
    }
    
    static int getNumberInMap(String[] map, int row, int column) {
        String rowLine = map[row];
        char character = rowLine.charAt(column);
        int number = (int) Character.getNumericValue(character);
        return number;
    }
}
