package com.div.expensemanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class ExpenseDetailsReportActivity extends AppCompatActivity
{
    SQLiteDatabase database;
    String email;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_details_report);
        tv1=findViewById(R.id.textView1);
        email=getIntent().getExtras().getString("email");
    }
    public void show(View view)
    {
            database=openOrCreateDatabase("Trip", Context.MODE_PRIVATE,null);
            Cursor cursor=database.rawQuery("select * from ExpenseDetails where email="+email,null);
            String exp_id,trip_id,date;

            int allot,travel,food,shop,others,balance;
            while (cursor.moveToNext())
            {
                exp_id=cursor.getString(1);
                trip_id=cursor.getString(2);
                date=cursor.getString(3);
                allot=cursor.getInt(4);
                travel=cursor.getInt(5);
                food=cursor.getInt(6);
                shop=cursor.getInt(7);
                others=cursor.getInt(8);
                balance=cursor.getInt(9);
                String row=exp_id+" : "+trip_id+" : "+date+"  :  "+ allot+"  :  "+travel+" : "+food+" : "+shop+" : "+others+" : "+balance;

                tv1.append("\n"+row);

            }
        }
    }

