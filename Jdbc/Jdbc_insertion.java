package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc_insertion {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		// Statement statement = null;
		PreparedStatement statement = null;
		// ResultSet resultSet=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the rows you want to insert ");

		int a = sc.nextInt();
		int b[] = new int[a];
		String[] address1 = new String[a];
		String[] address2 = new String[a];
		for (int i = 0; i < a; i++) {
			System.out.println("Enter EMP ID : ");
			b[i] = sc.nextInt();
			System.out.println("Enter ADDRESS 1 : ");
			address1[i] = sc.next();
			System.out.println("Enter ADDRESS 2 : ");
			address2[i] = sc.next();
		}

//		for (String add : address1) {
//			System.out.println(add);
//		}

		String url = "jdbc:mysql://127.0.0.1:3306/codebegun_test_db";
		String userName = "root";
		String password = "root";
		// String query = "select * from address";
		String insertQuery = "insert into address(emplyee_id,address1,address2)" + "value(?,?,?)";
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, password);
			// statement = connection.createStatement();
			statement = connection.prepareStatement(insertQuery);
			for (int i = 0; i < a; i++) {
				statement.setInt(1, b[i]);
				statement.setString(2, address1[i]);
				
				statement.setString(3, address2[i]);
				int noOfRows = statement.executeUpdate();
				System.out.println(noOfRows);
				// resultSet = statement.executeQuery(query);
//			while(resultSet.next()) {
//				System.out.println(resultSet.getString("address1"));
//			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			statement.close();
			connection.close();
			// resultSet.close();

		}

	}
}
