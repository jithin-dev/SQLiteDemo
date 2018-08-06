package com.jithin.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentDbHelper dbHelper = new StudentDbHelper(this);

        // Write

        SQLiteDatabase db1 = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("sid", 9);
        values.put("sname", "Shajohn");
        values.put("marks", 37);

        db1.insert("student",null,values);

        // Read

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String projection[] = {"sid","sname","marks"};
        Cursor c = db.query("student",projection,null,null,null,null,null);


        for (int i=0; i<3; i++){
            c.moveToPosition(i);
            System.out.println("student id is: " + c.getString(0));
            System.out.println("name is: " + c.getString(1));
            System.out.println("mark is: " + c.getString(2));
        }
    }
}
