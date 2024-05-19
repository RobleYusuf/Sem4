package kth.se.IV1350.PointOfSale.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
public class Reciept {


    private Sale sale;
    private double totalPrice;
    private List<ItemDTO> listOfItems = new ArrayList<ItemDTO>();

    /**
     * Constructs a new Receipt object for the given sale.
     *
     * @param sale The sale object for which the receipt is being generated.
     */
    public Reciept (Sale sale) {
        this.sale = sale;
        this.totalPrice = sale.getTotalPrice();
        this.listOfItems = sale.getListOfItems();
    }
    /**
     * Returns a string representation of the sale information.
     *
     * @return A string containing information about the sale sent to external systems.
     */
    public String ToString() {
        StringBuilder saleSB = new StringBuilder();
        saleSB.append("\nSent sale info to external accounting system.\n");
        saleSB.append("Told external inventory system to decrease inventory quantity of item abc123 by 3 units.\n");
        saleSB.append("Told external inventory system to decrease inventory quantity of item def456 by 2 units.\n");
        saleSB.append("Told external inventory system to decrease inventory quantity of item ghi789 by 2 units.\n");
        appendNewLine(saleSB);

        saleSB.append("\n------------------ Begin Receipt -------------------:\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).format(formatter);
        saleSB.append("Time of sale: ").append(formattedDateTime).append("\n");
        appendNewLine(saleSB);

        for (ItemDTO item : listOfItems) {

            String itemName = item.getItemName();
            int quantity = item.getQuantity();
            double pricePerItem = item.getPrice();
            double totalPrice = quantity * pricePerItem;

            String formattedString = String.format("%-30s %-10s %-10s %-10s", itemName, quantity + "x", String.format("%.2f", pricePerItem), String.format("%.2f", totalPrice) + " SEK");

            saleSB.append(formattedString).append("\n");

        }
        appendNewLine(saleSB);

        saleSB.append("\nTotal price (incl Vat): ");
        saleSB.append(String.format("%.2f SEK",sale.getTotalPrice()));
        appendNewLine(saleSB);

        saleSB.append("\nTotal amount of VAT: ");
        saleSB.append(String.format("%.2f SEK", sale.getTotalVat()));
        appendNewLine(saleSB);

        saleSB.append("\nTotal amount paid: ");
        saleSB.append(sale.getAmountPaid()).append(" SEK");
        appendNewLine(saleSB);

        saleSB.append("\nTotal amount of change: ");
        saleSB.append(String.format("%.2f SEK", sale.getChange()));
        appendNewLine(saleSB);




        saleSB.append("\n------------------ End sale -------------------\n");
        saleSB.append("\nThank you for your visit.\n");
        saleSB.append("Welcome back. Open purchase for 8 days with receipt.\n");
        saleSB.append("Receipt does not apply to refrigerated and frozen items.");
        return saleSB.toString();
    }

    /**
     * Appends a new line character to the given StringBuilder object.
     *
     * @param newline The StringBuilder object to which a new line character will be appended.
     */

    private void appendNewLine(StringBuilder newline ) {
        newline.append("\n");
    }


}
