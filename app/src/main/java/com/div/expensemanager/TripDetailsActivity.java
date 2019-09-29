package com.div.expensemanager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class TripDetailsActivity extends AppCompatActivity
{
EditText et1,et2,et3,et4,et5;
SQLiteDatabase database;
String email;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
        et4=findViewById(R.id.editText4);
        et5=findViewById(R.id.editText5);
        email=getIntent().getExtras().getString("email");
    }//end of onCreate()
    public void trip(View view)
    {
       String tripId=et1.getText().toString();
       String begin=et2.getText().toString();
       String destination=et3.getText().toString();
       String start=et4.getText().toString();
       String end=et5.getText().toString();

        database=openOrCreateDatabase("trip", Context.MODE_PRIVATE,null);

        if(tripId.isEmpty()||begin.isEmpty()||destination.isEmpty()||start.isEmpty()||end.isEmpty())
            {
                Toast.makeText(TripDetailsActivity.this, "Please fill the fields!!", Toast.LENGTH_SHORT).show();
            }
        else
            {
                database.execSQL("create table if not exists trip_details(email varchar,trip_id varchar not null primary key,beginning varchar,destination varchar,start_date date,end_date date)");

                tripId="'"+tripId+"'";
                begin="'"+begin+"'";
                destination="'"+destination+"'";
                start="'"+start+"'";
                end="'"+end+"'";
                email="'"+email+"'";

                database.execSQL("insert into trip_details(email,trip_id,beginning,destination,start_date,end_date)" + "values("+email+"," + tripId + "," + begin + "," + destination + "," + start + "," + end + ")");
                Intent intent=new Intent(TripDetailsActivity.this,TripRegisteredActivity.class);
                startActivity(intent);

            }

    }

}

