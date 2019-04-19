package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  public static  DB_Connection connection = new DB_Connection();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        connection.checklogin("Mido","Mdo");
        connection.newprofile("99","Emir","Male","Data","emko","HAram","emir");

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
