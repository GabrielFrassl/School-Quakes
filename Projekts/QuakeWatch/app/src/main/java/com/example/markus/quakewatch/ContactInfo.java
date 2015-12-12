package com.example.markus.quakewatch;



public class ContactInfo {
    protected String ort;
    protected String time;
    protected String date;
    protected String starke;

    public ContactInfo(String mort,String mtime, String mdate, String mstarke)
    {
        this.ort = mort;
        this.time = mtime;
        this.date = mdate;
        this.starke = mstarke;
    }
}
