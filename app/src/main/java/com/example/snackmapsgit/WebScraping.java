package com.example.snackmapsgit;

import android.os.AsyncTask;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraping extends AsyncTask<String, Integer, String> {
    public static String getScrape(String url) {
        Connection connection = Jsoup.connect(url);
        try {
            Document doc = connection.get();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "th";
    }

    @Override
    protected String doInBackground(String... strings) {
        return getScrape(strings)
    }
}