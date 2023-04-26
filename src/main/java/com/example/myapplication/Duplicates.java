package com.example.myapplication;

import java.util.HashSet;

public class Duplicates {
    public static String removeCommon(String poz, String neg) {
        char[] pozArr = poz.toCharArray();
        char[] negArr = neg.toCharArray();

        HashSet<Character> set = new HashSet<>();
        for (char c : pozArr) {
            set.add(c);
        }

        StringBuilder neg_output = new StringBuilder();
        for (char c : negArr) {
            if (!set.contains(c)) {
                neg_output.append(c);
            }
        }
        return neg_output.toString();
    }


}
