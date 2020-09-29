package com.example.hw_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_plus;
    private Button btn_plus1;
    private Button btn_plus5;
    private Button btn_plus10;
    private Button btn_Intent;
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // sub actvity와 연결

        tv_plus = findViewById(R.id.tv_plus);
        btn_plus1 = findViewById(R.id.btn_plus1);
        btn_plus5 = findViewById(R.id.btn_plus5);
        btn_plus10 = findViewById(R.id.btn_plus10);
        btn_Intent = findViewById(R.id.btn_Intent);


        btn_plus1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num+=1;
                tv_plus.setText(Integer.toString(num));
            }
        });

        btn_plus5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num+=5;
                tv_plus.setText(Integer.toString(num));
            }
        });

        btn_plus10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num+=10;
                tv_plus.setText(Integer.toString(num));
            }
        });

        btn_Intent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent); // Activity 이동
            }
        });

    }
}