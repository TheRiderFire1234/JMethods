public class SeriesComparison {

    static final double EPS = 1e-10;

    // исходный ряд
    static double originalSeries() {
        double sum = 0.0;
        int n = 1;

        while (true) {
            double term = 1.0 / (n * n + 1.0);
            sum += term;

            if (1.0 / n < EPS) { // оценка остатка
                break;
            }
            n++;
        }

        System.out.println("Исходный ряд:");
        System.out.println("  Число членов: " + n);
        return sum;
    }

    // преобразованный ряд
    static double transformedSeries() {
        double sum = 0.0;
        int n = 1;

        while (true) {
            double term = 1.0 / (Math.pow(n, 4) * (n * n + 1.0));
            sum += term;

            if (1.0 / (5.0 * Math.pow(n, 5)) < EPS) { // оценка остатка
                break;
            }
            n++;
        }

        double constant =
                Math.PI * Math.PI / 6.0
                        - Math.pow(Math.PI, 4) / 90.0;

        System.out.println("Преобразованный ряд:");
        System.out.println("  Число членов: " + n);

        return constant + sum;
    }

    public static void main(String[] args) {

        double s1 = originalSeries();
        double s2 = transformedSeries();

        System.out.printf("%nСумма исходного ряда:        %.12f%n", s1);
        System.out.printf("Сумма преобразованного ряда: %.12f%n", s2);
    }
}

