package com.div.expensemanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class TripDetailsReportActivity extends AppCompatActivity
{
    SQLiteDatabase database;
    TextView tv1;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details_report);
    email=getIntent().getExtras().getString("email");
    tv1=findViewById(R.id.textView1);
    show();
    }//end of onCreate()

    public void show()
    {

             database=openOrCreateDatabase("trip", Context.MODE_PRIVATE,null);
             String sql="select * from trip_details where email="+email;
             System.out.println("query" + sql);
             if(sql==null)
             {
                 Toast.makeText(this,"No trip registeres!!",Toast.LENGTH_SHORT);
             }
             Cursor cursor=database.rawQuery(sql,null);
             String trip_id,begin,destination,start,end;
             tv1.setText("trip ID  :   Beginning   :   Destination  :,Start_Date   :,   End_Date   :");
             while (cursor.moveToNext())
             {
                trip_id=cursor.getString(1);
                begin=cursor.getString(2);
                destination=cursor.getString(3);
                start=cursor.getString(4);
                end=cursor.getString(5);
                String row=trip_id+"  :  "+begin+"   :   "+destination+" : "+start+"  :   "+end;
                tv1.append("\n"+row);
             }

    }

}

