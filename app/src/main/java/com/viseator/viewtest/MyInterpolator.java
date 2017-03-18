package com.viseator.viewtest;

import android.animation.TimeInterpolator;
import android.util.Log;

/**
 * Created by viseator on 3/18/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class MyInterpolator implements TimeInterpolator {
    private static final String TAG = "@vir MyInterpolator";

    @Override
    public float getInterpolation(float input) {
//        Log.d(TAG, String.valueOf(input));
        return input * input;
    }
}
