
package com.mycompany.newsapplication;

public class NewsData {
    public String heading;
    public String description;
    public String link;
    public String time;

    public NewsData(String heading, String description, String link, String time) {
        this.heading = heading;
        this.description = description;
        this.link = link;
        this.time = time;
    }
    public String getDescription() {
        return description;
    }
    public String getTime() {
        return time;
    }

    public String getHeading() {
        return heading;
    }

    public String getLink(){
        return link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}
