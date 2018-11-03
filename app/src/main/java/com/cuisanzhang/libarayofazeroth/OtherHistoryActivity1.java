package com.cuisanzhang.libarayofazeroth;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class OtherHistoryActivity1 extends Activity {

    private ListView listView;

    private  String[] Historys = {
            "01  黎明之雾",
            "02  大地母亲的悲伤",

            "03  月神与白鹿",
            "04  森林之王与最初的德鲁伊",
            "05  半人马的仇恨",
            "06  两个帝国",
            "07  帝国的陷落",
            "08  巨魔传说",
            "09  噬灵者的愤怒",
            "10  堕落者纲要",
            "11  亡灵的起源",
            "12  第二次兽人战争的结局",
            "13  达隆郡全史",
            "14  流沙之战",
            "15  魔兽世界 中文官方网站 World Of Warcraft - 冬幕节",



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
