package selenium.demo.model.Response;


import java.time.Instant;

public class Book {

    public String isbn;

    public String title;

    public String subTitle;

    public String author;
    public String publishDate;

    public String publisher;

    public Integer pages;

    public String description;

    public String website;


    public void setPublishDate(String publishDate) {
        Instant timeStamp=null;
        timeStamp=Instant.parse(publishDate);
        this.publishDate = publishDate;
    }



}
