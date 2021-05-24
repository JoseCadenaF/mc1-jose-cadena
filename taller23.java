package metodos;

public class taller23{
	public static void main(String[] args) {		
		double[] datos_x = {0, 0, 1.5, 3, 0, 1.5, 3, 3};
		double[] datos_y = {0, 3, 3, 6, 6, 9, 9, 3};
		double[] datos_z = {21, 31.5, 16.5, 18, 34.5, 34.5, 21, 9};
		
		double st = 0;
		double sr = 0;
		
		double sy = 0;
		double sy_x = 0;
		double r = 0;
		
		double sumatoria_x = 0;
		double sumatoria_y = 0;
		double sumatoria_z = 0;
		
		double sumatoria_x_y = 0;
		double sumatoria_x_z = 0;
		double sumatoria_y_z = 0;
		
		double sumatoria_x_dos = 0;
		double sumatoria_y_dos = 0;
		
		for (int i = 0; i < datos_x.length; i++) {
			sumatoria_x += datos_x[i];
			sumatoria_y += datos_y[i];
			sumatoria_z += datos_z[i];
			
			sumatoria_x_dos += Math.pow(datos_x[i], 2);
			sumatoria_y_dos += Math.pow(datos_y[i], 2);
			
			sumatoria_x_y += datos_x[i] * datos_y[i];
			sumatoria_x_z += datos_x[i] * datos_z[i];
			sumatoria_y_z += datos_y[i] * datos_z[i];
		}
		
		int tamaño = datos_x.length;
		double media_z = (sumatoria_z/tamaño);

        double[][] a = {{datos_x.length, sumatoria_x, sumatoria_y}, 
        			   {sumatoria_x, sumatoria_x_dos, sumatoria_x_y}, 
        			   {sumatoria_y, sumatoria_x_y, sumatoria_y_dos}};
        
        double[] b = {sumatoria_z, sumatoria_x_z, sumatoria_y_z};
        double[] x = gauss(a, b);
        
        //Se imprimen los resultados
        for (int i = 0; i < x.length; i++) {
            System.out.println("x" + (i + 1) + " = " + x[i]);
        }
        
        System.out.println();
        
        //Se imprimen las pruebas
        for (int i = 0; i < x.length; i++) {
            double test = 0;
            for (int j = 0; j < x.length; j++) {
                test += a[i][j] * x[j];
            }
            test -= b[i];
            System.out.println("test " + (i + 1) + " = " + test);
        }
        
        System.out.println();
                
        for (int i = 0; i < datos_z.length; i++) {
			st += Math.pow(datos_z[i] - media_z, 2);
			sr += Math.pow(datos_z[i] - x[0] - (x[1]*datos_x[i]) - (x[2]*datos_y[i]), 2);
		}

        sy = Math.sqrt(st/ (tamaño - 1));
        sy_x = Math.sqrt(sr/ (tamaño - (2 + 1)));
        r = Math.sqrt((st - sr)/st);
        
        System.out.println("st = " + st + " sr = " + sr );
        System.out.println("sy = " + sy + " sy/x = " + sy_x + " R = " + r);
        System.out.println("funcion: Z = " + x[0] + " " +  x[1] + "X + " + x[2] + "Y");
	}
	
    private static double[] gauss(double[][] a, double[] b) {
        double[][] aAux = duplicarArreglo(a);
        double[] bAux = duplicarArreglo(b);
        int n = bAux.length;
        
        System.out.println("Ecuaciones");
        imprimirEcuaciones(aAux, bAux);
        System.out.println();
        
        //Se construye la matriz triangular superior
        for (int i = 0; i < n - 1; i++) {
            //Reducción
            for (int j = i + 1; j < n; j++) {
                double fact = aAux[j][i] / aAux[i][i];
                
                for (int k = 0; k < n; k++) {
                    aAux[j][k] -= (aAux[i][k] * fact);
                }
                
                bAux[j] -= (bAux[i] * fact);
                
                System.out.println("Reducción " + (j + 1) + " con " + (i + 1));
                imprimirEcuaciones(aAux, bAux);
                System.out.println();
            }
        }
        
        //Solución hacia atrás
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double resta = 0;
            for (int j = i + 1; j < n; j++) {
                resta += aAux[i][j] * x[j];
            }
            x[i] = (bAux[i] - resta) / aAux[i][i];
        }
        
        return x;
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