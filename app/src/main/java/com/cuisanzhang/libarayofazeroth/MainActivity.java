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
import android.widget.LinearLayout;
import android.widget.TextView;

import tyrantgit.explosionfield.ExplosionField;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private TextView main_history ;
    private TextView other_history;

    private ExplosionField explosionField;
    private Handler mHandler = new Handler();
    private Intent intent = null;


    private LinearLayout title;
    private LinearLayout logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_layout);


        explosionField = ExplosionField.attach2Window(MainActivity.this);

        title = findViewById(R.id.title);
        logo = findViewById(R.id.logo);

        title.setOnClickListener( MainActivity.this);
        logo.setOnClickListener( MainActivity.this);

//        mVisible = true;
        main_history = findViewById(R.id.main_history);
        other_history = findViewById(R.id.other_history);


        main_history.setOnClickListener(MainActivity.this);

        other_history.setOnClickListener(MainActivity.this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        StartAction(main_history);
        StartAction(other_history);

    }



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

    @Override
    public void onClick(View v) {
        intent = null;

        switch (v.getId()){

            case R.id.main_history:
                intent = new Intent(MainActivity.this, MainHistoryActivity.class);

                break;
            case R.id.other_history:
                intent = new Intent(MainActivity.this, OtherHistoryActivity.class);
                break;
//            case R.id.main_history3:
//
//
//                break;
            case R.id.title:
                break;
            case R.id.logo:
                break;

            default:
                break;
        }

        explosionField.explode(v);
        if(intent != null) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //跳转到MainActivity
                    startActivity(intent);
                }
            }, 1000);// n微妙后跳转
//            v.setVisibility(View.INVISIBLE);
        }
    }
//---------------------
//    作者：ruancoder
//    来源：CSDN
//    原文：https://blog.csdn.net/ruancoder/article/details/52357566
//    版权声明：本文为博主原创文章，转载请附上博文链接！
}
