package com.google.renpincalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/8/14 16:03
 * @des  计算器主页面
 */
public class CalcActivity extends Activity{
    private TextView result_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        result_tv = (TextView)findViewById(R.id.result_tv);

        Intent intent = getIntent();
        String data = intent.getData().toString();
        String name = data.replace("calc://", "");
        // 计算人品
        byte[] result = name.getBytes();
        int total = 0;
        for(byte b:result) {
            int number = b & 0xff;
            total+= number;
        }

        int rp = Math.abs(total) % 100;
        String desc ="";
        if(rp>90) {
            desc ="你的人品非同小可,坟上冒黑烟";
        }else if(rp>60) {
            desc = "你的人品不错哦";
        }else if(rp>30) {
            desc = "你有偷窥别人的人品";
        }else {
            desc = "你的人品..,hehe";
        }
        result_tv.setText(name+"的人品为："+rp+"\n"+desc);
    }
}
