package library;

/**
 * Concrete class that represents a Magazine.
 *
 * Magazine inherits all functionality from {@link Publication Publication} and from {@link LibraryItem LibraryItem}
 *
 */
public class Magazine extends Publication {

    private int volume;

    /**
     * Construct a Magazine object.
     * @param title
     * @param pageCount
     * @param volume
     */
    public Magazine(String title, int pageCount, int volume) {
        super(title, pageCount);
        this.volume = volume;
    }

    @Override
    public String toString() {
        String partial = super.toString();
        return "Volume: " + volume + ", "
                + partial;
// title pagecount from Publication
    }

    public void read() {
        // TODO: implement this
    }

}
