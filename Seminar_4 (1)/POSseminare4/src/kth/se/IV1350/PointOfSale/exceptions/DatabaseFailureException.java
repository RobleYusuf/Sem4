package kth.se.IV1350.PointOfSale.exceptions;

/**
 * the class that throws exception when conneting to database failed
 */
public class DatabaseFailureException extends Exception {
    /**
     * constructor for DatabaseFailureException.
     * @param message the message that describes the reason for exception
     */
    public DatabaseFailureException(String message) {
        super(message);
    }
}
