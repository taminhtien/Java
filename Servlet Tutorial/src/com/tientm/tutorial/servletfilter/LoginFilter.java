package com.tientm.tutorial.servletfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tientm.tutorial.beans.UserInfo;

/*@WebFilter(filterName = "LoginFilter", urlPatterns = { "/info/*",
		"/somepath/abc/*" })
*/
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	@Override
	public void destroy() {
	}

	private String getFullRequestURL(HttpServletRequest req) {
		// Ví dụ: http://localhost:8080/contextPath/servletPath
		String requestURL = req.getRequestURL().toString();
		// Ví dụ: text1=Hello&text2=World
		String queryString = req.getQueryString();
		if (queryString == null) {
			return requestURL;
		}
		return requestURL + "?" + queryString;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("- Filter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String servletPath = req.getServletPath();
		System.out.println("- Servlet Path: " + servletPath);

		HttpSession session = req.getSession();

		// Lấy đối tượng UserInfo đã ghi vào session khi đăng nhập thành công
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		// Nếu chưa từng đăng nhập hoặc đăng nhập không thành công
		// userInfo sẽ null
		if (userInfo == null) {
			System.out.println("userInfo = null");
			// Nếu hiện tại không phải là trang /loginForm và /doLogin
			// thì chuyển đến trang /loginForm
			// Tránh lặp vô tận
			if (!servletPath.equals("/loginForm")
					&& !servletPath.equals("/doLogin")) {
				// Lấy ra request URL hiện tại
				// để lưu trữ lại để sau khi login thành công sẽ tự chuyển lại
				// trang này
				String callbackURL = this.getFullRequestURL(req);
				System.out.println("- callbackURL: " + callbackURL);

				// Lưu vào request
				// Dữ liệu này chỉ tồn tại trong trang chuyển tiếp
				// Chuyển tiếp sang trang /loginForm sẽ có
				req.setAttribute("callbackURL", callbackURL);

				// Sử dụng RequestDispatcher để chuyển tiếp
				// tới LoginFormServlet
				// Đồng thời truyền các thông tin trong attribute sang trang mới
				RequestDispatcher dispatcher = req.getServletContext()
						.getRequestDispatcher("/loginForm");
				dispatcher.forward(req, res);
				System.out.println("- forward to /loginForm");
				return;
			}
		}
		// Nếu người dùng đăng nhập rồi, gọi Filter mặc định
		System.out.println("userInfo != null");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
