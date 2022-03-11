package strings.problems;

public class DigitsSumFromString {
    public static int returnSum(String originalString) {
        int sum = 0;

        for (int i = 0; i < originalString.length(); i++) {
            char character = originalString.charAt(i);
            if (Character.isDigit(character)) {
                /*String s= String.valueOf(character);
                Integer integer= Integer.parseInt(s);
                sum+=integer;*/
                sum += Integer.parseInt(String.valueOf(character));
            }
        }
        return sum;
    }

    public static int returnSUmOfNumbers(String string) {
        int sum = 0;
        String[] strings = string.split("[^0-9]");
        for (String s : strings) {
            if (!s.equals("")) {
                System.out.println(s);
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }
}
