package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckerServlet")
public class CheckerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CheckerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// loginOK.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String keywords = request.getParameter("keywords");
		
		//入力された値からそれぞれの画面へフォワード
		
		if("red".equals(keywords)) {//危険度：大へフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/checkResultRed.jsp");
		    dispatcher.forward(request, response);
		}else if("yellow".equals(keywords)){//危険度：中へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/checkResultYellow.jsp");
		    dispatcher.forward(request, response);
		}else if("green".equals(keywords)){//危険度：小へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/checkResultGreen.jsp");
		    dispatcher.forward(request, response);
		}
		
		doGet(request, response);
	}

}
