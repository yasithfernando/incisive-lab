package com.example.incisivelab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.incisivelab.HelloApplication.stage;

public class DetailsPageOneController {
    public TextField txtTitle;
    public TextField batchNumberText;
    public TextField checkpointTxt;
    public TextField analystTxt;
    public TextField checkerTxt;
    public TextArea notesTxt;
    public ComboBox bovineBlueCombo;
    public Button resetBtn;
    public Button nextBtn;
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
    @FXML
    public void onResetButtonClick(ActionEvent actionEvent) {
        //TODO Implement Reset Functionality
        System.out.println("Reset Button Clicked!");
    }
    @FXML
    public void onNextButtonClick(ActionEvent actionEvent) throws IOException {
        //TODO Validate Form Details and Navigate
        System.out.println("Next Button Click");
        FXMLLoader fxmlLoader = new FXMLLoader(DetailsPageTwoController.class.getResource("details-page-two.fxml"));

        //Set the stage with the new scene
        Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
        stage.setTitle("Incisive Lab");
        stage.setScene(scene);
        stage.show();
    }
}