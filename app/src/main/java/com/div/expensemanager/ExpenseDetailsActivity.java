package com.div.expensemanager;

import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ExpenseDetailsActivity extends AppCompatActivity
{
    public EditText et1,et2,et3;
    public CheckBox cb1,cb2,cb3,cb4;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_details);

        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
        cb1=findViewById(R.id.checkBox1);
        cb2=findViewById(R.id.checkBox2);
        cb3=findViewById(R.id.checkBox3);
        cb4=findViewById(R.id.checkBox4);
        email=getIntent().getExtras().getString("email");
    }//end of onCreate()

    public void second(View view)
        {
            if(et1.getText().toString().isEmpty()|et2.getText().toString().isEmpty()||et3.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Plaease Fill the details first!!", Toast.LENGTH_SHORT).show();
            }
            else
            {

                switch (view.getId())
            {
                case R.id.textView3:
                    Toast.makeText(this, "The Page is already open!!", Toast.LENGTH_SHORT).show();
                     break;
                case R.id.textView4:
                    new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Intent i=new Intent(ExpenseDetailsActivity.this,ExpenseDetailsActivity2.class);
                            i.putExtra("travel",  cb1.isChecked());
                            i.putExtra("food", cb2.isChecked());
                            i.putExtra("shopping", cb3.isChecked());
                            i.putExtra("others",cb4.isChecked());
                            i.putExtra("date",et3.getText().toString());
                            i.putExtra("exp-id",et1.getText().toString());
                            i.putExtra("trip-id",et2.getText().toString());
                            i.putExtra("email",email);
                            startActivity(i);
                            finish();
                            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                        }
                    },500);
                     break;

            }
        }
        }

}
