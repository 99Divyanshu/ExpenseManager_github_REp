package com.div.expensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogInResultActivity extends AppCompatActivity
{
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_result);
        email=getIntent().getExtras().getString("email");
    }//end of onCreate()

    public void clicked(View view)
    {
      switch(view.getId())
      {
          case R.id.button1:
              Intent intent=new Intent(LogInResultActivity.this,AddTripActivity.class);
              intent.putExtra("email",email);
              startActivity(intent);
              break;

          case R.id.button3:
              intent=new Intent(LogInResultActivity.this,ReportTripActivity.class);
              intent.putExtra("email",email);
              startActivity(intent);
              break;
          case R.id.button4:
              intent=new Intent(LogInResultActivity.this,DeleteTripActivity.class);
              startActivity(intent);
              break;
      }
    }
}
