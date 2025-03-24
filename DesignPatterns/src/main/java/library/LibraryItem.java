package library;

import java.util.UUID;

/**
 * An interface that describes the behavior that any item in a library must support.
 */
public abstract class LibraryItem {

    protected CardHolder holder;
    protected boolean isCheckedOut;
    protected String id;

    public LibraryItem() {
        this.holder = null;
        this.isCheckedOut = false;
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Determine whether the item is checked out.
     *
     * @return true if the item is checked out and false otherwise.
     */
    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    /**
     * Check out the item.
     * If the item is already checked out the method will return false.
     *
     * @return true if the checkout was successful
     */
    public boolean checkoutItem(CardHolder holder) {
        if (isCheckedOut) {
            return false;
        }
        isCheckedOut = true;
        this.holder = holder;
        return true;
    }

    /**
     * Return the item.
     * If the item is bot checked out the method will return false.
     *
     * @param holder the current holder of the item
     * @return true if the return was successful
     */
    public boolean returnItem(CardHolder holder) {
        if (isCheckedOut && holder != null && holder.equals(this.holder)) {
            isCheckedOut = false;
            holder.removeCheckedOutItem(this);
            holder = null;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "holder=" + holder +
                ", isCheckedOut=" + isCheckedOut +
                '}';
    }
}
