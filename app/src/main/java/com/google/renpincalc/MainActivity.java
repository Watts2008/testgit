package com.google.renpincalc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button start_btn;
    private EditText name_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_btn = (Button)findViewById(R.id.start_btn);
        name_et = (EditText)findViewById(R.id.name_et);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到第二个界面上
                Intent intent = new Intent();
                intent.setAction("com.google.renpincalc.CALC");
                intent.setData(Uri.parse("calc://"+name_et.getText().toString()));
                startActivity(intent);
            }
        });

    }
}
