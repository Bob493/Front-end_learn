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

public class design extends AppCompatActivity {
    MyHelper myHelper;
    ContentValues values;
    private EditText et_password;
    private EditText wet1;
    private EditText wet2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        myHelper=new MyHelper(this);
        et_password=(EditText) findViewById(R.id.et_design);
        wet1=(EditText) findViewById(R.id.et_update_design);
        wet2=(EditText) findViewById(R.id.et_update);
        Button design1=(Button) findViewById(R.id.btn_design);
        Button design2=(Button) findViewById(R.id.btn_design_close);
        Button design3=(Button) findViewById(R.id.btn_update);
        design1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w=et_password.getText().toString();
                SQLiteDatabase db = myHelper.getWritableDatabase();
                values=new ContentValues();
                values.put("word",w);
                db.insert("password",null,values);
                db.close();
                Toast.makeText(design.this,"密码设置成功！",Toast.LENGTH_SHORT).show();
                et_password.setText("");
            }
        });
        design2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(design.this,mainpage.class);
                startActivity(intent);
            }
        });
        design3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String old=wet1.getText().toString();
                String rld=wet2.getText().toString();
                SQLiteDatabase db = myHelper.getWritableDatabase();
                values=new ContentValues();
                values.put("word",rld);
                db.update("password",values,"word=?",
                        new String[]{old});
                Toast.makeText(design.this,"密码修改成功!",Toast.LENGTH_SHORT).show();
                db.close();
                wet1.setText("");
                wet2.setText("");
            }
        });
    }
}
