package com.interview.vaccines.utils;

import org.springframework.lang.NonNull;

public class StringUtils {

    public static boolean isPalindrome(@NonNull String str) {
        String lowerCase = str.toLowerCase();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (lowerCase.charAt(i) != lowerCase.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static int toInteger(@NonNull String str) {
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            number *= 10;
            number += Character.getNumericValue(str.charAt(i));
        }
        return number;
    }
}
