package com.android.anim.viewAnim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.R;

import static android.view.animation.LayoutAnimationController.ORDER_NORMAL;

public class AnimSetActivity extends AppCompatActivity {
    private static final String TAG = "AnimSetActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_set);

        final Button button = (Button) findViewById(R.id.button_anim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(AnimSetActivity.this, R.anim.view_anim);
                animation.setFillAfter(true);
                button.startAnimation(animation);
            }
        });

        final LinearLayout ll_layout_anim = (LinearLayout) findViewById(R.id.ll_layout_anim);
        findViewById(R.id.button_layout_anim_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(AnimSetActivity.this, R.anim.right_in);
                LayoutAnimationController controller = new LayoutAnimationController(animation);
                controller.setOrder(ORDER_NORMAL);
                controller.setDelay(0.5f);
                controller.setInterpolator(new DecelerateInterpolator());
                ll_layout_anim.setLayoutAnimation(controller);
                ll_layout_anim.setLayoutAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.d(TAG, "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.d(TAG, "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.d(TAG, "onAnimationRepeat");
                    }
                });
                ll_layout_anim.startLayoutAnimation();

            }
        });

    }
}
