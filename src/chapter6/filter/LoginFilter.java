package chapter6.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chapter6.beans.User;

@WebFilter("/edit")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) request).getSession();
        User loginUser = (User) session.getAttribute("loginUser");

		if (!(loginUser == null)) {
			//リクエストされているサーブレットに移行
			chain.doFilter(request, response);
		}else {
			List<String> errorMessages = new ArrayList<String>();
			errorMessages.add("ログインしてください");
			//request.setAttribute("errorMessages", errorMessages);
			session.setAttribute("errorMessages", errorMessages);
			//ログイン画面に移行
			((HttpServletResponse) response).sendRedirect("./login");

		}



	}
	@Override
	public void init(FilterConfig config) {
	}
	@Override
	public void destroy() {
	}
}
