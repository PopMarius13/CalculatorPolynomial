package com.utcn.calculatoare.tp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        String label = "Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".";

        stage.setScene(new Scene(parent , 800 , 400));
        stage.setTitle(label);
        stage.show();
    }
    public static void main(String[] args) {
        launch();

    }

}