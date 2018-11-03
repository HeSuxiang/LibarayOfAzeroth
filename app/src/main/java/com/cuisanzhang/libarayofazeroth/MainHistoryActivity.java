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
public class MainHistoryActivity extends Activity {

    private TextView main_history1;
    private TextView main_history2;
    private TextView main_history3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_history);

        main_history1 = findViewById(R.id.main_history1);
        main_history2 = findViewById(R.id.main_history2);
        main_history3 = findViewById(R.id.main_history3);


        main_history1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHistoryActivity.this, MainHistoryActivity1.class);

                startActivity(intent);
            }
        });

        main_history2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHistoryActivity.this, MainHistoryActivity2.class);

                startActivity(intent);
            }
        });

        main_history3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHistoryActivity.this, MainHistoryActivity3.class);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


        StartAction(main_history1);
        StartAction(main_history2);
        StartAction(main_history3);
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
