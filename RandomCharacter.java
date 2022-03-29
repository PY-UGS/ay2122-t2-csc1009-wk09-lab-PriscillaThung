import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class RandomCharacter {
    final static int LETTERS = 26;


    public static void main (String[] arg){
        for(int i = 0; i< 15;i++)
        {
            System.out.println("Get Random lower case letter: " + getRandomLowerCaseLetter());
            System.out.println("Get Random upper case letter: " + getRandomUpperCaseLetter());
            System.out.println("Get Random Digit: " + getRandomDigitCharacter());
            System.out.println("Get Random Character: " + getRandomCharacter());
        }
    }

    public static char getRandomLowerCaseLetter(){
        Random random = new Random();
        char c = (char)('a' + random.nextInt(LETTERS));
        return c;
    }

    public static char getRandomUpperCaseLetter(){
        Random random = new Random();
        char c = (char)('A' + random.nextInt(LETTERS));
        return c;
    }

    public static char getRandomDigitCharacter(){
        Random random = new Random();
        char c = (char)('0' + random.nextInt(9));
        return c; 
    }

    public static char getRandomCharacter(){
        char c = 0;
        Random random = new Random();
        int i = random.nextInt(3);
        switch (i){
            case 0:
            c = getRandomLowerCaseLetter();
            break;

            case 1:
            c = getRandomUpperCaseLetter();
            break;

            case 2:
            c = getRandomDigitCharacter();
            break;
        }
        return c;
    }

    public static boolean checkPrime(int digit)
    {
        int checkRemainder = 0;
        for(int i=2; i<= Math.sqrt(digit);i++)
        {
            checkRemainder = digit % i;
            if(checkRemainder==0)
            {
                return false;
            }
        }
        return true;
    }


    @Test
    public void testGetRandomLowerCaseLetter(){
        assertTrue(Character.isLowerCase(getRandomLowerCaseLetter()));
        assertFalse(Character.isLowerCase(getRandomUpperCaseLetter()));
        assertFalse(Character.isLowerCase(getRandomDigitCharacter()));
    }

    @Test
    public void testGetRandomUpperCaseLetter(){
        assertTrue(Character.isUpperCase(getRandomUpperCaseLetter()));
        assertFalse(Character.isUpperCase(getRandomLowerCaseLetter()));
        assertFalse(Character.isUpperCase(getRandomDigitCharacter()));
    }

    @Test
    public void testGetRandomDigit(){
        assertTrue(Character.isDigit(getRandomDigitCharacter()));
        assertFalse(Character.isDigit(getRandomLowerCaseLetter()));
        assertFalse(Character.isDigit(getRandomUpperCaseLetter()));
    }

    
    @Test
    public void testGetRandomCharacter(){
        assertTrue(Character.isLetterOrDigit(getRandomDigitCharacter()));
        assertFalse(Character.isLetterOrDigit('&'));
        assertFalse(Character.isLetterOrDigit(' '));
    }

    @Test
    public void testCheckPrime(){
        assertEquals(false, checkPrime(4));
        assertEquals(true, checkPrime(3));

    }

}
