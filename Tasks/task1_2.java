package Tasks;

public class task1_2 {
    public static boolean isPalindrome(String str) {
        String strReplaced = str.replaceAll("[^a-zA-Z0-9]", "");
        int strLength = strReplaced.length();
        String firstHalf, secondHalf, reversedSecond;
        if (strLength % 2 == 0) {
            firstHalf = strReplaced.substring(0, strLength/2);
            secondHalf = strReplaced.substring(strLength/2);
        } else {
            int midChar = (strLength/2) + 1;
            firstHalf = strReplaced.substring(0, midChar -1 );
            secondHalf = strReplaced.substring(midChar);

        }
        reversedSecond = new StringBuilder(secondHalf).reverse().toString();
        return firstHalf.toLowerCase().equals(reversedSecond.toLowerCase());
    }

    public static void main(String[] args) {
        String str1 = "";

        System.out.println(str1 + " is a palindrome: " + isPalindrome(str1));
    }
}
