public class SeriesComparison {

    static final double EPS = 0.1;

    public static double originalSeries() {
        double sum = 0.0;
        int n = 1;
        while (true) {
            sum += 1.0 / (n * n + 1);
            if (1.0 / n < EPS) break;
            n++;
        }
        System.out.println("Исходный ряд: использовано членов = " + n);
        return sum;
    }

    public static double transformedSeries() {
        double sum = 0.0;
        int n = 1;
        while (true) {
            sum += 1.0 / (Math.pow(n, 4) * (n * n + 1));
            if (1.0 / (5 * Math.pow(n, 5)) < EPS) break;
            n++;
        }
        double result = Math.PI * Math.PI / 6 - Math.pow(Math.PI, 4) / 90 + sum;
        System.out.println("Преобразованный ряд: использовано членов = " + n);
        return result;
    }

    public static void main(String[] args) {

        double s1 = originalSeries();
        double s2 = transformedSeries();

        System.out.println("Исходный результат = " + s1);
        System.out.println("Преобразованный результат = " + s2);
    }
}

