package com.example.androidtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class myself3 extends AppCompatActivity {
    MyHelper myHelper;
    SQLiteDatabase db;
    SQLiteDatabase dd;
    private TextView note_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself3);
        myHelper=new MyHelper(myself3.this);
        Button delete=(Button) findViewById(R.id.myself3_btn);
        note_=(TextView) findViewById(R.id.myself3_tv1);
        note_.setMovementMethod(ScrollingMovementMethod.getInstance());
        db=myHelper.getReadableDatabase();
        Cursor cursor=db.query("note",null,null,null,null,null,null);
        cursor.moveToFirst();
        if(cursor.getCount()==0){
            Toast.makeText(myself3.this,"便签信息为空！",Toast.LENGTH_SHORT).show();
        }else{
            cursor.moveToFirst();
            note_.setText(cursor.getString(0));
            while (cursor.moveToNext()){
                note_.append("\n\n\n"+cursor.getString(0));
            }
            cursor.close();
            db.close();
        }
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog;
                dialog = new AlertDialog.Builder(myself3.this).setTitle("警告")
                        .setMessage("确定要清空便签信息吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dd=myHelper.getWritableDatabase();
                                dd.delete("note",null,null);
                                Toast.makeText(myself3.this,"便签信息已清空！",Toast.LENGTH_SHORT).show();
                                note_.setText("");
                                dd.close();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                dialog.show();
            }
        });
    }
}
