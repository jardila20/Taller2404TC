package org.jpavlich.util;

public class Stopwatch {
    private long startTime;
    private boolean first = true;

    public long elapsed() {
        if (first) {
            startTime = System.currentTimeMillis();
            first = false;
            return 0;
        } else {
            return System.currentTimeMillis() - startTime;
        }
    }

}
