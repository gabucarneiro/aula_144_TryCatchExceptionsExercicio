package application;

import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
//import java.util.List;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program_exercice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date now = new Date();
		System.out.println(sdf.format(now));
		System.out.println();
		
		try {
			//List<Account> acc = new ArrayList<>();
			System.out.println("-- Account --");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			Account acc = new Account(number, holder, balance, withdrawLimit);
			System.out.println(acc.toString());
			
			System.out.println();
			System.out.print("Enter amout for withdraw: ");
			double amount = sc.nextDouble();
			acc.withdraw(amount);
			System.out.println();
			System.out.println(acc.toString());
		}
		catch (InputMismatchException e) {
			System.out.println("Error: Input mismatch.");
		}
		catch (DomainException e) {
			System.out.println("Not possible to comply: "+ e.getMessage());
		}
		
		
		System.out.print("");
		System.out.print("");
		
		sc.close();
	}

}
