package sample;

public class Problema {


    public double funcion(double r, double l,double x,double v){
        return  (Math.pow(r,2)*Math.acos((r-x)/r)-(r-x)*Math.sqrt(2*r*x-Math.pow(x,2)))*l-v;
    }


    public String biseccion(double r, double l, double v,double tol){
        double errorAbs=0;
        double a=0;
        double b=2*r;
        double x;
        int iteraciones=0;
        if (funcion(r,l,a,v)*funcion(r,l,b,v)<0){
            do {
                x=(a+b)/2;
                errorAbs=(b-a)/2;
                boolean test= funcion(r,l,a,v)*funcion(r,l,x,v)<0;
                if (test) b=x;
                else{
                    if (!test) a=x;
                    else  errorAbs=0;
                }
                iteraciones++;
            }while (errorAbs>tol);
            return ("Aproximación: "+x+ " | Cantidad de iteraciones: "+ iteraciones);
        }
        else return ("No se garantiza la existencia de soluciones :(");
    }

}
