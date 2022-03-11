package sales;

public class SalesPerson {
    private static final int MAIN_WEEKLY_SALARY = 200;
    private static final double WEEKLY_COMMISSION = 0.09;

    private final String name;
    private int grossSalesPerWeek;
    private int weeklySalary;

    public SalesPerson(String name, int sales) {
        this.name = name;
        this.grossSalesPerWeek = sales;
        this.weeklySalary = (int) (MAIN_WEEKLY_SALARY + WEEKLY_COMMISSION * grossSalesPerWeek);
    }
    public String getName() {
        return name;
    }

    public int getGrossSalesPerWeek() {
        return grossSalesPerWeek;
    }

    public int getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return "SalesPerson{" +
                "name='" + name + '\'' +
                ", grossSalesPerWeek= $" + grossSalesPerWeek +
                ", weeklySalary= $" + weeklySalary +
                '}';
    }
}
