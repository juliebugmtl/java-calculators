package com.juliemartin.app;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author Julie Martin
 */
public class MoneyCalculators {

    Scanner sc = new Scanner(System.in);
    
    private NumberFormat nf;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    
    private void enterLoanValues() {
        
    System.out.println("Enter amount of loan in dollars: ");
    double pv = sc.nextDouble();
    sc.nextLine();
        
    System.out.println("Enter annual rate in percent: ");
    double rate = sc.nextDouble() / 100 / 12.0;
    sc.nextLine();
    
    System.out.println("Enter term in years: ");
    double term = sc.nextDouble() * 12.0;
    sc.nextLine();
    
    double pmt = pv * (rate / (1.0 - (Math.pow((1.0 + rate), -term))));
    
    System.out.println("You need to pay " + formatter.format(pmt) + " every month.");
    
    }
    
    private void enterFutureValues() {
        
    System.out.println("Enter amount put aside each month in dollars: ");
    double pmt = sc.nextDouble();
    sc.nextLine();
        
    System.out.println("Enter annual interest rate in percent: ");
    double rate = sc.nextDouble() / 100 / 12.0;
    sc.nextLine();
    
    System.out.println("Enter term in years: ");
    double term = sc.nextDouble() * 12.0;
    sc.nextLine();
    
    double fv = pmt * ((1.0 - (Math.pow((1.0 + rate), term)))) / rate;
    
    System.out.println("After " + (int)term / 12 + " years, you will have " + formatter.format(Math.abs(fv)));
    
    }
    
    private void enterSavingsGoal() {
        
    System.out.println("Enter the amount you'd like to have in dollars: ");
    double fv = sc.nextDouble();
    sc.nextLine();
        
    System.out.println("Enter annual interest rate in percent: ");
    double rate = sc.nextDouble() / 100 / 12.0;
    sc.nextLine();
    
    System.out.println("Enter term in years: ");
    double term = sc.nextDouble() * 12.0;
    sc.nextLine();
    
    double sg = fv * (rate / (1.0 - (Math.pow((1.0 + rate), term))));
    
    System.out.println("To get to " + formatter.format(Math.abs(fv)) + " after " + (int)term / 12 + " years, you need to save " + formatter.format(Math.abs(sg)) + " every month.");
    
    }    
    
    
    public void perform() {

    enterLoanValues();
    enterFutureValues();
    enterSavingsGoal();

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MoneyCalculators mc = new MoneyCalculators();
        mc.perform();
        System.exit(0);
    }
    
}
