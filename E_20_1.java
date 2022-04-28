package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E_20_1 {
    public static void main(String[] args) throws Exception {
        File file = new File("20.1.txt");
        List<String> list = new ArrayList<>();

        try (

                Scanner s = new Scanner(file);
        ) {
            while (s.hasNext()) {
                String[] array = s.nextLine().split(" ");
                for (int i = 0; i < array.length; i++) {
                    if (array[i].length() > 0 &&
                            Character.isLetter(array[i].charAt(0))) {
                        list.add(array[i]);
                    }
                }
            }
        }
        Collections.sort(list);

        System.out.println(list);
    }
}
