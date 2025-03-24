package library;

import java.util.function.Predicate;

/**
 * Demonstrates a predicate.
 */
public class CheckedOutMagazinesPredicate implements Predicate<LibraryItem> {

    @Override
    public boolean test(LibraryItem magazine) {
        return magazine instanceof Magazine && magazine.isCheckedOut();
    }

}
