package com.example.markus.quakewatch;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class Formular_frueher extends AppCompatActivity {

    Toolbar toolbar;
    public Button weiter;
    public static Button datum, zeit;
    public EditText ort,plz;
    final Calendar c = Calendar.getInstance();

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

                Intent i = new Intent(Formular_frueher.this, Comics.class);
                startActivity(i);
            }
        });

        datum = (Button) findViewById(R.id.input_datum);
        zeit = (Button) findViewById(R.id.input_zeit);

        zeit.setText(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE));
        datum.setText(c.get(Calendar.DAY_OF_MONTH) + ":" + (c.get(Calendar.MONTH) + 1) + ":" + c.get(Calendar.YEAR));

        Senden.hour = c.get(Calendar.HOUR_OF_DAY);
        Senden.minute = c.get(Calendar.MINUTE);
        Senden.year = c.get(Calendar.YEAR);
        Senden.month = (c.get(Calendar.MONTH) + 1);
        Senden.day = c.get(Calendar.DAY_OF_MONTH);
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
