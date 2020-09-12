package com.example.androidtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class data extends AppCompatActivity {
    MyHelper myHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        myHelper=new MyHelper(data.this);
        Button bt1=(Button) findViewById(R.id.data_income);
        Button bt2=(Button) findViewById(R.id.data_ecpend);
        Button bt3=(Button) findViewById(R.id.data_note);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog;
                dialog = new AlertDialog.Builder(data.this).setTitle("警告")
                        .setMessage("确定要清空收入信息吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                db=myHelper.getWritableDatabase();
                                db.delete("info",null,null);
                                Toast.makeText(data.this,"收入信息已清空！",Toast.LENGTH_SHORT).show();
                                db.close();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                dialog.show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog;
                dialog = new AlertDialog.Builder(data.this).setTitle("警告")
                        .setMessage("确定要清空支出信息吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                db=myHelper.getWritableDatabase();
                                db.delete("out",null,null);
                                Toast.makeText(data.this,"支出信息已清空！",Toast.LENGTH_SHORT).show();
                                db.close();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                dialog.show();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(data.this,myself3.class);
                startActivity(intent);
            }
        });
    }
}
