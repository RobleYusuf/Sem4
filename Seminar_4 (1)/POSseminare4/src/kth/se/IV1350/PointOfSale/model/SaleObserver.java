package kth.se.IV1350.PointOfSale.model;

/**
 * this interface class define sale observer
 * it used by classes that observe new sale
 */
public interface SaleObserver {
        /**
         * method that will be called when new sale occurs.
         * @param totalAmount the total amount of new sale
         */
        public void newSale(double totalAmount);

}
