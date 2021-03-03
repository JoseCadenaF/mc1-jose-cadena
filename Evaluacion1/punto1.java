package punto1;

import java.util.Scanner;
import java.util.HashSet;

public class punto1 {

	public static void main(String[] args) {
	
		Scanner Sc = new Scanner(System.in);
        HashSet<Integer> A = new HashSet <Integer> ();
        for (int i = 10; i < 30; i++) {
            A.add(i);
        }
        HashSet<Integer> B = new HashSet <Integer> ();
        B.add(0);
        B.add(2);
        B.add(4);
        B.add(6);
        B.add(12);
        B.add(24);
        B.add(48); 
        
        HashSet<Integer> C = new HashSet <Integer> ();
        for (int i = 0; i <= 45; i++) {
            if(i%4 == 2){
                C.add(i);
            }
            
        }
        HashSet<Integer> D = new HashSet <Integer> ();
        for (int i = 1; i < 40; i++) {
            if(numero_primo(i)){
                D.add(i);
            }
        }

        HashSet<Integer> OP1 = new HashSet <Integer> ();
        HashSet<Integer> OP2 = new HashSet <Integer> ();
        HashSet<Integer> OP3 = new HashSet <Integer> ();
        
        OP1 = diferenciasimetrica(diferencia(A, C), interseccion(B, D));
        System.out.println(OP1);
        OP2 = diferencia(diferenciasimetrica(interseccion(B, D), C), union(A, D));
        System.out.println(OP2);
        OP3 = union(interseccion(A, interseccion(B, C)), union(diferencia(A, C), diferencia(B, D)));
        System.out.println(OP3);

    }

    public static boolean numero_primo(int x)
    {
        if(x == 1){
            return false;
        }else if(x == 2){
            return true;
        }else{
            for (int i = 2; i <x; i++) {
                if(x%i == 0){
                    return false;
                }
            }
            return true;
        }
    }
    public static HashSet<Integer> union (HashSet<Integer> A ,HashSet<Integer> B){
        HashSet<Integer> union = new HashSet <Integer> ();
         for (int elemento : A) {
                    union.add(elemento);
                }
                  for (int elemento : B) {
                    union.add(elemento);  
                }
        return union;
    }

    public static HashSet<Integer> interseccion (HashSet<Integer> A ,HashSet<Integer> B){
        HashSet<Integer>interseccion = new HashSet<>(); 
                for (int elemento : A) {
             
                
                  for (int elemento1 : B) {
                    
                    if (elemento == elemento1){
                        interseccion.add(elemento);
                  }
                    
                  }
                }
                return interseccion;
    }
    public static HashSet<Integer> diferencia(HashSet<Integer> A ,HashSet<Integer> B){
        HashSet<Integer>diferencia = new HashSet<>();
                 
        diferencia = (HashSet<Integer>)A.clone();
        diferencia.removeAll(B);
        return diferencia;
    }

    public static HashSet<Integer> diferenciasimetrica(HashSet<Integer> A ,HashSet<Integer> B){
        HashSet<Integer>diferenciasimetrica = new HashSet<>();
        diferenciasimetrica = diferencia(union(A,B),interseccion(A,B));
                 
                 
        return diferenciasimetrica;
    }


	}


