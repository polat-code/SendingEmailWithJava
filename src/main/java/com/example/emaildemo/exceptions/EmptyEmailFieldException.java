package com.example.emaildemo.exceptions;


public class EmptyEmailFieldException extends Exception {
    public EmptyEmailFieldException(String s) {
        super(s);
    }
}
