package kth.se.IV1350.PointOfSale.startup;
import kth.se.IV1350.PointOfSale.controller.Controller;
import kth.se.IV1350.PointOfSale.exceptions.DatabaseFailureException;
import kth.se.IV1350.PointOfSale.exceptions.ItemNotFoundException;
import kth.se.IV1350.PointOfSale.integration.AccountingSystem;
import kth.se.IV1350.PointOfSale.integration.InventorySystem;
import kth.se.IV1350.PointOfSale.integration.Printer;
import kth.se.IV1350.PointOfSale.view.ErrorFileException;
import  kth.se.IV1350.PointOfSale.view.View;


/**
 * Main entry point of the application.
 * Initializes the necessary components and starts the application.
 */
public class Main {

    public static void main(String[] args ) throws ItemNotFoundException , DatabaseFailureException {


        Printer printer = new Printer();
        InventorySystem inventorySystem = new InventorySystem();
        AccountingSystem accountingSystem = new AccountingSystem();
        Controller contr = new Controller(accountingSystem,inventorySystem ,printer);
        View view = new View(contr);
        ErrorFileException errorFileExc = new ErrorFileException();
        view.runFakeExecution();



    }
}