package com.internshala.databaseconnection;

public class User {
    public int rollnumber,grnumber,enrollment;
    public String name,category,mentor;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(int rollnumber,int enrollment,String name , String category,int grnumber,String mentor) {
        this.rollnumber = rollnumber;
        this.enrollment = enrollment;
        this.name = name;
        this.category = category;
        this.grnumber = grnumber;
        this.mentor = mentor;


    }
}