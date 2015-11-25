import org.junit.After;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.Scanner;

import static org.junit.Assert.*;

public class PalindromeCheckerTest {

    @Test
    public void checkPalindromeTestObject(){
        PalindromeChecker testObject = new PalindromeChecker();
        assertNotNull(testObject);
    }
    @Test
    public void checkPalindromeTestObject_YesPalindrome(){
        PalindromeChecker testObject = new PalindromeChecker();
        assertTrue(testObject.isAPalindrome("MOM"));
    }
    @Test
    public void checkPalindromeTestObject_NOtPalindrome(){
        PalindromeChecker testobject = new PalindromeChecker();
        assertFalse(testobject.isAPalindrome("blah"));
    }
    @Test
    public void complexPalindromeTestObject_NOtPalindrome(){
        PalindromeChecker testobject = new PalindromeChecker();
        assertFalse(testobject.isAPalindrome("gffhsdfadsgsfh"));
    }



}