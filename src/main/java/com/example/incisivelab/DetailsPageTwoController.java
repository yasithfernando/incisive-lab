package com.example.incisivelab;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.incisivelab.DetailsPageOneController.bovine_or_globin;
import static com.example.incisivelab.HelloApplication.stage;


public class DetailsPageTwoController {


//    fxml componenets
    public Button resetBtn;
    public Button nextBtn;
    public Button backBtn;

    //    tssf
    public TextField tssfTotalVolumeTxt;
    public TextField tssfFinalConcentrationTxt;
    public TextField tssfEstimatedConcentrationOfTestSampleTxt;
    public  Label tssfVolumeOfSampleLabel;
    public  Label tssfVolumeOf2XRSOBLabel;

//    rssf
    public TextField rssfTotalVolumeTxt;
    public TextField rssfFinalConcentrationTxt;
    public TextField rssfConcentrationOfRefernceStndardTxt;
    public Label rssfVolumeOfSampleLabel;
    public Label rssfVolumeOf2XRSOBLabel;
    public static TextField dilutionTableTestSampleVolumeOfSampleTxt;
    public static TextField dilutionTableTestSampleTotalVolumeTxt;
    public static TextField dilutionTableReferenceStandardVolumeOfSampleTxt;
    public static TextField dilutionTableReferenceStandardTotalVolumeTxt;

//getting values
//    static String dilutionTableTestSampleVolumeOfSample_txt = dilutionTableTestSampleVolumeOfSampleTxt.getText();
//    static String dilutionTableTestSampleTotalVolume_txt = dilutionTableTestSampleTotalVolumeTxt.getText();
//    static String dilutionTableReferenceStandardVolumeOfSample_txt = dilutionTableReferenceStandardVolumeOfSampleTxt.getText();
//    static String dilutionTableReferenceStandardTotalVolume_txt = dilutionTableReferenceStandardTotalVolumeTxt.getText();

    public void tssfCalculations() {
//        getting text
//    test sample

        Double tssfTotalVolume_text = Double.valueOf(tssfTotalVolumeTxt.getText());
        Double tssfFinalConcentration_text = Double.valueOf(tssfFinalConcentrationTxt.getText());
        Double tssfEstimatedConcentrationOfTestSample_text = Double.valueOf(tssfEstimatedConcentrationOfTestSampleTxt.getText());


//        tssflabels
        double tssfVolumeOfSample_lbl =  (tssfTotalVolume_text*tssfEstimatedConcentrationOfTestSample_text)/tssfFinalConcentration_text;
        double tssfVolumeOf2XRSOB_lbl =  1000 -tssfVolumeOfSample_lbl;
        //todo set lables to have these values
        tssfVolumeOfSampleLabel.setText(String.valueOf(tssfVolumeOfSample_lbl));
        tssfVolumeOf2XRSOBLabel.setText(String.valueOf(tssfVolumeOf2XRSOB_lbl));

    }

    public void rssfCalculations() {

        Double rssfTotalVolume_text = Double.valueOf(rssfTotalVolumeTxt.getText());
        Double rssfFinalConcentration_text = Double.valueOf(rssfFinalConcentrationTxt.getText());
        Double rssfConcentrationOfRefernceStndard_text = Double.valueOf(rssfConcentrationOfRefernceStndardTxt.getText());

//        getting text


//        tssflabels
        double rssfVolumeOfSample_lbl =  (rssfTotalVolume_text*rssfFinalConcentration_text)/rssfFinalConcentration_text;
        double rssfVolumeOf2XRSOB_lbl =  1000 -rssfVolumeOfSample_lbl;
        //todo set lables to have these values
        tssfVolumeOfSampleLabel.setText(String.valueOf(rssfVolumeOfSample_lbl));
        tssfVolumeOf2XRSOBLabel.setText(String.valueOf(rssfVolumeOf2XRSOB_lbl));

    }

    public void dialutionTable(){
        //    dialution Table
        Double dilutionTableTestSampleVolumeOfSample_text = Double.valueOf(dilutionTableTestSampleVolumeOfSampleTxt.getText());
        Double dilutionTableTestSampleTotalVolume_text = Double.valueOf(dilutionTableTestSampleTotalVolumeTxt.getText());
        Double dilutionTableReferenceStandardVolumeOfSample_text = Double.valueOf(dilutionTableReferenceStandardVolumeOfSampleTxt.getText());
        Double dilutionTableReferenceStandardTotalVolume_text = Double.valueOf(dilutionTableReferenceStandardTotalVolumeTxt.getText());


    }


    //    reference standard



    public void initialize() {
//        Final Concentration needs to be updated based on Bovine haemoglobin or BlueCheck?
        if (("Bovine Haemoglobin").equals(bovine_or_globin))
        {
            tssfFinalConcentrationTxt.setText("4");
            rssfFinalConcentrationTxt.setText("4");
        } else if (("BlueCheck").equals(bovine_or_globin))
        {
            tssfFinalConcentrationTxt.setText("8");
            rssfFinalConcentrationTxt.setText("8");
        }
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

//    update tssf fields
    public void tssfFieldsUpdate(){
        if (tssfEstimatedConcentrationOfTestSampleTxt.getText() != null){
            double tssfFinalConcentration_txt = Double.parseDouble(tssfFinalConcentrationTxt.getText());
            double  tssfEstimatedConcentrationOfTestSample_txt = Double.parseDouble(tssfEstimatedConcentrationOfTestSampleTxt.getText());
            double output = (1000 * tssfFinalConcentration_txt) / tssfEstimatedConcentrationOfTestSample_txt;

            tssfVolumeOfSampleLabel.setText(String.valueOf(output));
            tssfVolumeOf2XRSOBLabel.setText(String.valueOf(1000-output));
        }
    }

//    update rssf fields
public void rssfFieldsUpdate(){
    if (rssfConcentrationOfRefernceStndardTxt.getText() != null){
        double rssfFinalConcentration_txt = Double.parseDouble(rssfFinalConcentrationTxt.getText());
        double  rssfEstimatedConcentrationOfTestSample_txt = Double.parseDouble(rssfConcentrationOfRefernceStndardTxt.getText());
        double output = (1000 * rssfFinalConcentration_txt) / rssfEstimatedConcentrationOfTestSample_txt;

        rssfVolumeOfSampleLabel.setText(String.valueOf(output));
        rssfVolumeOf2XRSOBLabel.setText(String.valueOf(1000-output));
    }
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
