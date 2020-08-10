package com.kanna.emailapp;

import java.util.Scanner;

public class Email {

	Scanner sc = new Scanner(System.in);

	private final String COMPANY_SUFFIX = "company.com";

	private String firstName;
	private String lastName;
	private String department;
	private String password = "";
	private String email;
	private int mailBoxCapacity = 100;
	private String alternateEmail = "-";

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	/*
	 * @param firstName
	 * 
	 * @param lastName
	 * 
	 */
	Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("User generated ");

		// Getting department details
		this.department = getDepartmanet();

		// Default password generation
		this.password = getPassWord();

		// Forming email_id
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + COMPANY_SUFFIX;
		printDetails();

	}

	/*
	 * @return department
	 * 
	 */
	private String getDepartmanet() {
		System.out.println("Enter the department name \n" + "1 - Accounts \n" + "2 - Sales \n" + "3 - Production \n"
				+ "0 - Others \n");
		int choice = sc.nextInt();
		String department;

		switch (choice) {
		case 1:
			department = "Accounts";
			break;

		case 2:
			department = "Sales";
			break;

		case 3:
			department = "Production";
			break;

		default:
			department = "Others";
			break;
		}

		return department;
	}

	/*
	 * 
	 * @return password
	 * 
	 */
	private String getPassWord() {

		String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String str2 = "abcdefghijklmnopqrstuvwxyz";
		String num = "0123456789";
		String spl = "!@#$%^&*()";
		String password = "";

		int caps = (int) (Math.random() * str1.length());
		password += str1.charAt(caps);

		for (int i = 0; i < 5; i++) {
			int lower = (int) (Math.random() * str2.length());
			password += str2.charAt(lower);
		}

		for (int i = 0; i < 2; i++) {
			int number = (int) (Math.random() * num.length());
			password += num.charAt(number);
		}

		int splChar = (int) (Math.random() * spl.length());
		password += spl.charAt(splChar);

		return password;
	}

	protected void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
		System.out.println("Mailbox limit changed to " + this.mailBoxCapacity);
	}

	protected void setAlternateEmail(String alterEmail) {
		this.alternateEmail = alterEmail;
		System.out.println("Alternate email address added :" + this.alternateEmail);
	}

	protected void changePassword(String password) {
		this.password = password;
		System.out.println("Password changed sucessfully");
	}

	public void printDetails() {
		System.out.println("User details");
		System.out.println("---------------------------------------------");
		System.out.println("First Name :" + this.firstName);
		System.out.println("Last Name :" + this.lastName);
		System.out.println("Department :" + this.department);
		System.out.println("Password :" + this.password);
		System.out.println("Email id :" + this.email);
		System.out.println("Mail capacity :" + this.mailBoxCapacity);
		System.out.println("Alternative email_id :" + this.alternateEmail);
		System.out.println("---------------------------------------------");
	}

}
