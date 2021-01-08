package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.InfoDTO;
import JDBC.InfoConnect;

/**
 * Servlet implementation class stayServlet
 */
@WebServlet("/stayServlet")
public class stayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public stayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pref = request.getParameter("pref");
		List<InfoDTO>list = new ArrayList<>();
		int i = 0;

		//情報にマッチしたやつだけを表示させる
		//自分で作ったやつをデータベースから引っ張り出す方法
		//DBに接続して取り出すことにする
		InfoConnect connect  = new InfoConnect();

		try {
			Connection con = connect.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM SearchInfo WHERE place = ?");
			stmt.setString(1, pref);
			ResultSet rs = stmt.executeQuery();

			HttpSession session = request.getSession();

			while(rs.next()) {
				++i;
				String ryokanName = rs.getString("ryokanName");
				String place = rs.getString("place");

				InfoDTO info = new InfoDTO();

				 	info.setRyokan(ryokanName);
					info.setPlace(place);
					list.add(info);
					session.setAttribute("i", i);
					session.setAttribute("ryokanName", ryokanName);
					session.setAttribute("place", place);
					session.setAttribute("list", list);
			}
			session.setAttribute("pref", pref);

			request.getRequestDispatcher("/info.jsp").forward(request,response);
		}catch(SQLException e) {
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
