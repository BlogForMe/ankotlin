package com.android.util;

/**
 * Created by A on 2018/1/22.
 */

/**
 * Not a real crash reporting library!
 */
public class FakeCrashLibrary {
    public static void log(int priority, String tag, String message) {
    }

    public static void logWarning(Throwable t) {
    }

    public static void logError(Throwable t) {
    }

    private FakeCrashLibrary() {
        throw new AssertionError("No instances.");
    }
}
