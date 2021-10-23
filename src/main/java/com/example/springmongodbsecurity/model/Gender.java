package com.example.springmongodbsecurity.model;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");
    private String text;
    private Gender(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
