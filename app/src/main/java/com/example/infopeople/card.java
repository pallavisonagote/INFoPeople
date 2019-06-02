package com.example.infopeople;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class card {
    private String name;
    private int age;
     Calendar calendar=Calendar.getInstance();
    private String date= DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(calendar.getTime());

    public card() {
    }

    public card(String name, int age, String date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
