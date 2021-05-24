package taller21;

public class taller21 {

    public static void main(String[] args) {

        double[] x = {1, 4, 6, 10, 12, 15, 16};
        double[] y = {0.5, 1.1, 1.4, 2.3, 2.7, 3.2, 3.5};

        double sumax = 0;
        double sumay = 0;
        double promx;
        double promy;
        double mulxy = 0;
        double cuax = 0;
        double a1;
        double a0;
        double st = 0;
        double sr = 0;
        double sy = 0;
        double syx = 0;
        double r;
        for (int i = 0; i < x.length; i++) {
            sumax += x[i];
            sumay += y[i];
            mulxy += x[i] * y[i];
            cuax += Math.pow(x[i], 2);

        }

        promx = sumax / x.length;
        promy = sumay / y.length;
        System.out.print("x: [");
        for (int j = 0; j < x.length; j++) {
            System.out.print(x[j] + ", ");
        }
        System.out.println("]");

        System.out.print("y: [");
        for (int k = 0; k < x.length; k++) {

            System.out.print(y[k] + ", ");
        }
        System.out.println("]");

        a1 = ((x.length * mulxy) - (sumax * sumay)) / (((x.length * cuax) - (Math.pow(sumax, 2))));
        a0 = promy - (a1 * promx);

        for (int i = 0; i < y.length; i++) {
            st += Math.pow(y[i] - promy, 2);

            sr += Math.pow(y[i] - a0 - (a1 * x[i]), 2);

        }

        sy = Math.sqrt(st / (x.length - 1));
        syx = Math.sqrt(sr / (x.length - 2));

        r = Math.sqrt((st - sr) / st) * 100;

        System.out.println("---------------------------------");
        System.out.println("r: " + r + "%");
        System.out.println("sy: " + sy);
        System.out.println("syx: " + syx);
        System.out.println("y: " + a0 + "+" + a1 + "x");
        System.out.println("st: " + st);
        System.out.println("sr: " + sr);
    }

}