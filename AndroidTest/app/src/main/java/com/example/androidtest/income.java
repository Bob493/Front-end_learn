package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class income extends AppCompatActivity {
    MyHelper myHelper;
    private EditText et_money;
    private EditText et_time;
    private EditText et_kind;
    private EditText et_from;
    private EditText et_remark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        myHelper=new MyHelper(this);
        et_money=(EditText) findViewById(R.id.money1);
        et_time=(EditText) findViewById(R.id.time1);
        et_kind=(EditText) findViewById(R.id.kind1);
        et_from=(EditText) findViewById(R.id.from1);
        et_remark=(EditText) findViewById(R.id.remark1);
        Button save=(Button) findViewById(R.id.income_btn);
        Button quit=(Button) findViewById(R.id.income_btn_close) ;
        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String m=et_money.getText().toString();
                String t=et_time.getText().toString();
                String k=et_kind.getText().toString();
                String f=et_from.getText().toString();
                String r=et_remark.getText().toString();
                if(m.equals("")||t.equals("")||k.equals("")||f.equals("")||r.equals("")) {
                    Toast.makeText(income.this, "输入不能为空，请重新输入！", Toast.LENGTH_SHORT).show();
                }else {
                    SQLiteDatabase db = myHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("moneya", m);
                    values.put("timea", t);
                    values.put("kinda", k);
                    values.put("froma", f);
                    values.put("remarka", r);
                    db.insert("info", null, values);
                    Toast.makeText(income.this, "数据已添加", Toast.LENGTH_SHORT).show();
                    db.close();
                    et_money.setText("");
                    et_time.setText("");
                    et_kind.setText("");
                    et_from.setText("");
                    et_remark.setText("");
                }
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(income.this,mainpage.class);
                startActivity(intent);
            }
        });
    }

}


