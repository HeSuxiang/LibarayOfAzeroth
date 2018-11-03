package com.cuisanzhang.libarayofazeroth;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainHistoryActivity extends Activity {


    private  String[] Historys = {
            "1.1 泰坦神话",
            "1.2 萨格拉斯的背叛",
            "1.3 上古之神与艾泽拉斯的秩序",
            "1.4 守护巨龙",
            "1.5 卡多雷和永恒之井",
            "1.6 上古战争",
            "1.7 世界的分裂",
            "1.8 海加尔山和伊利丹的礼物",
            "1.9 世界之树和翡翠梦境",
            "1.10 高等精灵的流放",
            "1.11 哨兵的长期卫戎",
            "1.12 奎尔萨拉斯的建立",
            "1.13 阿拉索与巨魔战争",
            "1.14 帝国的陷落",
            "1.15 提瑞法斯的守护者",

            "铁炉堡—矮人的觉醒",
            "七大王国",
            "艾格文与屠龙",
            "三锤之战",
            "最后的守护者",
            "基尔加丹和影子契约",
            "部落的崛起",
            "黑暗之门与暴风城的陷落",
            "洛丹伦联盟",
            "跨越黑暗之门",
            "德拉诺的入侵",
            "巫妖之王的诞生",
            "寒冰王冠与冰封王座",
            "格瑞姆巴托之战",
            "兽人的消沉",


            "新的部落",
            "蜘蛛之战",
            "克尔苏加德和天灾军团的建立",
            "联盟的分裂",
            "洛丹伦的天灾",
            "太阳之井—奎尔萨拉斯的沦陷",
            "阿克蒙德的归来和卡利姆多之旅",
            "背叛者的胜利",
            "血精灵的崛起",
            "瘟疫之地的内战",
            "巫妖王的胜利",
            "古老的仇恨-卡利姆多的开拓",
            "诅咒之路",
            "亡灵瘟疫流行病学",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_history);

        ListView listView = (ListView) findViewById(R.id.listView);

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

}
