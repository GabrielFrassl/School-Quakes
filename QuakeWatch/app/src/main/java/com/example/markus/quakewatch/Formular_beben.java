package com.example.markus.quakewatch;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Formular_beben extends AppCompatActivity {

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
        datum = (Button) findViewById(R.id.input_datum);
        zeit = (Button) findViewById(R.id.input_zeit);
        ort.setText(Senden.ort);
        plz.setText("0000");
        zeit.setText(Senden.hour+ ":" + Senden.minute);
        datum.setText(Senden.day + ":" + Senden.month + ":" + Senden.year);


        weiter = (Button) findViewById(R.id.weiter);
        weiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Senden.ort = ort.getText().toString();
                Senden.plz = plz.getText().toString();

                Intent i = new Intent(Formular_beben.this, Comics.class);
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
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

}
