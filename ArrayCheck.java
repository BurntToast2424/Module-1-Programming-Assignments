import java.util.Scanner;

public class ArrayCheck {
    //** Checks if two 3x3 arrays are the same */
    public static boolean equals(int[][] m1, int[][] m2) 
    {
        // Check if equal
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (m1[i][j] != m2[i][j])
                {
                    return false;
                }
            }
        }
  		
        // Returns true if nothing was inequal
        return true;
    }

    //** Prompts input for two 3x3 arrays, and checks if the are the same or not */
    public static void main(String[] args)
    {
        // Create objects
        Scanner input = new Scanner(System.in);
        int[][] list1 = new int[3][3];
        int[][] list2 = new int[3][3];

        // Prompt user
        System.out.print("Enter list1: ");

        // Set array 1
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                list1[i][j] = input.nextInt();
            }
        }

        // Prompt user
        System.out.print("Enter list2: ");

        // Set array 2
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                list2[i][j] = input.nextInt();
            }
        }

        // Check arrays
        boolean Equal = equals(list1, list2);

        if (Equal)
        {
            System.out.println("They are identical.");
        }
        else
        {
            System.out.println("They are not identical.");
        }
    }
}
