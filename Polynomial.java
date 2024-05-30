import java.math.*;

public class Polynomial {

    // Fields
    double[] coefficients;
    int[] exponents;

    // Given nothing, construct polynomial with coefficient 0 and exponent 1
    public Polynomial() {
        coefficients = new double[]{0}; // Initialize coefficient to {0}
        exponents = new int[]{1}; // Initialize exponent to {1}
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

    public Polynomial add(Polynomial polynomial) {

        int max_length = Math.max(polynomial.coefficients.length, coefficients.length);
        int min_length = Math.min(polynomial.coefficients.length, coefficients.length);

        // Take the max size of the bigger of the two polynomials and create an array with that size
        double[] result_coefficients = new double[max_length];

        for (int i = 0; i < min_length; i++) {
            result_coefficients[i] = coefficients[i] + polynomial.coefficients[i];
        }

        return new Polynomial(result_coefficients);
        
    }

    public String toString() {

        String output = "";

        for (int i = 0; i < coefficients.length; i++) {
            output.concat(String.valueOf(coefficients[i]) + "x" );
        } 

        return output;

    }

    public double evaluate(double x) {

        double sum = 0;

        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * Math.pow(x, i);
        }

        return sum;
        
    }

    public boolean hasRoot(double x) {

        if (evaluate(x) == 0) {
            return true;
        }

        return false;
    }

    public Polynomial multiply(Polynomial polynomial) {

        int max_length = Math.max(polynomial.coefficients.length, coefficients.length);
        int min_length = Math.min(polynomial.coefficients.length, coefficients.length);

        //double result_coefficients 

        Polynomial result = new Polynomial();



        return result;
    }

}