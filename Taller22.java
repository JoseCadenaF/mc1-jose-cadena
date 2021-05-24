package taller22;

public class Taller22 {

    public static void main(String[] args) {
        double[] x = {2, 4, 6, 8, 10, 12, 14, 16};
        double[] y = {4.5, 1.5, 1, 4, 5.5, 8.5, 11, 18};

        double sumax = 0;
        double sumay = 0;
        double promx;
        double promy;
        double xy = 0;
        double[] x2 = new double[x.length];
        double x3 = 0;
        double sumax2 = 0;
        double x4 = 0;
        double x2y = 0;
        double a0;
        double a1;
        double a2;
        double st = 0;
        double sr = 0;
        double sy = 0;
        double sysobrex = 0;
        double r;
        for (int i = 0; i < x.length; i++) {
            x2[i] = x[i] * x[i];
            sumax2 += x2[i];
            //System.out.println(x2[i]);
        }

        for (int i = 0; i < x.length; i++) {
            sumax += x[i];
            sumay += y[i];
            xy += x[i] * y[i];

            x3 += Math.pow(x[i], 3);
            x4 += Math.pow(x[i], 4);
            x2y += x2[i] * y[i];
        }
        System.out.println("Σx: " + sumax);
        System.out.println("Σx2: " + sumax2);
        System.out.println("Σx3: " + x3);
        System.out.println("Σx4: " + x4);
        System.out.println("Σy: " + sumay);
        System.out.println("Σxy: " + xy);
        System.out.println("Σx2y: " + x2y);
        promx = sumax / x.length;
        promy = sumay / y.length;
        System.out.println("\nmedia x: " + promx);
        System.out.println("media y: " + promy);

        double[][] a = {{x.length, sumax, sumax2}, {sumax, sumax2, x3}, {sumax2, x3, x4}};
        double[] b = {sumay, xy, x2y};
        double[] resultado = Gauss_Jordan(a, b);

        a0 = resultado[0];
        a1 = resultado[1];
        a2 = resultado[2];
                
                
        for (int i = 0; i < y.length; i++) {
            st += Math.pow(y[i] - promy, 2);

            sr += Math.pow(y[i] - a0 - (a1 * x[i])-(a2 * x2[i]), 2);

        }

        sy = Math.sqrt(st / (x.length - 1));
        sysobrex = Math.sqrt(sr / (x.length - 2));

        
        r = Math.sqrt((st - sr) / (st)) * 100;

        System.out.println("\n---------------------------------");
        System.out.println("A0: " + a0);
        System.out.println("A1: " + a1);
        System.out.println("A2: " + a2);
        System.out.println("St: " + st);
        System.out.println("Sr: " + sr);
        System.out.println("r: " + r + "%");
        System.out.println("Y: " + a0 + " + " + a1 + "x + " + a2 + "x^2");

    }

    private static double[] Gauss_Jordan(double[][] a, double[] b) {

        double[][] aAux = duplicarArreglo(a);
        double[] bAux = duplicarArreglo(b);

        int n = bAux.length;
        System.out.println("");
        System.out.println("Ecuaciones");
        imprimirEcuaciones(aAux, bAux);
        System.out.println();

        for (int i = 0; i < n; i++) {

            if (aAux[i][i] == 0) {

                int fila = i;
                for (int j = i + 1; j < aAux.length; j++) {

                    if ((aAux[j][i]) != 0) {
                        fila = j;
                        break;
                    }
                }

                double temp = bAux[i];
                bAux[i] = bAux[fila];
                bAux[fila] = temp;

                for (int k = 0; k < aAux.length; k++) {

                    temp = aAux[i][k];
                    aAux[i][k] = aAux[fila][k];
                    aAux[fila][k] = temp;
                }

                System.out.println("|  Pivoteo:  |");
                imprimirEcuaciones(aAux, bAux);
                System.out.println("------------------------------------------------");
                System.out.println("");
            }

            double Mayor = (aAux[i][i]);

            bAux[i] = bAux[i] / Mayor;
            for (int l = 0; l < aAux.length; l++) {

                aAux[i][l] = aAux[i][l] / Mayor;
            }
     
            for (int j = 0; j < n; j++) {

                if (i != j) {

                    double fact = aAux[j][i] / aAux[i][i];

                    for (int k = 0; k < n; k++) {
                        aAux[j][k] -= aAux[i][k] * fact;
                    }
                    bAux[j] -= bAux[i] * fact;             
                }
            }
        }

        return bAux;
    }

    private static double[][] duplicarArreglo(double[][] m) {
        double[][] duplicado = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            System.arraycopy(m[i], 0, duplicado[i], 0, m[i].length);
        }
        return duplicado;
    }

    private static double[] duplicarArreglo(double[] v) {
        double[] duplicado = new double[v.length];
        System.arraycopy(v, 0, duplicado, 0, v.length);
        return duplicado;
    }

    private static void imprimirEcuaciones(double[][] a, double[] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("| " + b[i]);
        }
    }
}
