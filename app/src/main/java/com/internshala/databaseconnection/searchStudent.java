package com.internshala.databaseconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class searchStudent extends AppCompatActivity {
      private   Button btnEnter;
       private EditText etxtNumber;
       private AutoCompleteTextView actxtView;
       private ArrayAdapter <String> arrayAdapter;
       ArrayList <String> arrayList;
        String[] nameDatarr=new String[82];
        int i=0;
        int j;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchstudent);
        setComponentValue();
       

                etxtNumber.setText("");

                        btnEnter.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                        if (etxtNumber.length() == 3) {
                                                String inputRollNo = etxtNumber.getText().toString();
                                                Intent intent = new Intent(searchStudent.this, ShowData.class);
                                                intent.putExtra("keyname", inputRollNo);
                                                startActivity(intent);
                                                TextView invalid;
                                                invalid = findViewById(R.id.txtInvalidInput);
                                                invalid.setText("");
                                                etxtNumber.setText("");
                                        } else {
                                                TextView invalid;
                                                invalid = findViewById(R.id.txtInvalidInput);
                                                invalid.setText("INVALID INPUT");
                                                etxtNumber.setText("");

                                        }


                                }
                        });
                }


        void setComponentValue()
        {
        btnEnter=findViewById(R.id.btnEnter);
        etxtNumber=findViewById(R.id.editTextNumber);


}
        }