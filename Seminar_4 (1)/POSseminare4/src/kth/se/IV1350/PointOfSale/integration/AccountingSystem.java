package kth.se.IV1350.PointOfSale.integration;
import kth.se.IV1350.PointOfSale.model.ItemDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountingSystem {

    private List<ItemDTO> soldItemsList = new ArrayList<ItemDTO>();

    /**
     * Adds a list of sold items to the accounting system.
     *
     * @param soldItems A list of ItemDTO objects representing the items that have been sold.
     */
    public void addSoldItems( List<ItemDTO> soldItems ) {

        this.soldItemsList.addAll(soldItems);
    }

    /**
     * Retrieves the list of sold items from the accounting system.
     *
     * @return The list of sold items.
     */
    public List<ItemDTO> getSoldItemsList() {
        return soldItemsList;
    }
}
