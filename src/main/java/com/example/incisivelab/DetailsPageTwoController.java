package com.example.incisivelab;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;

import static com.example.incisivelab.DetailsPageOneController.bovine_or_globin;
import static com.example.incisivelab.HelloApplication.numberofGelRuns_Text;
import static com.example.incisivelab.HelloApplication.stage;

public class DetailsPageTwoController {
    public  TextField dilutionTableTestSampleVolumeOfSampleTxt;
    public  TextField dilutionTableTestSampleTotalVolumeTxt;
    public  TextField dilutionTableReferenceStandardVolumeOfSampleTxt;
    public  TextField dilutionTableReferenceStandardTotalVolumeTxt;
    public TextField numberOfGelRunsTxtnumberOfGelRunsTxt;

    //todo after ui changes take place
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
    JPanel buttonPanel = new JPanel();

    public void tssfCalculations() {

        Double tssfTotalVolume_text = Double.valueOf(tssfTotalVolumeTxt.getText());
        double tssfFinalConcentration_text = Double.parseDouble(tssfFinalConcentrationTxt.getText());
        Double tssfEstimatedConcentrationOfTestSample_text = Double.valueOf(tssfEstimatedConcentrationOfTestSampleTxt.getText());

        double tssfVolumeOfSample_lbl = (tssfTotalVolume_text * tssfEstimatedConcentrationOfTestSample_text) / tssfFinalConcentration_text;
        double tssfVolumeOf2XRSOB_lbl = 1000 - tssfVolumeOfSample_lbl;
        tssfVolumeOfSampleLabel.setText(String.valueOf(tssfVolumeOfSample_lbl));
        tssfVolumeOf2XRSOBLabel.setText(String.valueOf(tssfVolumeOf2XRSOB_lbl));
    }

    public void rssfCalculations() {

        Double rssfTotalVolume_text = Double.valueOf(rssfTotalVolumeTxt.getText());
        double rssfFinalConcentration_text = Double.parseDouble(rssfFinalConcentrationTxt.getText());
        Double rssfConcentrationOfRefernceStndard_text = Double.valueOf(rssfConcentrationOfRefernceStndardTxt.getText());
        double rssfVolumeOfSample_lbl = (rssfTotalVolume_text * rssfFinalConcentration_text) / rssfFinalConcentration_text;
        double rssfVolumeOf2XRSOB_lbl = 1000 - rssfVolumeOfSample_lbl;
        tssfVolumeOfSampleLabel.setText(String.valueOf(rssfVolumeOfSample_lbl));
        tssfVolumeOf2XRSOBLabel.setText(String.valueOf(rssfVolumeOf2XRSOB_lbl));

    }

    public void initialize() {
//        Final Concentration needs to be updated based on Bovine haemoglobin or BlueCheck?
        if (("Bovine Haemoglobin").equals(bovine_or_globin)) {
            tssfFinalConcentrationTxt.setText("4");
            rssfFinalConcentrationTxt.setText("4");
        } else if (("BlueCheck").equals(bovine_or_globin)) {
            tssfFinalConcentrationTxt.setText("8");
            rssfFinalConcentrationTxt.setText("8");
        }
        numberOfGelRunsTxtnumberOfGelRunsTxt.setText(String.valueOf(numberofGelRuns_Text));


    }

