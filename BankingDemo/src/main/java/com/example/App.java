package com.example;

import java.sql.SQLException;
import java.util.Scanner;

import com.example.bank.Atm;


public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("-----Welcome to banking system--------");
		System.out.println("Enter your choice");
		System.out.println("1=CreateAccount");
		System.out.println("2=AddBalance to your account");
		System.out.println("3=Get your account details");
		int choice=sc.nextInt();
		Atm atm = new Atm();
		switch(choice) {
		case 1 -> atm.createNew();
		case 2 -> atm.updateBalance();
		case 3 -> atm.fetchBalance();
		default -> System.out.println("Wrong input");
		}
		
    }
}
