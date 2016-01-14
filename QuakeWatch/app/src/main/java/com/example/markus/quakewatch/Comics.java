package com.example.markus.quakewatch;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Comics extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formular, menu);
        return true;
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

    public void comic1(View v)
    {
        Senden.comic = 1;
        Intent i = new Intent(Comics.this, Zusatzfragen.class);
        startActivity(i);
    }

    public void comic2(View v)
    {
        Senden.comic = 2;
        Intent i = new Intent(Comics.this, Zusatzfragen.class);
        startActivity(i);
    }

    public void comic3(View v)
    {
        Senden.comic = 3;
        Intent i = new Intent(Comics.this, Zusatzfragen.class);
        startActivity(i);
    }

    public void comic4(View v)
    {
        Senden.comic = 4;
        Intent i = new Intent(Comics.this, Zusatzfragen.class);
        startActivity(i);
    }

    public void comic5(View v)
    {
        Senden.comic = 5;
        Intent i = new Intent(Comics.this, Zusatzfragen.class);
        startActivity(i);
    }

    public void comic6(View v)
    {
        Senden.comic = 6;
        Intent i = new Intent(Comics.this, Zusatzfragen.class);
        startActivity(i);
    }
}
