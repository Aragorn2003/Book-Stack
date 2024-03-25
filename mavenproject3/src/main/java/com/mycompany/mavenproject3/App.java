package com.mycompany.mavenproject3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {
    private static ArrayList<Book> stack;
     @Override
    public void init(){
        /*
        setStack(new ArrayList<>(100));
        getStack().add(0,new Book("Title1", "Author1", 1961));
        getStack().add(0,new Book("Title2", "Author2", 1962));
        getStack().add(0,new Book("Title3", "Author3", 1963));
        */
        stack = new ArrayList<>(100);
        stack.add(0, new Book("Title1", "Author1", 1961));
        stack.add(0, new Book("Title2", "Author2", 1962));
        stack.add(0, new Book("Title3", "Author3", 1963));
    }
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * @return the stack
     */
    public static ArrayList<Book> getStack() {
        return stack;
    }

    /**
     * @param aStack the stack to set
     */
    public static void setStack(ArrayList<Book> aStack) {
        stack = aStack;
    }

}