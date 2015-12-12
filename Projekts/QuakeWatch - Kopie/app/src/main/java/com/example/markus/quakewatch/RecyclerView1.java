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
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.RadioButton;

        import org.json.JSONArray;
        import org.json.JSONObject;

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
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
            JSONObject json = new JSONObject("{\"type\":\"FeatureCollection\",\"metadata\":{\"totalCount\":595668},\"features\":[{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       27.5,        36.81,        -6.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000066\",    \"properties\": {     \"lastupdate\": \"2015-11-19T11:07:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": 27.5,      \"auth\": \"ISK\",      \"lat\": 36.81,      \"depth\": 6.0,      \"unid\": \"20151119_0000066\",      \"mag\": 2.7,      \"time\": \"2015-11-19T11:00:58.4Z\",      \"source_id\": \"471003\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"DODECANESE IS.-TURKEY BORDER REG\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       8.17,        47.55,        -1.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000063\",    \"properties\": {     \"lastupdate\": \"2015-11-19T10:50:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": 8.17,      \"auth\": \"ZUR\",      \"lat\": 47.55,      \"depth\": 1.0,      \"unid\": \"20151119_0000063\",      \"mag\": 1.6,      \"time\": \"2015-11-19T10:43:05.2Z\",      \"source_id\": \"470997\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"SWITZERLAND\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       -121.25,        36.64,        -5.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000061\",    \"properties\": {     \"lastupdate\": \"2015-11-19T10:40:00.0Z\",      \"magtype\": \"md\",      \"evtype\": \"ke\",      \"lon\": -121.25,      \"auth\": \"NC\",      \"lat\": 36.64,      \"depth\": 5.0,      \"unid\": \"20151119_0000061\",      \"mag\": 2.7,      \"time\": \"2015-11-19T10:38:15.6Z\",      \"source_id\": \"470993\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"CENTRAL CALIFORNIA\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       39.34,        36.87,        -11.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000064\",    \"properties\": {     \"lastupdate\": \"2015-11-19T10:54:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": 39.34,      \"auth\": \"ISK\",      \"lat\": 36.87,      \"depth\": 11.0,      \"unid\": \"20151119_0000064\",      \"mag\": 2.1,      \"time\": \"2015-11-19T09:56:43.7Z\",      \"source_id\": \"470999\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"TURKEY-SYRIA BORDER REGION\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       42.47,        36.35,        -6.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000065\",    \"properties\": {     \"lastupdate\": \"2015-11-19T10:57:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": 42.47,      \"auth\": \"ISK\",      \"lat\": 36.35,      \"depth\": 6.0,      \"unid\": \"20151119_0000065\",      \"mag\": 2.8,      \"time\": \"2015-11-19T09:50:32.2Z\",      \"source_id\": \"471000\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"IRAQ\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       -98.43,        36.64,        -3.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000057\",    \"properties\": {     \"lastupdate\": \"2015-11-19T09:59:00.0Z\",      \"magtype\": \"mb\",      \"evtype\": \"ke\",      \"lon\": -98.43,      \"auth\": \"NEIC\",      \"lat\": 36.64,      \"depth\": 3.0,      \"unid\": \"20151119_0000057\",      \"mag\": 3.1,      \"time\": \"2015-11-19T09:46:22.2Z\",      \"source_id\": \"470984\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"OKLAHOMA\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       -70.36,        -20.16,        -36.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000056\",    \"properties\": {     \"lastupdate\": \"2015-11-19T09:56:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": -70.36,      \"auth\": \"GUC\",      \"lat\": -20.16,      \"depth\": 36.0,      \"unid\": \"20151119_0000056\",      \"mag\": 3.1,      \"time\": \"2015-11-19T09:44:44.0Z\",      \"source_id\": \"470983\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"OFFSHORE TARAPACA, CHILE\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       13.89,        37.72,        -35.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000059\",    \"properties\": {     \"lastupdate\": \"2015-11-19T10:04:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": 13.89,      \"auth\": \"ROM\",      \"lat\": 37.72,      \"depth\": 35.0,      \"unid\": \"20151119_0000059\",      \"mag\": 3.1,      \"time\": \"2015-11-19T09:43:37.5Z\",      \"source_id\": \"470986\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"SICILY, ITALY\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       141.21,        37.7,        -65.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000051\",    \"properties\": {     \"lastupdate\": \"2015-11-19T11:06:00.0Z\",      \"magtype\": \"mb\",      \"evtype\": \"ke\",      \"lon\": 141.21,      \"auth\": \"EMSC\",      \"lat\": 37.7,      \"depth\": 65.0,      \"unid\": \"20151119_0000051\",      \"mag\": 4.9,      \"time\": \"2015-11-19T09:33:04.5Z\",      \"source_id\": \"470976\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"NEAR EAST COAST OF HONSHU, JAPAN\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       31.55,        40.28,        -5.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000048\",    \"properties\": {     \"lastupdate\": \"2015-11-19T08:52:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": 31.55,      \"auth\": \"ISK\",      \"lat\": 40.28,      \"depth\": 5.0,      \"unid\": \"20151119_0000048\",      \"mag\": 2.0,      \"time\": \"2015-11-19T08:24:03.4Z\",      \"source_id\": \"470967\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"WESTERN TURKEY\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       20.5,        38.5,        -10.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000047\",    \"properties\": {     \"lastupdate\": \"2015-11-19T08:44:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": 20.5,      \"auth\": \"THE\",      \"lat\": 38.5,      \"depth\": 10.0,      \"unid\": \"20151119_0000047\",      \"mag\": 3.0,      \"time\": \"2015-11-19T08:23:42.0Z\",      \"source_id\": \"470966\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"GREECE\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       123.96,        6.47,        -567.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000045\",    \"properties\": {     \"lastupdate\": \"2015-11-19T08:39:00.0Z\",      \"magtype\": \"mb\",      \"evtype\": \"ke\",      \"lon\": 123.96,      \"auth\": \"EMSC\",      \"lat\": 6.47,      \"depth\": 567.0,      \"unid\": \"20151119_0000045\",      \"mag\": 4.4,      \"time\": \"2015-11-19T08:04:19.7Z\",      \"source_id\": \"470963\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"MORO GULF, MINDANAO, PHILIPPINES\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       -122.45,        46.25,        -20.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000044\",    \"properties\": {     \"lastupdate\": \"2015-11-19T08:06:00.0Z\",      \"magtype\": \"md\",      \"evtype\": \"ke\",      \"lon\": -122.45,      \"auth\": \"NEIR\",      \"lat\": 46.25,      \"depth\": 20.0,      \"unid\": \"20151119_0000044\",      \"mag\": 2.7,      \"time\": \"2015-11-19T08:02:30.5Z\",      \"source_id\": \"470961\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"WASHINGTON\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       -71.84,        -30.39,        -32.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000043\",    \"properties\": {     \"lastupdate\": \"2015-11-19T08:04:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": -71.84,      \"auth\": \"GUC\",      \"lat\": -30.39,      \"depth\": 32.0,      \"unid\": \"20151119_0000043\",      \"mag\": 4.4,      \"time\": \"2015-11-19T07:47:29.0Z\",      \"source_id\": \"470960\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"OFFSHORE COQUIMBO, CHILE\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       -98.39,        36.67,        -2.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000042\",    \"properties\": {     \"lastupdate\": \"2015-11-19T08:56:00.0Z\",      \"magtype\": \"mw\",      \"evtype\": \"ke\",      \"lon\": -98.39,      \"auth\": \"EMSC\",      \"lat\": 36.67,      \"depth\": 2.0,      \"unid\": \"20151119_0000042\",      \"mag\": 4.7,      \"time\": \"2015-11-19T07:42:11.3Z\",      \"source_id\": \"470957\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"OKLAHOMA\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       -66.67,        -22.62,        -209.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000040\",    \"properties\": {     \"lastupdate\": \"2015-11-19T08:10:00.0Z\",      \"magtype\": \"mb\",      \"evtype\": \"ke\",      \"lon\": -66.67,      \"auth\": \"EMSC\",      \"lat\": -22.62,      \"depth\": 209.0,      \"unid\": \"20151119_0000040\",      \"mag\": 5.0,      \"time\": \"2015-11-19T07:40:25.5Z\",      \"source_id\": \"470956\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"JUJUY, ARGENTINA\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       -73.97,        5.66,        -113.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000041\",    \"properties\": {     \"lastupdate\": \"2015-11-19T07:53:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": -73.97,      \"auth\": \"RSNC\",      \"lat\": 5.66,      \"depth\": 113.0,      \"unid\": \"20151119_0000041\",      \"mag\": 2.0,      \"time\": \"2015-11-19T07:39:18.0Z\",      \"source_id\": \"470959\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"COLOMBIA\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       20.59,        38.73,        -1.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000046\",    \"properties\": {     \"lastupdate\": \"2015-11-19T08:32:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": 20.59,      \"auth\": \"THE\",      \"lat\": 38.73,      \"depth\": 1.0,      \"unid\": \"20151119_0000046\",      \"mag\": 2.9,      \"time\": \"2015-11-19T07:38:30.8Z\",      \"source_id\": \"470955\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"GREECE\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       35.31,        40.17,        -5.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000039\",    \"properties\": {     \"lastupdate\": \"2015-11-19T07:43:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": 35.31,      \"auth\": \"ISK\",      \"lat\": 40.17,      \"depth\": 5.0,      \"unid\": \"20151119_0000039\",      \"mag\": 2.4,      \"time\": \"2015-11-19T07:03:50.0Z\",      \"source_id\": \"470954\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"CENTRAL TURKEY\"   } },{   \"geometry\": {     \"type\": \"Point\",      \"coordinates\": [       20.58,        38.77,        -6.0     ]   },    \"type\": \"Feature\",    \"id\": \"20151119_0000062\",    \"properties\": {     \"lastupdate\": \"2015-11-19T10:48:00.0Z\",      \"magtype\": \"ml\",      \"evtype\": \"ke\",      \"lon\": 20.58,      \"auth\": \"THE\",      \"lat\": 38.77,      \"depth\": 6.0,      \"unid\": \"20151119_0000062\",      \"mag\": 2.7,      \"time\": \"2015-11-19T07:00:42.5Z\",      \"source_id\": \"470950\",      \"source_catalog\": \"EMSC-RTS\",      \"flynn_region\": \"GREECE\"   } }]}");
            JSONArray j = json.getJSONArray("features");
             for(int i = 0; i < j.length(); i++)
             {


                 JSONObject c = j.getJSONObject(i);
                 JSONObject b = c.getJSONObject("properties");
                 String[] td = b.getString("time").split("T");
                 String ort = b.getString("flynn_region");
                 if(ort.length() >= 30)
                    ort = b.getString("flynn_region").substring(0, 30) + "...";
                 ContactInfo test = new ContactInfo(ort,td[1],td[0],b.getString("mag"));
                 contactList.add(test);
             }

        }catch(Exception e)
        {
          e.printStackTrace();
        }
          return contactList;
      }




}