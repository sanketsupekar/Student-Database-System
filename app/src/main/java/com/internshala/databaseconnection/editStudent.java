package com.internshala.databaseconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class editStudent extends AppCompatActivity {
    public Button btnSubmit,btnFind;
    public EditText txtFindRoll,txtInputName,txtInputEnrollment,txtInputRoll,txtInputCategory,txtInputGrnumber,txtInputMentor;
    public String txtName,txtEnrollment,txtRoll,txtCategory,txtGrnumber,txtMentor;
    public SQLiteDatabase database;
    EditText[] emptyErrorShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        Myhelper helper=new Myhelper(this);
        database=helper.getReadableDatabase();
        setUICompoent();
        btnSubmit.setEnabled(false);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cheakValidInput())
                {
                    findData();
                    btnSubmit.setEnabled(true);

                }

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cheakDataValid())
                {
                    updateData();
                    clearEditText();

                }

            }
        });

    }
    void setUICompoent()
    {
        btnFind=findViewById(R.id.btnFind);
        btnSubmit=findViewById(R.id.btnSubmit);
        txtFindRoll=findViewById(R.id.txtFindRoll);
        txtInputName=findViewById(R.id.txtInputName);
        txtInputEnrollment=findViewById(R.id.txtInputEnrollment);
        txtInputRoll=findViewById(R.id.txtInputRoll);
        txtInputCategory=findViewById(R.id.txtInputCategory);
        txtInputGrnumber=findViewById(R.id.txtInputGrnumber);
        txtInputMentor=findViewById(R.id.txtInputMentor);

    }
    void findData()
    {
        String rollNumber= txtFindRoll.getText().toString();
        Cursor cursor= database.rawQuery("SELECT NAME,ROLL_NO,ENROLLMENT_NO,CATEGORY,GRNUMBER,MENTOR FROM STUDENT WHERE ROLL_NO=?",new String[]{rollNumber});
        if (cursor != null) {
            cursor.moveToFirst();
            try {


                String nameData = cursor.getString(0);
                String rollData = cursor.getString(1);
                String enrollmentData = cursor.getString(2);
                String categoryData = cursor.getString(3);
                String grnumberData = cursor.getString(4);
                String mentorData = cursor.getString(5);

                txtInputName.setText(nameData.toString());
                txtInputRoll.setText(rollData.toString());
                txtInputRoll.setFocusable(false);
                txtInputEnrollment.setText(enrollmentData.toString());
                txtInputCategory.setText(categoryData.toString());
                txtInputGrnumber.setText(grnumberData.toString());
                txtInputMentor.setText(mentorData.toString());

            } catch (CursorIndexOutOfBoundsException e) {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
                txtFindRoll.getText().clear();

            }
        }
    }
    void clearEditText()
    {
        emptyErrorShow = new EditText[]{   txtInputName,
                txtInputEnrollment,
                txtInputRoll,
                txtInputCategory,
                txtInputGrnumber,
                txtInputMentor
        };
        for (int i=0;i<6;i++)
        {
            emptyErrorShow[i].getText().clear();
        }
        btnSubmit.setEnabled(false);
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
            Toast.makeText(editStudent.this, "Enter Proper Roll Number", Toast.LENGTH_SHORT).show();
            txtFindRoll.getText().clear();
            clearEditText();
            finalError=false;
        }
        return finalError;
    }
    boolean cheakDataValid()
    {
        int collectError=0;
        boolean finalError=true;
        String[] emptyCheack=
                {
                        txtName=txtInputName.getText().toString(),
                        txtEnrollment=txtInputEnrollment.getText().toString(),
                        txtRoll=txtInputRoll.getText().toString(),
                        txtCategory=txtInputCategory.getText().toString(),
                        txtGrnumber=txtInputGrnumber.getText().toString(),
                        txtMentor=txtInputMentor.getText().toString()
                };


        emptyErrorShow = new EditText[]{   txtInputName,
                txtInputEnrollment,
                txtInputRoll,
                txtInputCategory,
                txtInputGrnumber,
                txtInputMentor
        };

        for (int i=0;i<6;i++)
        {
            if(TextUtils.isEmpty(emptyCheack[i])) {
                emptyErrorShow[i].setError("Enter "+emptyCheack[i]);
                collectError++;
            }
        }
        if (collectError!=0)
        {
            finalError=false;
        }

        return finalError;
    }
    void updateData()
    {
        ContentValues values= new ContentValues();
        values.put("NAME", String.valueOf(txtInputName.getText()));
        values.put("ROLL_NO", String.valueOf(txtInputRoll.getText()));
        values.put("ENROLLMENT_NO", String.valueOf(txtInputEnrollment.getText()));
        values.put("CATEGORY", String.valueOf(txtInputCategory.getText()));
        values.put("GRNUMBER", String.valueOf(txtInputGrnumber.getText()));
        values.put("MENTOR", String.valueOf(txtInputMentor.getText()));
        try {
            database.update("STUDENT",values,"ROLL_NO=?",new String[]{txtFindRoll.getText().toString()});
           // database.insert("STUDENT",null,values);
            Toast.makeText(editStudent.this, "Data Insertion Done", LENGTH_SHORT).show();

        }
        catch (Exception e)
        {
            Toast.makeText(editStudent.this, "Data Insertion Fail", LENGTH_SHORT).show();

        }
    }
}