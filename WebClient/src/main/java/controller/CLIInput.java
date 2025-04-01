package controller;

import java.util.Scanner;

public class CLIInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getLocation() {
        System.out.println("Where are you located? ");
        return scanner.nextLine();
    }

    public static boolean getGoAgain() {
        System.out.println("Go Again? ");
        String result = scanner.nextLine().trim();
        while(!validResult(result)) {
            System.out.println(result.trim());
            System.out.println("Invalid input! Try again.");
            System.out.println("Go Again? ");
            result = scanner.nextLine();
        }
        return result.equals("yes");
    }

    private static boolean validResult(String result) {
        return result != null
                && (result.equals("yes")
                || result.equals("no"));
    }

}
