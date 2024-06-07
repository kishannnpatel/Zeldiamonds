package universite_paris8.iut.kpatel.zeldiamond;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import universite_paris8.iut.kpatel.zeldiamond.controller.Controller;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("viewZeldiamond.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1800, 1800);
        Pane root = (Pane) scene.getRoot();
        root.requestFocus();
        stage.setTitle("Zeldiamond");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}