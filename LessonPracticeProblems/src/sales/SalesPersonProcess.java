package sales;

import java.util.List;
import java.util.Random;

public class SalesPersonProcess {
    public static void calculateSalaries() {
        List<SalesPerson> salesPersonList = generateSalesPersonList();
    }

    private static List<SalesPerson> generateSalesPersonList() {
        int minNumber = 10;
        int maxNumer = 101;
        Random random = new Random();
        int i = random.nextInt(maxNumer - minNumber) + minNumber;

        Math.random()
    }
}
