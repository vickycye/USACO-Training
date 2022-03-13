/*
ID: vickyye1
LANG: JAVA
TASK: gift1
*/

import java.util.*;
import java.io.*;

/*
Problem Name: Greedy Gift Givers
Created Date: 3/12/2022
*/

public class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        
        int N = Integer.parseInt(f.readLine());
        Map<String, Integer> people = new HashMap<String,  Integer>();
        String[] originalOrder = new String[N];
        
        for (int i = 0; i < N; i++) {
            String name = f.readLine();
            people.put(name, 0);
            originalOrder[i] = name;
        }

        for (int i = 0; i < N; i++) {
            String person = f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine(), " ");
            int amountTaken = Integer.parseInt(st.nextToken());
            int distribution = Integer.parseInt(st.nextToken());

            people.put(person, people.get(person) - amountTaken);
            int eachCost = 0;
            if (distribution != 0) {
                eachCost = amountTaken / distribution;
                people.put(person, people.get(person) + amountTaken % distribution);
            }
            for (int j = 0; j < distribution; j++) {
                String gifting = f.readLine();
                people.put(gifting, people.get(gifting) + eachCost);
            }
        }

        for (int i = 0; i < originalOrder.length; i++) {
            out.println(originalOrder[i] + " " + people.get(originalOrder[i]));
        }
 
        f.close();
        out.close();
    }
}
