package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    Button boton;

    @FXML
    Label cromo;


    public void saludar(){

        cromo.setText("hola ema");



    }



}
