package com.viseator.viewtest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by viseator on 5/28/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class BasketView extends View {
    private BasketRegion region;
    private int side;
    private static final String TAG = "@vir BasketView";
    private Paint mPaint;
    private Paint supportPaint;
    private Paint mRedPaint;
    private Path supportPath;
    private BasketRegionSet mBasketRegionSet = BasketRegionSet.getInstance();

    private Path mPath;

    public BasketView(Context context) {
        super(context);
    }

    public BasketView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BasketView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BasketView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        drawBgLines();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
        canvas.drawPath(supportPath, supportPaint);
        for(int i = 0; i < mBasketRegionSet.getRegions().size(); i++) {
            BasketRegion basketRegion = mBasketRegionSet.getRegions().get(i);
            drawRegion(canvas, basketRegion, basketRegion.getPaint());
        }
    }

    private void init() {

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);
        supportPaint = new Paint(mPaint);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.BLACK);
        mRedPaint = new Paint(mPaint);
        mRedPaint.setColor(Color.RED);
        mRedPaint.setStyle(Paint.Style.FILL);
        supportPaint.setColor(Color.GRAY);
        supportPaint.setStrokeWidth(2);
        mPath = new Path();
        supportPath = new Path();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        side = width < height ? width : height;
        setMeasuredDimension(side, side);
        mBasketRegionSet.setSide(side);
        mBasketRegionSet.calRegions();

    }

    private void drawBgLines() {

        float height = (float) (side * 140 / 150.0);
        mPath.moveTo(0, 0);
        mPath.lineTo(side, 0);
        mPath.lineTo(side, height);
        mPath.lineTo(0, height);
        mPath.lineTo(0, 0);

        supportPath.moveTo(side / 2, 0);
        supportPath.lineTo(side / 2, side);

        float r18 = (float) (18 / 150.0 * side);
        RectF smallRect = new RectF(side / 2 - r18, height - r18, side / 2 + r18, height + r18);
        mPath.addArc(smallRect, 180, 180);

        float rectWidth = (float) (49 / 150.0 * side);
        float rectHeight = (float) (58 / 150.0 * side);
        RectF mainRect = new RectF(side/2-rectWidth/2,0,side/2+rectWidth/2,rectHeight);
        mPath.addRect(mainRect, Path.Direction.CW);

        smallRect.set(side/2-r18,rectHeight-r18,side/2+r18,rectHeight+r18);
        mPath.addArc(smallRect,0,180);

        float y16 = (float) (16/150.0*side);
        float r67 = (float) (67.28/150*side);
        mPath.moveTo(side/2-r67,0);
        mPath.lineTo(side/2-r67,y16);
        mPath.moveTo(side/2+r67,0);
        mPath.lineTo(side/2+r67,y16);

        RectF bigRect = new RectF(side/2-r67,y16-r67,side/2+r67,y16+r67);
        mPath.addArc(bigRect,0,180);

        /*Test Below*/
//        region = new BasketRegion();
//        Path path = new Path();
//        float r24 = (float) (side * 24.5 / 150);
//        RectF rectF = new RectF(side / 2 - r24, -r24, side / 2 + r24, r24);
//        path.addArc(rectF, 0, 180);
//        path.moveTo(side/2-r24,0);
//        path.lineTo(side/2+r24,0);
//        boolean s =  region.setPath(path, new Region(0, 0, 1000, 1000));
    }

    private void drawRegion(Canvas c, BasketRegion basketRegion,Paint paint) {
        RegionIterator regionIterator = new RegionIterator(basketRegion);
        Rect r = new Rect();
        while (regionIterator.next(r)) {
            c.drawRect(r,paint);
        }
    }
    private int convertDpToPx(int dp) {
        return Math.round(dp * (getResources().getDisplayMetrics().xdpi / DisplayMetrics.DENSITY_DEFAULT));

    }

    private int convertPxToDp(int px) {
        return Math.round(px / (Resources.getSystem().getDisplayMetrics().xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
