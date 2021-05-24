package metodosNumericos;

import java.util.ArrayList;
import java.util.Scanner;

public class taller20 {

    public static void main(String[] args) {

        System.out.println("1:MinimosCuadrados \n 2: Regresiones lineales  \n 3:Razón de crecimiento regresiones lineal"
                + "  \n 4: Razón potencia");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        ArrayList<Integer> XY = new ArrayList<Integer>();
        ArrayList<Integer> X2 = new ArrayList<Integer>();

        double[] x = {0.5, 0.8, 1.3, 1.8, 3, 5};
        double[] y = {0.1, 0.2, 0.5, 1, 3, 8.8};
        switch (opcion) {
            case 1:
                double sumatoriaX = 0;
                double sumatoriaY = 0;
                double sumatoriaXY = 0;
                double sumatoriaX2 = 0;
                for (int i = 0; i < x.length; i++) {
                    sumatoriaX += x[i];
                    sumatoriaY += y[i];
                    sumatoriaXY += x[i] * y[i];
                    sumatoriaX2 += Math.pow(x[i], 2);
                }
                double promedioX = sumatoriaX / x.length;
                double promedioy = sumatoriaY / y.length;

                double A1 = ((x.length * sumatoriaXY) - (sumatoriaX * sumatoriaY)) / ((x.length * sumatoriaX2) - Math.pow(sumatoriaX, 2));

                double A0 = promedioy - (A1 * promedioX);

                System.out.println("MinimosCuadrados ");
                System.out.println("y = " + A0 + " + " + A1 + "x");

                break;

            case 2:
                sumatoriaX = 0;
                sumatoriaY = 0;
                sumatoriaXY = 0;
                sumatoriaX2 = 0;
                for (int i = 0; i < x.length; i++) {
                    sumatoriaX += x[i];
                    sumatoriaY += Math.log(y[i]);
                    sumatoriaXY += x[i] * Math.log(y[i]);
                    sumatoriaX2 += Math.pow(x[i], 2);
                }
                promedioX = sumatoriaX / x.length;
                promedioy = sumatoriaY / y.length;

                A1 = ((x.length * sumatoriaXY) - (sumatoriaX * sumatoriaY)) / ((x.length * sumatoriaX2) - Math.pow(sumatoriaX, 2));

                A0 = promedioy - (A1 * promedioX);

                double alfa = Math.exp(A0);
                //beta es igual A1

                System.out.println("Regresiones lineales ");
                System.out.println("y = " + alfa + "e^" + A1 + "x");

                break;

            case 3:

                sumatoriaX = 0;
                sumatoriaY = 0;
                sumatoriaXY = 0;
                sumatoriaX2 = 0;
                for (int i = 0; i < x.length; i++) {
                    sumatoriaX += 1/x[i];
                    sumatoriaY += 1/y[i];
                    sumatoriaXY += (1 / x[i]) * (1 / y[i]);
                    sumatoriaX2 += Math.pow(1 / x[i], 2);
                }
                promedioX = sumatoriaX / x.length;
                promedioy = sumatoriaY / y.length;

                A1 = ((x.length * sumatoriaXY) - (sumatoriaX * sumatoriaY)) / ((x.length * sumatoriaX2) - Math.pow(sumatoriaX, 2));

                A0 = promedioy - (A1 * promedioX);

                alfa = (1 / A0);
                //beta 
                double beta = A1 / A0;

                System.out.println("Razón de crecimiento regresiones lineal ");
                System.out.println("y = " + alfa + "*" + "( x/(" + beta + " + x))");

                break;
            case 4:
                
              sumatoriaX = 0;
                sumatoriaY = 0;
                sumatoriaXY = 0;
                sumatoriaX2 = 0;
                for (int i = 0; i < x.length; i++) {
                    sumatoriaX += Math.log10(x[i]);
                    sumatoriaY += Math.log10(y[i]);
                    sumatoriaXY +=  Math.log10(x[i]) * Math.log10(y[i]);
                    sumatoriaX2 += Math.pow( Math.log10(x[i]), 2);
                }
                promedioX = sumatoriaX / x.length;
                promedioy = sumatoriaY / y.length;

                A1 = ((x.length * sumatoriaXY) - (sumatoriaX * sumatoriaY)) / ((x.length * sumatoriaX2) - Math.pow(sumatoriaX, 2));

                A0 = promedioy - (A1 * promedioX);

                alfa = Math.pow(10,A0);
                //beta 
                 beta = A1 ;

                System.out.println("Razón de potencia regresiones lineal ");
               System.out.println("y = " + alfa + "*" + "( x/(" + beta + " + x))");

                
                
                
                break;

        }

    }

}