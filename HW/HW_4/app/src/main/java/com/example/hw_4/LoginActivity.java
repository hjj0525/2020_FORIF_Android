package com.example.hw_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    TextView userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userID = (TextView)findViewById(R.id.userID);

        Intent intent = getIntent();

        String id = intent.getExtras().getString("ID");
        userID.setText(id);
    }
}