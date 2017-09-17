package sample;

public class Problema {


    public double funcion(double r, double l,double x,double v){
        return   (Math.pow(r,2)*Math.acos((r-x)/r)-(r-x)*Math.sqrt(2*r*x-Math.pow(x,2)))*l-v;
    }

    public double funcionPirma(double r, double l, double x){
        return 2*l*Math.sqrt(x*(2*r-x));
    }

    public String biseccion(double r, double l, double v,double tol){
        double errorAbs=0;
        double a=0.0000001;
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


    public  String NewtonRapson(double x,double r, double l, double v, double tol, int iteraciones){
        double errorRelativo= Double.POSITIVE_INFINITY;
        double xi;
        int i=0;
         while (errorRelativo>tol && i<= iteraciones){
             i++;
             xi=x-funcion(r,l,x,v)/funcionPirma(r,l,x);
             errorRelativo=Math.abs((xi-x)/xi);
             x=xi;
         }
         if ( i>iteraciones ){
             return "No se ha podido calcular la aproximación...";
         }
         else{
             return ("Aproximación: "+x+ " | Cantidad de iteraciones: "+ i);
         }
    }

    public String Secante(double x1,double x2,double r, double l, double v, double tol, int iteraciones){
        double errorRelativo= Double.POSITIVE_INFINITY;
        double xi;
        int i=0;
        while (errorRelativo>tol && i<= iteraciones){
            i++;
            xi=x1-(funcion(r,l,x1,v)*(x1-x2))/(funcion(r,l,x1,v)-funcion(r,l,x2,v));
            errorRelativo=Math.abs((xi-x1)/xi);
            x2=x1;
            x1=xi;
        }
        if ( i>iteraciones ){
            return "No se ha podido calcular la aproximación...";
        }
        else{
            return ("Aproximación: "+x1+ " | Cantidad de iteraciones: "+ i);
        }
    }







}
