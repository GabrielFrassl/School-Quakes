package com.example.markus.quakewatch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;


public class MainActivity extends AppCompatActivity {

    // Declaring Your View and Variables
    ImageButton FAB;
    Button back,jetzt,min;
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {"AT","EU","World", "ZAMG"};
    int Numboftabs =4;
    SharedPreferences SP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            // <---- run your one time code here
            new SendfeedbackJob().execute();


            // mark first time has runned.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }
        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Senden.api = SP.getString("apikey", "");



        // Creating The Toolbar and setting it as the Toolbar for the activity
        Senden.ausgabe(); //Zu testzwecken
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");//Setzt titel auf "" damit es sich nicht mit dem Layout überschneidet
        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);


        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
        pager.setOffscreenPageLimit(4);

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

        FAB = (ImageButton) findViewById(R.id.imageButton);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findViewById(R.id.button1).setVisibility(View.VISIBLE);
                findViewById(R.id.button2).setVisibility(View.VISIBLE);
                findViewById(R.id.button3).setVisibility(View.VISIBLE);
                findViewById(R.id.imageButton).setVisibility(View.INVISIBLE);
                findViewById(R.id.button3).setBackgroundColor(Color.TRANSPARENT);
            }
        });

        back = (Button) findViewById(R.id.button3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.surfaceView).setVisibility(View.INVISIBLE);
                findViewById(R.id.button1).setVisibility(View.INVISIBLE);
                findViewById(R.id.button2).setVisibility(View.INVISIBLE);
                findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                findViewById(R.id.TextView).setVisibility(View.INVISIBLE);
                findViewById(R.id.imageButton).setVisibility(View.VISIBLE);

            }
        });
        min = (Button) findViewById(R.id.button1);
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.imageButton).setVisibility(View.VISIBLE);
                findViewById(R.id.surfaceView).setVisibility(View.INVISIBLE);
                findViewById(R.id.button1).setVisibility(View.INVISIBLE);
                findViewById(R.id.button2).setVisibility(View.INVISIBLE);
                findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                findViewById(R.id.TextView).setVisibility(View.INVISIBLE);

                Intent i = new Intent(MainActivity.this, Formular_jetzt.class);
                startActivity(i);
            }
        });
        jetzt = (Button) findViewById(R.id.button2);
        jetzt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.imageButton).setVisibility(View.VISIBLE);
                findViewById(R.id.surfaceView).setVisibility(View.INVISIBLE);
                findViewById(R.id.button1).setVisibility(View.INVISIBLE);
                findViewById(R.id.button2).setVisibility(View.INVISIBLE);
                findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                findViewById(R.id.TextView).setVisibility(View.INVISIBLE);

                Intent i = new Intent(MainActivity.this, Formular_frueher.class);
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

        return super.onOptionsItemSelected(item);
    }

    private class SendfeedbackJob extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String[] params) {
// do above Server call here
            makePostRequest();
            return null;
        }

        @Override
        protected void onPostExecute(String message) {
//process message
        }

    }
    private void makePostRequest() {


        HttpClient httpClient = new DefaultHttpClient();
// replace with your url
        HttpPost httpPost = new HttpPost("http://geoweb.zamg.ac.at/quakeapi/v01/getapikey");


//Encoding POST data
//httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Basic cXVha2VhcGk6I3FrcCZtbGRuZyM=");

//making POST request.
        try {
            HttpResponse response = httpClient.execute(httpPost);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
            String json = reader.readLine();
            JSONTokener tokener = new JSONTokener(json);
            JSONObject finalResult = new JSONObject(tokener);
            Log.d("Http Post Response:", finalResult.getString("apikey"));
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("apikey", finalResult.getString("apikey"));
            editor.commit();
// write response to log
        } catch (ClientProtocolException e) {
// Log exception
            e.printStackTrace();
        } catch (Exception e) {
// Log exception
            e.printStackTrace();
        }

    }
}
