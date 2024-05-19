package kth.se.IV1350.PointOfSale.controller;
import kth.se.IV1350.PointOfSale.exceptions.DatabaseFailureException;
import kth.se.IV1350.PointOfSale.integration.AccountingSystem;
import kth.se.IV1350.PointOfSale.integration.InventorySystem;
import kth.se.IV1350.PointOfSale.exceptions.ItemNotFoundException;
import kth.se.IV1350.PointOfSale.integration.Printer;
import kth.se.IV1350.PointOfSale.model.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Sale sale;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private Printer printer;
    private List <SaleObserver>SaleObserverList = new ArrayList<>();


    /**
     * Constructor for the Controller class.
     *
     * @param accountingSystem The accounting system to be used by the controller.
     * @param inventorySystem The inventory system to be used by the controller.
     * @param printer The printer to be used by the controller.
     */


    public Controller(AccountingSystem accountingSystem ,InventorySystem inventorySystem , Printer printer ) {
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem ;
        this.printer = printer;
    }

    /**
     * This method to start new sale.
     */

    public void startSale() {

        this.sale = new Sale();
        sale.addSaleObserver(SaleObserverList);
    }
    /**
     * Scans an item with the given item ID and quantity.
     * If the item is found in the inventory system, its quantity is increased by the given amount.
     * The item is then added to the sale list.
     * @param  itemID The ID of the item to be scanned.
     *.
     */


    public ItemDTO scanItem(String itemID) throws ItemNotFoundException, DatabaseFailureException{

        try {
            ItemDTO scannedItem = inventorySystem.getItemInfo(itemID);
            sale.addItemToList(scannedItem);
            return scannedItem;
        }catch (ItemNotFoundException e) {
           throw e;
        }catch(DatabaseFailureException e){
            throw new DatabaseFailureException( e.getMessage());
        }

        }




    /**
     *  Ends the current sale and prints out the total price of the sale.
     */

    public double endSale() {
        double totalPrice = sale.getTotalPrice();

        return totalPrice;

    }

    /**
     * the payment method show how much the customer have paid
     * @param amountPaid is the amount money the customer have paid.
     */
    public double payment(double amountPaid) {
        sale.setAmountPaid(amountPaid);
        double paid = sale.getAmountPaid();

        return paid;
    }

    /**
     * updatedExternalSystems methods updates the externalSystem  with information about sold items
     * efter that removes the sold items from the inventory system and also saves them into the accounting system.
     */
    public void updatedExternalSystems() {
        inventorySystem.updatedTheSoldItems(sale.getListOfItems());
        accountingSystem.addSoldItems(sale.getListOfItems());

    }
    /**
     * this methods prints out receipt
     */
    public void printOutTheReciept() {
        sale.printReceipt(printer , sale);
    }

    /**
     * this method adds Sale observer in sale observer list.
     * @param obs sale observer to be added
     */
    public void addSaleObserver( SaleObserver obs){
    SaleObserverList.add(obs);
}

}
