package TalleresMC;

import java.util.Scanner;

public class Taller19 {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        
         ///Valores de x Y y con sus respectivas variables para los calculos 
        double[] x = {1, 3, 5, 7, 9, 11, 13};
        double[] y = {0.3, 0.7, 1.7, 3.5, 5.5, 27.5, 38.5};
        double sumax=0,sumay=0,promediox=0,promedioy=0,multi=1,sumaxy=0,xx,sumax2=0,a1,a0;
        double aux = 0, desve,val,aux2,errore,coere,aux3=0,val1=0,aux4,r2;
        
        System.out.println("------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("REGRESION LINEAL");
        	for (int i = 0; i < x.length; i++) {
        		sumax += x[i];
        		promediox = sumax/ x.length;
            }

             for (int i = 0; i < y.length; i++) {
            	 sumay += y[i];
                 promedioy = sumay/y.length;
             }
             
             for (int i = 0; i < x.length; i++) {
                  multi = x[i]*y[i];
                  sumaxy += multi;
             }
             
             for (int i = 0; i < x.length; i++) {
                   xx =  Math.pow(x[i], 2);
                   sumax2+=xx;
             }
             
             for (int i = 0; i < y.length; i++) {
            	 	val = y[i] - promedioy;
            	 	aux = aux+val;
            	 	val = 0;
             }
             
      a1 = (x.length * sumaxy - sumax * sumay) / (x.length * sumaxy - Math.pow(sumax,2));
      a0 = (promedioy - a1 * promediox);
             
             for (int i = 0; i < y.length; i++) {
         	 	val1 = ((y[i] - a0) - (a1*x[i]));
         	 	aux3 = aux3+val1;
         	 	val1 = 0;
             }
      
      aux2 = aux * aux;
      desve = Math.sqrt(aux2/6);
      aux4 = aux3 * aux3;
      errore = Math.sqrt(aux4/5);
      r2 = (Math.sqrt(aux-aux3/aux))*100;
      coere = Math.sqrt(r2);
      
      System.out.println("La respuesta es Y = " + a0 + " + " + a1 + "x");
      System.out.println(" ");
      System.out.println("------------------------------------------------------------------");
      System.out.println("Desviación Estándar: " + desve);
      System.out.println("Error Estándar:  " + errore);
      System.out.println("Coeficiente de Correlación:  " + coere);
    }  
}  
  