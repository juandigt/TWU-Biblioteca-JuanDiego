package com.twu.biblioteca;

public class Movie {

    private String name;
    private String director;
    private int year;
    private String rating = "unrated";


    public Movie(String name, String director, int year, String rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getName(){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

}
