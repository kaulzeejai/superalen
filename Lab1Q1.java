package com.csc3104lab.csc3104lab.Lab1;

import javafx.application.Application;
import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.scene.Scene;

import javafx.stage.Stage;


import java.util.Random;

public class Lab1Q1 extends Application {
    public void start(Stage primaryStage) {
        GridPane gpane = new GridPane();
        Random random = new Random();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 10; col++) {
                int randomnum = random.nextInt(10);
                TextField textfield = new TextField(String.valueOf(randomnum));

                //setting the text to center
                textfield.setAlignment(Pos.CENTER);
                //set the size the textfield
                textfield.setPrefSize(50, 50);
                //set the border colour to red
                textfield.setStyle("-fx-border-color: red");

                gpane.add(textfield, row, col);


            }



        }
        //set the scene and title name of the scene
        Scene scene = new Scene(gpane,400,450);
        primaryStage.setTitle("Lab 1 Assignment"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }
    public static void main(String[] args) {
        launch(args);
    }
}
