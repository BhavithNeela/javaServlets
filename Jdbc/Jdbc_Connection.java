package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_Connection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement statement = null;
		ResultSet resultSet=null;
		String url="jdbc:mysql://127.0.0.1:3306/codebegun_test_db";
		String userName="root";
		String password="root";
		String query = "select * from address";
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,userName, password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println(resultSet.getString("address1"));
			}
		}
		catch(Exception a) {
			a.printStackTrace();
		}
		finally {
			connection.close();
			statement.close();
			resultSet.close();
		}

	}

}
