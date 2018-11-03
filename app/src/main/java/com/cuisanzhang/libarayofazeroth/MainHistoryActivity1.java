package com.cuisanzhang.libarayofazeroth;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainHistoryActivity1 extends Activity {

    private ListView listView;

    private  String[] Historys = {
            "01  泰坦神话",
            "02  萨格拉斯的背叛",
            "03  上古之神与艾泽拉斯的秩序",
            "04  守护巨龙",
            "05  卡多雷和永恒之井",
            "06  上古战争",
            "07  世界的分裂",
            "08  海加尔山和伊利丹的礼物",
            "09  世界之树和翡翠梦境",
            "10  高等精灵的流放",
            "11  哨兵的长期卫戎",
            "12  奎尔萨拉斯的建立",
            "13  阿拉索与巨魔战争",
            "14  帝国的陷落",
            "15  提瑞法斯的守护者",

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
            public View getView(int position, View convertView, ViewGroup parent) {
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

//                holder.name.setText(block.getMaterial());

                return convertView;
            }

        }

    @Override
    protected void onResume() {
        super.onResume();

        startAlphaAnimation(listView);
    }

    public void startAlphaAnimation(View view){
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