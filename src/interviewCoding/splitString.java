import java.util.ArrayList;
import java.util.List;

public class splitString {
    public static void main(String[] args) {
        String input = "ab13d-98r";
        List<Integer> maxSumNumbers = new ArrayList<>();
        System.out.println("Numbers contributing to the maximum sum: " + maxSumNumbers);
    }

    private static List<Integer> findMaxSumNumbers(String input) {
        StringBuilder number = new StringBuilder();
        List<Integer> currentNumbers = new ArrayList<>();
        List<Integer> maxSumNumbers = new ArrayList<>();
        int maxSum = 0;
        int currentSum = 0;

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch) || ch == '-') {
                number.append(ch);
            } else {
                if (number.length() > 0) {
                    int num = Integer.parseInt(number.toString());
                    currentSum += num;
                    currentNumbers.add(num);
                    number = new StringBuilder();
                }
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSumNumbers = new ArrayList<>(currentNumbers);
                }
            }
        }

        if (number.length() > 0) {
            int num = Integer.parseInt(number.toString());
            currentSum += num;
            currentNumbers.add(num);
        }

        if (currentSum > maxSum) {
            maxSumNumbers = new ArrayList<>(currentNumbers);
        }

        return maxSumNumbers;
    }
}
