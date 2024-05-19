package kth.se.IV1350.PointOfSale.view;
import kth.se.IV1350.PointOfSale.controller.Controller;
import kth.se.IV1350.PointOfSale.integration.*;
import kth.se.IV1350.PointOfSale.model.*;
import kth.se.IV1350.PointOfSale.startup.*;
import kth.se.IV1350.PointOfSale.exceptions.*;
 import kth.se.IV1350.PointOfSale.view.ErrorFileException;
/**
 * Represents the user interface of the system.
 * Interacts with the Controller to perform system operations.
 */

public class View {
    private Controller contr;

    /**
     * Constructs a new View object with the specified Controller.
     *
     * @param contr The Controller object responsible for handling user interactions.
     */
    public View(Controller contr)
    {
        this.contr = contr;
        contr.addSaleObserver(new TotalRevenueView());
        contr.addSaleObserver(new TotalRevenueFileOutput());
    }



    /* Implementing a false abstraction as we are unable to create a genuine VY.
    This method involves invoking all system operations within the controller.
    */
    public void runFakeExecution() throws  ItemNotFoundException, DatabaseFailureException{
try {
    System.out.println("a new sale has been started");
    contr.startSale();
    System.out.println("cashier scans items:\n");
    System.out.println("add item 1:\n");
    ItemDTO item1 = contr.scanItem("abc123");

    System.out.println("itemName:" + item1.getItemName() + "\n"
            + "itemID:" + item1.getItemID() + "\n"
            + "itemPrice:" + item1.getPrice() + " SEK" + "\n"
            // + "ItemQuantity:" + item1.getItemQuantity() + "\n"
            + "itemVat:" + item1.getVat() + "\n"
            + "itemDescription:" + item1.getItemDescription() + "");


    System.out.println("\nadd item 2:\n");

    ItemDTO item2 = contr.scanItem("def456");
    System.out.println("itemName:" + item2.getItemName() + "\n"
            + "itemID:" + item2.getItemID() + "\n"
            + "itemPrice:" + item2.getPrice() + " SEK" + "\n"
            + "itemVat:" + item2.getVat() + "\n"
            + "itemDescription:" + item2.getItemDescription() + "");

    System.out.println("\nadd item 3:\n");
    ItemDTO item3 =  contr.scanItem("xxxx");

    System.out.println("itemName:" + item3.getItemName() + "\n"
            + "itemID:" + item3.getItemID() + "\n"
            + "itemPrice:" + item3.getPrice() + " SEK" + "\n"
            //  + "ItemQuantity:" + item3.getItemQuantity() + "\n"
            + "itemVat:" + item3.getVat() + "\n"
            + "itemDescription:" + item3.getItemDescription() + "");

    System.out.println("\nadd item 4:\n");

    ItemDTO item4 =  contr.scanItem("ghi789");
    System.out.println("itemName:" + item4.getItemName() + "\n"
            + "itemID:" + item4.getItemID() + "\n"
            + "itemPrice:" + item4.getPrice() + " SEK" + "\n"
            // + "ItemQuantity:" + item4.getItemQuantity() + "\n"
            + "itemVat:" + item4.getVat() + "\n"
            + "itemDescription:" + item4.getItemDescription() + "");



    System.out.println("\nadd item 5:\n");
    ItemDTO item5 =  contr.scanItem("def456");
    System.out.println("itemName:" + item5.getItemName() + "\n"
            + "itemID:" + item5.getItemID() + "\n"
            + "itemPrice:" + item5.getPrice() + " SEK" + "\n"
            // + "ItemQuantity:" + item5.getItemQuantity() + "\n"
            + "itemVat:" + item5.getVat() + "\n"
            + "itemDescription:" + item5.getItemDescription() + "");

    System.out.println("\nadd item 6:\n");
    ItemDTO item6 =  contr.scanItem("ghi789");
    System.out.println("itemName:" + item6.getItemName() + "\n"
            + "itemID:" + item6.getItemID() + "\n"
            + "itemPrice:" + item6.getPrice() + " SEK" + "\n"
            // + "ItemQuantity:" + item6.getItemQuantity() + "\n"
            + "itemVat:" + item6.getVat() + "\n"
            + "itemDescription:" + item6.getItemDescription() + "");


    System.out.println("\nadd item 7:\n");
    ItemDTO item7 = contr.scanItem("abc123");
    System.out.println("itemName:" + item7.getItemName() + "\n"
            + "itemID:" + item7.getItemID() + "\n"
            + "itemPrice:" + item7.getPrice() + " SEK" + "\n"
            // + "ItemQuantity:" + item7.getItemQuantity() + "\n"
            + "itemVat:" + item1.getVat() + "\n"
            + "itemDescription:" + item7.getItemDescription() + "");


    }catch( ItemNotFoundException e){
    System.out.println("Could not find the item:" + e.getMessage());
    ErrorFileException.getError(e);
    }catch (DatabaseFailureException e){
    System.out.println("Could not connect database: " + e.getMessage());
    ErrorFileException.getError(e);
    }


        double totalPrice =   contr.endSale();
        System.out.printf("\nTotal Price is: %.2f SEK%n ",totalPrice);

        double paid = contr.payment(500);
        System.out.printf("Customer paid: %.2f SEK%n ",paid);
        contr.printOutTheReciept();


    }
}
