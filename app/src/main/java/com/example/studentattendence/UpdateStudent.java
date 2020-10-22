package com.example.studentattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateStudent extends AppCompatActivity {
EditText et_search;
    EditText[] ets=new EditText[8];
    int[] ids={R.id.et_stname,R.id.et_mobile,R.id.et_gmail,R.id.et_stdep,R.id.et_sem,R.id.et_year,R.id.et_college,R.id.et_fee};
    String [] values=new String[ets.length];
    int i;   //i for loop counter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);
        et_search=(EditText)findViewById(R.id.et_search);
        for (i=0;i<ets.length;i++)
        {
            ets[i]=(EditText)findViewById(ids[i]);
        }

    }
    public void search(View view) {
        if (et_search.getText().toString().isEmpty()) {
            et_search.setError("Empty");
            et_search.requestFocus();
        }else{
            String roll=et_search.getText().toString().trim();
            DbManager db=new DbManager(getApplicationContext());
            SQLiteDatabase d=db.getWritableDatabase();
            String query="select * from Student_Info where stroll='"+roll+"'";
            Cursor c=d.rawQuery(query,null);
            if(c.moveToFirst())
            {
                ets[0].setText(ets[0].getText().toString()+c.getString(0));
                ets[1].setText(ets[1].getText().toString()+c.getString(1));
                ets[2].setText(ets[2].getText().toString()+c.getString(2));
                ets[3].setText(ets[3].getText().toString()+c.getString(4));
                ets[4].setText(ets[4].getText().toString()+c.getString(5));
                ets[5].setText(ets[5].getText().toString()+c.getString(6));
                ets[6].setText(ets[6].getText().toString()+c.getString(7));
                ets[7].setText(ets[7].getText().toString()+c.getString(8));
            }
            else
            {
                Toast.makeText(this, "Record Not Found", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void update(View view){
        if (et_search.getText().toString().isEmpty()) {
            et_search.setError("Empty");
            et_search.requestFocus();
        }else{
            String [] values=new String[ets.length];
            for(i=0;i<ets.length;i++)
            {
                values[i]=ets[i].getText().toString().trim();
            }
            String roll=et_search.getText().toString().trim();
            String name=ets[0].getText().toString();
            DbManager db=new DbManager(getApplicationContext());
            SQLiteDatabase d=db.getWritableDatabase();
            String query="update Student_info set stname='"+values[0]+"',stmobile='"+values[1]+"',stgmail='"+values[2]+"',stdeptt='"+values[3]+"'," +
                    "stsem='"+values[4]+"',styear='"+values[5]+"',stcoll='"+values[6]+"',stfee='"+values[7]+"' where stroll='"+roll+"'";
            d.execSQL(query);
            Toast.makeText(this, "Thank You ! "+name+" Record updated  succesfully", Toast.LENGTH_SHORT).show();
            for(i=0;i<ets.length;i++)
            {
                ets[i].setText("");
            }
        }
    }


    public void back(View view){
        Intent I=new Intent(this,TeacherHome.class);
        startActivity(I);
    }
}
