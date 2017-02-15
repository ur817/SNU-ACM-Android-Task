package com.priyanshrastogi.acmtask;

public class Card {

    private String text1;
    private String text2;
    private String image;

    public Card(String text1, String text2, String image) {
        this.text1 = text1;
        this.text2 = text2;
        this.image = image;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getImage() {
        return image;
    }
}
