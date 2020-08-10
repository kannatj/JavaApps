package com.kanna.emailapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmailApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Email obj1 = new Email("Kanna", "tjk"); // New User
		boolean flag = true;
		int option = 0;
        
		while (flag) {
			System.out.println("Enter the option you want to perform");
			System.out.print("1. Change password" + "\n2. Change MailBox limit" + "\n3. Set alternate email"
					+ "\n4. Display details");
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Give correct input");
			}

			switch (option) {
			case 1:
				System.out.println("Enter new password");
				Lable: while (true) {
					System.out.print("Password policy");
					System.out.println("\n1.Dont use username as password \n2. Length should be greater than 8");
					System.out.println("Note : A strengthen password should have combination of spl char, number and caps");

					String password = sc.next();

					if (password.length() < 8 || password.contains(obj1.getFirstName())) {
						System.out.println("Password policy violated");
						System.out.println();
						continue Lable;
					} else {
						obj1.changePassword(password);
						break;
					}
				}
				break;

			case 2:
				System.out.println("Enter capacity you want");
				int capacity = sc.nextInt();
				obj1.setMailBoxCapacity(capacity);
				break;

			case 3:
				System.out.println("Enter alternative email address");
				String alterEmail = sc.next();
				obj1.setAlternateEmail(alterEmail);
				break;

			case 4:
				obj1.printDetails();
				break;

			default:
				System.out.println("Bad option");
			}

			System.out.println("want to continue give \n y - Yes    n - No");
			char flagOption = (sc.next().toLowerCase()).charAt(0);

			if (flagOption == 'y')
				flag = true;
			else
				flag = false;

		}

	}

}
