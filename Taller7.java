<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Taller7 {


        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("digite el valor");
        double valor =sc.nextDouble();
        
        double erroraproximado = (0.5*Math.pow(10,-7))*100;
            
        double erroresperado = 100;
        
        int contador = 0;
        
        int potencia = 0;
        
        double x = 0;
        
        double y = 0;
        
        
        do{
            
            if(contador%2==0){
              y = x;
              x = x + Math.pow(valor,potencia)/factorial(potencia);    
              
              contador++;
              potencia++;
            }else{
              y = x;
              x = x - Math.pow(valor,potencia)/factorial(potencia);    
              
              contador++;
              potencia++; 
            }
              erroresperado =  Math.abs((x-y)/x)*100;
              
            System.out.println("----------------------------------------------------------");
            System.out.println("La iteracion actual es: " + contador);
            System.out.println("El valor de la iteracion #" + contador+ " es: " + x);
            System.out.println("Su error aproximado es: " + erroresperado);
            System.out.println("----------------------------------------------------------");
            System.out.println("\n\n");
            
        }while(erroraproximado<erroresperado);
        
        }
         private static double factorial(int n)
    {   
        double rta = 1;
        for (int i = 2; i <= n; i++)
        {
            rta *= i;
        }

        return rta;
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Taller7 {


        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("digite el valor");
        double valor =sc.nextDouble();
        
        double erroraproximado = (0.5*Math.pow(10,-7))*100;
            
        double erroresperado = 100;
        
        int contador = 0;
        
        int potencia = 0;
        
        double x = 0;
        
        double y = 0;
        
        
        do{
            
            if(contador%2==0){
              y = x;
              x = x + Math.pow(valor,potencia)/factorial(potencia);    
              
              contador++;
              potencia++;
            }else{
              y = x;
              x = x - Math.pow(valor,potencia)/factorial(potencia);    
              
              contador++;
              potencia++; 
            }
              erroresperado =  Math.abs((x-y)/x)*100;
              
            System.out.println("----------------------------------------------------------");
            System.out.println("La iteracion actual es: " + contador);
            System.out.println("El valor de la iteracion #" + contador+ " es: " + x);
            System.out.println("Su error aproximado es: " + erroresperado);
            System.out.println("----------------------------------------------------------");
            System.out.println("\n\n");
            
        }while(erroraproximado<erroresperado);
        
        }
         private static double factorial(int n)
    {   
        double rta = 1;
        for (int i = 2; i <= n; i++)
        {
            rta *= i;
        }

        return rta;
    }
}
>>>>>>> f06071b60c6095a6c5e4a8257b8df835eaefa7fd
//><