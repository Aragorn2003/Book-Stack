package com.mycompany.mavenproject3;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class PrimaryController {
    
    @FXML
    private Button Add;
    @FXML
    private Button Remove;
    @FXML
    private Button Edit;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private BorderPane borderPane;
    @FXML
    private ListView<Book> listView;
    
    private ArrayList<Book> stack = App.getStack();
    
     @FXML
    private void initialize(){
    updateStackView();
    
    //borderPane.setCenter(listView);
    Add.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            //handleAddButton(event);
            addNewBook(event);
    }
    });
    Remove.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            //handleRemoveButton(event);
            removeBook(event);
        }
    });
    
    Edit.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            Book choosenBook = listView.getSelectionModel().getSelectedItem();
            editBook(choosenBook);
        }
    });
    
    listView.setOnMouseClicked(event -> {
        Book selectedItem = listView.getSelectionModel().getSelectedItem();
        String printName = selectedItem.getName();
        String printAuthor = selectedItem.getAuthor();
        int selectedYear = selectedItem.getYear();
        String printYear = String.valueOf(selectedYear);
        
        textField1.setText(printName);
        textField2.setText(printAuthor);
        textField3.setText(printYear);
    
    });
    
   
    }
    
    /*
    private void handleAddButton(ActionEvent event) {
            
        }
    
    private void handleRemoveButton(ActionEvent event){
    
     }
    */
    
   
    @FXML
    private void addNewBook(ActionEvent event){//Vyčte co je napsaného v textField1, textField2 a textField3 a přidá prvek s těmito hodnotami na vrchol zásobníku
        String newName = textField1.getText();
        String newAuthor = textField2.getText();
        int newYear = Integer.parseInt(textField3.getText());
        
        stack.add(0, new Book(newName, newAuthor, newYear));
        updateStackView();
    } 
    
    @FXML
    private void removeBook(ActionEvent event){//projde celý zásobník a označený prvek z něj vymaže (budeli se shodovat jméno, autor a rok
        String nameToRemove = textField1.getText();
        String authorToRemove = textField2.getText();
        int yearToRemove = Integer.parseInt(textField3.getText());
        for (Book book: stack){
            if(book.getName().equals(nameToRemove) && book.getAuthor().equals(authorToRemove) && book.getYear() == yearToRemove){
                stack.remove(book);
                updateStackView();
                break;
            }
        }
        
    }
    
    @FXML
    private void editBook(Book book){
        String name = textField1.getText();
        String author = textField2.getText();
        int year = Integer.parseInt(textField3.getText());
        
        book.setName(name);
        book.setAuthor(author);
        book.setYear(year);
        updateStackView();
    }
    
   // private void clickedReaction(){} //Po kliknutí na prvek v zásobníku se v textových polích zobrazí hodnoty označeného prvku
    
    public void updateStackView(){
       // listView.getItems().clear();
        //listView.getItems().addAll(stack);
        ObservableList<Book> ol = FXCollections.observableArrayList();
        ol.addAll(stack);
        listView.setItems(ol);
}
}
