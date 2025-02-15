package jsondemo.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class to demonstrate how to use the Jackson library to parse JSON.
 */
public class Book {

    // The data member names match the keys in the .json file
    @JsonProperty("author")
    private String author;

    @JsonProperty("title")
    private String title;

    @JsonProperty("pageCount")
    private int pageCount;

    /**
     * Jackson uses the default constructor and setter methods
     * to create a new object.
     */
    public Book() {}

    public Book(String author, String title, int pageCount) {
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Jackson uses the getter methods when writing to file.
     * @return
     */
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
}