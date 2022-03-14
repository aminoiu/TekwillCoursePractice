package sales;

import strings.problems.ValidationInput;

import java.util.*;


public class SalesPersonProcess {
    public static void main(String[] args) {
        calculateSalaries();
    }

    public static void calculateSalaries() {
        List<SalesPerson> salesPersonList = generateSalesPersonList();
        Map<SalariesRanges, Integer> salariesRangesIntegerMap = initMapWithRanges();
        for (SalesPerson salesPerson : salesPersonList) {
            int salary = salesPerson.getWeeklySalary();
            SalariesRanges salariesRanges = getSalaryRange(salary);
            if (salariesRanges != null) {
                salariesRangesIntegerMap.replace(salariesRanges, (salariesRangesIntegerMap.get(salariesRanges) + 1));
            } else {
                salariesRangesIntegerMap.replace(SalariesRanges.R9, (salariesRangesIntegerMap.get(SalariesRanges.R9) + 1));
            }
        }

        printList(salesPersonList);
        printMap(salariesRangesIntegerMap);
    }

    private static void printMap(Map<SalariesRanges, Integer> salariesRangesIntegerMap) {
        System.out.println("Salaries in ranges:");
        for (Map.Entry<SalariesRanges, Integer> entry : salariesRangesIntegerMap.entrySet()) {
            System.out.println(entry.getKey().toString() + ":" + entry.getValue().toString());
        }
    }

    private static void printList(List<SalesPerson> salesPersonList) {
        System.out.println("All employees: ");
        for (SalesPerson salesPerson : salesPersonList) {
            System.out.println(salesPerson.toString());
        }
    }

    private static Map<SalariesRanges, Integer> initMapWithRanges() {
        Map<SalariesRanges, Integer> salariesRangesIntegerMap = new HashMap<>();
        for (SalariesRanges salariesRanges : SalariesRanges.values()) {
            salariesRangesIntegerMap.put(salariesRanges, 0);
        }
        return salariesRangesIntegerMap;
    }

    private static SalariesRanges getSalaryRange(int salary) {
        SalariesRanges salariesRange = null;
        for (SalariesRanges salariesRanges : SalariesRanges.values()) {
            if (salariesRanges.getMinValue() <= salary && salary <= salariesRanges.getMaxValue()) {
                salariesRange = salariesRanges;
                break;
            }
        }
        return salariesRange;
    }

    private static List<SalesPerson> generateSalesPersonList() {
        List<SalesPerson> salesPersonList = new ArrayList<>();
        ValidationInput validationInput = new ValidationInput();
        System.out.println("Enter the number of sales people:");
        int numberOfSalesPeople = validationInput.inputInt();
        for (int i = 0; i < numberOfSalesPeople; i++) {
            salesPersonList.add(new SalesPerson(getRandomString(5), getRandomInt(200, 10000)));
        }
        return salesPersonList;
    }

    private static String getRandomString(int numberOfChars) {
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < numberOfChars; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            name.append(randomChar);
        }
        return name.toString();
    }

    private static int getRandomInt(int minimumNBumber, int maximumNumber) {
        Random random = new Random();
        return random.nextInt(maximumNumber - minimumNBumber) + minimumNBumber;
    }
}
