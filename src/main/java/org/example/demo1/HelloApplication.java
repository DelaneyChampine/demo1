package org.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        Scene scene = new Scene(root,320, 240);
        Label label = new Label("Hello");
        root.getChildren().add(label);
        Button button = new Button("Click me!");
        root.getChildren().add(button);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        Timer timer = new Timer();
        Thread thread = new Thread(() -> {
            while (true) {
                label.setText(String.valueOf(timer.getTime()));
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }

    public static void main(String[] args) {
        launch();
    }
}