package kth.se.IV1350.PointOfSale.integration;
import kth.se.IV1350.PointOfSale.model.*;
public class Printer {
    /**
     * Initializes a new Printer object.
     */
    public Printer() {

    }

    /**
     * this method is printed out the receipt
     * @param receiptDTO.
     */
    public static void printoutReceipt(Reciept receipt)
    {
        System.out.println(receipt.ToString());
        //System.out.println(receipt.toString());

    }

}
