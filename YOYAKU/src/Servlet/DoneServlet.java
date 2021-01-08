package Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.DTO;
import JDBC.Connect;

/**
 * Servlet implementation class DoneServlet
 */
@WebServlet("/DoneServlet")
public class DoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DTO dto = new DTO();
		HttpSession session = request.getSession();

		String id = (String)session.getAttribute("name");
		String checkInDay = request.getParameter("checkInDay");
		String checkOutDay = request.getParameter("checkOutDay");
		String ryokan = (String)session.getAttribute("ryokanName");


		session.setAttribute("checkInDay",checkInDay);
		session.setAttribute("checkOutDay", checkOutDay);

		//id,予約日,旅館名をデータベースに追加して予約情報を保管する。
		Connect connect = new Connect();
		//チェックインとチェックアウトの日付を比較

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date checkIn = format.parse(checkInDay);
			Date checkOut = format.parse(checkOutDay);

			if(checkIn.compareTo(checkOut)==-1) {
				try{
					connect.storageGetConnection();
					String sql = "insert into Storage value(?,?,?,?)";
					PreparedStatement stmt = connect.storageGetConnection().prepareStatement(sql);
					stmt.setString(1, id);
					stmt.setString(2, checkInDay);
					stmt.setString(3, checkOutDay);
					stmt.setString(4, ryokan);
					stmt.executeUpdate();

				}catch(SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("/DoneUpdate.jsp").forward(request,response);
			}else {
				request.getRequestDispatcher("/DoneError.jsp").forward(request, response);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
