package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.DTO;
import DTO.torokuDTO;

public class Connect {
	String url="jdbc:mysql://localhost/toroku";
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
	 public DTO findUser(String name,String password) {
		 DTO dto = new DTO();

		 try {
	            con = getConnection();

	            statement = con.prepareStatement("SELECT * FROM KanriToroku WHERE name = ? and password = ?");
	            statement.setString(1, name);
	            statement.setString(2, password);
	            ResultSet resultSet = statement.executeQuery();

	            if (!resultSet.next()) {
	            	return null;
	            }

	            dto.setName(resultSet.getString("name"));
	            dto.setPassword(resultSet.getString("password"));

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	           try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	           try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        }
		 return dto;
	 }
	 public Connection storageGetConnection() throws SQLException{
		 String url="jdbc:mysql://localhost/Search";
		 String username="root";
		 String password="danngomaru02";
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
	 public torokuDTO torokuCom(String name) {
		 torokuDTO dto = new torokuDTO();

		 try {
	            con = getConnection();

	            statement = con.prepareStatement("SELECT * FROM KanriToroku WHERE name = ?");
	            statement.setString(1, name);
	            ResultSet resultSet = statement.executeQuery();

	            if (!resultSet.next()) {
	            	return null;
	            }

	            dto.setName(resultSet.getString("name"));

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	           try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	           try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        }
		 return dto;
}
}
