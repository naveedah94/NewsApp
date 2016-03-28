
package com.mycompany.newsapplication;

import java.util.ArrayList;

public class NewsApp {
    
    public static void main(String[] args) {
        GetNewsFromSource getNews = new GetNewsFromSource();
        ArrayList<NewsData> allNews;
        URL url = new URL();
        allNews = getNews.getNews(url.getUrlEng());
        int counter = 1;
        for(NewsData n : allNews){
            System.out.print("News #" + counter + "\n");
            System.out.print("Heading : " + n.getHeading() + "\n");
            System.out.print("Time : " + n.getTime() + "\n");
            System.out.print("Link : " + n.getLink() + "\n");
            System.out.print("Description : " + n.getDescription() + "\n");
            System.out.print("------------------------------------------------\n");
            counter++;
        }
    }
    
}
