import java.util.Scanner;

public class CardVerify
{
    /** Return true if the card number is valid */
    public static boolean isValid(long number)
    {
        // Verification vaariable
        int V = 0;
        boolean Valid = true;

        // Check prefix
        if (!prefixMatched(number, 4))
        {
            if (!prefixMatched(number, 5))
            {
                if (!prefixMatched(number, 37))
                {
                    if (!prefixMatched(number, 6))
                    {
                        V = 1;
                        Valid = false;
                    }
                }
            }
        }

        // Check card length
        if (getSize(number) < 13)
        {
            V = 2;
            Valid = false;
        }
        else if (getSize(number) > 16)
        {
            V = 2;
            Valid = false;
        }

        // Get sums
        int OddSum = sumOfOddPlace(number);
        int EvenSum = sumOfDoubleEvenPlace(number);
        int FinalSum = OddSum + EvenSum;

        // Checksum
        if (FinalSum % 10 != 0)
        {
            V = 3;
            Valid = false;
        }

        switch (V)
        {
            case 0: System.out.println("Valid"); break;
            case 1: System.out.println("Prefix failed"); break;
            case 2: System.out.println("Size failed"); break;
            case 3: System.out.println("Sum failed"); break;
        }

        // Return boolean
        return Valid;
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number)
    {
        // Settup variables
        int sum = 0;
        char d = 'a';
        int mDigit = 0;
        int digit = 0;
        String n = number + "";


        // Get size
        int L = getSize(number);

        // Add the digits
        for (int i = 0; i < L; i += 2)
        {
            d = n.charAt(i);
            mDigit = Integer.parseInt(String.valueOf(d)) * 2;
            digit = getDigit(mDigit);
            sum += digit;
        }
    
        // Return sum
        return sum;
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number)
    {
        // Make variable
        int Digit = number;

        // Turn 2 digits into 1
        if (number >= 10) 
        {
            String n = number + "";
            char n1 = n.charAt(0);
            char n2 = n.charAt(1);
            int N1 = Integer.parseInt(String.valueOf(n1));
            int N2 = Integer.parseInt(String.valueOf(n2));
            Digit = N1 + N2;
        }

        // Return digit
        return Digit;
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number)
    {
        // Settup variables
        int sum = 0;
        char d = 'a';
        int digit = 0;
        String n = number + "";

        // Get size
        int L = getSize(number);

        // Add the digits
        for (int i = 1; i < L; i += 2)
        {
            d = n.charAt(i);
            digit = Integer.parseInt(String.valueOf(d));
            sum += digit;
        }
    
        // Return sum
        return sum;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d)
    {
        // Convert d to string
        String D = d + "";

        // Get digits
        long prefix = getPrefix(number, D.length());
        String p = prefix + "";

        // Compare and return
        if (D.equals(p))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /** Return the number of digits in d */
    public static int getSize(long d)
    {
        // Convert d to string
        String D = d + "";

        // Return length
        return D.length();
    }

    /** Return the first k number of digits from number. If the
    * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k) 
    {
        // Converty to string
        String n = number + "";

        // Settup Variable
        String p = "";

        // Check length
        if (n.length() <= k)
        {
            p = n;
        }
        else
        {
            // Get digits
            for (int i = 0; i < k; i++)
            {
                p += n.charAt(i);
            }
        }

        // Return prefix
        return Long.parseLong(p);
    }

    /** Promt user for a number */
    public static void main(String[] args)
    {
        // Create scanner
        Scanner input = new Scanner(System.in);

        // Prompt user
        System.out.print("Enter credit card number: ");

        Long number = input.nextLong();

        // Perform check
        isValid(number);
    }
}
