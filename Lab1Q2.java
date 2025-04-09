package com.csc3104lab.csc3104lab.Lab1;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.Scene;

import javafx.stage.Stage;

import javax.swing.*;


public class Lab1Q2 extends Application {
    @Override
    public void start(Stage primarystage) {


        //create a pane and set the properties
        GridPane gPane=new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding(new Insets(12,13,14,12.5));
        gPane.setHgap(6);
        gPane.setVgap(6);

        //place node in the pane
        Label mLabel =new Label("Name:");
        TextField Tname=new TextField();
        gPane.add(mLabel,0,0);
        gPane.add(Tname,1,0);


        Label matric =new Label("Matric Number:");
        TextField Tmatric=new TextField();
        gPane.add(matric,0,1);
        gPane.add(Tmatric,1,1);


        Label mHeight =new Label("Height(m):");
        TextField THeight=new TextField();
        gPane.add(mHeight,0,2);
        gPane.add(THeight,1,2);


        Label mWeight =new Label("Weight(kg):");
        TextField TWeight=new TextField();
        gPane.add(mWeight,0,3);
        gPane.add(TWeight,1,3);
        //Calculate button is generated
        Button button=new Button("Calculate");
        gPane.add(button,1,5);
        GridPane.setValignment(button, VPos.CENTER);//allign button to the center

        Label result=new Label();
        gPane.add(result,1,2,3,4);
        //ensure the result is display at the right side of node
        GridPane.setHalignment(result, HPos.RIGHT);
        //ensure the result is display at the bottom side of node
        GridPane.setValignment(result,VPos.BOTTOM);


        button.setOnAction (e -> {
            try {
                // Parse weight and height values from the text fields
                Integer.parseInt(Tmatric.getText());
                double weight = Double.parseDouble(TWeight.getText());
                double height = Double.parseDouble(THeight.getText());

                // Calculate BMI and display it in the result label
                double bmi = weight / (height * height);
                result.setText(String.format(Tname.getText() + "'s BMI : %.2f", bmi));
            }
            catch (Exception ex) {
                // Handle any invalid input and display error message
                result.setText("Invalid Input");
            }
        });

        Scene scene = new Scene(gPane);
        primarystage.setTitle("Body Mass Index (BMI)"); // Set the stage title
        primarystage.setScene(scene); // Place the scene in the stage
        primarystage.show(); // Display the stage



    }
    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}