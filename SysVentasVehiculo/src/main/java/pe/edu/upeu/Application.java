package pe.edu.upeu;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        //Micronaut.run(Application.class, args);
        JavaFxApp.launch(JavaFxApp.class, args);
    }
}