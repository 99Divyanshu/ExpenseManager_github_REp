package com.div.expensemanager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity
{
    Boolean temp=false;
EditText et1,et2;
String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);
    }//end of onCreate()
    public void login1(View view)
    {
        SQLiteDatabase database = openOrCreateDatabase("ExpenseManager", Context.MODE_PRIVATE, null);
        email = et1.getText().toString();
        password = et2.getText().toString();
        Cursor c = database.rawQuery("select * from Record", null);
        Boolean k=false;
        while (c.moveToNext()) {
            if (email.equals(c.getString(1)) && password.equals(c.getString(2)) ) {
                k=true;
                Intent login = new Intent(LogInActivity.this, LogInResultActivity.class);
                login.putExtra("email",email);
                startActivity(login);
            }
          /*  else
            {

            }*/
        }
        if(!k)
        {
            Toast.makeText(this, "User doesnt exist .Please register or check the fields!!", Toast.LENGTH_SHORT).show();
        }
    }



}
