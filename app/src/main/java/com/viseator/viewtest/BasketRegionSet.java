package com.viseator.viewtest;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
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
    }

    public void calRegions(){
        calRegion1();
    }

    private void calRegion1() {
        BasketRegion region = new BasketRegion();
        Path path = new Path();
        float r24 = (float) (side * 24.5 / 150);
        RectF rectF = new RectF(side / 2 - r24, -r24, side / 2 + r24, r24);
        path.addArc(rectF, 0, 180);
        path.moveTo(side/2-r24,0);
        path.lineTo(side/2+r24,0);
        boolean s =  region.setPath(path, new Region(0, 0, (int)side, (int)side));
        Log.d(TAG, String.valueOf(s));
        mRegions.add(region);
    }


    public static List<BasketRegion> getRegions() {
        return mRegions;
    }

    public static void setRegions(List<BasketRegion> regions) {
        mRegions = regions;
    }
}
