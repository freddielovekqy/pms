package com.ntu.pms.utils;

import java.util.Random;

public class StringUtils {

    public static String getRandomUrlString() {
        Random rand = new Random();
        final int A = 'A', z = 'z';
        StringBuilder builder = new StringBuilder();

        while (builder.length() < 10) {
            int number = rand.nextInt(z + 1);
            if (number >= A && !(number <= 96 && number >= 91)) {
                builder.append((char) number);
            }
        }
        return builder.toString();
    }
}
