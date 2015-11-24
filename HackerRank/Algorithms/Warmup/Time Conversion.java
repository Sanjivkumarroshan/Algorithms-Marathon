/*
Problem Statement

Given a time in AM/PM format, convert it to military (24-hour) time.

Note: Midnight is 12:00:00AM on a 12-hour clock and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock and 12:00:00 on a 24-hour clock.

Input Format

A time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM), where 01≤hh≤12.

Output Format

Convert and print the given time in 24-hour format, where 00≤hh≤23.

Sample Input

07:05:45PM
Sample Output

19:05:45
Explanation

7 PM is after noon, so you need to add 12 hours to it during conversion. 12 + 7 = 19. Minutes and seconds do not change in 12-24 hour time conversions, so the answer is 19:05:45.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String input = in.next();

        if (input != null) {
            String timeIn24 = get24TimeString(input);
            // Print
            System.out.println(timeIn24);
        }
    }
    
    static String get24TimeString(String orgString) {
        String hourStr = orgString.substring(0, 2);
        String endStr = orgString.substring(orgString.length() - 2);
        
        if (endStr.equals("PM") && !hourStr.equals("12")) {
            int pmHour = Integer.parseInt(hourStr) + 12;
            hourStr = Integer.toString(pmHour);
        }
        
        if (endStr.equals("AM") && hourStr.equals("12")) {
            hourStr = "00";
        }

        return hourStr + orgString.substring(2, orgString.length() - 2);
    }
    
}