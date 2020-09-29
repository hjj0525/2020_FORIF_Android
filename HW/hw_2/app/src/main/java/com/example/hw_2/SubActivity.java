package com.example.hw_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class SubActivity extends AppCompatActivity {


    private Button btn_Intent;
    private Button btn_submit;
    private NumberPicker np_month;
    private NumberPicker np_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btn_Intent = findViewById(R.id.btn_Intent);
        btn_submit = findViewById(R.id.btn_submit);
        np_month = findViewById(R.id.np_month);
        np_day = findViewById(R.id.np_day);

        np_month.setMinValue(1);
        np_month.setMaxValue(12);
        np_day.setMinValue(1);
        np_day.setMaxValue(31);

        btn_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int month = np_month.getValue();
                int day = np_day.getValue();

                if(month == 5 && day == 25){
                    makeText(SubActivity.this, "Correct", LENGTH_SHORT).show();
                }else{
                    makeText(SubActivity.this, "Wrong", LENGTH_SHORT).show();
                }
            }
        });


        btn_Intent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity.this, MainActivity.class);
                startActivity(intent); // Activity 이동
            }
        });
    }
}