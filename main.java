import java.util.Scanner;
import static java.time.Clock.system;
import java.util.HashSet;

class Main{
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Elementos del conjunto uno?");
        int numUno = sc.nextInt();
        HashSet<Integer> conjuntoUno = new HashSet<>();
        for (int i = 0; i < numUno; i++) {
            System.out.println("Ingrese el o los elementos " + i);
            int n = sc.nextInt();
            conjuntoUno.add(n);
        }

        System.out.println("¿Elementos del conjunto dos?");
        int numDos = sc.nextInt();
        HashSet<Integer> conjuntoDos = new HashSet<>();
        for (int i = 0; i < numDos; i++) {
            System.out.println("Ingrese el o los elementos " + i);
            int n = sc.nextInt();
            conjuntoDos.add(n);
        }
        boolean Ejecutable= true;
        
        while(Ejecutable==true){
        
        System.out.println("¿Operacion a Realizar?");
        System.out.println("1. Union");
        System.out.println("2. Interseccion");
        System.out.println("3. Diferencia");
        System.out.println("4. Diferencia simetrica");
        int n = sc.nextInt();

        switch (n) {
            case 1:
                HashSet<Integer> union = new HashSet<>();

                for (int i = 0; i < conjuntoUno.size(); i++) {
                    for (Object e : conjuntoUno) {
                        union.add((Integer) e);
                    }
                }
                for (int i = 0; i < conjuntoDos.size(); i++) {
                    for (Object e : conjuntoDos) {
                        union.add((Integer) e);
                    }
                }
                System.out.println("Conjunto uno" + conjuntoUno);
                System.out.println("Conjunto Dos" + conjuntoDos);
                System.out.println("Conjunto resultado" + union);
                System.out.println("Cardinalidad " + union.size());

                break;

            case 2:
                HashSet<Integer> interseccion = new HashSet<>();
                for (Object e : conjuntoUno) {
                    for (Object h : conjuntoDos) {
                        if (e == h) {
                            interseccion.add((Integer) e);
                        }
                    }
                }
                System.out.println("Conjunto uno" + conjuntoUno);
                System.out.println("Conjunto Dos" + conjuntoDos);
                System.out.println("Conjunto resultado" + interseccion);
                System.out.println("Cardinalidad " + interseccion.size());
                break;

            case 3:
                HashSet<Integer> diferencia = new HashSet<>();
                for (Object e : conjuntoUno) {
                    if (!conjuntoDos.contains(e)) {
                        diferencia.add((Integer) e);
                    }

                }
                System.out.println("Conjunto uno" + conjuntoUno);
                System.out.println("Conjunto Dos" + conjuntoDos);
                System.out.println("Conjunto resultando" + diferencia);
                System.out.println("Cardinalidad " + diferencia.size());

                break;

            case 4:
                HashSet<Integer> simetrica = new HashSet<>();

                for (Object e : conjuntoUno) {
                    if (!conjuntoDos.contains(e)) {
                        simetrica.add((Integer) e);
                    }
                }
                for (Object e : conjuntoDos) {
                    if (!conjuntoUno.contains(e)) {
                        simetrica.add((Integer) e);
                    }
                }
                System.out.println("Conjunto uno" + conjuntoUno);
                System.out.println("Conjunto Dos" + conjuntoDos);
                System.out.println("Conjunto resultado" + simetrica);
                System.out.println("Cardinalidad " + simetrica.size());
                break;

        }
         System.out.println("Desea realizar alguna otra operacion?"
                 + " 1= si, 2=no");
         int deci= sc.nextInt();
         if (deci==1){
             Ejecutable=true;
                 }else{
         Ejecutable=false;
         }
         
        }
        System.out.println("Cuidese, vuelva pronto");
        
    }
}