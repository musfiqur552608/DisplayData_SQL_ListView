package com.example.displaysqldata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    private EditText id, name;
    private Button save, show, update, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        id = findViewById(R.id.idEdit);
        name = findViewById(R.id.nameEdit);
        save = findViewById(R.id.savebtn);
        show = findViewById(R.id.showbtn);
        update = findViewById(R.id.updatebtn);
        delete = findViewById(R.id.deletebtn);





        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stid = id.getText().toString();
                String stname = id.getText().toString();
                long rowNumber = databaseHelper.saveData(stid,stname);
                if(rowNumber > -1){
                    Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_SHORT).show();
                    id.setText("");
                    name.setText("");
                }else {
                    Toast.makeText(getApplicationContext(), "Data is not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
                startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}