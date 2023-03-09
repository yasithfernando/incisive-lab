package com.example.incisivelab;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;

import static com.example.incisivelab.HelloApplication.stage;

public class RawDataPageController {
    public Button addRowButton;
    public Button removeRowButton;
    public TextField sampleNameTxt;
    public Button resetBtn;
    public Button nextBtn;
    public Button backBtn;
    public TableView<RawData> rawDataTable;

    public static TableView<RawData> finalisedRawDataTable;
    public TextField monomerText;
    public TextField dimerText;
    public TextField trimerText;
    public TextField tretramerText;

    public void initialize(){
        // Set up the table columns
        TableColumn<RawDataPageController.RawData, String> sampleColumn = new TableColumn<>("Sample");
        sampleColumn.setCellValueFactory(new PropertyValueFactory<>("sample"));
        sampleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<RawDataPageController.RawData, Double> monomerColumn = new TableColumn<>("Monomer 14 kDa");
        monomerColumn.setCellValueFactory(new PropertyValueFactory<>("monomer"));
        monomerColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<RawDataPageController.RawData, Double> dimerColumn = new TableColumn<>("Dimer 14 kDa");
        dimerColumn.setCellValueFactory(new PropertyValueFactory<>("dimer"));
        dimerColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<RawDataPageController.RawData, Double> trimerColumn = new TableColumn<>("Trimer 14 kDa");
        trimerColumn.setCellValueFactory(new PropertyValueFactory<>("trimer"));
        trimerColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<RawDataPageController.RawData, Double> tretramerColumn = new TableColumn<>("Tretramer 14 kDa");
        tretramerColumn.setCellValueFactory(new PropertyValueFactory<>("tretramer"));
        tretramerColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

//        laneContentsTable.getColumns().addAll(sampleNameCol, dilutionFactorCol, standardCurveConcentrationCol);

        // Add some sample data to the table
        RawDataPageController.RawData sample1 = new RawDataPageController.RawData("TS D3",22033.898, 14276.46, 2803.54, 1470.62);
        rawDataTable.getItems().add(sample1);
    }

    public void addRow(ActionEvent actionEvent) {
        if (sampleNameTxt.getText() != null && monomerText.getText() != null && dimerText.getText() != null && trimerText.getText() != null && tretramerText.getText() != null){
            try {
                rawDataTable.getItems().add(new RawData(
                        sampleNameTxt.getText(),
                        Double.parseDouble(monomerText.getText()),
                        Double.parseDouble(dimerText.getText()),
                        Double.parseDouble(trimerText.getText()),
                        Double.parseDouble(tretramerText.getText())
                ));
                sampleNameTxt.clear();
                monomerText.clear();
                dimerText.clear();
                trimerText.clear();
                tretramerText.clear();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void removeRow(ActionEvent actionEvent) {
        // Remove the selected row from the table
        int selectedIndex = rawDataTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            rawDataTable.getItems().remove(selectedIndex);
        }
    }

    public void onResetButtonClick(ActionEvent actionEvent) {
    }

    public void onNextButtonClick(ActionEvent actionEvent) throws IOException {
        finalisedRawDataTable = rawDataTable;
        FXMLLoader fxmlLoader = new FXMLLoader(MassCorrectionPageController.class.getResource("mass-correction-page.fxml"));

        //Set the stage with the new scene
        Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
        stage.setTitle("Incisive Lab");
        stage.setScene(scene);
        stage.show();
    }

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LaneIndicatorPageController.class.getResource("lane-indicator-page.fxml"));

        //Set the stage with the new scene
        Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
        stage.setTitle("Incisive Lab");
        stage.setScene(scene);
        stage.show();
    }


    public static class RawData{
        private String sampleName;
        private double monomer;
        private double dimer;
        private double trimer;
        private double tretramer;

        public RawData(String sampleName, double monomer, double dimer, double trimer, double tretramer) {
            this.sampleName = sampleName;
            this.monomer = monomer;
            this.dimer = dimer;
            this.trimer = trimer;
            this.tretramer = tretramer;
        }

        public String getSampleName() {
            return sampleName;
        }

        public void setSampleName(String sampleName) {
            this.sampleName = sampleName;
        }

        public double getMonomer() {
            return monomer;
        }

        public void setMonomer(double monomer) {
            this.monomer = monomer;
        }

        public double getDimer() {
            return dimer;
        }

        public void setDimer(double dimer) {
            this.dimer = dimer;
        }

        public double getTrimer() {
            return trimer;
        }

        public void setTrimer(double trimer) {
            this.trimer = trimer;
        }

        public double getTretramer() {
            return tretramer;
        }

        public void setTretramer(double tretramer) {
            this.tretramer = tretramer;
        }
    }
}
