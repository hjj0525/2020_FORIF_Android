package com.example.hw_4;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class RegActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSubmit;
    Button btnDelete;
    EditText editID;
    EditText editPW;
    EditText editName;
    EditText editAge;
    TextView textID;
    TextView textPW;
    TextView textName;
    TextView textAge;

    String ID;
    String name;
    String password;
    long age;
    String sort = "userid";
    ArrayAdapter<String> arrayAdapter;

    static ArrayList<String> arrayIndex =  new ArrayList<String>();
    static ArrayList<String> arrayData = new ArrayList<String>();
    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
        editID = (EditText)findViewById(R.id.editID);
        editPW = (EditText)findViewById(R.id.editPW);
        editName = (EditText)findViewById(R.id.editName);
        editAge = (EditText)findViewById(R.id.editAge);
        textID = (TextView)findViewById(R.id.textID);
        textPW = (TextView)findViewById(R.id.textPW);
        textName = (TextView)findViewById(R.id.textName);
        textAge = (TextView)findViewById(R.id.textAge);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        ListView listView = (ListView) findViewById(R.id.dbListView);
        listView.setAdapter(arrayAdapter);

        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        btnSubmit.setEnabled(true);
    }

    public void setInsertMode(){
        editID.setText("");
        editPW.setText("");
        editName.setText("");
        editAge.setText("");
        btnSubmit.setEnabled(true);
    }

    public void showDatabase(String sort){
        Cursor iCursor = mDbOpenHelper.sortColumn(sort);
        Log.d("showDatabase", "DB Size: " + iCursor.getCount());
        arrayData.clear();
        arrayIndex.clear();
        while(iCursor.moveToNext()){
            String tempIndex = iCursor.getString(iCursor.getColumnIndex("_id"));
            String tempID = iCursor.getString(iCursor.getColumnIndex("userid"));
            tempID = setTextLength(tempID,10);
            String tempPW = iCursor.getString(iCursor.getColumnIndex("password"));
            tempPW = setTextLength(tempPW,10);
            String tempName = iCursor.getString(iCursor.getColumnIndex("name"));
            tempName = setTextLength(tempName,10);
            String tempAge = iCursor.getString(iCursor.getColumnIndex("age"));
            tempAge = setTextLength(tempAge,10);

            String Result = tempID + tempPW+ tempName + tempAge;
            arrayData.add(Result);
            arrayIndex.add(tempIndex);
        }
        arrayAdapter.clear();
        arrayAdapter.addAll(arrayData);
        arrayAdapter.notifyDataSetChanged();
    }

    public String setTextLength(String text, int length){
        if(text.length()<length){
            int gap = length - text.length();
            for (int i=0; i<gap; i++){
                text = text + " ";
            }
        }
        return text;
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btnSubmit){
            ID = editID.getText().toString();
            password = editPW.getText().toString();
            name = editName.getText().toString();
            age = Long.parseLong(editAge.getText().toString());
            mDbOpenHelper.open();
            if (mDbOpenHelper.selectID(ID) == false){
                mDbOpenHelper.insertColumn(ID, password, name, age);
                showDatabase(sort);
                setInsertMode();
                editID.requestFocus();
                editID.setCursorVisible(true);
            }
            else{
                Toast.makeText(getApplicationContext(), "이미 존재하는 아이디입니다.",Toast.LENGTH_LONG).show();
                setInsertMode();
            }
        }
        else if(v.getId() == R.id.btnDelete){
            mDbOpenHelper.deleteAllColumns();
            showDatabase(sort);
        }
    }
}
