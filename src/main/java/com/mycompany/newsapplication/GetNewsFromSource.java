
package com.mycompany.newsapplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class GetNewsFromSource {
    String url;
    
    final ArrayList<NewsData> fetchedData;

    public GetNewsFromSource() {
        this.fetchedData = new ArrayList<NewsData>();
    }
    
    public ArrayList<NewsData> getNews(String URL){
        try {
            this.url = URL;
            Document doc;
            NewsData n;
            doc = Jsoup.connect(url).get();
            Elements content = doc.getElementsByClass("cbp-vm-title");
            Elements content2 = doc.getElementsByClass("cbp-vm-price");
            Elements timeContent = doc.getElementsByClass("latest-time");
            Elements linkSites = doc.getElementsByClass("cbp-vm-image");
            String h3Data = "";
            String desc = "";
            String imgLink = "";
            ArrayList<String> newsLinks = new ArrayList<String>();
            ArrayList<String> timeArray = new ArrayList<String>();
            for(Element getLink : linkSites){
                newsLinks.add(getLink.attr("href"));
                Element x = getLink.getElementsByTag("img").first();
                imgLink = x.attr("src");
            }
            int counter = 0;
            for(Element time : timeContent){
                Element timeTagElement = time.getElementById("time");
                timeArray.add(timeTagElement.text());
            }
            for(Element x : content){
                h3Data = x.text();
                Element descTemp = content2.get(counter);
                desc = descTemp.text();
                n = new NewsData(h3Data, desc, newsLinks.get(counter),timeArray.get(counter));
                fetchedData.add(n);
                counter++;
                h3Data = "";
                desc = "";
            }
            
        } catch (IOException ex) {
            Logger.getLogger(GetNewsFromSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fetchedData;
    }
}
