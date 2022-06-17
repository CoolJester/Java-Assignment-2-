package Question1;

/**
 *
 * @author Ntsako
 */
public class Finance_Period extends Customer{
    
    //Overriding the calculate repayment method found in the Customer class
    @Override
    public void calculateMonthlyRepayment(){
        //Calculating the monthly repayment with no interest
        MonthlyRepayment = ProductPrice / NumberOfMonths;
        
        //Testing if the number of months to pay are greater then 3 than adding interest if so
        if(NumberOfMonths > 3){
            MonthlyRepayment += (MonthlyRepayment * 0.25);
        }
    }
}
