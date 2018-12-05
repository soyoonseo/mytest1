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

	// � ��û�� ������ ��� ó���ϴ� �޼��带 ����
	protected void myProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=euc-kr");
		req.setCharacterEncoding("euc-kr");
		String query = req.getParameter("query");
		System.out.println("query: " + query);
		// todayview ��û
		Action action = ctx.getBean(query, Action.class); //��û�� ���� ���� bean���� ������ �� ���� 
		// ��Ʈ������ �ش� TodayAction�̶�� ���� �޼��带 ȣ��@
		ActionForward af = action.execute(req, resp);
		StringBuffer path = new StringBuffer();
		path.append("/WEB-INF/jsp/").append(af.getUrl()); 
		// �̵����
		if (af.isUrlMethod()) { // true
			// forward�� ��ü���� req, resp�� �����Ͽ� ���� ��Ų��.
			resp.sendRedirect(path.toString());

		} else {
			RequestDispatcher rd = req.getRequestDispatcher(path.toString());
			rd.forward(req, resp);
		}
	}
}
