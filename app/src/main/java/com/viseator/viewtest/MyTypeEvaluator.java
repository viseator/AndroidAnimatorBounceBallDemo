package com.viseator.viewtest;

import android.animation.TypeEvaluator;
import android.util.Log;

/**
 * Created by viseator on 3/18/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class MyTypeEvaluator implements TypeEvaluator {
    private static final String TAG = "@vir MyTypeEvaluator";

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
//        Log.d(TAG, String.valueOf(fraction));
        int start = ((Number) startValue).intValue();
        int end = ((Number) endValue).intValue();
        return (int) (start + fraction * (end - start)) ;
    }
}
