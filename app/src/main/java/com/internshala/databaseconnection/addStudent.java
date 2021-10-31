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

public class addStudent extends AppCompatActivity {
    public Button btnSubmit;
    public EditText txtInputName,txtInputEnrollment,txtInputRoll,txtInputCategory,txtInputGrnumber,txtInputMentor;
    public String txtName,txtEnrollment,txtRoll,txtCategory,txtGrnumber,txtMentor;
    public int rollNumber;
    EditText[] emptyErrorShow;
    SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        final Myhelper helper=new Myhelper(this);
        database=helper.getWritableDatabase();
        setUICompoent();
        txtInputRoll.setText(String.valueOf(getRollNumber()));
        txtInputRoll.setFocusable(false);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cheakDataValid())
                {
                    uploadData();
                    clearEditText();
                    //Toast.makeText(addStudent.this, "Insert Data Successfully", LENGTH_SHORT).show();
                }
                else
                {
                    //Toast.makeText(addStudent.this, "Fail", LENGTH_SHORT).show();

                }
            }
        });


    }
    void setUICompoent()
    {
        btnSubmit=findViewById(R.id.btnSubmit);
        txtInputName=findViewById(R.id.txtInputName);
        txtInputEnrollment=findViewById(R.id.txtInputEnrollment);
        txtInputRoll=findViewById(R.id.txtInputRoll);
        txtInputCategory=findViewById(R.id.txtInputCategory);
        txtInputGrnumber=findViewById(R.id.txtInputGrnumber);
        txtInputMentor=findViewById(R.id.txtInputMentor);


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

    int getRollNumber()
    {
        int id;
        Cursor cursor= database.rawQuery("SELECT MAX(_id) FROM STUDENT",null);
        if (cursor != null) {
            cursor.moveToFirst();
            try
            {
                id = cursor.getInt(0) + 102;
                return id;

            } catch (CursorIndexOutOfBoundsException e)
            {

            }
        }

        return 0;
    }
    void clearEditText()
    {
        for (int i=0;i<6;i++)
        {
            emptyErrorShow[i].setText("");
        }
    }
    void uploadData()
    {
        ContentValues values= new ContentValues();
        values.put("NAME", String.valueOf(txtInputName.getText()));
        values.put("ROLL_NO", String.valueOf(txtInputRoll.getText()));
        values.put("ENROLLMENT_NO", String.valueOf(txtInputEnrollment.getText()));
        values.put("CATEGORY", String.valueOf(txtInputCategory.getText()));
        values.put("GRNUMBER", String.valueOf(txtInputGrnumber.getText()));
        values.put("MENTOR", String.valueOf(txtInputMentor.getText()));
        try {
            database.insert("STUDENT",null,values);
            Toast.makeText(addStudent.this, "Data Insertion Done", LENGTH_SHORT).show();

        }
        catch (Exception e)
        {
            Toast.makeText(addStudent.this, "Data Insertion Fail", LENGTH_SHORT).show();

        }
    }

}