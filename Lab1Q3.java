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

public class Lab1Q3 extends Application{
    public void start(Stage primarystage){
        //create a pane and set the properties
        GridPane gPane=new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding(new Insets(12,13,14,12.5));
        gPane.setHgap(6);
        gPane.setVgap(6);
        //node with specific feature is created
        Label LPrice =new Label("Unit Price of Product(RM):");
        TextField TPrice=new TextField();
        gPane.add(LPrice,0,2);
        gPane.add(TPrice,1,2);


        Label LQty =new Label("Quantity product sold:");
        TextField TQty=new TextField();
        gPane.add(LQty,0,3);
        gPane.add(TQty,1,3);

        Button button=new Button("Total sale:");
        gPane.add(button,1,5);
        GridPane.setValignment(button, VPos.CENTER);//allign button to the center
        GridPane.setHalignment(button,HPos.LEFT);

        Label result=new Label();
        gPane.add(result,1,2,3,4);
        //ensure the result is display at the right side of node
        GridPane.setHalignment(result, HPos.RIGHT);
        //ensure the result is display at the bottom side of node
        GridPane.setValignment(result,VPos.BOTTOM);



        button.setOnAction (e -> {
            try {
                // Parse weight and height values from the text fields

                double price = Double.parseDouble(TPrice.getText());
                double qty = Double.parseDouble(TQty.getText());

                // Calculate BMI and display it in the result label
                double sale=price*qty;
                result.setText("Price is RM"+sale);
            }
            catch (Exception ex) {
                // Handle any invalid input and display error message
                result.setText("Invalid Input");
            }
        });

        Scene scene = new Scene(gPane);
        primarystage.setTitle("Sale Calculator"); // Set the stage title
        primarystage.setScene(scene); // Place the scene in the stage
        primarystage.show(); // Display the stage



    }
    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
    }

