package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterLogic;

/**
 * Servlet implementation class signUpResultServlet
 */
@WebServlet("/SignUpResultServlet")
public class SignUpResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからデータを取得
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        String pass = (String) session.getAttribute("pass");
        String petName = (String) session.getAttribute("petName");
        String animals = (String) session.getAttribute("animals");
        LocalDate petBd = (LocalDate) session.getAttribute("petBd");
        
        // RegisterLogicクラスのインスタンスを作成
        RegisterLogic registerLogic = new RegisterLogic();

        // BOを呼び出し
        registerLogic.saveData(userId, pass, petName, animals, petBd);

        // 他の処理やリダイレクトを行う
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/welcome.jsp");
		dispatcher.forward(request, response);
	}

}
