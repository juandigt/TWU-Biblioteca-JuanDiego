package com.twu.biblioteca;

public class Movie {

    private String name;
    private String director;
    private int year;
    private int id;
    private boolean checkout;


    public Movie(String name, String director, int year, int id) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.id = id;
        this.checkout = false;
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
    public int getId(){
        return id;
    }

    public void setId(int year){
        this.id = id;
    }

    public boolean getCheckout(){
        return checkout;
    }
    public void setCheckout(){
        this.checkout = true;
    }

    public void setReturnBook(){
        this.checkout = false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }


    @Override
    public String toString() {
        String result = "";
        result = "\nName: "+this.name;
        result += "\nDirector: "+this.director;
        result += "\nYear: "+this.year+"\n";

        return result;
    }


}
