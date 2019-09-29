package com.div.expensemanager;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegistrationCompleteActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_complete);
        TextView tv1=findViewById(R.id.textView1);
    }//end of onCreate()
    public void click(View view)
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i=new Intent(RegistrationCompleteActivity.this,LogInActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        },1000);

    }
}
