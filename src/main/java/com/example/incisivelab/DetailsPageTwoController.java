package com.example.incisivelab;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.incisivelab.HelloApplication.stage;

public class DetailsPageTwoController {
    public Button resetBtn;
    public Button nextBtn;
    public Button backBtn;
    public TextField tssfTotalVolumeTxt;
    public TextField tssfFinalConcentrationTxt;
    public TextField tssfEstimatedConcentrationOfTestSampleTxt;
    public Label tssfVolumeOfSampleLabel;
    public Label tssfVolumeOf2XRSOBLabel;
    public TextField rssfTotalVolumeTxt;
    public TextField rssfFinalConcentrationTxt;
    public TextField rssfConcentrationOfRefernceStndardTxt;
    public Label rssfVolumeOfSampleLabel;
    public Label rssfVolumeOf2XRSOBLabel;
    public TextField dilutionTableTestSampleVolumeOfSampleTxt;
    public TextField dilutionTableTestSampleTotalVolumeTxt;
    public TextField dilutionTableReferenceStandardVolumeOfSampleTxt;
    public TextField dilutionTableReferenceStandardTotalVolumeTxt;

    public void initialize() {
        // Initialize the controller
    }

    public void onResetButtonClick(ActionEvent actionEvent) {

    }

    public void onNextButtonClick(ActionEvent actionEvent) throws IOException {
        //TODO Validate Form Details and Navigate
        FXMLLoader fxmlLoader = new FXMLLoader(LaneContentsPageController.class.getResource("lane-contents-page.fxml"));

        //Set the stage with the new scene
        Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
        stage.setTitle("Incisive Lab");
        stage.setScene(scene);
        stage.show();

    }

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DetailsPageOneController.class.getResource("details-page-one.fxml"));

        //Set the stage with the new scene
        Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
        stage.setTitle("Incisive Lab");
        stage.setScene(scene);
        stage.show();

    }
}
