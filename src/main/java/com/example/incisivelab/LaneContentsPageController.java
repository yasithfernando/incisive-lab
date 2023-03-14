package com.example.incisivelab;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;

import static com.example.incisivelab.HelloApplication.stage;

public class LaneContentsPageController {

    public Button resetBtn;
    public Button nextBtn;
    public Button backBtn;
    public Button addRowButton;
    public Button removeRowButton;
    public TextField sampleNameTxt;
    public TextField concentrationText;
    public TextField dilutionLevelText;

    public TextField gelLetterText;
    public DatePicker dateGelRun;
    @FXML
    private TableView<LaneContent> laneContentsTable;
    JPanel buttonPanel = new JPanel();

    //Creating Gel Run Object
    public static GelRun gelRun;


    public void initialize() {
        //Create Gel Run Object
        gelRun = new GelRun();

        // Set up the table columns
        TableColumn<LaneContent, Integer> laneColumn = new TableColumn<>("Lane");
        laneColumn.setCellValueFactory(new PropertyValueFactory<>("lane"));
        laneColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<LaneContent, Integer> sampleNameColumn = new TableColumn<>("Sample Name");
        sampleNameColumn.setCellValueFactory(new PropertyValueFactory<>("sampleName"));
        sampleNameColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<LaneContent, Double> concentrationColumn = new TableColumn<>("Concentration");
        concentrationColumn.setCellValueFactory(new PropertyValueFactory<>("concentration"));
        concentrationColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<LaneContent, Double> dilutionLevelColumn = new TableColumn<>("Dilution Level");
        dilutionLevelColumn.setCellValueFactory(new PropertyValueFactory<>("dilutionLevel"));
        dilutionLevelColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }

    @FXML
    public void addRow() {
        if (sampleNameTxt.getText() != null && concentrationText.getText() != null && dilutionLevelText.getText() != null){
            //todo check for number
//            if (concentrationText.getText())
            try {
                laneContentsTable.getItems().add(new LaneContent(
                        laneContentsTable.getItems().size() + 1,
                        sampleNameTxt.getText(),
                        Double.parseDouble(concentrationText.getText()),
                        Double.parseDouble(dilutionLevelText.getText())
                ));
                sampleNameTxt.clear();
                concentrationText.clear();
                dilutionLevelText.clear();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }else {
            JOptionPane.showMessageDialog(buttonPanel, "Fill All Fields in order to add a row");

        }

    }

    @FXML
    public void removeRow() {
        // Remove the selected row from the table
        int selectedIndex = laneContentsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            laneContentsTable.getItems().remove(selectedIndex);
        }
        else {
            JOptionPane.showMessageDialog(buttonPanel, "There are no rows left to remove");

        }
    }

    public void onResetButtonClick(ActionEvent actionEvent) {

    }

    public void onNextButtonClick(ActionEvent actionEvent) throws IOException {
        if (gelLetterText.getText() == null || gelLetterText.getText() == ""){
            JOptionPane.showMessageDialog(buttonPanel, "Please enter a Gel letter or number");
        }
        else if (dateGelRun.getValue() == null) {
            JOptionPane.showMessageDialog(buttonPanel, "Please select the date of the gelrun");
        }
        else {
            //TODO Add the Gel Run object to the details object gel run array
            //Details.gelRunArrayList.add(gelRun);

            //Setting this screen's lane content data into gel run object
            gelRun.setGelNumber(gelLetterText.getText());
            gelRun.setGelRunDate(dateGelRun.getValue());
            gelRun.setLaneContentTableView(laneContentsTable);

            FXMLLoader fxmlLoader = new FXMLLoader(LaneIndicatorPageController.class.getResource("lane-indicator-page.fxml"));

            //Set the stage with the new scene
            Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
            stage.setTitle("Incisive Lab");
            stage.setScene(scene);
            stage.show();
        }
    }

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DetailsPageTwoController.class.getResource("details-page-two.fxml"));

        //Set the stage with the new scene
        Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
        stage.setTitle("Incisive Lab");
        stage.setScene(scene);
        stage.show();
    }

    // The LaneContent class represents a single row in the table
    public static class LaneContent {
        private int lane;
        private String sampleName;
        private double dilutionLevel;
        private double concentration;

        public LaneContent(int lane, String sampleName,double concentration, double dilutionLevel) {
            this.lane = lane;
            this.sampleName = sampleName;
            this.concentration = concentration;
            this.dilutionLevel = dilutionLevel;
        }

        public int getLane() {
            return lane;
        }

        public String getSampleName() {
            return sampleName;
        }

        public void setSampleName(String sampleName) {
            this.sampleName = sampleName;
        }

        public double getDilutionLevel() {
            return dilutionLevel;
        }

        public void setDilutionLevel(double dilutionLevel) {
            this.dilutionLevel = dilutionLevel;
        }

        public double getConcentration() {
            return concentration;
        }

        public void setConcentration(double concentration) {
            this.concentration = concentration;
        }
    }
}

