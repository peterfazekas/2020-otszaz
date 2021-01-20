package hu.store.model.service;

public class ValueCalculator {

    private static final int[] VALUES = {0, 500, 950, 1350};
    private static final int DIFFERENCE = 400;

    public static int calculate(long count) {
        return ertek((int) count);
    }

    private static int ertek(int db) {
        return db < VALUES.length
                ? VALUES[db]
                : VALUES[VALUES.length - 1] + DIFFERENCE * (db - VALUES.length + 1);
    }
}
