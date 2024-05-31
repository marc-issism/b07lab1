import java.lang.reflect.Array;
import java.util.Arrays;

public class Polynomial {

    // Fields
    double[] coefficients;
    int[] exponents;

    // Given nothing, construct polynomial with coefficient 0 and exponent 1
    public Polynomial() {
        coefficients = new double[]{0}; // Initialize coefficient to {0}
        exponents = new int[]{0}; // Initialize exponent to {0}
    }

    // Given only coefficients, construct polynomial with each coefficient to the power of 1
    public Polynomial(double coefficients[]) {
        this.coefficients = coefficients; // Initialize to user given array of coefficients
        exponents = new int[coefficients.length];
        for (int i = 0; i < exponents.length; i++) {
            exponents[i] = 1;
        }
    }

    // Given both coefficients and exponents construct a polynomial with given coefficients and exponents
    public Polynomial(double coefficients[], int exponents[]) {
        this.coefficients = coefficients;

        if (exponents.length > coefficients.length) { // Cut exponents down to how many coefficients there are
            this.exponents = new int[coefficients.length];
            for (int i = 0; i < coefficients.length; i++) {
                this.exponents[i] = exponents[i];
            }
        }
        else if (exponents.length < coefficients.length) { // Replace empty exponent indeces with 1s
            this.exponents = new int[coefficients.length];
            for (int i = 0; i < exponents.length; i++) {
                this.exponents[i] = exponents[i];
            }
            for (int j = exponents.length; j < coefficients.length; j++) {
                this.exponents[j] = 1;
            }
        }
        else { // ex.length = co.length
            this.exponents = exponents;
        }

    }

    public Polynomial delete_zeros() {

        int non_zeros = 0;
        for (double c : coefficients) {
            if (c != 0) {
                non_zeros++;
            }
        }

        double result_coefficients[] = new double[non_zeros];
        int result_exponents[] = new int[non_zeros];

        for (int i = 0; i < non_zeros; i++) {
            result_coefficients[i] = coefficients[i];
            result_exponents[i] = exponents[i];
        }

        return new Polynomial(result_coefficients, result_exponents);

    }

    public Boolean contains_exponent(int exponent, int[] exponents) {

        for (int exp : exponents) {
            if (exponent == exp) return true;
        }

        return false;
    }

    public Polynomial add(Polynomial polynomial) {

        double result_coefficients[] = new double[coefficients.length + polynomial.coefficients.length];
        int result_exponents[] = new int[coefficients.length + polynomial.coefficients.length];

        boolean hasZero = false;

        int j = 0;
        for (int e : exponents) {
            if (!contains_exponent(e, result_exponents)) {
                result_exponents[j] = e;
                j++;
            }
            else if (e == 0 && !hasZero) {
                hasZero = true;
                result_exponents[j] = 0;
                j++;
            }
        }
        for (int e : polynomial.exponents) {
            if (!contains_exponent(e, result_exponents)) {
                result_exponents[j] = e;
                j++;
            }
            else if (e == 0 && !hasZero) {
                hasZero = true;
                result_exponents[j] = 0;
                j++;
            }
        }

        for (int i = 0; i < result_exponents.length; i++) {

            if (result_exponents[i] == 0 && i != 0) {
                break;
            }

            int e = result_exponents[i];
            double sum = 0;

            for (int k = 0; k < exponents.length; k++) {
                if (exponents[k] == e) {
                    sum += coefficients[k];
                }
            }

            for (int k = 0; k < polynomial.exponents.length; k++) {
                if (polynomial.exponents[k] == e) {
                    sum += polynomial.coefficients[k];
                }
            }
        
            result_coefficients[i] = sum;

        }

        return new Polynomial(result_coefficients, result_exponents).delete_zeros();

    }

    @Override
    public String toString() {

        String output = "";

        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] > 0 && i != 0) {
                output = output.concat("+");
            }
            output = output.concat(String.valueOf(coefficients[i]) + "x" + String.valueOf(exponents[i]));
        } 

        return output;

    }

    public double evaluate(double x) {

        double sum = 0;

        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * Math.pow(x, exponents[i]);
        }

        return sum;
        
    }

    public boolean hasRoot(double x) {

        if (evaluate(x) == 0) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Polynomial)) {
            return false;
        }

        Polynomial polynomial = (Polynomial) object;

        if (Arrays.equals(coefficients, polynomial.coefficients) && Arrays.equals(exponents, polynomial.exponents)) {
            return true;
        }

        return false;


    }

    public Polynomial multiply(Polynomial polynomial) {

        Polynomial sum = new Polynomial();

        for (int i = 0; i < coefficients.length; i++) {
            double result_coefficients[] = new double[coefficients.length];
            int result_exponents[] = new int[coefficients.length];
            int k = 0;
            for (int j = 0; j < polynomial.coefficients.length; j++) {
                result_coefficients[k] = coefficients[i] * polynomial.coefficients[j];
                result_exponents[k] = exponents[i] + polynomial.exponents[j];
                k++;
            }
            Polynomial result = new Polynomial(result_coefficients, result_exponents);
            sum = sum.add(result);
        }

        return sum;

    }

}