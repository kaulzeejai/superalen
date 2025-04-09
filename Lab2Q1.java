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



public class Lab2Q1  extends Application {
    @Override
    public void start(Stage primarystage) {


        //create a pane and set the properties
        GridPane gPane=new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding(new Insets(12,13,14,12.5));
        //the gap between the nodes is set
        gPane.setHgap(8);
        gPane.setVgap(8);
        //set pane is set into suitable following size
        gPane.setPrefSize(350,20);

        //place node in the pane following the details given
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
        gPane.add(button,0,5);
        GridPane.setHalignment(button, HPos.LEFT);//allign button to the left


        Label result=new Label();
        Label result1=new Label();

        gPane.add(result,1,4);

        gPane.add(result1,1,5); //set position of the displayed result next to the calculate button
        //ensure the result is display at the right part of node
        GridPane.setHalignment(result, HPos.RIGHT);
        //ensure the result is display at the bottom side of node
        GridPane.setValignment(result,VPos.CENTER);

        GridPane.setValignment(result1,VPos.BOTTOM);

        button.setOnAction ( e -> {
            try {
                // Parse weight and height values from the text fields

                double weight = Double.parseDouble(TWeight.getText());
                double height = Double.parseDouble(THeight.getText());

                // Calculate BMI and display it in the result label
                double bmi = weight / (height * height);
                result.setText(String.format(Tname.getText() + "'s BMI : %.2f", bmi));

                if(bmi<18.5){
                    result1.setText("Underweight and The Risk is Increased");
                }
                else if(bmi>18.5 && bmi<24.9){
                    result1.setText("Normal  and The Risk is Least");
                }
                else if(bmi>25.0 && bmi<29.9){
                    result1.setText("Overweight  and The Risk is Increased");
                }
                else if(bmi>30.0 && bmi<34.9){
                    result1.setText("Obese class I  and The Risk is high");
                }
                else if(bmi>35.0 && bmi<39.9){
                    result1.setText("Obese class II  and The Risk is very high");
                }
                else if( bmi>=40.0){
                    result1.setText("Obese class III and The Risk is extremely high");
                }

            }
            catch (Exception ex) {
                // Handle any invalid input and display error message
                result.setText("Invalid Input");
                result1.setText("Input invalid");
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
