package kth.se.IV1350.PointOfSale.view;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import kth.se.IV1350.PointOfSale.model.SaleObserver;

/**
 * this class creates totalRevenueOutPut file and shows total revenue.
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private double totalRevenue;

    private PrintWriter logFile;

    /**
     * constructer of totalRevenueFileOutput
     * generate Printwriter which allows writing to the totalRevenueOutPut file
     */
    public TotalRevenueFileOutput() {
        try {
            logFile = new PrintWriter(new FileWriter("totalRevenueOutPut.txt", true), true);
        } catch(IOException e) {
            System.out.println("Failure to write to the file");
            e.printStackTrace();
        }
    }
    /*
      * the method newSale shows the total revenue.
    */
    @Override
    public void newSale(double totalAmount) {
        totalRevenue += totalAmount;
        logFile.println("The total Revenue is: " + totalRevenue + " SEK\n");
    }
}

