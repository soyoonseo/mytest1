package control;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import action.Action;
import dao.DaoService;

@WebServlet("*.kosta")
public class ControlServlet extends HttpServlet {

	private static final long serialVersionUID = -4569756774981429919L;
	private ApplicationContext ctx;
	@Override
	public void init() throws ServletException {
		ctx = new GenericXmlApplicationContext("config/context2.xml");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		myProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		myProcess(req, resp);
	}

	// 어떤 요청이 오더라도 모두 처리하는 메서드를 정의
	protected void myProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=euc-kr");
		req.setCharacterEncoding("euc-kr");
		String query = req.getParameter("query");
		System.out.println("query: " + query);
		// todayview 요청
		Action action = ctx.getBean(query, Action.class); //요청에 따라 여러 bean들을 가져올 수 있음 
		// 컨트럴러가 해당 TodayAction이라는 모델의 메서드를 호출@
		ActionForward af = action.execute(req, resp);
		StringBuffer path = new StringBuffer();
		path.append("/WEB-INF/jsp/").append(af.getUrl()); 
		// 이동방식
		if (af.isUrlMethod()) { // true
			// forward될 객체에게 req, resp를 전달하여 유지 시킨다.
			resp.sendRedirect(path.toString());

		} else {
			RequestDispatcher rd = req.getRequestDispatcher(path.toString());
			rd.forward(req, resp);
		}
	}
}
