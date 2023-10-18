package com.example.snackmapsgit;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class WebScraping {

    static List<String> Data = new ArrayList<>();

    class Price{
        public volatile String price = "";
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


    protected List<String> scrapeWalmart(String url, MainActivity activity) {
        Thread thread = new Thread(() -> {
                // do background stuff here
                Document doc = getScrape(url);
                getPriceWalmart(doc);
                getProductWalmart(doc);
                activity.runOnUiThread(() -> {
                    // OnPostExecute stuff here
                });

        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Data;
    }
    public void getPriceWalmart(Document doc){
        Elements priceElement = doc != null ? doc.getElementsByClass("inline-flex flex-column") : null;
        Node priceNode = priceElement.get(0).childNode(0).childNode(0);
        Data.add(((TextNode) priceNode).text());
    }
    public void getProductWalmart(Document doc){
        Elements productElement = doc != null ? doc.getElementsByClass("lh-copy dark-gray mv1 f3 mh0-l mh3 b") : null;
        Node productNode = productElement.get(0).childNode(0);
        Data.add(((TextNode) productNode).text());
    }
}