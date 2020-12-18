package at.ac.fhcampuswien;

import com.sun.javafx.scene.text.TextLayout;
import javafx.application.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Black Jack");

        Parent root = FXMLLoader.load(this.getClass().getResource("/Table.fxml"));
        Scene scene = new Scene(root, 1600, 900);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();





    }
}
