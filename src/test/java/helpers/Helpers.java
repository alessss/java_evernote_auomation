package helpers;

public class Helpers {
    public static int extractDigit(String str){
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int number = Integer.parseInt(sb.toString());
        return number;
    }
}
