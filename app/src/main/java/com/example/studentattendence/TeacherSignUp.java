package com.example.studentattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class TeacherSignUp extends AppCompatActivity {
    EditText et_tname, et_tmobile, et_tgmail, et_password, et_cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_sign_up);
        et_tname = (EditText) findViewById(R.id.et_tname);
        et_tgmail = (EditText) findViewById(R.id.et_tgmail);
        et_tmobile = (EditText) findViewById(R.id.et_tmobile);
        et_password = (EditText) findViewById(R.id.et_password);
        et_cpassword = (EditText) findViewById(R.id.et_cpassword);
    }
    public void tsignup(View view) {

        if (et_tname.getText().toString().isEmpty()) {
            et_tname.setError("enter name please");
            et_tname.requestFocus();
        } else {
            if (et_tmobile.getText().toString().isEmpty()) {
                et_tmobile.setError("enter gmail please");
                et_tmobile.requestFocus();
            } else {
                if (et_tgmail.getText().toString().isEmpty()) {
                    et_tgmail.setError("enter mobile please");
                    et_tgmail.requestFocus();
                } else {
                    if (et_password.getText().toString().isEmpty()) {
                        et_password.setError("enter password please");
                        et_password.requestFocus();
                    } else {
                        if (et_cpassword.getText().toString().isEmpty()) {
                            et_cpassword.setError("confirm your password please");
                            et_cpassword.requestFocus();
                        }

                        else {
                            String password=et_password.getText().toString();
                            String cpassword=et_cpassword.getText().toString();
                            if(cpassword.equals(password)==false) {
                                String name = et_tname.getText().toString();
                                Toast.makeText(this, "Sorry "+name+" password did not match " , Toast.LENGTH_LONG).show();

                            }
                            else {
                                String[] values = new String[5];
                                values[0] = et_tname.getText().toString().trim();
                                values[1] = et_tmobile.getText().toString().trim();
                                values[2] = et_tgmail.getText().toString().trim();
                                values[3] = et_password.getText().toString().trim();
                                values[4] = et_password.getText().toString().trim();


                                {

                                    String name = et_tname.getText().toString();
                                    DbManagerT db = new DbManagerT(getApplicationContext());
                                    SQLiteDatabase d = db.getWritableDatabase();
                                    String query= "insert into Teacher_info values('"+values[0]+"','" + values[1] + "','" + values[2] + "','" + values[3] + "')";
                                    d.execSQL(query);
                                    Toast.makeText(this, "Thank You ! "+name+" You are registered succesfully", Toast.LENGTH_SHORT).show();


                                    //Toast.makeText(this, "Thanks " + name + " registraion is successfuly", Toast.LENGTH_SHORT).show();
                                    et_tname.setText("");
                                    et_tmobile.setText("");
                                    et_tgmail.setText("");
                                    et_cpassword.setText("");
                                    et_password.setText("");
                                }
                            }
                        }
                    }
                }


            }
        }

    }
    public void tsignin(View view){
        Intent I=new Intent(this,Teacher_login.class);
        startActivity(I);
    }
}
