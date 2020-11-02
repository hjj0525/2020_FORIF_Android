package com.example.hw_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int act2 = 1001;
    public DbOpenHelper mDbOpenHelper;

    ImageButton imgBtn;
    Button regBtn;
    EditText editID;
    EditText editPW;

    String ID;
    String PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtn = findViewById(R.id.imgBtn);
        regBtn = findViewById(R.id.regBtn);
        editID = findViewById(R.id.editID);
        editPW = findViewById(R.id.editPW);

        AnimationDrawable animationDrawable = (AnimationDrawable) imgBtn.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        regBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegActivity.class);
                startActivity(intent);
            }
        });

        imgBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ID = editID.getText().toString();
                PW = editPW.getText().toString();
                mDbOpenHelper.open();

                if(mDbOpenHelper.loginChecker(ID, PW) == true){
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    intent.putExtra("ID", ID);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "존재하지 않는 아이디이거나, 패스워드가 일치하지 않습니다.",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}