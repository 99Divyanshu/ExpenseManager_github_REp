package com.div.expensemanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteTripActivity extends AppCompatActivity
{
    SQLiteDatabase database;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_trip);
        et1=findViewById(R.id.editText1);
    }//end of onCreate()

    public void delete(View view)
    {
        database=openOrCreateDatabase("Trip", Context.MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("Select trip_id from trip_details",null);
        if(!et1.equals(cursor.getString(1)))
        {
            Toast.makeText(this, "Trip with this ID does not exist!! ", Toast.LENGTH_SHORT).show();
        }
        else
        {
           database.execSQL("delete from trip_details where trip_id="+et1);
            Toast.makeText(this, "Trip details Removed!!", Toast.LENGTH_SHORT).show();
        }
    }
}
