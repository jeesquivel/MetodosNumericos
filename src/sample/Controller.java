package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.lang.String;


import java.awt.*;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    Problema Problema=new Problema();



    double volumen=0;
    double radio=0;
    double longitud=0;
    double tolerancia=0;

    @FXML
    CheckBox piCheck;



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
    @FXML
    Pane Panel;
    @FXML
    Label errorMensaje;
    @FXML
    TextField EntryInicial;
    @FXML
    TextField EntryFinal;
    @FXML
    ChoiceBox opciones;






    public  void onEntryTextmensajeHnadle(InputMethodEvent event){
       int texto= event.getCaretPosition();
       TextField entrada= (TextField) Panel.getChildren().get(texto);
       try {
           double x=Double.parseDouble(String.valueOf(entrada));
           errorMensaje.setText("");
       }catch (Exception e){
           errorMensaje.setText(e.getMessage());

       }


    }


    public void OnMouseClickedOpciones(){
        int  index = (int) opciones.getSelectionModel().getSelectedIndex();
        switch (index) {
            case 0:
                System.out.print(0);
        }

    }





    public boolean parsear(){
        errorMensaje.setText("Mensaje:");
        mensaje.setText("Resultado:");

        try {
            tolerancia=Double.parseDouble(EntryTolerancia.getText());
            radio=Double.parseDouble(EntryRadio.getText());
            longitud=Double.parseDouble(EntryLongitud.getText());
            volumen=Double.parseDouble(EntryVolumen.getText());

            if ( piCheck.isSelected() ){
                volumen=volumen*Math.PI;
            }

            if ( radio<=0 | longitud<=0 | volumen <=0 ){
                errorMensaje.setText("Mensaje: No se admiten valores negativos...");
                errorMensaje.setTextFill(Color.RED);
                return false;
            }

            if ( tolerancia==0 | tolerancia<0.00000000000001 ){
                errorMensaje.setText("Mensaje: Revisar valor de tolerancia...");
                errorMensaje.setTextFill(Color.RED);
                return false;
            }

            if ( volumen<= Math.pow(radio,2)*Math.PI*longitud){
                errorMensaje.setText("Mensaje: OK");
                errorMensaje.setTextFill(Color.GREEN);
                return true;
            }
            else{
                errorMensaje.setText("Mensaje: El volumen sobrepasa la capacidad del tanque...");
                errorMensaje.setTextFill(Color.RED);
            }
            return false;

        }catch (Exception e){
            errorMensaje.setText("Mensaje: Valores de entradas incorrectos...");
            errorMensaje.setTextFill(Color.RED);
            return false;
        }

    }



    public void  calcular(){
        int  index = (int) opciones.getSelectionModel().getSelectedIndex();
        switch (index){
            case 0:
                CalcularBiseccion();
                break;
            case 1:
                CalcularNewton();
                break;
            case 2:
                CalcularSecante();

        }

    }




    @FXML
    public void CalcularBiseccion(){
        if (parsear()){
            System.out.println(volumen);
            mensaje.setText(Problema.biseccion(radio,longitud,volumen,tolerancia));
        }
    }


    public void CalcularNewton(){
        if ( parsear() ){
            try {
                double inicial= Double.parseDouble(EntryInicial.getText());
                    mensaje.setText(Problema.NewtonRapson(inicial,radio,longitud,volumen,tolerancia,100));
            }catch (Exception e){
                errorMensaje.setText("Mensaje: Revisar valor Iinical...");
                errorMensaje.setTextFill(Color.RED);
            }

            }

    }

    public void CalcularSecante(){
        if ( parsear() ){
            try {
                double x1= Double.parseDouble(EntryInicial.getText());
                double x2= Double.parseDouble(EntryFinal.getText());


                if ( x1==x2 ){
                    errorMensaje.setText("Mensaje: Revisar valores iniciales...");
                    errorMensaje.setTextFill(Color.RED);
                }
                else
                    mensaje.setText(Problema.Secante(x1,x2,radio,longitud,volumen,tolerancia,100));
            }catch (Exception e){
                errorMensaje.setText("Mensaje: Revisar valores iniciales...");
                errorMensaje.setTextFill(Color.RED);
            }
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        image= new Image("chino.png");
        vistaImagen.setImage(image);

    }



}
