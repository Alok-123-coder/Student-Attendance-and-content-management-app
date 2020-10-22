package com.example.studentattendence;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StudentReg extends AppCompatActivity {
    EditText[] ets=new EditText[9];
    int[] ids={R.id.et_stname,R.id.et_mobile,R.id.et_gmail,R.id.et_strollnum,R.id.et_stdep,R.id.et_sem,R.id.et_year,R.id.et_college,R.id.et_fee};
    String [] values=new String[ets.length];
    int i;   //i for loop counter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);
        for (i=0;i<ets.length;i++)
        {
            ets[i]=(EditText)findViewById(ids[i]);
        }

    }
    public void register(View view)
    {
        for(i=0;i<ets.length;i++)
        {
            if(ets[i].getText().toString().isEmpty())
            {
                ets[i].setError("Empty");
                ets[i].requestFocus();
                break;
            }
        }
        if(i==ets.length)
        {
            for(i=0;i<ets.length;i++)
            {
                values[i]=ets[i].getText().toString().trim();
            }
            String name=ets[0].getText().toString();
            DbManager db=new DbManager(getApplicationContext());
            SQLiteDatabase d=db.getWritableDatabase();
            String query="insert into Student_info values('"+values[0]+"','"+values[1]+"','"+values[2]+"','"+values[3]+"','"+values[4]+"'," +
                    "'"+values[5]+"'," + "'"+values[6]+"','"+values[7]+"','"+values[8]+"')";
            d.execSQL(query);
            Toast.makeText(this, "Thank You ! "+name+" You are registered succesfully", Toast.LENGTH_SHORT).show();
            for(i=0;i<ets.length;i++)
            {
                ets[i].setText("");
            }
        }
    }

    public void signin(View view){
        Intent I=new Intent(this,Student_login.class);
        startActivity(I);
    }


}
