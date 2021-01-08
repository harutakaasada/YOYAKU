package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.DTO;
import JDBC.Connect;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
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

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		Connect connect = new Connect();
		DTO dto = connect.findUser(name,password);

		boolean isLogin = (dto != null && name.equals(dto.getName()) && password.equals(dto.getPassword()));
		HttpSession session = request.getSession();
		session.setAttribute("name",name);

		if(isLogin) {
			request.setAttribute("name", dto.getName());
			request.getRequestDispatcher("/Login_Success.jsp").forward(request,response);
		}else {
			request.setAttribute("error", "名前かパスワードが間違っています 再入力してください");
			request.getRequestDispatcher("/Login_Error_again.jsp").forward(request,response);
		}
	}

}
