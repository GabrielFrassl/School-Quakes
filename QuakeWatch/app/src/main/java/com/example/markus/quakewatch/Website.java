package com.example.markus.quakewatch;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class Website extends Fragment {


    private WebView wv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_loadscreen, container, false);
        // Inflate the layout for this fragment
        wv = (WebView) v.findViewById(R.id.webView);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.loadUrl("http://www.zamg.ac.at/cms/de/geophysik/erdbeben/verhaltensratgeber");

        return v;
    }
}
