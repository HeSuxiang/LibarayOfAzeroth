package com.cuisanzhang.libarayofazeroth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class OtherHistoryActivity extends Activity {

    private TextView other_history1;
    private TextView other_history2;
    private TextView other_history3;
    private TextView other_history4;
    private TextView other_history5;
    private TextView other_history6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_other_history);

        other_history1 = findViewById(R.id.other_history1);
        other_history2 = findViewById(R.id.other_history2);
        other_history3 = findViewById(R.id.other_history3);
        other_history4 = findViewById(R.id.other_history4);
        other_history5 = findViewById(R.id.other_history5);
        other_history6 = findViewById(R.id.other_history6);


        other_history1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity1.class);

                startActivity(intent);
            }
        });

        other_history2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity2.class);

                startActivity(intent);
            }
        });

        other_history3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity3.class);

                startActivity(intent);
            }
        });
        other_history4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity4.class);

                startActivity(intent);
            }
        });
        other_history5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity5.class);

                startActivity(intent);
            }
        });
        other_history6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherHistoryActivity.this, OtherHistoryActivity6.class);

                startActivity(intent);
            }
        });
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
}
