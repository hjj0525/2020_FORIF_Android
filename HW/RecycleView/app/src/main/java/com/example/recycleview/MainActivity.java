package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String[] nameList = {"C", "C++", "C#", "CSS", "HTML", "JS"};
    String[] descriptionList = {"C_description", "C++_description", "C#_description", "CSS_description", "HTML_description", "JS_description"};

    int[] iconList = {R.drawable.c, R.drawable.cplusplus, R.drawable.csharp, R.drawable.css, R.drawable.html, R.drawable.javascript};

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Inflation

        recyclerView = findViewById(R.id.view_RV);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(this, nameList, descriptionList, iconList);
        recyclerView.setAdapter(myAdapter);
    }
}