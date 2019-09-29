package com.div.expensemanager;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity
{
    TextView tv2,tv3,tv4,tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        tv2=findViewById(R.id.textView2);
        tv2.setSelected(true);
        tv3=findViewById(R.id.textView3);
        tv4=findViewById(R.id.textView3);
        tv5=findViewById(R.id.textView5);
        tv5.setSelected(true);
    }

    public void signUp(View view)
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent=new Intent(HomeScreen.this,SignUpActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

            }
        },1000);

    }
    public void logIn(View view)
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent=new Intent(HomeScreen.this,LogInActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

            }
        },1000);
    }
}
