package Question1;

import javax.swing.JOptionPane;

/**
 *
 * @author Ntsako
 */
public class Customer_Finance {

    //The main method
    public static void main(String[] args){
        
        //The object that does not apply interest
        Customer userOne = new Customer();
        
        //The object that can apply interest
        Finance_Period userTwo = new Finance_Period();
        
        //Getting the data from the user for the first object
        userOne.setCustomerName();
        userOne.setCustomerNumber();
        userOne.setProductPrice();
        userOne.setNumberOfMonths();
        
        //Calculate the monthly repayment for first object
        userOne.calculateMonthlyRepayment();
        
        //Displaying the data for the first object
        display(userOne);
        
        //Getting the data from the user for the second object
        userTwo.setCustomerName();
        userTwo.setCustomerNumber();
        userTwo.setProductPrice();
        userTwo.setNumberOfMonths();
        
        //Calculate the monthly repayment for second object
        userTwo.calculateMonthlyRepayment();
        
        //Displaying the data for the second object
        display(userTwo);
        
    }
    
    //Method used to display the report
    public static void display(Customer c){
        JOptionPane.showMessageDialog(null, "Customer Name: " + c.getCustomerName() + "\nCustomer Contact: " + c.getCustomerNumber() + "\nProduct Price: " + c.getProductPrice() + "\nRepayment Months: " + c.getNumberOfMonths() + "\nMonthly Repayment: " + c.getMonthlyRepayment() + "\nTotal Due: " + (c.getMonthlyRepayment() * c.getNumberOfMonths()), "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
