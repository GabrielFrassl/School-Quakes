package com.example.markus.quakewatch;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Zusatzfragen extends AppCompatActivity {

    Toolbar toolbar;
    Button senden;
    NumberPicker np;
    EditText kommentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zusatz);
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

         np = (NumberPicker) findViewById(R.id.numberPicker);

        np.setMinValue(0);
        np.setMaxValue(20);

        kommentar = (EditText) findViewById(R.id.input_kommentar);

        senden = (Button) findViewById(R.id.senden);

        senden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Senden.stock = np.getValue();
                Senden.kommentar = kommentar.getText().toString();
                Senden.ausgabe();
                new Httpsend1().execute();
                onBackPressed();
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

    public class Httpsend1 extends AsyncTask<String, Void, Boolean> {
        protected Boolean doInBackground(String... param) {
            Boolean blnObj = new Boolean("false");
            boolean b = blnObj.booleanValue();

            HttpClient httpClient = new DefaultHttpClient();

            try {
                /*
                String Erdbeben = Senden.buildjson();
                System.out.println(Erdbeben.toString());
                HttpPost request = new HttpPost("http://geoweb.zamg.ac.at/quakeapi/v01/message");
                StringEntity params = new StringEntity(Erdbeben.toString());
                request.setHeader("content-type", "application/json");
                request.setHeader("Content-Type", "application/json");
                request.setHeader("Authorization", "Basic cXVha2VhcGk6I3FrcCZtbGRuZyM=");
                request.setHeader("X-QuakeAPIKey", api);
                request.setEntity(params);

                System.out.println(request.getAllHeaders());
                httpClient.execute(request);
                // handle response here...
                b = blnObj.booleanValue();
                */
                JSONObject Erdbeben = new JSONObject();
                Erdbeben.put("referenzID:", null);
                Erdbeben.put("locLon:", null);
                Erdbeben.put("locLat:", null);
                Erdbeben.put("locPrecision:", null);
                Erdbeben.put("locLastUpdate:",null);
                Erdbeben.put("mlocPLZ:","1190");
                Erdbeben.put("mlocOrtsname:", "Wien");
                Erdbeben.put("stockwerk:", 1);
                Erdbeben.put("klassifikation:", 2);
                Erdbeben.put("verspuert:","2015-12-06T21:30+01:00");
                Erdbeben.put("kommentar:", "testkommentar");
                Erdbeben.put("kontakt:",  "harald.bamberger@zamg.ac.at" );

                URL myURL = new URL("http://geoweb.zamg.ac.at/quakeapi/v01/message");
                HttpURLConnection myURLConnection = (HttpURLConnection) myURL.openConnection();
                myURLConnection.setRequestMethod("POST");
                myURLConnection.setRequestProperty("Content-Type", "application/json");
                myURLConnection.setRequestProperty("Authorization", "Basic cXVha2VhcGk6I3FrcCZtbGRuZyM=");
                myURLConnection.setRequestProperty("X-QuakeAPIKey", Senden.api);
                myURLConnection.setDoOutput(true);
                myURLConnection.setDoInput(true);
                myURLConnection.getOutputStream().write(Erdbeben.toString().getBytes("utf-8"));


                myURLConnection.connect();
                String a = ""+ myURLConnection.getResponseCode();
                System.out.println("test");
                BufferedReader in = new BufferedReader(new InputStreamReader(myURLConnection.getErrorStream()));
                String inputLine;
                String abc="";
                while ((inputLine = in.readLine()) != null)
                    abc+=inputLine;
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Fehlgeschlagen!!!");
            }
            return b;
        }

        protected void onPostExecute(Boolean result)
        {
            System.out.println("Senden hat geklappt!!!");
        }
    }
}
