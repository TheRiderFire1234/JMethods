public class SeriesComputation {

    static final double EPS = 3e-8;
    static final double TIME_PER_TERM_MICRO = 500.0; // 500 микросекунд

    static double s(double x) {
        double sum = 0.0;
        int k = 1;

        long startTime = System.nanoTime();

        while (true) {
            double kp = Math.sqrt(k * k * k + x);
            double km = Math.sqrt(k * k * k - x);

            double term = -2.0 * x / (kp * km * (kp + km));
            sum += term;

            if (Math.abs(term) < EPS) {
                break;
            }
            k++;
        }

        long endTime = System.nanoTime();
        double realTimeSec = (endTime - startTime) / 1e9;

        // оценка времени по пункту В
        double estimatedTimeSec =
                k * TIME_PER_TERM_MICRO * 1e-6;

        System.out.println("x = " + x);
        System.out.println("Использовано членов: " + k);
        System.out.printf("Оценка времени (пункт В): %.6f сек%n", estimatedTimeSec);
        System.out.printf("Фактическое время: %.6f сек%n", realTimeSec);
        System.out.println();

        return sum;
    }

    public static void main(String[] args) {

        double x1 = 0.5;
        double x2 = 0.99999999;

        System.out.printf("s(0.5) = %.10f%n%n", s(x1));
        System.out.printf("s(0.99999999) = %.10f%n", s(x2));
    }
}
