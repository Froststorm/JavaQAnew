import java.util.Scanner;

  public class PalindromeChecker{
        public boolean isAPalindrome(String string)
        {
            StringBuffer reversedString = new StringBuffer(string);
            String reverse = reversedString.reverse().toString();
            if (reverse.equalsIgnoreCase(string)) {
                return true;
            }
            return false;

        }

}
