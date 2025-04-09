package com.csc3104lab.csc3104lab.Lab2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class lab2klsaidil extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Labels
        Label vehicleTypeLabel = new Label("Select Vehicle Type:");
        Label speedLabel = new Label("Vehicle Speed (km/h):");
        Label speedLimitLabel = new Label("Speed Limit (km/h):");
        Label fineLabel = new Label("Fine Amount:");

        // Radio buttons for vehicle type
        ToggleGroup vehicleGroup = new ToggleGroup();
        RadioButton carRadioButton = new RadioButton("Car");
        carRadioButton.setToggleGroup(vehicleGroup);
        RadioButton bikeRadioButton = new RadioButton("Bike");
        bikeRadioButton.setToggleGroup(vehicleGroup);

        // Text fields for speed and speed limit
        TextField speedField = new TextField();
        TextField speedLimitField = new TextField();

        // Fine display label
        Label fineAmountLabel = new Label("RM0.00");

        // Calculate button
        Button calculateButton = new Button("Calculate Fine");
        calculateButton.setOnAction(event -> {
            try {
                double speed = Double.parseDouble(speedField.getText());
                double speedLimit = Double.parseDouble(speedLimitField.getText());
                double fine = calculateFine(carRadioButton.isSelected(), speed, speedLimit);
                fineAmountLabel.setText(String.format("RM%.2f", fine));
            } catch (NumberFormatException e) {
                fineAmountLabel.setText("Invalid input");
            }
        });

        // Layout setup
        HBox vehicleTypeBox = new HBox(10, carRadioButton, bikeRadioButton);
        vehicleTypeBox.setAlignment(Pos.CENTER_LEFT);

        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);
        inputGrid.setPadding(new Insets(20));

        inputGrid.add(vehicleTypeLabel, 0, 0);
        inputGrid.add(vehicleTypeBox, 1, 0);
        inputGrid.add(speedLabel, 0, 1);
        inputGrid.add(speedField, 1, 1);
        inputGrid.add(speedLimitLabel, 0, 2);
        inputGrid.add(speedLimitField, 1, 2);
        inputGrid.add(fineLabel, 0, 3);
        inputGrid.add(fineAmountLabel, 1, 3);

        VBox layout = new VBox(10, inputGrid, calculateButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        // Set up the scene and stage
        Scene scene = new Scene(layout, 350, 250);
        primaryStage.setTitle("Speeding Fine Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to calculate the fine based on vehicle type, speed, and speed limit
    private double calculateFine(boolean isCar, double speed, double speedLimit) {
        if (isCar) {
            if (speed <= speedLimit) {
                return 0;
            }
            return (speed - speedLimit) * (speed - speedLimit) * 0.5;
        } else {
            if (speed <= speedLimit) {
                return 0;
            }
            return 30 + (speed - speedLimit);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

