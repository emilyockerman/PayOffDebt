/*
* PayOffDebt.java
* 
* Author: Emily Ockerman
* 
* Submission Date: September 6, 2018
*
* Purpose: This program, if input is entered correctly, will be able to
* tell the user how many months it will take to pay off a debt given a 
* certain annual interest rate and monthly payment on a principal
* value.  It will also tell the user how much total money he/she
* will end up paying, as well as the total amount of interest 
* gathered on the amount over the course of the time it will
* take to pay off the debt.  Finally, it will tell the user 
* how much money they overpayed at the end of the final month.
*
* Statement of Academic Honesty:
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* CSCI 1301: Project 1 Page 3 or the course textbook. I recognize
* that any unauthorized
* assistance or plagairism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

import java.util.Scanner;

public class PayoffDebt {

	public static void main(String[] args) 
	{
		//Declare a Scanner Object
		Scanner input = new Scanner(System.in);

		//Variable declarations and initializations and prompting for input
		System.out.print("Principal:\t\t\t");
		double principal = input.nextDouble();
		System.out.print("Annual Interest Rate (%):\t");
		double annualInterestRate = input.nextDouble();
		System.out.print("Monthly Payment:\t\t");
		double monthlyPayment = input.nextDouble();
		
		//Variable declarations and initializations for output
		double paymentPart1 = Math.log(monthlyPayment);
		double paymentPart2 = Math.log(monthlyPayment - annualInterestRate/1200.0 * principal);
		double paymentPart3 = Math.log(annualInterestRate/1200.0 + 1.0);
		
		//Number of months needed to pay off credit card debt
		double exactMonths = (paymentPart1 - paymentPart2)/paymentPart3;
		int numberOfMonths = (int) Math.ceil(exactMonths);
		System.out.printf("\nMonths Needed to Pay Off:\t" + numberOfMonths);
		
		//Total amount paid
		double totalAmountPaid = numberOfMonths * monthlyPayment;
		System.out.printf("\nTotal Amount Paid:\t\t$%1.2f", totalAmountPaid);
		
		//Total interest paid
		double totalInterestPaid = totalAmountPaid - principal;
		System.out.printf("\nTotal Interest Paid:\t\t$%1.2f", totalInterestPaid);
		
		/*Overpayment: subtract the exact amount of time it takes to pay off the debt
		*from the ceiling amount.  The decimal remainder is then multiplied by the
		*monthly payment made to get the dollar amount of overpayment that the bank
		*will owe the debtor at the end of the last month*/
		double overpayment = (numberOfMonths - exactMonths)*monthlyPayment;
		System.out.printf("\nOverpayment:\t\t\t$%1.2f", overpayment);

	}

}
