package com.example.practice_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
    Button btn_test;
    Button btn_test1;
    ImageView img_me;
    TextView txt_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_me = findViewById(R.id.img_me);
        et_id = findViewById(R.id.et_id);
        btn_test = findViewById(R.id.btn_test);
        btn_test1 = findViewById(R.id.btn_test1);
        txt_test = findViewById(R.id.txt_test);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_test.append("\n");
                txt_test.append(et_id.getText());
            }
        });

        btn_test1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt_test.append("\nGithub: hjj0525");
            }
        });

    }
}