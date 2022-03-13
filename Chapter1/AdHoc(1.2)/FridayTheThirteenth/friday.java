/*
ID: vickyye1
LANG: JAVA
TASK: friday
*/

import java.util.*;
import java.io.*;

/*
Problem Name: Friday The Thirteenth
Created Date: 3/12/2022
*/

public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        
        int[] weekdays = new int[7];
        int N = Integer.parseInt(f.readLine());

        f.close();

        boolean isLeap = false;
        int totalDays = 13;
        weekdays[6]++; // counts for 1900 january 13
        for (int year = 1900; year < 1900 + N; year++) {
            if ((year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 400 != 0 && year % 100 != 0)) {
                isLeap = true;
            }
            for (int month = 1; month <= 12; month++) {
                if (year == 1900 && month == 1) {
                    continue;
                }
                if (month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11 || month == 1) {
                    totalDays += 31; // accounts for previous month
                } else if (month == 5 || month == 7 || month == 10 || month == 12) {
                    totalDays += 30;
                } else if (month == 3) {
                    if (isLeap) totalDays += 29;
                    else {
                        totalDays += 28;
                    }
                }
                weekdays[totalDays % 7]++;
            }
            isLeap = false;
        }

        out.print(weekdays[6]);
        for (int i = 0; i < weekdays.length - 1; i++) {
            out.print(" " + weekdays[i]);
        }
        out.println();
        out.close();
    }
}
