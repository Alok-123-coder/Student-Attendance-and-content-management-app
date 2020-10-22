package com.example.studentattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchStudent extends AppCompatActivity {
    EditText et_search;
    TextView[] tvs=new TextView[7];
    int [] ids={R.id.tv_stname,R.id.tv_department,R.id.tv_sem,R.id.tv_year,R.id.tv_college,R.id.tv_mobile,R.id.tv_gmail};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);
        et_search=(EditText)findViewById(R.id.et_search);
        for(i=0;i<tvs.length;i++)
        {
            tvs[i]=(TextView)findViewById(ids[i]);
        }
    }
    public void search(View view)
    {
        if(et_search.getText().toString().isEmpty())
        {
            et_search.setError("Empty");
            et_search.requestFocus();
        }
        else
        {
            String roll=et_search.getText().toString().trim();
            DbManager db=new DbManager(getApplicationContext());
            SQLiteDatabase d=db.getWritableDatabase();
            String query="select * from Student_Info where stroll='"+roll+"'";
            Cursor c=d.rawQuery(query,null);
            if(c.moveToFirst())
            {
                tvs[0].setText(tvs[0].getText().toString()+c.getString(0));
                tvs[1].setText(tvs[1].getText().toString()+c.getString(4));
                tvs[2].setText(tvs[2].getText().toString()+c.getString(5));
                tvs[3].setText(tvs[3].getText().toString()+c.getString(6));
                tvs[4].setText(tvs[4].getText().toString()+c.getString(7));
                tvs[5].setText(tvs[5].getText().toString()+c.getString(1));
                tvs[6].setText(tvs[6].getText().toString()+c.getString(2));
            }
            else
            {
                Toast.makeText(this, "Record Not Found", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void back(View view){
        Intent I=new Intent(this,TeacherHome.class);
        startActivity(I);
    }

}
