package com.example.snackmapsgit;

import android.app.Activity;
import android.os.AsyncTask;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraping {
    class Price{
        public volatile Double price = 0.0;
    }
    final Price itemPrice = new Price();
    final
    public Document getScrape(String url) {
        Connection connection = Jsoup.connect(url);
        try {
            Document document = connection.get();
            return document;

            // how to get information from a document
        }
        catch (IOException ex){
        }


       return null;
    }


    protected Double getScrapeInBackground(String url, MainActivity activity) {
        Thread thread = new Thread(() -> {
                // do background stuff here
                Document doc = getScrape(url);
                Elements elements = doc != null ? doc.getElementsByClass("inline-flex flex-column") : null;
                String get = elements.get(0).attr("text");
                activity.runOnUiThread(() -> {
                    // OnPostExecute stuff here
                    System.out.println("test2");
                });

        });
        thread.start();
        activity.setTest("test3");
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return itemPrice.price;
    }



}