package com.internshala.databaseconnection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class testFirebase extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Student Data");
    //Myhelper helper=new Myhelper(this);
   // SQLiteDatabase databaseRead=helper.getReadableDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_firebase);

        myRef.child("Roll Number").child("101").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    //Log.e("firebase", "Error getting data", task.getException());
                    Toast.makeText(testFirebase.this, "Error", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    Toast.makeText(testFirebase.this, String.valueOf(task.getResult().getValue()), Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
    public void writeNewUser(int rollnumber,int enrollment,String name , String category,int grnumber,String mentor) {
        User user = new User(rollnumber,enrollment,name ,category,grnumber,mentor);
        myRef.child("Roll Number").child(java.lang.String.valueOf(rollnumber)).setValue(user);
    }

  /*  void uploadData()
    {
        Cursor cursor= databaseRead.rawQuery("SELECT ROLL_NO,NAME,CATEGORY,GRNUMBER,ENROLLMENT_NO,MENTOR FROM STUDENT",null);
        if (cursor != null)
        {
            if (cursor.moveToFirst())
                try {
                    do {
                        String rollData = cursor.getString(0);
                        String nameData = cursor.getString(1);
                        String categoryData = cursor.getString(2);
                        String grnumberData = cursor.getString(3);
                        String enrollmentData = cursor.getString(4);
                        String mentorData = cursor.getString(5);
                        Toast.makeText(this, nameData, Toast.LENGTH_SHORT).show();
                        writeNewUser(Integer.parseInt(rollData), Integer.parseInt(enrollmentData),nameData,categoryData, Integer.parseInt(grnumberData),mentorData);
                    } while (cursor.moveToNext());

                }
                catch (CursorIndexOutOfBoundsException e)
                {
                    //   Intent intent= new Intent(ShowData.this,MainActivity.class);
                    // startActivity(intent);

                    setContentView(R.layout.activity_no_data);

                }
        }
    } */
}