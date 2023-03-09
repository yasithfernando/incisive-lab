package com.example.incisivelab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    public void onNextButtonClick(ActionEvent actionEvent) {
        //TODO Validate Form Details and Navigate
        System.out.println("Next Button Click");
    }
}