public class ErfTaylor {

    static double erfTaylor(double x) {
        double sum = 0.0;
        double term;
        int n = 0;

        double factorial = 1.0;
        double xPower = x;

        while (true) {
            term = ((n % 2 == 0) ? 1.0 : -1.0)
                    * xPower / (factorial * (2 * n + 1));

            double newSum = sum + term;

            if (newSum == sum) {
                break;
            }

            sum = newSum;

            n++;
            factorial *= n;
            xPower *= x * x;
        }

        System.out.println("  Использовано членов: " + n);

        return 2.0 / Math.sqrt(Math.PI) * sum;
    }

    public static void main(String[] args) {

        double[] xValues = {0.5, 1.0, 5.0, 10.0};

        double[] table = {
                0.5204998778130465,
                0.8427007929497149,
                0.9999999999984626,
                1.0
        };

        for (int i = 0; i < xValues.length; i++) {
            double x = xValues[i];

            System.out.println("x = " + x);

            double approx = erfTaylor(x);
            double exact = table[i];

            System.out.printf("  erf(x) по ряду   = %.15f%n", approx);
            System.out.printf("  erf(x) табличное = %.15f%n", exact);
            System.out.printf("  Абс. ошибка      = %.3e%n%n",
                    Math.abs(approx - exact));
        }
    }
}
