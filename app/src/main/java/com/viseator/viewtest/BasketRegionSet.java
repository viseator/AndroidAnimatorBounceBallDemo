package com.viseator.viewtest;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.health.PackageHealthStats;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by viseator on 5/28/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class BasketRegionSet {
    private static final String TAG = "@vir BasketRegionSet";
    private static List<BasketRegion> mRegions = new ArrayList<>();
    private static BasketRegionSet instance;
    private float side;
    float y16;
    float r42;

    private BasketRegionSet() {
    }

    public static BasketRegionSet getInstance() {
        if (instance == null) {
            instance = new BasketRegionSet();
        }
        return instance;
    }

    public void setSide(int side) {
        this.side = side;
        y16 = (float) (16 / 150.0 * side);
        r42 = (float) (42 / 150.0 * side);
    }

    public void calRegions() {
        calRegion1();
        calRegion2();
        calRegion3();
        calRegion4();
        calRegion5();
        calRegion6();
        calRegion7();
    }

    private void calRegion1() {
        BasketRegion region = new BasketRegion();
        Path path = new Path();
        float r24 = (float) (side * 24.5 / 150);
        RectF rectF = new RectF(side / 2 - r24, -r24, side / 2 + r24, r24);
        path.addArc(rectF, 0, 180);
        path.moveTo(side / 2 - r24, 0);
        path.lineTo(side / 2 + r24, 0);
        boolean s = region.setPath(path, new Region(0, 0, (int) side, (int) side));
        Log.d(TAG, String.valueOf(s));
        region.setPaintAlpha(30);
        mRegions.add(region);
    }

    private void calRegion2() {
        Path path = new Path();
        path.moveTo(side / 2, 0);
        path.lineTo(side / 2, y16);
        path.lineTo((float) (side / 2 - r42 / Math.sin(Math.toRadians(45))),
                (float) (y16 + r42 / Math.sin(Math.toRadians(45))));
        RectF rectF = new RectF(side / 2 - r42, y16 - r42, side / 2 + r42, y16 + r42);
        path.arcTo(rectF, 135, 45);
        path.lineTo(side / 2 - r42, 0);
        BasketRegion region = new BasketRegion();
        region.setPath(path, new Region(0, 0, (int) side, (int) side));

        region.op(mRegions.get(0), Region.Op.DIFFERENCE);
        region.setPaintAlpha(50);
        mRegions.add(region);
    }

    private void calRegion3() {
        Path path = new Path();
        RectF rectF = new RectF(side / 2 - r42, y16 - r42, side / 2 + r42, y16 + r42);
        path.moveTo(side / 2, y16);
        path.lineTo((float) (side / 2 + r42 / Math.sin(Math.toRadians(45))),
                (float) (y16 + r42 / Math.sin(Math.toRadians(45))));
        path.arcTo(rectF, 45, 90);
        path.lineTo(side / 2, y16);
        BasketRegion region = new BasketRegion();
        region.setPath(path, new Region(0, 0, (int) side, (int) side));

        region.op(mRegions.get(0), Region.Op.DIFFERENCE);
        region.setPaintAlpha(100);
        mRegions.add(region);

    }

    private void calRegion4() {
        Path path = new Path();
        path.moveTo(side / 2, 0);
        path.lineTo(side / 2 + r42, 0);
        path.lineTo(side / 2 + r42, y16);
        RectF rectF = new RectF(side / 2 - r42, y16 - r42, side / 2 + r42, y16 + r42);
        path.arcTo(rectF, 0, 45);
//        path.lineTo((float) (side / 2 + r42 / Math.sin(Math.toRadians(45)))), (float) (y16 + r42 / Math.sin(Math.toRadians(45)))));
        path.lineTo(side / 2, y16);
        path.lineTo(side / 2, 0);
        BasketRegion region = new BasketRegion();
        region.setPath(path, new Region(0, 0, (int) side, (int) side));

        region.op(mRegions.get(0), Region.Op.DIFFERENCE);
        region.setPaintAlpha(80);
        mRegions.add(region);
    }

    private void calRegion5() {
        Path path = new Path();
        RectF rectF = new RectF((float) (-side * 0.25), (float) (y16 - side * 0.75),
                (float) (side * 1.25), (float) (y16 + side * 0.75));
        path.moveTo(side / 2, y16);
        path.lineTo((float) (side / 2 - side * 0.75 * Math.cos(Math.toRadians(22.5))),
                (float) (y16 + side * 0.75 * Math.sin(Math.toRadians(22.5))));
        path.arcTo(rectF, 157.5f, 22.5f);
        path.lineTo(0, 0);
        path.lineTo(side / 2, 0);
        path.lineTo(side / 2, y16);

        BasketRegion region = new BasketRegion();
        region.setPath(path, new Region(0, 0, (int) side, (int) side));

        region.op(mRegions.get(0), Region.Op.DIFFERENCE);
        region.op(mRegions.get(1), Region.Op.DIFFERENCE);
        region.setPaintAlpha(80);
        mRegions.add(region);
    }

    private void calRegion6() {
        Path path = new Path();
        RectF rectF = new RectF((float) (-side * 0.25), (float) (y16 - side * 0.75),
                (float) (side * 1.25), (float) (y16 + side * 0.75));
        path.moveTo(side / 2, y16);
        path.lineTo((float) (side / 2 - side * 0.75 * Math.cos(Math.toRadians(67.5))),
                (float) (y16 + side * 0.75 * Math.sin(Math.toRadians(67.5))));
        path.arcTo(rectF, 112.5f, 45f);
        path.lineTo(side / 2, y16);
        BasketRegion region = new BasketRegion();
        region.setPath(path, new Region(0, 0, (int) side, (int) side));

        region.op(mRegions.get(0), Region.Op.DIFFERENCE);
        region.op(mRegions.get(1), Region.Op.DIFFERENCE);
        region.op(mRegions.get(2), Region.Op.DIFFERENCE);
        region.op(new Region(0,(int)(side*95.0/150),(int)(side),(int)(side)), Region.Op.DIFFERENCE);
        region.setPaintAlpha(40);
        mRegions.add(region);
    }

    private void calRegion7() {
        Path path = new Path();
        RectF rectF = new RectF((float) (-side * 0.25), (float) (y16 - side * 0.75),
                (float) (side * 1.25), (float) (y16 + side * 0.75));
        path.moveTo(side / 2, y16);
        path.lineTo((float) (side / 2 + side * 0.75 * Math.cos(Math.toRadians(67.5))),
                (float) (y16 + side * 0.75 * Math.sin(Math.toRadians(67.5))));
        path.arcTo(rectF, 67.5f, 45);
        path.lineTo(side/2,y16);

        BasketRegion region = new BasketRegion();
        region.setPath(path, new Region(0, 0, (int) side, (int) side));

        region.op(mRegions.get(0), Region.Op.DIFFERENCE);
        region.op(mRegions.get(2), Region.Op.DIFFERENCE);
        region.op(new Region(0,(int)(side*95.0/150),(int)(side),(int)(side)), Region.Op.DIFFERENCE);
        region.setPaintAlpha(60);
        mRegions.add(region);

    }
    public static List<BasketRegion> getRegions() {
        return mRegions;
    }

    public static void setRegions(List<BasketRegion> regions) {
        mRegions = regions;
    }
}
