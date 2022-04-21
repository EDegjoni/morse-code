package morse;

import java.util.*;
import java.util.regex.*;

/**
 * 
 * @author ASUS
 *
 */
public class morseTranslator {
	
	static int translationMode;
	static String phraseInput;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Initializing both arrays that hold our morse code and alphabet.
		 * then asking the user for their input.
		 */
		String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
				".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
				"...-", ".--", "-..-", "-.--", "--.."};
		
    	String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
    			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

		System.out.println("In this translator, English will be converted to Morse, and vice versa.\nPlease select what language you wish to translate.\n1. English.\n2. Morse.");
		Scanner input = new Scanner(System.in);
		int selectionInput = input.nextInt();
		
		/**
		 * If/else statement to check which translation option the user selected.
		 * Changes the value of translationMode accordingly, then asks for sentence input.
		 */
		  if (selectionInput == 1) {
			  translationMode = 1;
			  System.out.println("English selected!\nPlease enter your English phrase to be translated:");
			  input = new Scanner(System.in);
			  phraseInput = input.nextLine();
		  }
		  else if (selectionInput == 2){
			  translationMode = 2;
			  System.out.println("Morse code selected!\nPlease enter your Morse code to be translated:");
			  input = new Scanner(System.in);
			  phraseInput = input.nextLine();
		  }
		  else {
			  System.out.println("Sorry, your input was invalid. Please try again.");
		  }
		
		/**
		 * Switch block that depends on the value of translationMode.
		 * Case 1 gives us English to Morse.
		 * Case 2 gives us Morse to English.
		 */
		switch(translationMode) {
		
		/**
		 * For loop with an if/else block nestled inside.
		 * While the for loop continues, x will gain the value of the sentence input char being iterated.
		 * If it's a single space, it gets replaced with 3 spaces.
		 * Otherwise, each letter gets printed out in morse form, with a space in between.
		 */
		case 1: {
			phraseInput = phraseInput.toUpperCase();
            
            for (int i = 0; i < phraseInput.length(); i++) {
                char x = phraseInput.charAt(i);
                if (x == ' ') {
                	System.out.print("  ");
                }
                else {
                	System.out.print(morse[x - 'A'] + " ");
                }
            }
            System.out.println("\nThank you for your patronage. Come back any time!");
            break;
		}
		
		/**
		 * Defining a pattern and matcher to search for morse code input.
		 * While loop that keeps going while there are still morse letters to be matched.
		 * Integer y gains the value of the index of the code currently being matched in the morse array.
		 * It then gets printed out by being matched with its corresponding alphabet letter.
		 */
		case 2: {
			Pattern morsePatt = Pattern.compile("[\\.-]+");
            Matcher morseMatch = morsePatt.matcher(phraseInput);
            
            while (morseMatch.find()) {
                int y;
                y = Arrays.asList(morse).indexOf(morseMatch.group());
                System.out.printf(alphabet[y]);
	             }
                }
		System.out.println("\nThank you for your patronage. Come back any time!");
		break;
		
	default:
		}
		
	}

}
