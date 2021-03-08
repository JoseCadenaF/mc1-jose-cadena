package taller2;

import java.util.HashSet;
import java.util.Scanner;


public class taller2 {
//<>
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
public static HashSet<Integer> inter (HashSet<Integer> A ,HashSet<Integer> B){
    

HashSet<Integer>inter = new HashSet<>(); 
        for (int elemento : A) {
     
        
          for (int elemento1 : B) {
            
            if (elemento == elemento1){
                inter.add(elemento);
          }
            
          }
        }
        return inter;
}
@SuppressWarnings("unchecked")
public static HashSet<Integer> diferencia(HashSet<Integer> A ,HashSet<Integer> B){
HashSet<Integer>diferencia = new HashSet<>();
     
     diferencia = (HashSet<Integer>)A.clone();
      diferencia.removeAll(B);
      return diferencia;
}
 public static HashSet<Integer> diffa(HashSet<Integer> A ,HashSet<Integer> B){
 HashSet<Integer>diffa = new HashSet<>();
     diffa = diferencia(union(A,B),inter(A,B));
     
     
     return diffa;
 }
    @SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        
             
        HashSet<Integer> conjunto1 = new HashSet<Integer>();
        
        for (int i = 6; i < 25; i++){
            conjunto1.add(i);
        }  

        HashSet<Integer> conjunto2 = new HashSet<Integer>();
        
        for (int i=1;i<=30;i++) {
            if (i%2==1){
                conjunto2.add(i);
            }
        }
        HashSet<Integer> conjunto3 = new HashSet<Integer>();
        conjunto3.add(0);
        conjunto3.add(3);
        conjunto3.add(6);
        conjunto3.add(9);
        conjunto3.add(11);
        conjunto3.add(15);
        conjunto3.add(18);
        conjunto3.add(20);
        
        HashSet<Integer> conjunto4 = new HashSet<Integer>();
        conjunto4.add(2);
        conjunto4.add(3);
        conjunto4.add(5);
        conjunto4.add(7);
        conjunto4.add(11);
        conjunto4.add(13);
        conjunto4.add(17);
        conjunto4.add(19);
        conjunto4.add(23);
        conjunto4.add(29);
        conjunto4.add(31);
        conjunto4.add(37);

System.out.println(conjunto1);
System.out.println(conjunto2);
System.out.println(conjunto3);
System.out.println(conjunto4);
        
       HashSet<Integer> respuesta1 = new HashSet<Integer>();
       respuesta1 = inter(diffa(conjunto1,conjunto2),conjunto3);
       HashSet<Integer> respuesta2 = new HashSet<Integer>();
       respuesta2 = union(diferencia(conjunto1,conjunto3),conjunto2);
       HashSet<Integer> respuesta3 = new HashSet<Integer>();
       respuesta3 = diffa(conjunto1,union(conjunto3,conjunto4));
       HashSet<Integer> respuesta4 = new HashSet<Integer>();
       respuesta4 = diffa(diferencia(conjunto3,conjunto1),inter(conjunto2,conjunto4));
       
       System.out.println("----RESPUESTAS----");
       System.out.println(respuesta1);
       System.out.println(respuesta2);
       System.out.println(respuesta3);
       System.out.println(respuesta4);
       
    }
        
      
       
        
 
    
    
          
        
}