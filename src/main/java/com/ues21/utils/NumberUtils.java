package com.ues21.utils;

import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by fleon on 1/7/17.
 */
public class NumberUtils {

    public static int getRandomTo(int limit) {
        // From 0 to limit:
        limit = Math.abs(limit);

        Long seed = new GregorianCalendar().getTimeInMillis();
        return new Random(seed).nextInt(limit) + 1;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}
