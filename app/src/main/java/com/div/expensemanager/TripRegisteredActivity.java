package com.div.expensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TripRegisteredActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_registered);
    }//end of onCreate()

    public void addtrip(View v)
    {
        Intent i=new Intent(TripRegisteredActivity.this,LogInResultActivity.class);
        startActivity(i);

    }
}
