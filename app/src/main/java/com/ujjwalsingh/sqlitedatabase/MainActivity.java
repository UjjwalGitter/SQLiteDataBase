package com.ujjwalsingh.sqlitedatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Log.i("kzzfirst", "gr");
            SQLiteDatabase users = this.openOrCreateDatabase("People", MODE_PRIVATE, null);
            Log.i("kzzsec", "a");
            users.execSQL("Create Table If Not Exists People(Name VARCHAR, Age INT(3) )");
            Log.i("kzzthird", "a");
            users.execSQL("Insert Into People(Name, Age) values ('Ujjwal',19),('Space',23),('rocket',30)");
            //users.execSQL("Insert Into People(Name, Age) values ('DEaval',19)");
            Log.i("kzzfour", "a");

            Cursor c = users.rawQuery("SELECT * FROM People", null);
            Log.i("kzzfifth", "a");

            int nameIndex = c.getColumnIndex("Name");
            int ageIndex = c.getColumnIndex("Age");
            Log.i("kzzsix", "a");
            c.moveToFirst();
            while (c != null) {
                Log.i("kzzseven", "a");
                Log.i("name: ", c.getString(nameIndex));
                Log.i("age: ", c.getString(ageIndex));
                Log.i("kzzeight", "a");
                c.moveToNext();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
