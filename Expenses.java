package com.csc3104lab.csc3104lab.Lab2;


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

public class Expenses extends Application{
    public void start(Stage primarystage){
        //create a pane and set the properties
        GridPane gPane=new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding(new Insets(12,13,14,12.5));
        gPane.setHgap(6);
        gPane.setVgap(6);
        gPane.setPrefSize(350,50);
        //node with specific feature is created
        Label LCode=new Label("Spent:");
        TextField TCode=new TextField();
        gPane.add(LCode,0,1);
        gPane.add(TCode,1,1);

        Label LName =new Label("Total spent:");
        TextField TName=new TextField();
        gPane.add(LName,0,2);
        gPane.add(TName,1,2);

        Label LPrice =new Label("Unit Price of Product(RM):");
        TextField TPrice=new TextField();
        gPane.add(LPrice,0,3);
        gPane.add(TPrice,1,3);


        Label LQty =new Label("Quantity product sold:");
        TextField TQty=new TextField();
        gPane.add(LQty,0,4);
        gPane.add(TQty,1,4);

        Button button=new Button("Total sale");
        gPane.add(button,0,5);

        GridPane.setHalignment(button,HPos.LEFT);
        GridPane.setValignment(button,VPos.CENTER);



        Label result=new Label();
        gPane.add(result,1,6);
        //ensure the result is display at the right side of node
        GridPane.setHalignment(result, HPos.RIGHT);
        //ensure the result is display at the bottom side of node
        GridPane.setValignment(result,VPos.BOTTOM);

        Label result1=new Label();
        gPane.add(result1,1,7);
        GridPane.setHalignment(result1,HPos.CENTER);
        GridPane.setValignment(result1,VPos.BOTTOM);

        Label result2 =new Label();
        gPane.add(result2,1,8);
        GridPane.setHalignment(result2,HPos.CENTER);
        GridPane.setValignment(result2,VPos.BOTTOM);

        Label result3 =new Label();
        gPane.add(result3,1,9);
        GridPane.setHalignment(result3,HPos.CENTER);
        GridPane.setValignment(result3,VPos.BOTTOM);

        Label result4 =new Label();
        gPane.add(result4,1,10);
        GridPane.setHalignment(result4,HPos.CENTER);
        GridPane.setValignment(result4,VPos.BOTTOM);

        Label result5=new Label();
        gPane.add(result5,1,11);
        GridPane.setHalignment(result5,HPos.CENTER);
        GridPane.setValignment(result5,VPos.BOTTOM);

        Label result6 =new Label();
        gPane.add(result6,1,12);
        GridPane.setHalignment(result6,HPos.CENTER);
        GridPane.setValignment(result6,VPos.BOTTOM);

        Label result7 =new Label();
        gPane.add(result7,1,13);
        GridPane.setHalignment(result7,HPos.CENTER);
        GridPane.setValignment(result7,VPos.BOTTOM);

        button.setOnAction (e -> {
            try {
                // Parse weight and height values from the text fields

                double price = Double.parseDouble(TPrice.getText());
                double qty = Double.parseDouble(TQty.getText());
                double discount=0;
                // Calculate BMI and display it in the result label
                double sale=price*qty;

                //display of  product code, name, price per unit, quantity, total price, discount and total price after discount
                result1.setText("Product code:"+TCode.getText());
                result2.setText("Name:"+TName.getText());
                result3.setText("Price per unit"+TPrice.getText());
                result4.setText("Quantity"+TQty.getText());

                result5.setText("Price is RM"+sale);

                //discount rate based on total sale

                if(sale<=500){
                    discount=sale-(sale*0.03);

                }
                else if(sale<=5000){
                    discount=sale-(sale*0.075);
                }
                else if(sale<=10000){
                    discount=sale-(sale*0.1);
                }
                else if(sale<=15000){
                    discount=sale-(sale*0.15);
                }
                result6.setText("Price  after discount is RM"+discount);
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




