package com.internshala.databaseconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class deleteStudent extends AppCompatActivity {
    public Button btnDelete,btnFind;
    public TextView txtNameShow;
    public EditText txtFindRoll;
    public SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        btnDelete=findViewById(R.id.btnDelete);
        btnFind=findViewById(R.id.btnFind);
        txtFindRoll=findViewById(R.id.txtFindRoll);
        txtNameShow=findViewById(R.id.txtNameShow);
        Myhelper helper=new Myhelper(this);
        database=helper.getReadableDatabase();
        btnDelete.setEnabled(false);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cheakValidInput())
                {
                    findData();
                    btnDelete.setEnabled(true);
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
                clearEditText();
            }
        });
    }
    void clearEditText()
    {
        txtFindRoll.getText().clear();
        txtNameShow.setText("");
        btnDelete.setEnabled(false);
    }
    boolean cheakValidInput()
    {
        boolean finalError=true;
        if(TextUtils.isEmpty(txtFindRoll.getText())) {
            txtFindRoll.setError("Enter Roll Number");
            clearEditText();
            finalError=false;
        }
        else if((txtFindRoll.getText().toString().length())<3)
        {
            Toast.makeText(deleteStudent.this, "Enter Proper Roll Number", Toast.LENGTH_SHORT).show();
            txtFindRoll.getText().clear();
            clearEditText();
            finalError=false;
        }
        return finalError;
    }
    void deleteData()
    {
        String rollNumber= txtFindRoll.getText().toString();
        database.delete("STUDENT","ROLL_NO=?",new String[]{rollNumber});
        Toast.makeText(this, "Row Deleted Successfully", Toast.LENGTH_SHORT).show();
        }
    void findData()
    {
        String rollNumber= txtFindRoll.getText().toString();
        Cursor cursor= database.rawQuery("SELECT NAME,ROLL_NO FROM STUDENT WHERE ROLL_NO=?",new String[]{rollNumber});
        if (cursor != null) {
            cursor.moveToFirst();
            try {
                String nameData = cursor.getString(0);
                String rollData = cursor.getString(1);
                txtNameShow.setText(rollData+" - "+nameData);
            } catch (CursorIndexOutOfBoundsException e) {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
                txtFindRoll.getText().clear();

            }
        }
    }
}
