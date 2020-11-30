package web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;

@Controller
public class LoginInterceptorController implements HandlerInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptorController.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null) {
			
			response.sendRedirect("/member/login");
			return false;
		}
		return true;
	}
}
