package com.example.incisivelab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.security.Key;

import static com.example.incisivelab.HelloApplication.stage;

public class DetailsPageOneController {
    String title_text;
    String batch_number_text;
    String checkPoint_text;
    String analyst_text;
    String checked_text;
    String notes_text;
    static String bovine_or_globin;




    public TextField txtTitle;
    public TextField batchNumberText;
    public TextField checkpointTxt;
    public TextField analystTxt;
    public TextField checkerTxt;
    public TextArea notesTxt;
    public ComboBox bovineBlueCombo;
    public Button resetBtn;
    public Button nextBtn;

//    todo rename
    JPanel buttonPanel = new JPanel();
    @FXML
    public void onResetButtonClick(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(buttonPanel,"All Inputs Have been reset");

        txtTitle.setText("");
        batchNumberText.setText("");
        checkpointTxt.setText("");
        analystTxt.setText("");
        checkpointTxt.setText("");
        notesTxt.setText("");
        bovineBlueCombo.setValue("");

    }
    @FXML
    public void onNextButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println(bovineBlueCombo.getValue());
        //TODO Validate Form Details and Navigate
        System.out.println("Next Button Click");
        FXMLLoader fxmlLoader = new FXMLLoader(DetailsPageTwoController.class.getResource("details-page-two.fxml"));

//        input validation
        title_text = txtTitle.getText() ;
        batch_number_text = batchNumberText.getText();
        checkPoint_text = checkpointTxt.getText();
        analyst_text = analystTxt.getText();
        checked_text = checkpointTxt.getText();
        notes_text = notesTxt.getText();
        bovine_or_globin = (String) bovineBlueCombo.getValue();

        System.out.println(bovine_or_globin);
        if (!inputValidater(title_text , "[a-zA-Z ]+")){
            JOptionPane.showMessageDialog(buttonPanel,"Invalid input for Title Text \n" + title_text);
        } else if (!inputValidater(batch_number_text , "[a-zA-Z0-9 ]+")) {
            JOptionPane.showMessageDialog(buttonPanel,"Invalid input for Batch Number \n" + batch_number_text);
        } else if (!inputValidater(checkPoint_text , "[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(buttonPanel, "Invalid input for checkpoint text \n" + checkPoint_text);
        } else if (!inputValidater(analyst_text , "[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(buttonPanel,"Invalid input for analyst text \n" + analyst_text);
        } else if (!inputValidater(checked_text , "[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(buttonPanel,"Invalid input for checked text \n" + checked_text);
        }else if (!inputValidater(notes_text , "[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(buttonPanel,"Invalid input for notes text \n" + title_text);
        } else if (bovine_or_globin == null) {
            JOptionPane.showMessageDialog(buttonPanel, "Select option for bovine or globin");
        }else {
            //Set the stage with the new scene
            Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
            stage.setTitle("Incisive Lab");
            stage.setScene(scene);
            stage.show();
        }


    }
    public boolean inputValidater(String text,String regex) {
        if (text.matches(regex)) {
            return true;
        }
        return false;
    }
}