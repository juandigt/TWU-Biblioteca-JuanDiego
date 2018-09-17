package com.twu.biblioteca;

public class Book {

    private String author;
    private String title;
    private int year;



    public Book(String au, String tit, int ye) {
        this.author = au;
        this.title = tit;
        this.year = ye;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public int getYear(){
        return year;
    }

    public void setYear(int Year){
        this.year = Year;
    }

    @Override
    public String toString() {
        String resultado = "";
        resultado = "\nAuthor: "+this.author;
        resultado += "\nTitle: "+this.title;
        resultado += "\nYear: "+this.year+"\n";

        return resultado;
    }

}