package com.example.movieworkshoptemplate.models;

//Movie POJO
public class Movie {

    //3.2
    int year;
    int length;
    String title;
    String subject;
    int popularity;
    boolean awards;

    public Movie(int year, int length, String title, String subject, int popularity, boolean awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;

    }
}
