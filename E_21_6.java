package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E_21_6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();

        System.out.println("Enter a numbers" + "\nInput ends when the input is 0:");

        int key;
        while ((key = s.nextInt()) != 0) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            }
            else {
                int count = map.get(key);
                count++;
                map.put(key, count);
            }
        }

        int max = Collections.max(map.values());

        System.out.print("The most occurrences numbers are: ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }
}
