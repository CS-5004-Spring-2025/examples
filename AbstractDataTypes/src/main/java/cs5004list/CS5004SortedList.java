package cs5004list;

// public class Book implements Comparable<Book>
public interface CS5004SortedList<T extends Comparable<T>> {

// CS5004SortedList<String> words = new LSDJFDSLKJF<>();
// List<Widget> widgets = new ArrayList<>();

    void insert(T t);

    int size();
}
