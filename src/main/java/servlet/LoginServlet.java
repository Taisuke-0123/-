package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		//ログイン処理の実行
		Login login = new Login(userId,pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		//ログイン処理の成否によって処理を分岐
		if(result) {//ログイン成功時
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			
			// ペット名をaccountインスタンスから取得してセッションスコープに保存
		    Account account = bo.getAccountDetails(login);
		    String petName = account.getPetName();
		    session.setAttribute("petName", petName);
		    
		    //ペットの誕生日をaccountインスタンスから取得してセッションスコープに保存
		    LocalDate petBd = account.getPetBd();
		    session.setAttribute("petBd", petBd);
		    
		    //ペットの誕生日から年齢をセッションスコープに保存
		    LocalDate currentDate = LocalDate.now();
		    Period age = Period.between(petBd, currentDate);
		    int ageYears = age.getYears();
		    int ageMonth = age.getMonths();
		    session.setAttribute("ageYears", ageYears);
		    session.setAttribute("ageMonth", ageMonth);
		    
		    //ログイン成功画面をセッションスコープに保存
		    session.setAttribute("returnToPage", "WEB-INF/jsp/loginOK.jsp");
			
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(request, response);
			
		}else {//ログイン失敗時
			//リダイレクト
			
			response.sendRedirect("LoginServlet");
		}
		
	}

}
