package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.InfoDTO;

public class SearchDAO {
	String url="jdbc:mysql://localhost/Search";
	 String username="root";
	 String password="danngomaru02";
	 List<InfoDTO>list = new ArrayList<>();
	 int i = 0;

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
		 public List<InfoDTO> info(String pref) {//条件取得
			 InfoDTO info = new InfoDTO();
			 try {
		            con = getConnection();

		            if(pref.equals("")) {
		            statement = con.prepareStatement("SELECT * FROM SearchInfo");
		            statement.setString(1, pref);
		            ResultSet resultSet = statement.executeQuery();

		            while(resultSet.next()) {
		            	++i;
		            info.setRyokan(resultSet.getString("name"));
		            info.setPlace(resultSet.getString("place"));

		            list.add(info);
		            }
		            }else{
		            	 statement = con.prepareStatement("SELECT * FROM SearchInfo WHERE place = ?");
				            ResultSet resultSet = statement.executeQuery();

		            	 while(resultSet.next()) {
				            	++i;
				            info.setRyokan(resultSet.getString("name"));
				            info.setPlace(resultSet.getString("place"));

				            list.add(info);
				            }
		            }

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
			 return list;
		 }
}
