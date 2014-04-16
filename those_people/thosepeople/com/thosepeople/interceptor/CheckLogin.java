/**
 * 
 */
package com.thosepeople.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author chenzhuo
 *
 */
public class CheckLogin extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Object userInfo=request.getSession().getAttribute("userInfo");
		if(userInfo==null){
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return false;
		}
		return true;
	}


}
