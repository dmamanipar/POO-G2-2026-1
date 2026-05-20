package pe.edu.upeu.sysventas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pe.edu.upeu.sysventas.config.AppContext;
import pe.edu.upeu.sysventas.config.DatabaseConfig;

public class SysVentasApplication extends Application {

    Parent parent;

    @Override
    public void init() throws Exception {
        DatabaseConfig.init(); //Iniciar la DB
        AppContext context = AppContext.getInstance();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
        loader.setControllerFactory(context::getBean);
        parent = loader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(parent);
        stage.setTitle("Sistema de Ventas");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        DatabaseConfig.shutdown();
        super.stop();
    }
}
