package com.cuisanzhang.libarayofazeroth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends Activity {

    private TextView main_history ;
    private TextView other_history;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_layout);

//        mVisible = true;
        main_history = findViewById(R.id.main_history);
        other_history = findViewById(R.id.other_history);


        // Set up the user interaction to manually show or hide the system UI.
//        mControlsView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                toggle();
//                Log.e("log=" , "OnClickListener");
//            }
//        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
//        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);

        StartAction(main_history);
        StartAction(other_history);
        main_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainHistoryActivity.class);

                startActivity(intent);
            }
        });

        other_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OtherHistoryActivity.class);

                startActivity(intent);
            }
        });
    }

//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//
//        // Trigger the initial hide() shortly after the activity has been
//        // created, to briefly hint to the user that UI controls
//        // are available.
//        delayedHide(100);
//        Log.e("log=" , "onPostCreate");
//    }
//
//    private void toggle() {
////        if (mVisible) {
//            hide();
//            Log.e("log=" , "toggle hide");
////        }
////        else {
////            show();
////            Log.e("log=" , "toggle show");
////        }
//    }
//
//    private void hide() {
//        // Hide UI first
//        Log.e("log=" , "hide");
//
//        //ActionBar actionBar = getSupportActionBar();
////        if (actionBar != null) {
////            actionBar.hide();
////        }
////        mControlsView.setVisibility(View.GONE);
////        mVisible = false;
//
//        // Schedule a runnable to remove the status and navigation bar after a delay
////        mHideHandler.removeCallbacks(mShowPart2Runnable);
//        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
//    }
//
////    @SuppressLint("InlinedApi")
////    private void show() {
////        // Show the system bar
////        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
////                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
////        mVisible = true;
////
////        Log.e("log=" , "show");
////        // Schedule a runnable to display UI elements after a delay
////        mHideHandler.removeCallbacks(mHidePart2Runnable);
////        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
////    }
//
//    /**
//     * Schedules a call to hide() in [delay] milliseconds, canceling any
//     * previously scheduled calls.
//     */
//    private void delayedHide(int delayMillis) {
//        Log.e("log=" , "delayedHide");
//        mHideHandler.removeCallbacks(mHideRunnable);
//        mHideHandler.postDelayed(mHideRunnable, delayMillis);
//    }


    void StartAction(View view) {

        // 以view中心为缩放点，由初始状态放大两倍
        ScaleAnimation animation = new ScaleAnimation(
                0.6f, 1.0f, 0.6f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        );
        animation.setDuration(3000);
//        animation.setRepeatCount(1);
        //animation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(animation);
    }
//---------------------
//    作者：ruancoder
//    来源：CSDN
//    原文：https://blog.csdn.net/ruancoder/article/details/52357566
//    版权声明：本文为博主原创文章，转载请附上博文链接！
}
