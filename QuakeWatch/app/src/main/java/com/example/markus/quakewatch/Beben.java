package com.example.markus.quakewatch;



public class Beben {
    protected String ort;
    protected String time;
    protected String date;
    protected String starke;
    protected String koordinaten;
    protected String zeitzone;
    protected String zenturm;
    protected String tiefe;
    protected String id;

    public Beben(String mort, String mtime, String mdate, String mstarke, String mkoordinaten, String mzeitzone, String mzentrum, String mtiefe, String mid)
    {
        this.ort = mort;
        this.time = mtime;
        this.date = mdate;
        this.starke = mstarke;
        this.koordinaten = mkoordinaten;
        this.zeitzone = mzeitzone;
        this.zenturm = mzentrum;
        this.tiefe = mtiefe;
        this.id = mid;
    }
}
