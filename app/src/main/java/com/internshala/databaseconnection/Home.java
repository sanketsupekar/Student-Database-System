package com.internshala.databaseconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    public Button btnSearchStudent,btnAddStudent,btnEditStudent,btnDeleteStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnSearchStudent=findViewById(R.id.btnSearchStudent);
        btnAddStudent=findViewById(R.id.btnAddStudent);
        btnEditStudent=findViewById(R.id.btnEditStudent);
        btnDeleteStudent=findViewById(R.id.btnDeleteStudent);

        btnSearchStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,searchStudent.class);
                startActivity(intent);
            }
        });

            btnAddStudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Home.this,addStudent.class);
                    startActivity(intent);
                }
            });

                btnEditStudent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Home.this,editStudent.class);
                        startActivity(intent);
                    }
                });
        btnDeleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,deleteStudent.class);
                startActivity(intent);
            }
        });

    }
}