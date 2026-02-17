public class SeriesSum {

    static final double EPS = 3e-8;
    
    public static double compute(double x) {
        double sum = 0.0;
        int k = 1;

        while (true) {
            double k3 = k * k * k;

            double sqrt1 = Math.sqrt(k3 + x);
            double sqrt2 = Math.sqrt(k3 - x);

            double term = (-2.0 * x) /
                    (sqrt1 * sqrt2 * (sqrt1 + sqrt2));
            sum += term;
            double remainderEstimate = (2.0 / 7.0) *
                    Math.pow(k, -3.5);

            if (remainderEstimate < EPS)
                break;

            k++;
        }

        System.out.println("Использовано членов: " + k);
        return sum;
    }

    public static void main(String[] args) {
        double x1 = 0.5;
        double x2 = 0.99999999;

        System.out.println("x = 0.5");
        System.out.println("s(x) = " + compute(x1));

        System.out.println();

        System.out.println("x = 0.99999999");
        System.out.println("s(x) = " + compute(x2));
    }
}
