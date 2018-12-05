package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res);
}
