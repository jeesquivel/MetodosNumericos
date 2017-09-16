package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    Problema Problema=new Problema();



    double volumen=0;
    double radio=0;
    double longitud=0;
    double tolerancia=0;

    @FXML
    Button boton;
    @FXML
    Label mensaje;

    @FXML
    TextField EntryVolumen;
    @FXML
    TextField EntryLongitud;
    @FXML
    TextField EntryRadio;
    @FXML
    TextField EntryTolerancia;

    @FXML
    ImageView vistaImagen;

    @FXML
    Image image;



    public boolean parsear(){

        try {
            tolerancia=Double.parseDouble(EntryTolerancia.getText());
            radio=Double.parseDouble(EntryRadio.getText());
            longitud=Double.parseDouble(EntryLongitud.getText());
            volumen=Double.parseDouble(EntryVolumen.getText());

            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    public void CalcularBiseccion(){
        if ( parsear() ){
            mensaje.setText(Problema.biseccion(radio,longitud,volumen,tolerancia));
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        image= new Image("chino.png");
        vistaImagen.setImage(image);
    }


}
