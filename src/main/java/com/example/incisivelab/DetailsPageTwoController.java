package com.example.incisivelab;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize() {
        // Initialize the controller
    }

    public void onResetButtonClick(ActionEvent actionEvent) {

    }

    public void onNextButtonClick(ActionEvent actionEvent) {

    }

    public void onBackButtonClick(ActionEvent actionEvent) {

    }
}
