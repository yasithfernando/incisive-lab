module com.example.incisivelab {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires commons.math3;
    //requires org.apache.pdfbox;

    opens com.example.incisivelab to javafx.fxml;
    exports com.example.incisivelab;
}