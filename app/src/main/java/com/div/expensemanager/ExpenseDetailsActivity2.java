package com.div.expensemanager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExpenseDetailsActivity2 extends AppCompatActivity {
    EditText et4;
    int a, b, g, c, d, e, travel, food, shopping, others, balance, alloted;
    EditText et6, et5;
    EditText et7;
    EditText et8;
    EditText et9;
    TextView tv1;
    Boolean cb1, cb2, cb3, cb4;
    String et3, et1, et2,email;
    SQLiteDatabase database;
    int f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_details2);
        TextView tv6 = findViewById(R.id.textView6);
        email=getIntent().getExtras().getString("email");
        et4 = findViewById(R.id.editText4);
        et5 = findViewById(R.id.editText5);
        et6 = findViewById(R.id.editText6);
        et7 = findViewById(R.id.editText7);
        et8 = findViewById(R.id.editText8);
        et3 = getIntent().getExtras().getString("date");
        cb1 = getIntent().getExtras().getBoolean("travel");
        cb2 = getIntent().getExtras().getBoolean("food");
        cb3 = getIntent().getExtras().getBoolean("shopping");
        cb4 = getIntent().getExtras().getBoolean("others");
        et1 = getIntent().getExtras().getString("exp-id");
        et2 = getIntent().getExtras().getString("trip-id");
        tv6.setText(et3);
        tv1 = findViewById(R.id.textView1);
        if (cb1 == false) {
            et5.setEnabled(false);
            a = 0;
        } else {
            a = Integer.parseInt(et5.getText().toString());
        }
        if (cb2 == false) {
            et6.setEnabled(false);
            b = 0;
        } else {
            b = Integer.parseInt(et6.getText().toString());
        }
        if (cb3 == false) {
            et7.setEnabled(false);
            c = 0;
        } else {
            c = Integer.parseInt(et7.getText().toString());
        }
        if (cb4 = false) {
            et8.setEnabled(false);
            d = 0;
        } else {
            d = Integer.parseInt(et8.getText().toString());
        }

    }//end of onCreate()

    public void update(View view) {

        if (et4.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter the Required Field!!", Toast.LENGTH_SHORT).show();
        } else {
            f = Integer.parseInt(et4.getText().toString());
            g = f - (a + b + c + d);
            if (g < 0) {
                Toast.makeText(this, "Please Manage your expenses,your expenses is greater than Fund Alloted!!", Toast.LENGTH_LONG).show();
            } else {
                tv1.setText("" + g);
                Toast.makeText(this, "Balance  =" + g, Toast.LENGTH_LONG).show();

                database = openOrCreateDatabase("Trip", Context.MODE_PRIVATE, null);
                alloted = Integer.parseInt(et4.getText().toString());
                travel = Integer.parseInt(et5.getText().toString());
                food = Integer.parseInt(et6.getText().toString());
                shopping = Integer.parseInt(et7.getText().toString());
                others = Integer.parseInt(et8.getText().toString());
                balance = Integer.parseInt(tv1.getText().toString());
                et1 = "'" + et1 + "'";
                et3 = "'" + et3 + "'";
                et2 = "'" + et2 + "'";
                email="'"+email+"'";

                database.execSQL("create table if not exists ExpenseDetails(email varchar,exp_id varchar primary key not null,trip_id varchar references trip_details(trip_id) on Delete Cascade,date varchar,alloted_fund int not null,travel int default 0,food int default 0,shopping int default 0,others int default 0,balance int)");
                Cursor cursor = database.rawQuery("select trip_id from trip_details", null);
                while (cursor.moveToNext()) {
                    if (!et1.equals(cursor.getString(0))) {
                        database.execSQL("insert into ExpenseDetails(email,exp_id,trip_id,date,alloted_fund,travel,food,shopping,others,balance)" + "values("+email+"," + et1 + "," + et2 + "," + et3 + ", " + alloted + "," + travel + "," + food + "," + shopping + "," + others + "," + balance + ")");
                        Toast.makeText(this, "Record created!!", Toast.LENGTH_SHORT).show();
                    } else {
                        database.execSQL("update ExpenseDetails set date=" + et3 + ",travel=travel+" + travel + ",food= food+" + food + ",shopping=shopping+" + shopping + ",others=others+" + others + ",balance=balance+" + balance);
                        Toast.makeText(this, "Record Updated!!", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }

    }
}