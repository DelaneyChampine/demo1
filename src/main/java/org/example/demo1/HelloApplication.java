package org.example.demo1;

import javafx.application.Application;
import javafx.application.Platform;
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
        timer.addObserver(
                (tmr) -> Platform.runLater(() -> label.setText(String.valueOf(tmr.getTime())))
                         );
    }

    public static void main(String[] args) {
        launch();
    }
}