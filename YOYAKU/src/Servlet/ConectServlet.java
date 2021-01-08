package Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.torokuDTO;
import JDBC.Connect;

/**
 * Servlet implementation class ConectServlet
 */
@WebServlet("/ConectServlet")
public class ConectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connect connect = new Connect();
		try {
			 connect.getConnection();//接続
			 String name = request.getParameter("name");
			 String password = request.getParameter("password");

			 torokuDTO dto = connect.torokuCom(name);

			 boolean isToroku = (dto != null && name.equals(dto.getName()));

			 if(!isToroku) {
			String sql = "insert into KanriToroku values(?,?)";
			PreparedStatement stmt = connect.getConnection().prepareStatement(sql);//値を追加
			stmt.setString(1, name);
	        stmt.setString(2,password);
		    stmt.executeUpdate();//更新
		    request.getRequestDispatcher("/2.LOGIN.jsp").forward(request, response);
			 }else {
				 request.getRequestDispatcher("torokuError.jsp").forward(request, response);
			 }
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}

}
