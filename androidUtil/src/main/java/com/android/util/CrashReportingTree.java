package com.android.util;

import android.util.Log;

import timber.log.Timber;

/**
 * Created by jon on 2/1/18.
 */

public class CrashReportingTree extends Timber.Tree {

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }
        FakeCrashLibrary.log(priority, tag, message);
        if (t != null) {
            if (priority == Log.ERROR) {
                FakeCrashLibrary.logError(t);
            } else if (priority == Log.WARN) {
                FakeCrashLibrary.logWarning(t);
            }
        }
    }
}

