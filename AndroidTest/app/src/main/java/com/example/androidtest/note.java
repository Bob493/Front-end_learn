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

public class note extends AppCompatActivity {
    MyHelper myHelper;
    private EditText et_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        myHelper=new MyHelper(this);
        et_note=(EditText) findViewById(R.id.note_et);
        Button save=(Button) findViewById(R.id.note_btn);
        Button quit=(Button) findViewById(R.id.note_btn_close) ;
        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String e=et_note.getText().toString();
                if (e.equals(""))
                {
                    Toast.makeText(note.this, "输入不能为空，请重新输入！", Toast.LENGTH_SHORT).show();
                }else { SQLiteDatabase db = myHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put("note", e);
                    db.insert("note", null, values);
                    Toast.makeText(note.this, "数据已添加", Toast.LENGTH_SHORT).show();
                    db.close();
                    et_note.setText("");
                }}
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(note.this,mainpage.class);
                startActivity(intent);
            }
        });
    }
}
