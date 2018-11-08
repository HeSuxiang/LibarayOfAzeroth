package com.cuisanzhang.libarayofazeroth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import tyrantgit.explosionfield.ExplosionField;

public class OtherHistoryActivity3 extends Activity {

    private ListView listView;
    private ExplosionField explosionField;
    private Handler mHandler = new Handler();

    private String[] Historys = {
            "卡兹戈姆的日记",
            "莫里·铁钻的日记",
            "格瑞林·白须的日记",
            "巴尔洛戈的日记",
            "染血的日记",
            "泰洛尼斯的日记",
            "吉尔尼的日记",
            "亨里格·独眉的日记",
            "斯温农场中的书",
            "贝拉摩尔的研究日记",
            "荆棘谷的青山",

//                 "01  卡兹戈姆的日记",
//                //"2",
//                "02  莫里·铁钻的日记",
//                "03  格瑞林·白须的日记",
//                "04  巴尔洛戈的日记",
//                "05  染血的日记",
//                "06  泰洛尼斯的日记",
//                "07  吉尔尼的日记",
//                "08  亨里格·独眉的日记",
//                "09  斯温农场中的书",
//                "10  贝拉摩尔的研究日记",
//                "11  荆棘谷的青山",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_history_list);

        listView = (ListView) findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(getApplicationContext());

        listView.setAdapter(adapter);

        //去掉分割线
        listView.setDividerHeight(0);
        explosionField = ExplosionField.attach2Window(this);

    }

    private class MyAdapter extends BaseAdapter {

        private final class ViewHolder {
            //            private String name;
            private TextView textView;
        }

        private LayoutInflater mInflater = getLayoutInflater();
        private ViewHolder holder = null;

        private MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return Historys.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            final int pos = position;

            if (convertView == null) {

                holder = new ViewHolder();

                convertView = mInflater.inflate(R.layout.layout_listview_item, null);

//                    holder.name = "";

                holder.textView = (TextView) convertView
                        .findViewById(R.id.textView);

                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();

            }


            holder.textView.setText(Historys[position]);
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    explosionField.explode(v);

                    //延时执行
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //跳转到MainActivity
                            Intent intent = new Intent(OtherHistoryActivity3.this, WebViewActivity.class);
                            intent.putExtra(WebViewActivity.EXTRA_URI, "html/2/3/" + (position + 1) + ".html");
                            startActivity(intent);


                        }
                    }, 800);// n微妙后跳转

                }
            });
//                holder.name.setText(block.getMaterial());

            return convertView;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        startAlphaAnimation(listView);
    }

    public void startAlphaAnimation(View view) {
        /**
         * @param fromAlpha 开始的透明度，取值是0.0f~1.0f，0.0f表示完全透明， 1.0f表示和原来一样
         * @param toAlpha 结束的透明度，同上
         */
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        //设置动画持续时长
        alphaAnimation.setDuration(3000);

        //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
        alphaAnimation.setFillAfter(true);

        //开始动画
        view.startAnimation(alphaAnimation);
    }
//        ---------------------
//                作者：Itgo_Ben
//        来源：CSDN
//        原文：https://blog.csdn.net/shibin1990_/article/details/51602498
//        版权声明：本文为博主原创文章，转载请附上博文链接！


}
