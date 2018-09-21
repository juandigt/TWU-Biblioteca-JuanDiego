package com.twu.biblioteca;

public class Book {

    private String author;
    private String title;
    private int year;
    private int id;
    private boolean checkout;


    public Book() {
    }

    public Book(String au, String tit, int ye, int id) {
        this.author = au;
        this.title = tit;
        this.year = ye;
        this.id = id;
        this.checkout = false;
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

    public void setYear(int year){
        this.year = year;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
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
        Book book = (Book) o;
        return id == book.id;
    }


    @Override
    public String toString() {
        String result = "";
        result = "\nAuthor: "+this.author;
        result += "\nTitle: "+this.title;
        result += "\nYear: "+this.year+"\n";

        return result;
    }

}