    public void onNextButtonClick() throws IOException {
        Double dilutionTableTestSampleVolumeOfSample_text = Double.valueOf(dilutionTableTestSampleVolumeOfSampleTxt.getText());
        Double dilutionTableTestSampleTotalVolume_text = Double.valueOf(dilutionTableTestSampleTotalVolumeTxt.getText());
        Double dilutionTableReferenceStandardVolumeOfSample_text = Double.valueOf(dilutionTableReferenceStandardVolumeOfSampleTxt.getText());
        Double dilutionTableReferenceStandardTotalVolume_text = Double.valueOf(dilutionTableReferenceStandardTotalVolumeTxt.getText());
        numberofGelRuns_Text = Double.valueOf(numberOfGelRunsTxtnumberOfGelRunsTxt.getText());

//        validations
        if (dilutionTableTestSampleVolumeOfSample_text <= 0){
            JOptionPane.showMessageDialog(buttonPanel, "Please enter a valid value for volume of sample in the dilution table ");
        } else if (dilutionTableTestSampleTotalVolume_text <= 0){
            JOptionPane.showMessageDialog(buttonPanel, "Please enter a valid value for total volume of sample in the dilution table ");
        }

        else if (dilutionTableReferenceStandardVolumeOfSample_text <= 0){
            JOptionPane.showMessageDialog(buttonPanel, "Please enter a valid value for sample volume of reference standard in the dilution table ");
        } else if (dilutionTableReferenceStandardTotalVolume_text <= 0){
            JOptionPane.showMessageDialog(buttonPanel, "Please enter a valid value for total volume of reference standard in the dilution table ");
        } else if (numberofGelRuns_Text== null ||numberofGelRuns_Text <= 0) {
            JOptionPane.showMessageDialog(buttonPanel, "Please enter a valid value for gel runs");

        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(LaneContentsPageController.class.getResource("lane-contents-page.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
            stage.setTitle("Incisive Lab");
            stage.setScene(scene);
            stage.show();
        }
    }

    public void tssfFieldsUpdate() {

        if (tssfEstimatedConcentrationOfTestSampleTxt.getText() == null || tssfEstimatedConcentrationOfTestSampleTxt.getText() == "") {
            JOptionPane.showMessageDialog(buttonPanel, "Estimated concentration of Test Sample (mg/mL) cannot be empty ");
        } else if (Integer.valueOf(tssfEstimatedConcentrationOfTestSampleTxt.getText()) <= 0) {
            JOptionPane.showMessageDialog(buttonPanel, "Estimated concentration of Test Sample (mg/mL) cannot be empty ");
        } else if (tssfEstimatedConcentrationOfTestSampleTxt.getText() != null && Integer.valueOf(tssfEstimatedConcentrationOfTestSampleTxt.getText()) > 0) {
            double tssfFinalConcentration_txt = Double.parseDouble(tssfFinalConcentrationTxt.getText());
            double tssfEstimatedConcentrationOfTestSample_txt = Double.parseDouble(tssfEstimatedConcentrationOfTestSampleTxt.getText());
            double output = (1000 * tssfFinalConcentration_txt) / tssfEstimatedConcentrationOfTestSample_txt;
            tssfVolumeOfSampleLabel.setText(String.valueOf(output));
            tssfVolumeOf2XRSOBLabel.setText(String.valueOf(1000 - output));
        }
    }

    public void rssfFieldsUpdate() {
        if (rssfConcentrationOfRefernceStndardTxt.getText() == null || rssfConcentrationOfRefernceStndardTxt.getText() == "") {
            JOptionPane.showMessageDialog(buttonPanel, "Concentration of Reference Standard (mg/mL) cannot be empty ");
        } else if (Integer.valueOf(rssfConcentrationOfRefernceStndardTxt.getText()) <= 0) {
            JOptionPane.showMessageDialog(buttonPanel, "Concentration of Reference Standard (mg/mL) cannot be Negative ");
        } else if (rssfConcentrationOfRefernceStndardTxt.getText() != null && Integer.valueOf(rssfConcentrationOfRefernceStndardTxt.getText()) > 0) {
            double rssfFinalConcentration_txt = Double.parseDouble(rssfFinalConcentrationTxt.getText());
            double rssfEstimatedConcentrationOfTestSample_txt = Double.parseDouble(rssfConcentrationOfRefernceStndardTxt.getText());
            double output = (1000 * rssfFinalConcentration_txt) / rssfEstimatedConcentrationOfTestSample_txt;
            rssfVolumeOfSampleLabel.setText(String.valueOf(output));
            rssfVolumeOf2XRSOBLabel.setText(String.valueOf(1000 - output));
        } else if (rssfConcentrationOfRefernceStndardTxt.getText() == null) {
            JOptionPane.showMessageDialog(buttonPanel, "Concentration of Reference Standard (mg/mL) cannot be empty ");
        } else if (Integer.valueOf(rssfConcentrationOfRefernceStndardTxt.getText()) <= 0) {
            JOptionPane.showMessageDialog(buttonPanel, "Concentration of Reference Standard (mg/mL) cannot be Negative ");
        }
    }


    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DetailsPageOneController.class.getResource("details-page-one.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
        stage.setTitle("Incisive Lab");
        stage.setScene(scene);
        stage.show();

    }

}
