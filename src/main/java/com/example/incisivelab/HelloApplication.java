package com.example.incisivelab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Stage stage;

    public static int numberOfGelRuns;


    @Override
    public void start(Stage stage) throws IOException {
        HelloApplication.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("details-page-one.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1178, 700);
        stage.setTitle("Incisive Lab");
        stage.setScene(scene);
        stage.show();
        System.out.println("At Hello Application End");

    }

    public static void main(String[] args) {
        launch();
    }
}

//math operations
