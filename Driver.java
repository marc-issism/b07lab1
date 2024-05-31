import java.util.Arrays;

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

            System.out.println("Testing add()...");

            System.out.println("Test 2a: same number of coeffs and exp");
            Polynomial test2_p1 = new Polynomial(new double[]{10, -10}, new int[]{1, 2});
            Polynomial test2_p2 = new Polynomial(new double[]{5, -5}, new int[]{1, 2});
            Polynomial test2_p3 = test2_p1.add(test2_p2);
            if (!Arrays.equals(test2_p3.coefficients, new double[]{15.0, -15.0})) {
                System.out.println("Test 2a failed: unexpected coefficients.");
            }
            else if (!Arrays.equals(test2_p3.exponents, new int[]{1, 2})) {
                System.out.println("Test 2a failed: unexpected exponents.");
            }
            else {
                System.out.println("Test 2a success!");
            }

            System.out.println("Test 2b: one polynomial has more coefficients");
            Polynomial test2b1 = new Polynomial(new double[]{1, 2, 3}, new int[]{1, 2, 3});
            Polynomial test2b2 = new Polynomial(new double[]{4, 5}, new int[]{1, 5});
            Polynomial test2b_result = test2b1.add(test2b2);
            if (!Arrays.equals(test2b_result.coefficients, new double[]{5, 2, 3, 5})) {
                System.out.println("Test 2b failed: unexpected coefficients.");
            }
            else if (!Arrays.equals(test2b_result.exponents, new int[]{1, 2, 3, 5})) {
                System.out.println("Test 2b failed: unexpected exponents.");
            }
            else {
                System.out.println("Test 2b success!");
            }

            System.out.println("Testing evaluate()...");
            System.out.println("Test 3: evaluate 5x + 2x2 - 3x3 @ x = 2, 0, -2");
            Polynomial test3 = new Polynomial(new double[]{5, 2, -3}, new int[]{1, 2, 3});

            if (test3.evaluate(2) != -6) {
                System.out.println("Test 3 failed: x = 2 does not return 0, got " + String.valueOf(test3.evaluate(2)));
            }
            else if (test3.evaluate(0) != 0) System.out.println("Test 3 failed: x = 0 does not return 0");
            else if (test3.evaluate(-2) != 22) System.out.println("Test 3 failed: x = -2 does not return 0");
            else System.out.println("Test 3 success!");

            System.out.println("Testing hasRoot()...");
            if (test3.hasRoot(0) == false) {
                System.out.println("Test 4 failed: 5x + 2x2 - 3x3 has a root at 0, got false");
            }
            else if (test3.hasRoot(1) == true) {
                System.out.println("Test 4 failed: 5x + 2x2 - 3x3 has no root at 1, got true");
            }
            else {
                System.out.println("Test 4 success!");
            }

            System.out.println("Testing multiply()...");
            Polynomial test4_1 = new Polynomial(new double[]{1, 1}, new int[]{0, 1});
            Polynomial test4_2 = new Polynomial(new double[]{-2, 1}, new int[]{0, 1});
            Polynomial test4_result = new Polynomial(new double[]{-2, -1, 1}, new int[]{0, 1, 2});

            if (!test4_result.equals(test4_1.multiply(test4_2))) {
                System.out.println("Test 4a failed: Incorrect multiplaction of binomials.");
            }
            else {
                System.out.println("Test 4 success!");
            }
            


            System.out.println("Testing equals()...");
            if (!(new Polynomial().equals(new Polynomial()))) {
                System.out.println("Test 5a failed: Empty polynomials not equal.");
            }
            else if (!(new Polynomial(new double[]{1, 2, -3}, new int[]{0, 1, 2}).equals(new Polynomial(new double[]{1, 2, -3}, new int[]{0, 1, 2})))) {
                System.out.println("Test 5b failed: Equal polynomials of order 3 not equal.");
            }
            else if (new Polynomial().equals(test4_2)) {
                System.out.println("Test 5c failed: Empty polynomial equal to non-empty polynomial");
            }
            else {
                System.out.println("Test 5 success!");
            }

        }
    }