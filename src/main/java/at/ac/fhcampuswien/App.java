package at.ac.fhcampuswien;

import javafx.application.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.*;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = null;
        try {
            root = FXMLLoader.load(this.getClass().getResource("/Table.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        primaryStage.setTitle("Black Jack");

        Scene scene = new Scene(root, 1600, 900);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
