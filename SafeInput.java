import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do {
            System.out.print("\n" +prompt + ":");
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        Scanner in = new Scanner(System.in);
        int getint = 0;
        String trash = "";
        do {
            System.out.print(prompt);
            if (in.hasNextInt()) {
                getint = in.nextInt();
            } else {
                trash = in.nextLine();
                System.out.println("\nThe value you inputted was: " + trash);
                System.out.println("Please put in a valid integer!");
            }
        }while(getint == 0);

        return getint;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        Scanner in = new Scanner(System.in);
        double getdouble = 0;
        String trash = "";
        do {
            System.out.print(prompt);
            if (in.hasNextDouble()) {
                getdouble = in.nextDouble();
            } else {
                trash = in.nextLine();
                System.out.println("\nThe value you inputted was: " + trash);
                System.out.println("Please put in a valid number!");
            }
        }while(getdouble == 0);

        return getdouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        Scanner in = new Scanner(System.in);
        int getrangedint = 0;
        String trash = "";
        boolean check = false;
        do {
            System.out.print(prompt);
            if (in.hasNextInt()) {
                getrangedint = in.nextInt();
                if (getrangedint >= low && getrangedint <= high) {
                    check = true;
                }
                else {
                    System.out.println("Sorry, but the number is not between " + low + " and " + high + ". Please try again.");
                }
            } else {
                trash = in.nextLine();
                System.out.println("\nThe value you inputted was: " + trash);
                System.out.println("Please put in a valid number!");
                System.exit(0);
            }
        }while(!check);

        return getrangedint;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        Scanner in = new Scanner(System.in);
        double rangedDouble = 0.0;
        String trash = "";
        boolean check = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextDouble()) {
                rangedDouble = pipe.nextDouble();
                if (rangedDouble >= low && rangedDouble <= high) {
                    check = true;
                } else {
                    System.out.println("Sorry, but the number is not between " + low + " and " + high + ". Please try again.");
                }
            } else {
                trash = pipe.nextLine(); // Consume the invalid input
                System.out.println("\nThe value you inputted was: " + trash);
                System.out.println("Please put in a valid number!");
            }
        } while (!check);

        return rangedDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        boolean getYNConfirm = false; // default value

        do {
            System.out.print(prompt + " (Y/N): ");
            input = pipe.next();

            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                getYNConfirm = true;
                break;
            } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                getYNConfirm = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter 'Y', 'N', 'Yes', or 'No'.");
            }
        }while(true);

        return getYNConfirm;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String value = "";
        boolean gotAValue = false;

        do
        {
            // show the prompt
            System.out.print(prompt + ": ");
            // input the data
            value = pipe.nextLine();
            // test to see if it is correct
            if(value.matches(regExPattern))
            {
                // We have a match this String passes!
                gotAValue = true;
            }
            else
            {
                System.out.println("\nInvalid input: " + value);
            }

        }while(!gotAValue);

        return value;
    }

}
