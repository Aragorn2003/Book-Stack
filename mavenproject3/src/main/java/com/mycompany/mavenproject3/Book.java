/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

/**
 *
 * @author Lukáš
 */
public class Book {
     private String name;
    private String author;
    private int yearOfPublish;
    
    public Book(String name, String author, int yearOfPublish){
        this.name=name;
        this.author=author;
        this.yearOfPublish= yearOfPublish;
    
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    
   
    /**
     * @return the yearOfPublish
     */
    public int getYear() {
        //return Integer.toString(yearOfPublish);
        return yearOfPublish;
    }
    
    
  

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @param yearOfPublish the yearOfPublish to set
     */
    public void setYear(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }
    
      @Override
    public String toString(){
    return name+" "+author+" "+yearOfPublish;
    }
}
