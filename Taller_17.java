package TalleresMC;

import java.util.Scanner;

public class Taller17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a;
         
        double cx ,cy,sumay=0,logn,Sumatoriax =0,Promediox = 0, Promedioy = 0, Sumatoriaxy =0,lnyx =1,Sumax2=0,x2=0, xlny,a1 =0,a0 =0;
        double []x = {1.2,2.4,3.6,4.8,6,7};
        double []y = {0.8,1,1.5,2,2.9,3.6};
           
        System.out.println("--------------------------------");
        System.out.println("X");
        System.out.println(" ");
        for (int i = 0; i <x.length; i++) {
        	Sumatoriax+=x[i];
            Promediox=Sumatoriax/x.length;
        }
        
        System.out.println("Sumatoria: " + Sumatoriax);
        System.out.println("Promedio: " + Promediox);
        System.out.println("--------------------------------");
                     
        System.out.println(" ");
        System.out.println("Ln(y)");
        System.out.println(" ");
        for (int i = 0; i <y.length; i++) {
            logn=Math.log(y[i]);
            sumay+=logn;
            Promedioy=sumay/y.length;
            System.out.println("ln(Y"+ i + "): " + logn); 
        }

        System.out.println("Sumatoria: "+sumay );
        System.out.println("Promedio: " +Promedioy );
        System.out.println("---------------------------------------");
        
        System.out.println(" ");
        System.out.println("X * Ln(Y)");
        System.out.println(" ");
        for (int i = 0; i <y.length; i++) {
            logn=Math.log(y[i]);
            lnyx =  x[i]*logn;
            System.out.println("ln(Y"+ i + ") * " + i + ": " + lnyx);
            Sumatoriaxy+=  x[i]*logn;
        }
        
        System.out.println("Sumatoria: " + Sumatoriaxy );
        System.out.println("----------------------------------------");
        
        System.out.println(" ");
        System.out.println("X^2");
        System.out.println(" ");
        for (int i = 0; i <x.length; i++) {
           x2= x[i]*x[i];
            System.out.println(x2);
            Sumax2+=x2;   
        }
        System.out.println("Sumatoria "+ Sumax2);
        System.out.println(" ");
        
        System.out.println("--------------------------------------------------------------");
        a1=(6*Sumatoriaxy-Sumatoriax*sumay)/(6*Sumax2-Math.pow(Sumatoriax, 2));
        a0= Promedioy-a1*Promediox;
        
        System.out.println("Y: " + a0 + " + " + a1 +"x");

        System.out.println("--------------------------------------------------------------");
        a= Math.pow(Math.E, a0);
        System.out.println("Respuesta: " + a +" e^" + a1+"x" );
        System.out.println("--------------------------------------------------------------");
    }
}
    