package com.hibernate.application;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;

public class JDBCTest {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@10.168.244.7:1521:Swdev";
		String user ="mic_common_sw";
		String password = "mic_common_sw";
		
		try {
			System.out.println("Connecting to DAtabase");
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select distinct(SWLDI_ENTITY_TYPE) from lms_deal_informations");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));				
			}
			
			Enumeration<Driver> e = DriverManager.getDrivers();
		      //Printing the list
		      while(e.hasMoreElements()) {
		         System.out.println(e.nextElement().getClass());
		      }
			System.out.println("Connection Success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
