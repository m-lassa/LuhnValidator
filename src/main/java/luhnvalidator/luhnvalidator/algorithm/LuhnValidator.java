package luhnvalidator.luhnvalidator.algorithm;

public class LuhnValidator {

    /**
     * This method validates whether a given numeric string passes the Luhn algorithm conditions.
     * @param number
     * @return      true if the input is a valid credit card or ID number
     */
    public static boolean validateNumber(String number){
        /*
        Validation of user input: blank spaces are removed from the
        numeric string. Also, the code ensures that the input is numeric
         */
        number = number.replaceAll(" ", "");
        try{
            Long.parseLong(number);
        } catch (NumberFormatException e){
            System.out.println("Invalid input");
            return false;
        }

        int sum = 0;
        boolean alternateDigit = false;

        /*
        Starting from the right of the string, the code loops through each
        digit and multiplies every second digit by 2.
         */

        for(int i = number.length()-1; i >= 0; i--){
            int digit = Integer.parseInt(number.substring(i, i+1));
            if(alternateDigit){
                digit *= 2;
                if(digit > 9){
                    digit = 1 + (digit % 10);
                }
            }
            sum += digit;
            alternateDigit = !alternateDigit;
        }

        return (sum % 10 == 0);
    }
}
