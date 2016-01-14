package com.example.markus.quakewatch;

import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.HttpClientConnection;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


/**
 * Created by limbeck-sonja on 16.12.2015.
 */
public final class Senden {

    public static int id;
    public static double mag;
    public static double tiefe;
    public static int year;
    public static int month;
    public static int day;
    public static int hour;
    public static int minute;
    public static int comic;
    public static int stock;
    public static String ort;
    public static String plz;
    public static String kommentar;
    public static String koordinaten;
    public static String zeitzone;
    public static String zentrum;
    public static String api;

    public Senden() {
        api = "";
        id = 0;
        tiefe = 0;
        mag = 0;
        year = 0;
        month = 0;
        day = 0;
        hour = 0;
        minute = 0;
        comic = 0;
        stock = 0;
        ort = "";
        plz = "";
        kommentar = "";
        koordinaten = "";
        zeitzone = "";
        zentrum = "";
    }


    public static void ausgabe() {
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
        System.out.println("Hour: " + hour);
        System.out.println("Minute: " + minute);
        System.out.println("Comic: " + comic);
        System.out.println("Stock:" + stock);
        System.out.println("Ort: " + ort);
        System.out.println("PlZ: " + plz);
        System.out.println("kommentar: " + kommentar);

    }
    private static JSONObject buildjson() {
        JSONObject Erdbeben = new JSONObject();
        try {
            Erdbeben.put("referenzID:",id);
            Erdbeben.put("locLon:",null);
            Erdbeben.put("locLat:",null);
            Erdbeben.put("locPrecision",null);
            Erdbeben.put("locLastUpdate:",null);
            Erdbeben.put("mlocPLZ:",plz);
            Erdbeben.put("mlocOrtsname:",ort);
            Erdbeben.put("stockwerk:", stock);
            Erdbeben.put("klassifikation:", comic);
            Erdbeben.put("verspuert:", day + "-" + month + "-" + year +"T"+day + ":" + month + ":" + year);
            Erdbeben.put("kommentar:", kommentar);
            Erdbeben.put("kontakt:", null);
            return Erdbeben;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Erdbeben;
    }
}
