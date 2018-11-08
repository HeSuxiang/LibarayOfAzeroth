package com.cuisanzhang.libarayofazeroth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
public class OtherHistoryActivity extends Activity implements View.OnClickListener {

    private TextView other_history1;
    private TextView other_history2;
    private TextView other_history3;
    private TextView other_history4;
    private TextView other_history5;
    private TextView other_history6;

    private LinearLayout title;
    private LinearLayout logo;
    private ExplosionField explosionField;
    private Handler mHandler = new Handler();
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_other_history);

        explosionField = ExplosionField.attach2Window(OtherHistoryActivity.this);
        title = findViewById(R.id.title);
        logo = findViewById(R.id.logo);


        other_history1 = findViewById(R.id.other_history1);
        other_history2 = findViewById(R.id.other_history2);
        other_history3 = findViewById(R.id.other_history3);
        other_history4 = findViewById(R.id.other_history4);
        other_history5 = findViewById(R.id.other_history5);
        other_history6 = findViewById(R.id.other_history6);

        title.setOnClickListener( OtherHistoryActivity.this);
        logo.setOnClickListener( OtherHistoryActivity.this);


        other_history1.setOnClickListener(OtherHistoryActivity.this);
        other_history2.setOnClickListener(OtherHistoryActivity.this);
        other_history3.setOnClickListener(OtherHistoryActivity.this);
        other_history4.setOnClickListener(OtherHistoryActivity.this);
        other_history5.setOnClickListener(OtherHistoryActivity.this);
        other_history6.setOnClickListener(OtherHistoryActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();


        StartAction(other_history1);
        StartAction(other_history2);
        StartAction(other_history3);
        StartAction(other_history4);
        StartAction(other_history5);
        StartAction(other_history6);
    }

    void StartAction(View view) {

        // 以view中心为缩放
        ScaleAnimation animation = new ScaleAnimation(
                0.6f, 1.0f, 0.6f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        );
        animation.setDuration(3000);
        view.startAnimation(animation);
    }
//---------------------
//    作者：ruancoder
//    来源：CSDN
//    原文：https://blog.csdn.net/ruancoder/article/details/52357566
//    版权声明：本文为博主原创文章，转载请附上博文链接！


    @Override
    public void onClick(View v) {

        intent = null;
        switch (v.getId()){

            case R.id.other_history1:
                intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity1.class);

                break;
            case R.id.other_history2:
                intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity2.class);

                break;
            case R.id.other_history3:
                intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity3.class);
                break;
            case R.id.other_history4:
                intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity4.class);
                break;
            case R.id.other_history5:
                intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity5.class);
                break;
            case R.id.other_history6:
                intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity6.class);
                break;
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
        }

    }
}
