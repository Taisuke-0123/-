package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ユーザー登録フォームへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/signUp.jsp");
		dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String userId = request.getParameter("userId");
	    String pass = request.getParameter("pass");
	    String dateParameter = request.getParameter("petBd");
	    String petName = request.getParameter("petName");
        String animals = request.getParameter("animals");

	    // LocalDateに変換（適切なフォーマットが前提）
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate petBd = LocalDate.parse(dateParameter, formatter);
	    
	    

	    // セッションスコープへデータを保存
	    HttpSession session = request.getSession();
	    session.setAttribute("userId", userId);
	    session.setAttribute("pass", pass);
	    session.setAttribute("petBd", petBd);
	    session.setAttribute("petName", petName);
	    session.setAttribute("animals", animals);

	    // ユーザー登録確認画面へフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/signUpCheck.jsp");
	    dispatcher.forward(request, response);
	}

}
