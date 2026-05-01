public class Palindrome {
    public static void main(String[] args) {
//массив
        String[] testStrings = {
                "java",
                "Palindrome",
                "madam",
                "racecar",
                "apple",
                "kayak",
                "song",
                "noon noon"
        };

//цикл
        for (String s : testStrings) {
            if (isPalindrome(s)) {
                System.out.println(s + " - палиндром");
            } else {
                System.out.println(s + " - не палиндром");
            }
        }
    }

    //метод
    public static String reverseString(String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }

    //метод
    public static boolean isPalindrome(String s) {
        String clean = s.toLowerCase().replace(" ", "");
        String reversed = reverseString(clean);
        return clean.equals(reversed);
    }
}