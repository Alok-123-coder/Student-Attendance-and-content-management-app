package com.example.studentattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentMenu extends AppCompatActivity {
ImageView reg,book,notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);
        reg=(ImageView)findViewById(R.id.reg);
        book=(ImageView)findViewById(R.id.book);
        notes=(ImageView)findViewById(R.id.notes);

    }
    public  void regis(View view){
        Intent I=new Intent(this,StudentReg.class);
        startActivity(I);
    }
    public  void books(View view){
        Intent I=new Intent(this,Book1.class);
        startActivity(I);
    }
    public  void note(View view){
        Intent I=new Intent(this,MainNotes.class);
        startActivity(I);
    }
    public  void calendar(View view){
        Intent I=new Intent(this,CalendarDemo.class);
        startActivity(I);
    }
    public void gc(View view)
    {
        Intent I=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.classroom.google.com"));
        startActivity(I);
        finish();
    }
}
