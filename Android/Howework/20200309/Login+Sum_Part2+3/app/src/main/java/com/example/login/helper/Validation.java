package com.example.login.helper;

import java.util.regex.Pattern;

public class Validation {
    public  static  ValidationError validateUsername(String username){
        if(username.length()<2){
            return ValidationError.USER_ERROR;
        }else{
            return null; //No error
        }
    }

    public static ValidationError validatePassword(String password){
        if(password.length() < 4) {
            return ValidationError.PASSWORD_ERROR;
        } else {
            return null;//No error
        }
    }


    public static ValidationError validateEmail(String email){
        //let use regex = Regular Expression
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z]+\\.[a-zA-z]{1,3}$");
        if(pattern.matcher(email).matches() == false) {
            return ValidationError.EMAIL_ERROR;
        } else {
            return null;//No error
        }
    }

}
