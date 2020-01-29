package com.company.entity;

public class CarpetEnt {

    private Long num;
    private int year;
    private String color;

    public Long getNum() {
        return num;
    }

    public CarpetEnt setNum(Long num) {
        this.num = num;
        return this;
    }

    public int getYear() {
        return year;
    }

    public CarpetEnt setYear(int year) {
        this.year = year;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CarpetEnt setColor(String color) {
        this.color = color;
        return this;
    }
}
