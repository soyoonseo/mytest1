package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ActionForward;

public class TodayView implements Action{
	private String url;
	private boolean method;
	public void setUrl(String url) {
		this.url = url;
	}	
	public void setMethod(boolean method) {
		this.method = method;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		StringBuffer sb = new StringBuffer();
		sb.append("오늘의 날짜는");
		sb.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		sb.toString();
		req.setAttribute("today", sb.toString());
		return new ActionForward(url, method);
	}

}
