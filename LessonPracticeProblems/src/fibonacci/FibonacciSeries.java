package fibonacci;

public class FibonacciSeries {
    private static int n1 = 0;
    private static int n2 = 1;
    private static int[] fibonacciSeriesValues;
    private static int arrayIndex = 2;

    private static void generateFibonacciSeries(int count) {
        if (count > 0) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            fibonacciSeriesValues[arrayIndex++] = n3;
            generateFibonacciSeries(count - 1);
        }
    }

    public static void createFibonacci(int count) {
        fibonacciSeriesValues = new int[count];
        fibonacciSeriesValues[0] = n1;
        fibonacciSeriesValues[1] = n2;
        generateFibonacciSeries(count - 2);
        printArray();
    }

    private static void printArray() {
        System.out.println("The Fibonacci series is:");
        for (int e : fibonacciSeriesValues) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
