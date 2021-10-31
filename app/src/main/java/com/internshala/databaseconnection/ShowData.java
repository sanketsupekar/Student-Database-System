package com.internshala.databaseconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowData extends AppCompatActivity {
    TextView name,roll,enrollment,category,grnumber,mentor;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Student Data");
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_show_data);
    Myhelper helper=new Myhelper(this);
    SQLiteDatabase database=helper.getReadableDatabase();
    String rollNumberInput=getIntent().getStringExtra("keyname");
    // Read from the database

    Cursor cursor= database.rawQuery("SELECT NAME,ROLL_NO,ENROLLMENT_NO,CATEGORY,GRNUMBER,MENTOR FROM STUDENT WHERE ROLL_NO=?",new String[]{rollNumberInput});
    if (cursor != null)
    {
        cursor.moveToFirst();
        try {


            String nameData = cursor.getString(0);
            String rollData = cursor.getString(1);
            String enrollmentData = cursor.getString(2);
            String categoryData = cursor.getString(3);
            String grnumberData = cursor.getString(4);
            String mentorData = cursor.getString(5);


            name = findViewById(R.id.txtNameShow);
            roll = findViewById(R.id.txtRollShow);
            enrollment = findViewById(R.id.txtEnrollmentShow);
            category = findViewById(R.id.txtCategoryShow);
            grnumber = findViewById(R.id.txtGrnumberShow);
            mentor = findViewById(R.id.txtMentorShow);

            name.setText(nameData.toString());
            roll.setText(rollData.toString());
            enrollment.setText(enrollmentData.toString());
            category.setText(categoryData.toString());
            grnumber.setText(grnumberData.toString());
            mentor.setText(mentorData.toString());
        }
        catch (CursorIndexOutOfBoundsException e)
        {
         //   Intent intent= new Intent(ShowData.this,MainActivity.class);
           // startActivity(intent);

            setContentView(R.layout.activity_no_data);

        }
    }
        }
        }