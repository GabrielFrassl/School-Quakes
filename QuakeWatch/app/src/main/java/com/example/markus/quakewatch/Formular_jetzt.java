package com.example.markus.quakewatch;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Formular_jetzt extends AppCompatActivity {

    Toolbar toolbar;
    public Button weiter;
    public static Button datum, zeit;
    public EditText ort,plz;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_formular);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");//Setzt titel auf "" damit es sich nicht mit dem Layout überschneidet


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ort = (EditText) findViewById(R.id.input_ort);
        plz = (EditText) findViewById(R.id.input_plz);
        weiter = (Button) findViewById(R.id.weiter);
        weiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Senden.ort = ort.getText().toString();
                Senden.plz = plz.getText().toString();

                Intent i = new Intent(Formular_jetzt.this, Comics.class);
                startActivity(i);
            }
        });

        datum = (Button) findViewById(R.id.input_datum);
        datum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment dpf = new DatePickerFragment();
                dpf.show(getSupportFragmentManager(), "DatePicker");

            }
        });

        zeit = (Button) findViewById(R.id.input_zeit);
        zeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerFragment tdf = new TimePickerFragment();
                tdf.show(getSupportFragmentManager(), "timePicker");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        this.finish();

    }
}
