package com.company;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class E_21_1 {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>(Arrays.asList(
                "George", "Jim", "John", "Blake", "Kevin", "Michael"));
        Set<String> set2 = new LinkedHashSet<>(Arrays.asList(
                "George", "Katie", "Kevin", "Michelle", "Ryan"));

        Set<String> unn = new LinkedHashSet<>(set1);
        unn.addAll(set2);
        System.out.println("Union: " + unn);

        Set<String> diff = new LinkedHashSet<>(set1);
        diff.removeAll(set2);
        System.out.println("Difference of the two sets: " + diff);


        Set<String> inters = new LinkedHashSet<>();
        for (String e: set2) {
            if (set1.contains(e))
                inters.add(e);
        }
        System.out.println("Intersection: " + inters);
    }
}
