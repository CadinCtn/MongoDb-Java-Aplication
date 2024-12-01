package model;

import org.bson.Document;

import java.util.Date;

public class Movie {

    private String title;

    private String description;


    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    ////////////
    public Movie(Document movie){
        this.title = movie.getString("title");
        this.description = movie.getString("description");
    }

    public Document toDocument(){
        Document document = new Document();
        document.append("title", title);
        document.append("description", description);
        return document;
    }

    //////////


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
