
public class Driver {
        public static void main(String [] args) {
            /*
            Polynomial p = new Polynomial();
            System.out.println(p.evaluate(3));
            double [] c1 = {6,0,0,5};
            Polynomial p1 = new Polynomial(c1);
            double [] c2 = {0,-2,0,0,-9};
            Polynomial p2 = new Polynomial(c2);
            Polynomial s = p1.add(p2);
            System.out.println("s(0.1) = " + s.evaluate(0.1));
            if(s.hasRoot(1)) System.out.println("1 is a root of s");
            else System.out.println("1 is not a root of s");
            */


            Polynomial p1 = new Polynomial();
            Polynomial p2 = new Polynomial(new double[]{0.1, 0.2, -0.1});
            Polynomial p3 = new Polynomial(new double[]{0.1, 0.2, -0.1, -0.31}, new int[]{1, 2, 3});

            for (int i = 0; i < p3.coefficients.length; i++) {
                System.out.print(p3.coefficients[i] + " ");
                System.out.println(p3.exponents[i]);
            }

            System.out.println(p3.toString());

        }
    }