package com.viseator.viewtest;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Region;

/**
 * Created by viseator on 5/28/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class BasketRegion extends Region {

    private Paint mPaint;
    public BasketRegion(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.RED);
        mPaint.setAlpha(0);
    }

    public void setPaintAlpha(int alpha){
        mPaint.setAlpha((int) (alpha / 100f * 255));
    }

    public Paint getPaint() {
        return mPaint;
    }
}
