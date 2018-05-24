package com.t3f.model;

public class Translation {
    private String german;
    private String english;

    public Translation(String german, String english) {
        this.german = german;
        this.english = english;
    }

    public String getGerman() {
        return german;
    }

    public String getEnglish() {
        return english;
    }
}
