package com.example.markus.quakewatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    Toolbar toolbar;
    Button beben;
    TextView ort, zeitzonewert, mag, date, mag2, coordinates, timezone, epicenter, depth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_green);
            if(Senden.mag < 2.5) {
                setContentView(R.layout.activity_detail_green);
            }
            else if(Senden.mag < 3.5) {
                setContentView(R.layout.activity_detail_yellow);
            }
            else if(Senden.mag >= 3.5) {
                setContentView(R.layout.activity_detail_red);
            }
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");//Setzt titel auf "" damit es sich nicht mit dem Layout überschneidet

        mag = (TextView) findViewById(R.id.stärkewert);
        mag2 = (TextView) findViewById(R.id.starke);
        ort = (TextView) findViewById(R.id.location);
        zeitzonewert = (TextView) findViewById(R.id.zeitwert);
        date = (TextView) findViewById(R.id.datewert);
        coordinates = (TextView) findViewById(R.id.coordinateswert);
        timezone = (TextView) findViewById(R.id.zeitzonewert);
        epicenter = (TextView) findViewById(R.id.epizentrumwert);
        depth = (TextView) findViewById(R.id.tiefewert);

        mag.setText(""+ Senden.mag);
        mag2.setText(""+ Senden.mag);
        ort.setText(""+ Senden.ort);
        zeitzonewert.setText(""+ Senden.hour+":"+ Senden.minute);
        date.setText(""+ Senden.day+":"+ Senden.month+":"+ Senden.year);
        coordinates.setText(Senden.koordinaten);
        timezone.setText(Senden.zeitzone);
        epicenter.setText(Senden.zentrum);
        depth.setText(""+ Senden.tiefe);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        beben = (Button) findViewById(R.id.beben);
        if(Senden.id == 0) {
            beben.setEnabled(false);
        }
        beben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Detail.this, Formular_beben.class);
                startActivity(i);
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
