package pe.edu.upeu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label lbn1=new Label("Numero 1");
        Label lbn2=new Label("Numero 2");
        TextField txtNum1=new TextField();
        TextField txtNum2=new TextField();
        Button btnSuma=new Button("Suma");
        Button btnResta=new Button("Resta");
        Label result=new Label("Resultado:");
        Label valorResult=new Label("0");
        btnSuma.setOnAction(e->{
            double resul=Double.parseDouble(txtNum1.getText())+Double.parseDouble(txtNum2.getText());
            valorResult.setText(String.valueOf(resul));
        });
        btnResta.setOnAction(e->{
            double resul=Double.parseDouble(txtNum1.getText())-Double.parseDouble(txtNum2.getText());
            valorResult.setText(String.valueOf(resul));
        });
        GridPane grid=new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15));
        grid.add(lbn1,0,0);
        Scene scene=new Scene(grid, 480,680);
        stage.setScene(scene);
        stage.show();
    }
}
