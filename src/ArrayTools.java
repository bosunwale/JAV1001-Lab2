import java.util.Arrays;
import java.util.Scanner;

public class ArrayTools {

    /*
    Variable is declared final to avoid
    overriding. It is declared out of the
    main method, so it can be called in methods
     */
    public static final String alphabets = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int arraySize, searchValue;
        int encryptKey, decryptKey;
        int[] number;
        String arrays;
        String encryptMessage, decryptMessage;

        /*This is the encryption display
        messages for the user
         */
        System.out.println("***Welcome***");
        System.out.println("Enter text for encryption");
        encryptMessage = userInput.nextLine();
        System.out.println("Enter value to shift");
        encryptKey = userInput.nextInt();
        System.out.println("The encrypted text is "+ CeaserCipherEncrypt(encryptMessage, encryptKey) +"\n");

        /*This is decryption display
        messages for the user
         */
        System.out.println("Enter text for decryption");
        decryptMessage = userInput.next();
        System.out.println("Enter value to shift");
        decryptKey = userInput.nextInt();
        System.out.println("The decrypted text is "+ CeaserCipherEncrypt(decryptMessage, decryptKey) +"\n");

        /*This is the array display messages
        to the user.

        Assigning an array of int with arraySize
        to variable number. The arraySize variable
        is the size of the array the user likes.
        Therefore, an array of int x size declared
        by user is created

        To know the length of the array, for-loop
        is called. With for-loop, the number of
        elements the user enters into the array
        will be kept together in the arraySize
        specified by user.
         */
        System.out.println("Enter the number of element of array you like");
        arraySize = userInput.nextInt();
        number = new int[arraySize];
        System.out.println("Enter the "+ arraySize +" elements you like");
        for(int i = 0; i < number.length; i++){
            number[i] = userInput.nextInt();
        }
        System.out.println("Here is your array: "+ Arrays.toString(number) +"\n" +
                "The average of the element in your array is: "+ ArrayAverage(number));
        /*
        This is the code to display what a user
        wants to search for
         */
        System.out.println("Enter the value to search for");
        searchValue = userInput.nextInt();
        SearchForArray(number, searchValue);
        ReverseArray(number);

    }
        /*
        Below, you will see the methods created
        to calculate for the sum and average of
        the elements in the array, to check if
        an element exist in the array, and the
        ceaser encrypt.
        */
    public static int SumArray(int[] arraySum){
        int sum = 0;
        for(int numbers : arraySum){
            sum = sum + numbers;
        }
        return sum;
    }

    public static int ArrayAverage(int[] arrayAverage){
        int average = SumArray(arrayAverage);
        return average / arrayAverage.length;
    }

    public static void ReverseArray(int[] reverseArray){
        int i;
        String reverseResult;
        for (i = reverseArray.length-1; i >= 0; i--){
            reverseResult = String.valueOf(reverseArray[i]);
            System.out.println(reverseResult);
        }
    }

    public static void SearchForArray(int[]arrayElements, int checkArrayValue){
        boolean check = false;
        for(double elements : arrayElements){
            if (elements == checkArrayValue) {
                check = true;
                break;
            }
        }
        if(check){
            System.out.printf("Yes, "+ checkArrayValue +" exist in the array\n");
        }else{
            System.out.printf("No, "+ checkArrayValue +" does not exist in the array\n");
        }
    }

    public static String CeaserCipherEncrypt(String text, int shiftValue){
        StringBuilder textCipher = new StringBuilder();
        int keyValue, characterPosition;
        char replaceValue;
        text = text.toLowerCase();
        for(int i = 0; i < text.length(); i++){
            characterPosition = alphabets.indexOf(text.charAt(i));
            keyValue = (shiftValue + characterPosition) % 26;
            replaceValue = alphabets.charAt(keyValue);
            textCipher.append(replaceValue);
        }
        return textCipher.toString();
    }
}
