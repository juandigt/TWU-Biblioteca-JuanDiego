package com.twu.biblioteca;

public class Book {

    private String author;
    private String title;
    private int year;

    public Book(){};

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
        resultado = "\nAutor: "+this.author;
        resultado += "\nTítulo: "+this.title;
        resultado += "\nAño: "+this.year+"\n";

        return resultado;
    }

}
//Book libro1 = new Book();
//libro1.setAuthor("Lorca");
//libro1.setTitle("La casa de Bernarda ..");
//libro1.setYear(1920);
//Book libro2 = new Book("Lorca", "La casa...", 1920);