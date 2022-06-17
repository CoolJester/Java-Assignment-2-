package Question1;

import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.JSType;

/**
 *
 * @author Ntsako
 */
public class Customer {

    //The 5 main attributes of the Customer class
    protected String CustomerName;
    protected String CustomerNumber;
    protected double ProductPrice;
    protected int NumberOfMonths;
    protected double MonthlyRepayment;
    
    //The setter methods
    public void setCustomerName() {
        this.CustomerName = JOptionPane.showInputDialog(null, "Enter the customer name", "Customer Name", 0);
    }

    public void setCustomerNumber() {
        this.CustomerNumber = JOptionPane.showInputDialog(null, "Enter the customer's contact number", "Contact Number", 0);
    }

    public void setProductPrice() {
        this.ProductPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the price of the product", "Product Price", 0));
    }

    public void setNumberOfMonths() {
        this.NumberOfMonths = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of repayment months", "Repayment Months", 0));
        
        //Making sure the number of months to pay are not greater then 12
        //NumberOfMonths = ((NumberOfMonths > 12) ? NumberOfMonths : 12);
    }
    
    //The getter methods
    public String getCustomerName() {
        return CustomerName;
    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public double getNumberOfMonths() {
        return NumberOfMonths;
    }

    public double getMonthlyRepayment() {
        return MonthlyRepayment;
    }
    
    //Calculating the repayment amount
    public void calculateMonthlyRepayment(){
        MonthlyRepayment = ProductPrice / NumberOfMonths;
    }
}
