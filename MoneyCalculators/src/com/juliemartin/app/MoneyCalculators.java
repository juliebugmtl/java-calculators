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
    
    private void showMenu() {
    System.out.println("Financial Calculator");
    System.out.println("");
    System.out.println("A) Loan Calculator");
    System.out.println("B) Future Value of Savings Calculator");
    System.out.println("C) Savings Goal Calculator");
    System.out.println("D) Exit");
    System.out.println("");
    }
    
    private char doMenuChoice() {
        char choice = '@';
        do {
            System.out.print("Please enter your choice: ");
            if (sc.hasNext("[a-dA-D]")) {
                choice = sc.next().toUpperCase().charAt(0);
            }
            if (choice == '@') {
                System.out.println("Invalid input.");
            }
            sc.nextLine();
        } while (choice == '@');

        return choice;
    }

    private void doChoiceA() {
            
            double pv = -1.0;
            do {
                System.out.print("Enter amount of loan in dollars: ");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    pv = sc.nextDouble();
                }
                if (pv == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (pv == -1.0);
            
            double rate = -1.0;
            do {
                System.out.print("Enter annual interest rate (ie: 0.05): ");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    rate = sc.nextDouble() / 12.0;
                }
                if (rate == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (rate == -1.0);
            
            double term = -1.0;
            do {
                System.out.print("Enter term in years: ");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    term = sc.nextDouble() * 12.0;
                }
                if (term == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (term == -1.0);
            
            double pmt = pv * (rate / (1.0 - (Math.pow((1.0 + rate), -term))));

            System.out.println("You need to pay " + formatter.format(pmt) + " every month.");
            System.out.println("");
    }

    private void doChoiceB() {
            double pmt = -1.0;
            do {
                System.out.print("Enter amount put aside each month in dollars: ");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    pmt = sc.nextDouble();
                }
                if (pmt == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (pmt == -1.0);
            
            double rate = -1.0;
            do {
                System.out.print("Enter annual interest rate (ie: 0.05): ");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    rate = sc.nextDouble() / 12.0;
                }
                if (rate == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (rate == -1.0);
            
            double term = -1.0;
            do {
                System.out.print("Enter term in years: ");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    term = sc.nextDouble() * 12.0;
                }
                if (term == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (term == -1.0);

            double fv = pmt * ((1.0 - (Math.pow((1.0 + rate), term)))) / rate;

            System.out.println("After " + (int)term / 12 + " years, you will have " + formatter.format(Math.abs(fv)));
            System.out.println("");
    }
    
    private void doChoiceC() {
            double fv = -1.0;
            do {
                System.out.print("Enter amount put aside each month in dollars: ");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    fv = sc.nextDouble();
                }
                if (fv == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (fv == -1.0);
            
            double rate = -1.0;
            do {
                System.out.print("Enter annual interest rate (ie: 0.05): ");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    rate = sc.nextDouble() / 12.0;
                }
                if (rate == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (rate == -1.0);
            
            double term = -1.0;
            do {
                System.out.print("Enter term in years: ");
                if (sc.hasNext("\\d*\\.?\\d*") ) {
                    term = sc.nextDouble() * 12.0;
                }
                if (term == -1.0) {
                    System.out.println("Invalid input.");
                }
                sc.nextLine();
            } while (term == -1.0);

            double sg = fv * (rate / (1.0 - (Math.pow((1.0 + rate), term))));

            System.out.println("To get to " + formatter.format(Math.abs(fv)) + " after " + (int)term / 12 + " years, you need to save " + formatter.format(Math.abs(sg)) + " every month.");
            System.out.println("");
    }
    
    public void perform() {

    
        char ch;

        do {
            showMenu();
            ch = doMenuChoice();
            System.out.println("You chose " + ch);

            switch (ch) {
                case 'A':
                    doChoiceA();
                    break;
                case 'B':
                    doChoiceB();
                    break;
                case 'C':
                    doChoiceC();
                    break;
            }
        } while (ch != 'D');
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
