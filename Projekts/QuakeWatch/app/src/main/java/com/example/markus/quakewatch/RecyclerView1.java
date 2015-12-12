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

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

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
    protected CustomAdapter mAdapter;
    protected int number;
    protected RecyclerView.LayoutManager mLayoutManager;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    public void setnumber(int i)
    {
        number = i;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StrictMode.setThreadPolicy(policy);
        View rootView = inflater.inflate(R.layout.recycler_view, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.cardList);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<ContactInfo> contactList = new ArrayList<ContactInfo>();
        contactList = test();

        mAdapter = new CustomAdapter(contactList);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }
    public List<ContactInfo> test()
    {
        List<ContactInfo> contactList = new ArrayList<ContactInfo>();
                    try {
                        JSONObject json = null;
                            switch(number)
                            {
                                case 0:
                                    json = readJsonFromUrl("http://www.seismicportal.eu/fdsnws/event/1/query?limit=100&minlat=46&maxlat=49&minlon=9&maxlon=17&format=json");
                                    break;
                                case 1:
                                    json = readJsonFromUrl("http://www.seismicportal.eu/fdsnws/event/1/query?limit=25&minlat=40&maxlat=80&minlon=20&maxlon=60&format=json");
                                    break;
                                case 2:
                                    json = readJsonFromUrl("http://www.seismicportal.eu/fdsnws/event/1/query?limit=25&format=json");
                                    break;

                            }
                        JSONArray j = json.getJSONArray("features");
                        for(int i = 0; i < j.length(); i++)
                        {
                            JSONObject c = j.getJSONObject(i);
                            JSONObject b = c.getJSONObject("properties");
                            String[] td = b.getString("time").split("T");
                            String ort = b.getString("flynn_region");
                            if(ort.length() >= 30)
                                ort = b.getString("flynn_region").substring(0, 30) + "...";
                            double mag = b.getDouble("mag");
                            if(b.getString("flynn_region").equals("AUSTRIA") && number == 0) {
                            ContactInfo test = new ContactInfo(b.getString("flynn_region"), td[1], td[0], b.getString("mag"));
                            contactList.add(test);
                        }
                                else if(number == 1) {
                                ContactInfo test = new ContactInfo(b.getString("flynn_region"), td[1], td[0], b.getString("mag"));
                                contactList.add(test);
                            }
                            else if(number == 2)
                            {
                                ContactInfo test = new ContactInfo(b.getString("flynn_region"), td[1], td[0], b.getString("mag"));
                                contactList.add(test);
                            }
                        }

                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    return contactList;
    }


    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException
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
    private static String readAll(Reader rd) throws IOException
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