package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    MyHelper myHelper;
    private EditText et_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHelper=new MyHelper(this);
        et_clear=(EditText) findViewById(R.id.et1);
        Button button=(Button) findViewById(R.id.btnLogin);
        Button clear=(Button) findViewById(R.id.btnclose);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag=0;
                SQLiteDatabase db = myHelper.getReadableDatabase();
                Cursor cursor=db.query("password",null,null,null,null,null,null);
                if(cursor.getCount()==0){
                    Toast.makeText(MainActivity.this,"欢迎登录！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, mainpage.class);
                    startActivity(intent);
                }
                else{
                    cursor.moveToFirst();
                    do{
                        String num=et_clear.getText().toString();
                        String value = cursor.getString(cursor.getColumnIndex("word"));
                        if(value.equals(num)){
                            flag=1;
                            break;
                        }
                       }while (cursor.moveToNext());
                    if (flag==1){
                        Toast.makeText(MainActivity.this, "欢迎登录！", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, mainpage.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"密码错误，请重新输入！", Toast.LENGTH_SHORT).show();
                    }
                }
                cursor.close();
                db.close();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                et_clear.setText("");
            }
        });
    }
}