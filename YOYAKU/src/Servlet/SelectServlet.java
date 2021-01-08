package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.SelectDTO;
import JDBC.InfoConnect;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		String ryokan = (String)session.getAttribute("ryokanName");

		InfoConnect connect = new InfoConnect();

		try {
			Connection con = connect.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM SearchDetails WHERE place = ?");
			stmt.setString(1, ryokan);
			ResultSet rs = stmt.executeQuery();




			if(rs.next()) {
				String selectDetails = rs.getString("details");
				String selectPlace = rs.getString("place");

				SelectDTO select = new SelectDTO();

				select.setSelectPlace(selectPlace);
				select.setSelectDetails(selectDetails);

				session.setAttribute("selectPlace", selectPlace);
				session.setAttribute("selectDetails", selectDetails);
			}
			request.getRequestDispatcher("/Done.jsp").forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
