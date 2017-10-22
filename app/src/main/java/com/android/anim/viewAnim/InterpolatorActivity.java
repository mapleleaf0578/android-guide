package com.android.anim.viewAnim;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;

import com.android.R;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.LineData;

public class InterpolatorActivity extends AppCompatActivity {

    private float[] xs = {0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);

        ll = (LinearLayout) findViewById(R.id.container);

        setChart(new AccelerateDecelerateInterpolator(), Color.BLUE);
        setChart(new AccelerateInterpolator(), Color.BLACK);
        setChart(new AnticipateInterpolator(), Color.CYAN);
        setChart(new AnticipateOvershootInterpolator(), Color.DKGRAY);
        setChart(new BounceInterpolator(), Color.GREEN);
        setChart(new CycleInterpolator(1f), Color.MAGENTA);
        setChart(new DecelerateInterpolator(), Color.RED);
        setChart(new FastOutLinearInInterpolator(), Color.YELLOW);
        setChart(new FastOutSlowInInterpolator(), Color.LTGRAY);
        setChart(new LinearInterpolator(), Color.BLUE);
        setChart(new LinearOutSlowInInterpolator(), Color.BLACK);
        setChart(new OvershootInterpolator(), Color.RED);
        setChart(new PathInterpolator(0.5f, 1f), Color.MAGENTA);

    }

    private void setChart(Interpolator interpolator, @ColorInt int color) {
        Chart<LineData> chart = InterpolatorHelper.getChart(this, xs, interpolator, color);
        ll.addView(chart);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) chart.getLayoutParams();
        lp.height = 1000;
        lp.bottomMargin = 100;
        lp.topMargin = 100;
        chart.invalidate();
    }
}
