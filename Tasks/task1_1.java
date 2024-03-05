package Tasks;

public class task1_1 {
    public static int countMultiplesOfFourOrSix(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 4 == 0 || num % 6 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 6, 8, 12, 15, 18, 20, 24, 30};
        int result = countMultiplesOfFourOrSix(numbers);
        System.out.println("Number of values that are a multiple of either 4 or 6: " + result);
    }
}
