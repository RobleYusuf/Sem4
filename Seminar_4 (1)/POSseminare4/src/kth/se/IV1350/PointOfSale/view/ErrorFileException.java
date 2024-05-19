package kth.se.IV1350.PointOfSale.view;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ErrorFileException class creates a log file for all exceptions that occur during sale.
 */
public class ErrorFileException {
private static PrintWriter logFileExc ;

    /**
     * this class creates ErrorFile when an exceptions is caught.
     */
    public ErrorFileException(){
    try{
        logFileExc = new PrintWriter ( new FileWriter ( "ErrorExceptionsFile.txt", true), true);
    }catch (IOException exc){
        System.out.println(" could not write to file");
        exc.printStackTrace();
    }
}

    /** the method getError writes exception accorded in to the ErrorExceptionsFile.
     *
     * @param exc the typ of exception which accorded.
     */
    public static void getError( Exception exc){

    logFileExc.println("Error: " + exc.getMessage());

}
}
