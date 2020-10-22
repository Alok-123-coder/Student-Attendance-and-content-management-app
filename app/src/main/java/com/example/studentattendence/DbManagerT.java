package com.example.studentattendence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManagerT extends SQLiteOpenHelper
{



    public DbManagerT(Context context) {
        super(context, "TDb",  null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table Teacher_info(tname text,tmobile text,tgmail text primary key,password text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

