import fibonacci.FibonacciSeries;
import strings.problems.DigitsSumFromString;

public class MainTest {
    public static void main(String[] args) {
        ValidationInput validationInput = new ValidationInput();
        System.out.println("Enter count:");
//        System.out.println(DigitsSumFromString.returnSum(validationInput.inputString()));
//        System.out.println(DigitsSumFromString.returnSUmOfNumbers(validationInput.inputString()));
        FibonacciSeries.createFibonacci(validationInput.inputInt());
    }
}
