package com.div.expensemanager;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddTripActivity extends AppCompatActivity
{
int i;
String email;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        email=getIntent().getExtras().getString("email");
    }//end of onCreate()

    public void details(View view)
    {
        i=view.getId();
       new Handler().postDelayed(new Runnable()
       {
           @Override
           public void run()
           {
               switch (i)
               {
                   case R.id.button1:
                       Intent i=new Intent(AddTripActivity.this,TripDetailsActivity.class);
                       i.putExtra("email",email);
                       startActivity(i);
                       break;
                   case R.id.button2:
                       i=new Intent(AddTripActivity.this,ExpenseDetailsActivity.class);
                       i.putExtra("email",email);
                       startActivity(i);
                       break;
               }
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
           }
       },500);

    }
}
