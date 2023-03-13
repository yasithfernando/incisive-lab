package com.example.incisivelab;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;

import static com.example.incisivelab.HelloApplication.stage;

public class ProteinConcentrationPageController {
    public TableView proteinConcentrationTable;
    public Label tsMeanLabel;
    public Label tsSDILabel;
    public Label tsPercentLabel;
    public Label tsStockLabel;
    public Label tsSDIILabel;
    public Label tsOriginalStockLabel;
    public Label tsSDIIILabel;
    public Label tsRSDLabel;

    public void initialize(){
        //Set up the protein concentration table
        initializeProteinConcentrationTable();

        //map normalized to dilution table to protein concentration
        mapNormalisedTableToProteinConcentration();
    }

    private void mapNormalisedTableToProteinConcentration() {
        TableView<MassCorrectionPageController.NormalisedToDilutionData> normalisedData = MassCorrectionPageController.finalNormalisedToDilutionTable;
        //TODO map normalised data table to protein concentration table
    }

    private void initializeProteinConcentrationTable() {
        TableColumn<ProteinConcentrationPageController.ProteinConcentrationData, Double> concentrationColumn = new TableColumn<>("concentration");
        concentrationColumn.setCellValueFactory(new PropertyValueFactory<>("concentration"));
        concentrationColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> tsRepOneColumn = new TableColumn<>("TS REP 1");
        tsRepOneColumn.setCellValueFactory(new PropertyValueFactory<>("tsRepOne"));
        tsRepOneColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> tsRepTwoColumn = new TableColumn<>("TS REP 2");
        tsRepTwoColumn.setCellValueFactory(new PropertyValueFactory<>("tsRepTwo"));
        tsRepTwoColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> tsRepThreeColumn = new TableColumn<>("TS REP 2");
        tsRepThreeColumn.setCellValueFactory(new PropertyValueFactory<>("tsRepThree"));
        tsRepThreeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> rsRepOneColumn = new TableColumn<>("RS REP 1");
        rsRepOneColumn.setCellValueFactory(new PropertyValueFactory<>("rsRepOne"));
        rsRepOneColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }

    public void onResetButtonClick(ActionEvent actionEvent) {

    }

    public void onNextButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MassCorrectionPageController.class.getResource("linearity-page.fxml"));

        //Set the stage with the new scene
        Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
        stage.setTitle("Incisive Lab");
        stage.setScene(scene);
        stage.show();
    }

    public void onBackButtonClick(ActionEvent actionEvent) {

    }

    public static class ProteinConcentrationData {

    }
}
