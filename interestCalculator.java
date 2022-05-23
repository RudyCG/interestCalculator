
//package javaapplication1;

import java.util.*;
public class interestCalculator 
{//start class
    public static void main (String [] args)
    {//start class
        final int ZERO = 0, TWELVE = 12, ONEHUNDRED = 100, THIRTYONE = 31;
        int days, counter = ZERO;
        double currentBal, payment, annualInt, monthlyInt, currentBalBilling;
        double paymentReceived, temporary, avgDailyBal, paymentInterest, principalPart, endingBal; 
        double accumulator1 = ZERO, accumulator2 = ZERO, accumulator3 = ZERO, accumulator4 = ZERO, accumulator5 = ZERO;
        double accumulator6 = ZERO;

        currentBal = currentBalMethod();
        
        while (currentBal > ZERO)
        {
            counter++;
            payment = paymentMethod();
        
            days = daysMethod();
        
            annualInt = annualIntMethod();
       
            //start of formulas
            monthlyInt = annualInt/ONEHUNDRED/TWELVE;
            currentBalBilling = currentBal * THIRTYONE;
            paymentReceived = payment * days;
            temporary = currentBalBilling - paymentReceived;
            avgDailyBal = temporary / THIRTYONE;
            paymentInterest = avgDailyBal * monthlyInt;
            principalPart = payment - paymentInterest;
            endingBal = currentBal - principalPart;
            //end of formulas
         
            //if statements start
            if(payment > currentBal)
            {
                payment = currentBal + paymentInterest;
                principalPart = currentBal;
                endingBal = ZERO;
            } 
            if(paymentInterest > payment)
            {    
                endingBal = currentBal + (paymentInterest - payment);
                principalPart = ZERO;
            }    
            //update accumulators
            accumulator1 += currentBal;
            accumulator2 += payment;
            accumulator3 += avgDailyBal;
            accumulator4 += principalPart;
            accumulator5 += paymentInterest;
            accumulator6 += endingBal;
            
            printOutMethod(annualInt, currentBal, payment, days, avgDailyBal, principalPart, paymentInterest, endingBal);
            
            currentBal = currentBalMethod();
        }//end while
        
        totalsMethod (accumulator1, accumulator2, accumulator3, accumulator4, accumulator5, accumulator6, counter);
        
    }//end main        
    public static double currentBalMethod()
    {
        Scanner scan = new Scanner (System.in);
        double currentBalM;
        System.out.printf("Enter current balance in dollars and cents: ");
        return currentBalM = scan.nextDouble();
        
    }      
    public static double paymentMethod()
    {
        Scanner scan = new Scanner (System.in);
        double paymentM;
        System.out.printf("Enter the payment made in dollars and cents: ");
        return paymentM = scan.nextDouble();
    }
    public static int daysMethod()
    {
        Scanner scan = new Scanner (System.in);
        int daysM;
        System.out.printf("Enter the days before statement date: ");
        return daysM = scan.nextInt();
    }        
    public static double annualIntMethod()
    {
        Scanner scan = new Scanner (System.in);
        double annualIntM;
        System.out.printf("Enter annual interest rate in percent form (ex: 8.75): ");
        annualIntM = scan.nextDouble();
        System.out.println();
        return annualIntM;
    }
    public static void printOutMethod(double annualIntPrint, double currentBalPrint, double paymentPrint, int daysPrint,
            double avgDailyBalPrint, double principalPartPrint, double paymentInterestPrint, double endingBalPrint)
    {
        System.out.printf("                        Annual interest rate:   %11.2f%%\n", annualIntPrint);
        System.out.printf("                           Beginning Balance:   $%10.2f\n", currentBalPrint);
        System.out.printf("                           Amount of payment:   $%10.2f\n", paymentPrint);
        System.out.printf("Number of days payment made before statement:   %11d\n", daysPrint);
        System.out.printf("                       Average Daily Balance:   $%10.2f\n", avgDailyBalPrint);   
        System.out.printf("                 Amount applied to principal:   $%10.2f\n", principalPartPrint);
        System.out.printf("                  Amount applied to interest:   $%10.2f\n", paymentInterestPrint);
        System.out.printf("                              Ending balance:   $%10.2f\n", endingBalPrint);
        System.out.println();
    }        
    public static void totalsMethod(double accumulatorM1, double accumulatorM2, double accumulatorM3, double accumulatorM4,
             double accumulatorM5, double accumulatorM6, int counterM)
    {
        System.out.println();
        System.out.printf("          Total of beginning balances: $%8.2f\n", accumulatorM1);
        System.out.printf("                    Total of payments: $%8.2f\n", accumulatorM2);
        System.out.printf("      Total of average daily balances: $%8.2f\n", accumulatorM3);
        System.out.printf("Total of amounts applied to principal: $%8.2f\n", accumulatorM4);
        System.out.printf(" Total of amounts applied to interest: $%8.2f\n", accumulatorM5);
        System.out.printf("             Total of ending balances: $%8.2f\n", accumulatorM6);
        System.out.println();
        System.out.println("Number of credit card statements processed:      " + counterM);
    }
}//end class