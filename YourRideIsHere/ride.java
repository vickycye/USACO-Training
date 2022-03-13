/*
ID: vickyye1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

/*
Problem Name: Your Ride is Here
Created Date: 3/12/2022
*/

public class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        
        String comet = f.readLine();
        String group = f.readLine();

        f.close();

        long cometTotal = 1;
        long groupTotal = 1;
        for (int i = 0; i < comet.length(); i++) {
            cometTotal *= (Character.toLowerCase(comet.charAt(i)) - 96);
        }

        for (int i = 0; i < group.length(); i++) {
            groupTotal *= (Character.toLowerCase(group.charAt(i)) - 96);
        }

        out.println((cometTotal % 47 == groupTotal % 47) ? "GO" : "STAY");

        out.close();
    }
}