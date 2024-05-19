package kth.se.IV1350.PointOfSale.exceptions;

/**
 * class that throwing exception when Item could not be found in inventory system.
 */
public class ItemNotFoundException extends Exception {

    /**
     *constructor for ItemNotFoundException with specified message.
     * @param message the message that shows when item not be fined.
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
}
