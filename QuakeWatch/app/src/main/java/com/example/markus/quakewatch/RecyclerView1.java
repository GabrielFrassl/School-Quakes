package com.example.markus.quakewatch;
/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the use of {@link RecyclerView} with a {@link LinearLayoutManager} and a
 * {@link GridLayoutManager}.
 */
public class RecyclerView1 extends Fragment
{
    protected RecyclerView mRecyclerView;
    protected CardViewAdapter mAdapter;
    protected int number;
    protected RecyclerView.LayoutManager mLayoutManager;
    List<Beben> Werte = new ArrayList<Beben>();
    //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    public void setnumber(int i) {
        number = i;
        HttpRequest http = new HttpRequest();
        http.execute();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //StrictMode.setThreadPolicy(policy);
        View rootView = inflater.inflate(R.layout.recycler_view, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.cardList);


        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new ScrollManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        //List<Beben> contactList2 = new ArrayList<Beben>();

        mRecyclerView.addOnItemTouchListener(new RecyclerClickListener(getContext(), new RecyclerClickListener.OnItemClickListener(){
                    @Override public void onItemClick(View view, int position)
                    {


                        Beben wert = Werte.get(position);
                        String[] time = wert.time.split(":");
                        String[] date = wert.date.split("-");
                        Senden.hour = Integer.parseInt(time[0]);
                        Senden.minute = Integer.parseInt(time[1]);
                        Senden.ort = wert.ort;
                        Senden.mag = Double.parseDouble(wert.starke);
                        Senden.year = Integer.parseInt(date[0]);
                        Senden.month = Integer.parseInt(date[1]);
                        Senden.day = Integer.parseInt(date[2]);
                        Senden.koordinaten = wert.koordinaten;
                        Senden.zeitzone = wert.zeitzone;
                        Senden.zentrum = wert.zenturm;
                        Senden.tiefe = Double.parseDouble(wert.tiefe);
                        Senden.id = Integer.parseInt(wert.id);
                        System.out.println(Senden.id);

                        Intent intent = new Intent(getActivity(), Detail.class);
                        startActivity(intent);
                    }
                })
        );


        //mAdapter = new CardViewAdapter(contactList2);
        // Set CardViewAdapter as the adapter for RecyclerView.
        //mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }
    private class HttpRequest extends AsyncTask<String,Void, List<Beben>>
    {
        protected List<Beben> doInBackground(String... param) {

            return test(number);
        }
        protected void onPostExecute(List<Beben> result)
        {
            mAdapter =  new CardViewAdapter(result);
            Werte = result;
            mRecyclerView.setAdapter(mAdapter);

        }
        public List<Beben> test(int zahl)
        {
            List<Beben> contactList = new ArrayList<Beben>();
            try {
                JSONObject json = null;
                switch(zahl)
                {
                    case 0:
                        json = readJsonFromUrl("http://geoweb.zamg.ac.at/fdsnws/app/1/query?location=austria&limit=25&orderby=time");
                        break;
                    case 1:
                        json = readJsonFromUrl("http://geoweb.zamg.ac.at/fdsnws/app/1/query?location=europa&limit=25&orderby=time");
                        break;
                    case 2:
                        json = readJsonFromUrl("http://geoweb.zamg.ac.at/fdsnws/app/1/query?location=welt&limit=25&orderby=time");
                        break;

                }
                JSONArray j = json.getJSONArray("features");
                for(int i = 0; i < j.length(); i++)
                {
                    JSONObject c = j.getJSONObject(i);
                    JSONObject b = c.getJSONObject("properties");
                    String[] td = b.getString("time").split("T");
                    String time = td[1].substring(0, td[1].indexOf('.'));
                    String ort = b.getString("region");
                    String zeitzone = b.getString("timezone");
                    String zenturm = b.getString("epicenter");
                    String tiefe = b.getString("depth");
                    JSONObject d = c.getJSONObject("geometry");
                    String koordinaten = d.getString("coordinates");
                    if(ort.length() >= 30)
                        ort = b.getString("region").substring(0, 30) + "...";
                    double mag = b.getDouble("mag");

                    String id = "0";
                    if(zahl == 0)
                        id = c.getString("id");

                        Beben test = new Beben(ort, time,td[0], String.valueOf(mag), koordinaten, zeitzone, zenturm, tiefe, id);
                        contactList.add(test);
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return contactList;
        }


        private JSONObject readJsonFromUrl(String url) throws IOException, JSONException
        {
            InputStream is = new URL(url).openStream();
            try
            {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONObject json = new JSONObject(jsonText);
                return json;
            }
            finally
            {
                is.close();
            }
        }
        private String readAll(Reader rd) throws IOException
        {
            StringBuilder sb = new StringBuilder();
            int cp;

            while ((cp = rd.read()) != -1)
            {
                sb.append((char) cp);
            }
            return sb.toString();
        }


    }

}