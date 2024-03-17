package com.java.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class Jdbc {
		void insert(SeterAndGetter obj) throws SQLException {
			// TODO Auto-generated method stub
			Connection connection = null;
			// Statement statement = null;
			PreparedStatement statement = null;
			// ResultSet resultSet=null;
			//Scanner sc = new Scanner(System.in);
			//System.out.println("Enter the rows you want to insert ");

			//int a = sc.nextInt();
//			String name=obj.getName();
//			String id = obj.getId();
//			String mobile=obj.getMobile();
//			String password1 = obj.getPassword();
//			//int b[] = new int[a];
			//String[] address1 = new String[a];
			//String[] address2 = new String[a];
			

//			for (String add : address1) {
//				System.out.println(add);
//			}

			String url = "jdbc:mysql://127.0.0.1:3306/codebegun_test_db";
			String userName = "root";
			String password = "root";
			// String query = "select * from address";
			String insertQuery = "insert into Registration(fullName,id,mobile,passwords)" + "value(?,?,?,?)";
			try {
				 //Class.forName("com.mysql.cj.jdbc.Driver",true,Driver.class.getClassLoader()).getClass();
				connection = DriverManager.getConnection(url, userName, password);
				// statement = connection.createStatement();
				statement = connection.prepareStatement(insertQuery);
				statement.setString(1,obj.getName());
				statement.setString(2,obj.getId());
				statement.setString(3, obj.getPassword());
				statement.setString(4,obj.getPassword());

				statement.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				
				statement.close();
				connection.close();
				// resultSet.close();

			}
		}
		void update()throws SQLException {
			
			Connection connection = null;
			PreparedStatement statement = null;
			String url = "jdbc:mysql://127.0.0.1:3306/codebegun_test_db";
			String userName = "root";
			String password = "root";
			String updateQuery="Update Registration set fullname='PathaVinith'"
					+ "Where Sno=2";
			try {
				connection = DriverManager.getConnection(url, userName, password);
				statement = connection.prepareStatement(updateQuery);
				statement.execute();
				}catch(Exception e) {
				e.printStackTrace();
			}
			finally{
				connection.close();
				statement.close();
				
			}
			
		}
		void deleteQuery()throws SQLException{
			Connection connection=null;
			PreparedStatement preparedstatement=null;
			String url = "jdbc:mysql://127.0.0.1:3306/codebegun_test_db";
			String userName = "root";
			String password = "root";
			String deleteQuery="Delete from Registration where Sno=5";
			try {
				connection=DriverManager.getConnection(url,userName,password);
				preparedstatement = connection.prepareStatement(deleteQuery);
				preparedstatement.execute();
			}
			catch(Exception delete) {
				delete.printStackTrace();
				
			}
			finally {
				connection.close();
				preparedstatement.close();
			}
			
			
		}
		
		 
		
		
		
		
		
		
		
}

