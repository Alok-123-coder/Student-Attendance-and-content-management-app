package com.example.studentattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeacherHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

    }
    public void Add(View view){
        Intent I=new Intent(this,StudentReg.class);
        startActivity(I);

    }
    public void search(View view){
        Intent I=new Intent(this,SearchStudent.class);
        startActivity(I);

    }
    public void update(View view){
        Intent I=new Intent(this,UpdateStudent.class);
        startActivity(I);

    }
    public void delete(View view){
        Intent I=new Intent(this,DeleteStudent.class);
        startActivity(I);

    }
}
