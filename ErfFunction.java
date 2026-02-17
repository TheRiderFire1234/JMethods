public class ErfFunction {
    public static void erfFunction(double x) {
        double sum = 0;
        double term = x;
        int n = 0;

        while (true) {
            double newSum = sum + term;
            if (sum == newSum) {break;}
            sum = newSum;
            term = term * (-x * x) * (2.0 * n + 1)
                    / ((n + 1) * (2.0 * n + 3));
            n++;
        }
        System.out.println( 2.0 / Math.sqrt(Math.PI) * sum + " " + n);
    }
    public static void main(String[] args) {
        double[] digs = {0.1, 0.2, 0.3, 0.4, 0.5};
        for (double x: digs) {
            erfFunction(x);
        }
    }
}
