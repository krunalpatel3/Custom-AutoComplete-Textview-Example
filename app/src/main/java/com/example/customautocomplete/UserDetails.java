package com.example.customautocomplete;


import android.util.Log;

public class UserDetails {

    private String Name,Number;

    public UserDetails(){

    }

    UserDetails(String Name, String Number){
        this.Name = Name;
        this.Number = Number;
    }


    String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }






}
