package kth.se.IV1350.PointOfSale.view;
import kth.se.IV1350.PointOfSale.model.SaleObserver;

/**
 * the class totalRevenueView observe new sales
 * by implementing with saleObserver
 */
public class TotalRevenueView implements SaleObserver {

    private double totalRevenue;

    /**
     * this method adds all sales and shows the total income.
     * @param totalAmount the total amount income.
     */
    @Override
    public void newSale(double totalAmount){
        totalRevenue += totalAmount;
    System.out.println("the total amount paid is now :" + totalAmount + "\n");
    }

}
