package com.wdl.lottiedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";
    private LottieAnimationView mLav;
    private Button mPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLav = findViewById(R.id.lav);
        mPlay = findViewById(R.id.btn_play);

        // 添加动画监听
        mLav.addAnimatorListener(new Animator.AnimatorListener()
        {
            @Override
            public void onAnimationStart(Animator animation)
            {
                Log.e(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animator animation)
            {
                Log.e(TAG, "onAnimationEnd: ");
            }

            @Override
            public void onAnimationCancel(Animator animation)
            {
                Log.e(TAG, "onAnimationCancel: ");
            }

            @Override
            public void onAnimationRepeat(Animator animation)
            {
                Log.e(TAG, "onAnimationRepeat: ");
            }
        });

        mLav.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                Log.e(TAG, "onAnimationRepeat: " + animation.getAnimatedValue());
            }
        });

        // 自定义动画时长以及速度
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(6000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                mLav.setProgress((Float) animation.getAnimatedValue());
            }
        });


        mPlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!mLav.isAnimating())
                {
                    mLav.playAnimation();
                } else
                {
                    mLav.pauseAnimation();
                }
            }
        });
    }
}
