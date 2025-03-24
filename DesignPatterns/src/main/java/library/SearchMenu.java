package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchMenu implements Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private Menu menu;
    private Library library;
    private List<String> searchOptions;

    public SearchMenu(Menu menu, Library library) {
        this.menu = menu;
        this.library = library;
        searchOptions = new ArrayList<>();
        searchOptions.add("BookSearch");
        searchOptions.add("MagazineSearch");
    }

    public boolean isChoiceValid(String option) {
        return menu.isChoiceValid(option) || searchOptions.contains(option);
    }

    public void showOptions() {
        menu.showOptions();
        for (String option : searchOptions) {
            ConsoleView.showMessage(option);
        }
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

    @Override
    public void handleChoice(String choice) {
        if(choice.equals("BookSearch")) {
            // library.searchBooks(...)
            System.out.println("book search...");
        } else if(choice.equals("MagazineSearch")) {
            // library.searchMags(...)
            System.out.println("magazine search...");
        } else {
            menu.handleChoice(choice);
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Menu menu = new BaseMenu(library);


        Menu searchMenu = new SearchMenu(menu, library);
        String choice = searchMenu.getChoice();
        searchMenu.handleChoice(choice);
    }


}
