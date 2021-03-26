package taller_6;

import java.util.Scanner;

/**
 *
 * @author Jefferson
 */
public class Taller_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Digita un angulo en radianes");
        double x = sc.nextDouble();
        
        double es = (0.5 * Math.pow(10,-8))*100;
        double er = 100;
        int po = 0;
        double a = 0;
        double b = 0;
        int cont = 0;
        
        
        do{
            b=a;
            if (cont%2==0) {
                a = a + (Math.pow(x,po)/factorial(po));
                cont++;
                po += 2;
            } else {
                b=a;
                a = a - (Math.pow(x,po)/factorial(po));
                cont++;
                po +=2;
            }
        
        er = Math.abs((a-b)/a)*100;
            System.out.println("******************************************");
            System.out.println("la iteracion es " + cont);
            System.out.println("el valor de la iteracion es" + a);
            System.out.println("error relativo "+ er);
            System.out.println("******************************************");
        }while(er>es);
        
        System.out.println("******************************************");
        System.out.println("la ultima iteracion es = " +cont);
        System.out.println("El valor de la iteracion actual es " +a);
        System.out.println("error relativo = " +er);
        System.out.println("******************************************");
        
    }
    private static double factorial(int n){
    double rta = 1;
        for (int i = 2; i <= n; i++) {
            rta *=i;
        }
        
        return rta;
    }
}
