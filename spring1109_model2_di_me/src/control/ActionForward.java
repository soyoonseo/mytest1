package control;

public class ActionForward {
	private boolean urlMethod; // true: forward, false: redirect
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ActionForward(String viewName, boolean urlMethod) {
		this.urlMethod = urlMethod;
		this.viewName = viewName;
	}
	private String viewName;  // view ¿Ã∏ß
	
	public boolean isUrlMethod() {
		return urlMethod;
	}
	public void setUrlMethod(boolean urlMethod) {
		this.urlMethod = urlMethod;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	
}
