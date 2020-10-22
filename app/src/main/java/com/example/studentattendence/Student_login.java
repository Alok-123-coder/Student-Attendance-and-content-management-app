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

public class Student_login extends AppCompatActivity {
    Button button;
EditText et_gmail,et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        button=findViewById(R.id.button1);
        et_gmail=(EditText)findViewById(R.id.et_gmail);
        et_password=(EditText)findViewById(R.id.et_password) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_gmail.getText().toString().isEmpty())
                {
                    et_gmail.setError("Empty");
                    et_gmail.requestFocus();
                } else
                {
                    if (et_password.getText().toString().isEmpty())
                    {
                        et_password.setError("Empty");
                        et_password.requestFocus();
                    } else
                    {
                        String lgmail=et_gmail.getText().toString().trim();
                        String lpass=et_password.getText().toString().trim();
                        DbManager db=new DbManager(getApplicationContext());
                        SQLiteDatabase d=db.getWritableDatabase();
                        String query="select * from Student_info where stgmail='"+lgmail+"' and stroll='"+lpass+"'";
                        Cursor c=d.rawQuery(query,null);
                        if(c.moveToFirst())
                        {
                            //Toast.makeText(this, "Login detailed matched", Toast.LENGTH_SHORT).show();
                            Intent I= new Intent(Student_login.this,Home.class);
                            startActivity(I);

                            //finish();
                            et_gmail.setText("");
                            et_password.setText("");
                        }
                        else
                        {
                            Toast.makeText(Student_login.this, "Record not found for given details", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });
    }
    public void streg(View view){
        Intent I=new Intent(this,StudentReg.class);
        startActivity(I);
    }
}
