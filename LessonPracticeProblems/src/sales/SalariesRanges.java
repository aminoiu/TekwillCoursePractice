package sales;

public enum SalariesRanges {
    R1(200, 299),
    R2(300, 399),
    R3(400, 499),
    R4(500, 599),
    R5(600, 699),
    R6(700, 799),
    R7(800, 899),
    R8(900, 999),
    R9(1000, 0);


    private final int minValue;
    private final int maxValue;

    private SalariesRanges(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
