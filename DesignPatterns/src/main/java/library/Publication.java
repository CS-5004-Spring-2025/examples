package library;

/**
 * Super class for items in the library that are publications, like books and magazines.
 * This is in contrast to items that may be media (LPs or CDs) or tools (hammers or saws).
 */
public abstract class Publication extends LibraryItem {

    protected int pageCount;
    protected String title;

    /**
     * Construct a Publication with a given title and page count.
     *
     * @param title title of the publication
     * @param pageCount number of pages
     */
    public Publication(String title, int pageCount) {
        this.pageCount = pageCount;
        this.title = title;
        this.isCheckedOut = false; // defaults to false
    }

    /**
     * Return the title.
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return the page count.
     * @return
     */
    public int getPageCount() {
        return pageCount;
    }


    public int compareTo(Publication publication) {
        return this.title.compareTo(publication.title);
    }

    /**
     * Abstract classes can have abstract methods that must be implemented by concrete child classes.
     */
    public abstract void read();

    @Override
    public String toString() {
        return "Publication{" +
                "pageCount=" + pageCount +
                ", title='" + title + '\'' +
//                ", holder=" + holder +
                ", isCheckedOut=" + isCheckedOut +
                '}';
    }
}
