package com.div.expensemanager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.PasswordAuthentication;

public class SignUpActivity extends AppCompatActivity
{
    Boolean temp=true;
    EditText email,pass,cnfpass,user;

    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email=findViewById(R.id.editText1);
        pass=findViewById(R.id.editText2);
        cnfpass=findViewById(R.id.editText3);
        user=findViewById(R.id.editText4);


    }//end of onCreate()
    public void register(View view)
    {
        database=openOrCreateDatabase("ExpenseManager", Context.MODE_PRIVATE,null);
        database.execSQL("create table if not exists Record(username varchar,email varchar primary key ,password varchar,repassword varchar)");

        String cpass=cnfpass.getText().toString();
       String pass1=pass.getText().toString();
        if (email.getText().toString().isEmpty()||pass.getText().toString().isEmpty()||cnfpass.getText().toString().isEmpty()||user.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please Enter all the required fields Correctly!!", Toast.LENGTH_LONG).show();
            temp=false;
        }
       if(!cpass.equals(pass1))
        {
            Toast.makeText(this, "Confirmation Password is not equal to Password!!", Toast.LENGTH_LONG).show();
            temp=false;
        }

       if (temp==true)
       {
           String username=user.getText().toString();
           String email1=email.getText().toString();
           String password=pass.getText().toString();
           String repass=cnfpass.getText().toString();
           username="'"+username+"'";
           email1="'"+email1+"'";
           password="'"+password+"'";
           repass="'"+repass+"'";
           String sql="insert into Record(username,email,password,repassword)"+"values("+username+","+email1+","+password+","+repass+")";
           database.execSQL(sql);
           new Handler().postDelayed(new Runnable()
           {
               @Override
               public void run()
               {
                   Intent i =new Intent(SignUpActivity.this,RegistrationCompleteActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
               }
           },1000);
       }

    }

}
