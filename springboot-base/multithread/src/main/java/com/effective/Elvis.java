package com.effective;

public enum Elvis {
    INSTANCE;


    public static void main(String[] args) {
        Elvis instance = INSTANCE;
        System.out.println(instance);
    }
}
