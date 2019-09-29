package com.div.expensemanager;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportTripActivity extends AppCompatActivity
{
    String email;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        email=getIntent().getExtras().getString("email");
        Button tdr  =findViewById(R.id.button1);
        tdr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(ReportTripActivity.this,TripDetailsReportActivity.class);
                i2.putExtra("email",email);
                startActivity(i2);
                finish();
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });
    }//end of onCreate()

//    public void report(View view)
//    {
//        switch(view.getId())
//        {
//            case R.id.button1:
//                new Handler().postDelayed(new Runnable()
//                {
//                    @Override
//                    public void run()
//                    {
//                        i=new Intent(ReportTripActivity.this,TripDetailsReportActivity.class);
//                        i.putExtra("email",email);
//                        startActivity(i);
//                        finish();
//                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
//
//                    }
//                },500);
//            case R.id.button2:
//                new Handler().postDelayed(new Runnable()
//                {
//                    @Override
//                    public void run()
//                    {
//                        i=new Intent(ReportTripActivity.this,ExpenseDetailsReportActivity.class);
//                        i.putExtra("email",email);
//                        startActivity(i);
//                        finish();
//                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
//                    }
//                },500);
//        }
//    }
}
