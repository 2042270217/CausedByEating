package org.example.utils;

import java.util.Random;

public class IdGeneratorUtils {
    private static final int MAX_RANGE = 9999999;
    private static final int MIN_RANGE = 1000000;
    private static final Random random = new Random();

    public static String genId() {
        int id = MIN_RANGE + random.nextInt(MAX_RANGE - MIN_RANGE + 1);
        return String.valueOf(id);
    }
}
