package com.example.incisivelab;

import javafx.scene.control.TableView;
import javafx.scene.image.Image;

import java.time.LocalDate;
import java.util.Date;

public class GelRun {

    private String title;
    private String batchNumber;
    private String checkpoint;
    private String analyst;
    private String checker;
    private String notes;
    private String bovineBlueDropDown;
    private double tssfEstimatedConcentration;
    private double tssfTotalVolume;
    private double tssfSampleVolume;
    private double tssf2XRSOBVolume;
    private double tssfFinalConcentration;
    private double rssfReferenceStandardConcentration;
    private double rssfTotalVolume;
    private double rssfSampleVolume;
    private double rssf2XRSOBVolume;
    private double rssfFinalConcentration;
    private String gelNumber;
    private LocalDate gelRunDate;
    private TableView<LaneContentsPageController.LaneContent> laneContentTableView;

    private TableView<RawDataPageController.RawData> rawDataTableView;
    private Image gelImage;
    private TableView<MassCorrectionPageController.MassCorrectionData> massCorrectionDataTableView;
    private TableView<MassCorrectionPageController.NormalisedToDilutionData> normalisedToDilutionDataTableView;

    //TODO rest of the tables and data from protein concentration view onwards




}
