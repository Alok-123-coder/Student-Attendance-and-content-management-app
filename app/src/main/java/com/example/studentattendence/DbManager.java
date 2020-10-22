package com.example.studentattendence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManager extends SQLiteOpenHelper
{



    public DbManager(Context context) {
        super(context, "StDb",  null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //String query1="create table Student_info(empid int primary key,empname text,department text,designation text,salary integer)";
        String query="create table Student_info(stname text,stmobile text,stgmail text,stroll text primary key,stdeptt text,stsem text,styear text,stcoll text," +
                "stfee text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

