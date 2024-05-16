import java.math.*;

public class Polynomial {

    // Field
    double[] coefficients;

    public Polynomial() {
        coefficients = new double[]{0}; // Initialize to {0}
    }

    public Polynomial(double coefficients[]) {
        this.coefficients = coefficients; // Initialize to user given array of coefficients
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

}