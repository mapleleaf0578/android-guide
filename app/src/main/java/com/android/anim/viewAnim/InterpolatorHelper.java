package com.android.anim.viewAnim;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Min Lei on 2017/10/21.
 * Email:leimin@souche.com, leiminzju@gmail.com
 */

public class InterpolatorHelper {

    public static Chart<LineData> getChart(Context context, float[] xs, Interpolator interpolator, @ColorInt int color) {
        LineChart chart = new LineChart(context);
        List<Entry> adiEntries = new ArrayList<>();

        for (float xValue : xs) {
            adiEntries.add(new Entry(xValue, interpolator.getInterpolation(xValue)));
        }

        LineDataSet dataSet = new LineDataSet(adiEntries, interpolator.getClass().getSimpleName());
        dataSet.setColor(color);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);

        return chart;
    }

}
