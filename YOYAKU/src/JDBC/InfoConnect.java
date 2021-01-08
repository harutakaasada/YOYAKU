package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InfoConnect {
	String url="jdbc:mysql://localhost/Search";
	 String username="root";
	 String password="danngomaru02";

	 Connection con = null;//初期化
	 PreparedStatement statement = null;

	 public Connection getConnection() throws SQLException {



		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");//ドライバロード
			 con=DriverManager.getConnection(url,username,password);//接続

		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }catch(SQLException e ) {
			 e.printStackTrace();
		 }
		 return con;
	 }
}
