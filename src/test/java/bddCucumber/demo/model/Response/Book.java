package bddCucumber.demo.model.Response;

import lombok.Data;

@Data
public class Book {

    private String isbn;

    private String title;

    private String subTitle;

    private String author;

    private String published;

    private String publisher;

    private int pages;

    private String description;

    private String website;


//    public void setPublishDate(String publishDate) {
//        Instant timeStamp=null;
//        timeStamp=Instant.parse(publishDate);
//        this.published = publishDate;
//    }



}
