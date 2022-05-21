
import java.util.*;
public class interestCalculator
{//start class
    public static void main ( String [] args)
    {//start main
        Scanner scan = new Scanner (System.in);
        int days;
        double currentBal, payment, annualInt, monthlyInt, currentBalBilling;
        double paymentReceived, temporary, avgDailyBal, paymentInterest, principalPart, endingBal; 
        
       //start keyboard input
        System.out.printf("Enter current balance in dollars and cents: ");
        currentBal = scan.nextDouble();
        
        System.out.printf("Enter the payment made in dollars and cents: ");
        payment = scan.nextDouble();
        
        System.out.printf("Enter the days before statement date: ");
        days = scan.nextInt();
        
        System.out.printf("Enter annual interest rate in percent form (ex: 8.75): ");
        annualInt = scan.nextDouble();
        //end keyboard input
        
        System.out.println();
        
        //start of formulas
        monthlyInt = annualInt/100/12;
        
        currentBalBilling = currentBal * 31;
        
        paymentReceived = payment * days;
        
        temporary = currentBalBilling - paymentReceived;
        
        avgDailyBal = temporary / 31;
        
        paymentInterest = avgDailyBal * monthlyInt;
        
        principalPart = payment - paymentInterest;
        
        endingBal = currentBal - principalPart;
        //end of formulas

        System.out.printf("                        Annual interest rate:   %11.2f%%\n", annualInt);
        System.out.printf("                           Beginning Balance:   $%10.2f\n", currentBal);
        System.out.printf("                           Amount of payment:   $%10.2f\n", payment);
        System.out.printf("Number of days payment made before statement:   %11d\n", days);
        System.out.printf("                       Average Daily Balance:   $%10.2f\n", avgDailyBal);   
        System.out.printf("                 Amount applied to principal:   $%10.2f\n", principalPart);
        System.out.printf("                  Amount applied to interest:   $%10.2f\n", paymentInterest);
        System.out.printf("                              Ending balance:   $%10.2f\n", endingBal);
    }//end main        
            
}//end class