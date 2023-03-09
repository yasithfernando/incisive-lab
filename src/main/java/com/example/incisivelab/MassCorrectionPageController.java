package com.example.incisivelab;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

public class MassCorrectionPageController {

    public Button resetBtn;
    public Button nextBtn;
    public Button backBtn;
    public TableView<MassCorrectionData> massCorrectionTable;
    public TableView<NormalisedToDilutionData> normalisedToDilutionTable;

    public void initialize(){
        // Set up the mass correction table columns
        initialiseMassCorrectionTable();

        // Set up the normalised to dilution table columns
        initialiseNormalisedToDilutionTableColumn();

        //Calculate Mass Correction
        calculateMassCorrection(RawDataPageController.finalisedRawDataTable);

        //Calculate Normalised To Dilution Data


        // Add some sample data to the table
//        RawDataPageController.RawData sample1 = new RawDataPageController.RawData("TS D3",22033.898, 14276.46, 2803.54, 1470.62);
//        massCorrectionTable.getItems().add(sample1);
    }

    public void calculateMassCorrection(TableView<RawDataPageController.RawData> rawDataTable){
        try {
            for (int i = 0; i < rawDataTable.getItems().size(); i++){
                String sampleName = rawDataTable.getItems().get(i).getSampleName();
                double monomer = rawDataTable.getItems().get(i).getMonomer();
                double dimer = rawDataTable.getItems().get(i).getDimer()/2;
                double trimer = rawDataTable.getItems().get(i).getTrimer()/3;
                double tretramer = rawDataTable.getItems().get(i).getTretramer()/4;
                double totalProtein = monomer + dimer + trimer + tretramer;

                MassCorrectionData dataRow = new MassCorrectionData(sampleName,monomer,dimer,trimer,tretramer);
                massCorrectionTable.getItems().add(dataRow);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void normaliseToDilution(TableView<RawDataPageController.RawData> rawDataTable, double dilutionFactor){
        //TODO Confirm Usage of Dilution Factor
//        try {
//            int counter = 0;
//            for (int i = 0; i < rawDataTable.getItems().size(); i++){
//                if (counter)
//                counter++;
//                String sampleName = rawDataTable.getItems().get(i).getSampleName();
//                double monomer = rawDataTable.getItems().get(i).getMonomer();
//                double dimer = rawDataTable.getItems().get(i).getDimer()/2;
//                double trimer = rawDataTable.getItems().get(i).getTrimer()/3;
//                double tretramer = rawDataTable.getItems().get(i).getTretramer()/4;
//                double totalProtein = monomer + dimer + trimer + tretramer;
//
//                MassCorrectionData dataRow = new MassCorrectionData(sampleName,monomer,dimer,trimer,tretramer);
//                massCorrectionTable.getItems().add(dataRow);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    }

    public void initialiseMassCorrectionTable(){
        TableColumn<MassCorrectionPageController.MassCorrectionData, String> sampleColumn = new TableColumn<>("Sample");
        sampleColumn.setCellValueFactory(new PropertyValueFactory<>("sample"));
        sampleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> monomerColumn = new TableColumn<>("Monomer 14 kDa");
        monomerColumn.setCellValueFactory(new PropertyValueFactory<>("monomer"));
        monomerColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> dimerColumn = new TableColumn<>("Dimer 14 kDa");
        dimerColumn.setCellValueFactory(new PropertyValueFactory<>("dimer"));
        dimerColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> trimerColumn = new TableColumn<>("Trimer 14 kDa");
        trimerColumn.setCellValueFactory(new PropertyValueFactory<>("trimer"));
        trimerColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> tretramerColumn = new TableColumn<>("Tretramer 14 kDa");
        tretramerColumn.setCellValueFactory(new PropertyValueFactory<>("tretramer"));
        tretramerColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> totalProteinColumn = new TableColumn<>("Tretramer 14 kDa");
        totalProteinColumn.setCellValueFactory(new PropertyValueFactory<>("tretramer"));
        totalProteinColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }

    public void initialiseNormalisedToDilutionTableColumn(){
        TableColumn<MassCorrectionPageController.NormalisedToDilutionData, String> sampleColumnNormalised = new TableColumn<>("Sample");
        sampleColumnNormalised.setCellValueFactory(new PropertyValueFactory<>("sample"));
        sampleColumnNormalised.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> monomerColumnNormalised = new TableColumn<>("Monomer 14 kDa");
        monomerColumnNormalised.setCellValueFactory(new PropertyValueFactory<>("monomer"));
        monomerColumnNormalised.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> dimerColumnNormalised = new TableColumn<>("Dimer 14 kDa");
        dimerColumnNormalised.setCellValueFactory(new PropertyValueFactory<>("dimer"));
        dimerColumnNormalised.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> trimerColumnNormalised = new TableColumn<>("Trimer 14 kDa");
        trimerColumnNormalised.setCellValueFactory(new PropertyValueFactory<>("trimer"));
        trimerColumnNormalised.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> tretramerColumnNormalised = new TableColumn<>("Tretramer 14 kDa");
        tretramerColumnNormalised.setCellValueFactory(new PropertyValueFactory<>("tretramer"));
        tretramerColumnNormalised.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<MassCorrectionPageController.MassCorrectionData, Double> totalColumnNormalised = new TableColumn<>("Tretramer 14 kDa");
        totalColumnNormalised.setCellValueFactory(new PropertyValueFactory<>("tretramer"));
        totalColumnNormalised.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }

    public void onResetButtonClick(ActionEvent actionEvent) {
    }

    public void onNextButtonClick(ActionEvent actionEvent) {
    }

    public void onBackButtonClick(ActionEvent actionEvent) {
    }

    public static class MassCorrectionData{
        private String sampleName;
        private double monomer;
        private double dimer;
        private double trimer;
        private double tretramer;
        private double totalProtein;

        public MassCorrectionData(String sampleName, double monomer, double dimer, double trimer, double tretramer) {
            this.sampleName = sampleName;
            this.monomer = monomer;
            this.dimer = dimer;
            this.trimer = trimer;
            this.tretramer = tretramer;
            this.totalProtein = monomer + dimer + trimer + tretramer;
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

        public double getTotalProtein() {
            return totalProtein;
        }

        public void setTotalProtein(double totalProtein) {
            this.totalProtein = totalProtein;
        }
    }

    public static class NormalisedToDilutionData{
        private String sampleName;
        private double monomer;
        private double dimer;
        private double trimer;
        private double tretramer;
        private double total;

        public NormalisedToDilutionData(String sampleName, double monomer, double dimer, double trimer, double tretramer) {
            this.sampleName = sampleName;
            this.monomer = monomer;
            this.dimer = dimer;
            this.trimer = trimer;
            this.tretramer = tretramer;
            this.total = monomer + dimer + trimer + tretramer;
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

        public double getTotal() {
            return total;
        }

        public void setTotalProtein(double total) {
            this.total = total;
        }
    }
}
