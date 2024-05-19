package kth.se.IV1350.PointOfSale.model;

public class ItemDTO {

    private String itemID;
    private String itemName;
    private int itemQuantity;
    private  double price;
    private double vat;
    private String itemDescription;
    private int quantity;
    /**
     * Constructs a new ItemDTO object with the specified details.
     *
     * @param itemID The ID of the item.
     * @param itemName The name of the item.
     * @param itemQuantity The quantity of the item.
     * @param price The price of the item.
     * @param vat The VAT rate of the item.
     * @param itemDescription The description of the item.
     */

    public ItemDTO (String itemID , String itemName , int itemQuantity , double price , double vat,String itemDescription ) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemQuantity  = itemQuantity;
        this.price = price;
        this.vat = vat;
        this.itemDescription = itemDescription;

    }
    /**
     * method returns the itemID.
     * @return itemID
     */
    public String getItemID() {
        return itemID;
    }
    /**
     * method returns the name of item.
     * @return the name of item
     */
    public String getItemName() {
        return itemName;
    }
    /**
     * method returns the item description.
     * @return item description
     */
    public String getItemDescription() {
        return itemDescription;
    }
    /**
     * Returns the quantity of this item in stock.
     *
     * @return The quantity of this item in stock.
     */
    public int getItemQuantity() {
        return itemQuantity;
    }
    /**
     * method returns the item price.
     * @return item Price
     */
    public double getPrice() {
        return price;
    }
    /**
     * method returns the item vat.
     * @return item vat
     */
    public double getVat() {
        return vat;
    }

    /**
     *  Metod för att sätta kvantiteten
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * This method increases the quantity of an item.
     * @param addQuantity The quantity to be added to the existing item.
     */

    public void increaseQuantity (int addQuantity) {
        this.quantity +=  addQuantity;


    }
    /**
     * Returns the quantity of items sold.
     *
     * @return The quantity of items sold.
     */
    public int getQuantity(){
        return quantity;
    }
}
