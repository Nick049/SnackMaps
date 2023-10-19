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

    static List<String> priceList = new ArrayList<>();
    static List<String> productList = new ArrayList<>();

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
                getPriceWalmartPage(doc);
                getProdectWalmartPage(doc);

                /**getPriceWalmart(doc);
                getProductWalmart(doc);
                getLocationWalmart(doc); **/
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
        return priceList;
    }

    public void getPriceWalmartPage(Document doc){
        Elements urlElement = doc != null ? doc.getElementsByClass("mr1 mr2-xl b black lh-copy f5 f4-l") : null;
        Node priceNodeDolar = urlElement.get(0).childNode(2).childNode(0);
        Node priceNodeCent = urlElement.get(0).childNode(3).childNode(0);
        String price = ((TextNode)priceNodeDolar).text() + ((TextNode)priceNodeCent).text();
        priceList.add(price);
    }
    public void getProdectWalmartPage(Document doc){
        Elements urlElement = doc != null ? doc.getElementsByClass("w_V_DM") : null;
        Node priceNodeDolar = urlElement.get(0).childNode(2).childNode(0);
        String price = ((TextNode)priceNodeDolar).text();
        productList.add(price);
    }
    public void getPriceWalmart(Document doc){
        Elements productElement = doc != null ? doc.getElementsByClass("inline-flex flex-column") : null;
        Node productNode = productElement.get(0).childNode(0).childNode(0);
        productList.add(((TextNode) productNode).text());
    }
    public void getProductWalmart(Document doc){
        Elements productElement = doc != null ? doc.getElementsByClass("lh-copy dark-gray mv1 f3 mh0-l mh3 b") : null;
        Node productNode = productElement.get(0).childNode(0);
        priceList.add(((TextNode) productNode).text());
    }
    public void getLocationWalmart(Document doc){
        Elements locationElement = doc != null ? doc.getElementsByClass("mw-none-m mh2-m truncate") : null;
        Node productNode = locationElement.get(0).childNode(0);
        priceList.add(((TextNode) productNode).text());
    }
}