package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseMenu implements Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private List<String> options;
    private Library library;

    public BaseMenu(Library library) {
        options = new ArrayList<>();
        options.add("Checkout");
        options.add("Return");
        this.library = library;
    }

    public void showOptions() {
        for (String option : options) {
            ConsoleView.showMessage(option);
        }
    }

    public boolean isChoiceValid(String option) {
        return options.contains(option);
    }

    public String getChoice() {
        String choice;
        do {
            showOptions();
            choice = scanner.next();
        }
        while(!isChoiceValid(choice));
        return choice.trim();
    }

    public void handleChoice(String choice) {

        if (choice.equals("Checkout")) {
            // library.checkoutItem(...)
            System.out.println("checkout...");
        } else if(choice.equals("Return")) {
            // library.returnItem(...)
            System.out.println("return...");
        }
    }

    public static void main(String[] args) {
        BaseMenu menu = new BaseMenu(new Library());
        String choice = menu.getChoice();
        menu.handleChoice(choice);
    }
}
