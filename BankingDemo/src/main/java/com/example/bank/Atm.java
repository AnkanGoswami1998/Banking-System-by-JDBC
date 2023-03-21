/////Creating a banking system


package com.example.bank;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Atm {
	
	public static Connection connect() throws SQLException

	{

		String username = "root";
		String password = "Ankan@1998";

		String url = "jdbc:mysql://localhost:3306/sakila";

		return DriverManager.getConnection(url, username, password);
		
	}
	
    

	
	public void createNew() throws SQLException {
		
		Connection con = connect();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account id:");
		int id = sc.nextInt();
		System.out.println("Enter account name:");
		String name = sc.next();
		System.out.println("Enter account balance:");
		double balance = sc.nextInt();
		String query = "insert into bankaccount values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setDouble(3, balance);
		int result = ps.executeUpdate();
		if(result>0) {
			System.out.println("Added sucessfully");
		}
	}
	
	 public void updateBalance() throws SQLException {
			
			Connection con = connect();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter accountnumber:");
			int id = sc.nextInt();
			System.out.println("Add balance:");
			double balance = sc.nextDouble();
			String query = "update  bankaccount set acbalance  =acbalance+? where acid=?; ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDouble(1, balance);
			ps.setInt(2, id);
			
			int result=ps.executeUpdate();
			if(result>0) {
				System.out.println("Updated sucessfully");
			}
		}
	 
	 public void fetchBalance() throws SQLException {
		 
		 Connection con = connect();

			Statement stmt = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your accountnumber:");
			int id = sc.nextInt();
			
			String query = ("select * from bankaccount where acid = "+ id);

			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
			System.out.println("Account Number: "+rs.getInt(1));
			System.out.println("Account Name: "+rs.getString(2));
			System.out.println("Account Balance: "+rs.getDouble(3) + " rs");
			}
			else {
				System.out.println("Account doesnt exists......");
			}
	 }

}
