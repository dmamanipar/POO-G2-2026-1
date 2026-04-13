package pe.edu.upeu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main( String[] args ) {
      launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loand=new FXMLLoader(getClass()
                .getResource("/view/maingui.fxml"));
        Scene scene=new Scene(loand.load(), 400, 600);
        stage.setScene(scene);
        stage.show();
    }
}
