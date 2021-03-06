package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

public class myself2 extends AppCompatActivity {
    MyHelper myHelper;
    SQLiteDatabase db;
    private TextView show1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself2);
        myHelper=new MyHelper(myself2.this);
        show1=(TextView) findViewById(R.id.myself_tvb);
        db=myHelper.getReadableDatabase();
        Cursor cursor=db.query("info",null,null,null,null,null,null);
        cursor.moveToFirst();
        show1.setMovementMethod(ScrollingMovementMethod.getInstance());
        if(cursor.getCount()==0){
            show1.setText("");
            Toast.makeText(myself2.this,"查询数据为空！",Toast.LENGTH_SHORT).show();
        }else{
            cursor.moveToFirst();
            show1.setText("金额："+cursor.getString(0)+"，时间："+cursor.getString(1)+
                    "，种类："+cursor.getString(2)+"，来源："+cursor.getString(3)+"，备注："+cursor.getString(4));
            while (cursor.moveToNext())
            {
                show1.append("\n\n"+"金额："+cursor.getString(0)+"，时间："+cursor.getString(1)+
                        "，种类："+cursor.getString(2)+"，来源："+cursor.getString(3)+"，备注："+cursor.getString(4));
            }
            cursor.close();
            db.close();

        }
    }
}