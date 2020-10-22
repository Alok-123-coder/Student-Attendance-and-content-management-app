package com.example.studentattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Teacher_login extends AppCompatActivity {
    EditText et_email,et_password;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);
        button1=findViewById(R.id.button1);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_email.getText().toString().isEmpty())
                {
                    et_email.setError("Empty");
                    et_email.requestFocus();
                } else
                {
                    if (et_password.getText().toString().isEmpty())
                    {
                        et_password.setError("Empty");
                        et_password.requestFocus();
                    } else
                    {
                        String lgmail=et_email.getText().toString().trim();
                        String lpass=et_password.getText().toString().trim();
                        DbManagerT db=new DbManagerT(getApplicationContext());
                        SQLiteDatabase d=db.getWritableDatabase();
                        String query="select * from Teacher_info where tgmail='"+lgmail+"' and password='"+lpass+"'";
                        Cursor c=d.rawQuery(query,null);
                        if(c.moveToFirst())
                        {
                            //Toast.makeText(this, "Login detailed matched", Toast.LENGTH_SHORT).show();
                            Intent I= new Intent(Teacher_login.this,TeacherHome.class);
                            startActivity(I);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(Teacher_login.this, "Record not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }



    });

    }
    public void tsignup(View view){
        Intent I=new Intent(this,TeacherSignUp.class);
        startActivity(I);
    }
}
