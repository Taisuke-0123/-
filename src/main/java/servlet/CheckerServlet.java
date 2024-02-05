package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckerServlet
 */
@WebServlet("/CheckerServlet")
public class CheckerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckerServlet() {
        super();
        // TODO Auto-generated constructor stub
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
//		String option2 = request.getParameter("option2");
//		String option3 = request.getParameter("option3");
		
		//入力された値からそれぞれの画面へフォワード
		
		if("危険度：大".equals(keywords)) {//危険度：高へフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/checkResultRed.jsp");
		    dispatcher.forward(request, response);
		}else if("危険度：中".equals(keywords)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/checkResultYellow.jsp");
		    dispatcher.forward(request, response);
		}else if("危険度：小".equals(keywords)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/checkResultGreen.jsp");
		    dispatcher.forward(request, response);
		}
		
		doGet(request, response);
	}

}
