package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDataBase db = new MyDataBase(this);

        ListView listView = findViewById(R.id.list);

        ArrayList<User> arrayList = db.getAllUser();

        UserAdapter userAdapter = new UserAdapter(arrayList,this);

        listView.setAdapter(userAdapter);






    }
}