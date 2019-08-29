package com.zking.sys.jwt;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;

/**
 * * JWT验证过滤器，配置顺序 ：CorsFilte-->JwtFilter-->struts2中央控制器
 * 
 * @author Administrator
 *
 */
public class JwtFilter implements Filter {

	// 排除的URL，一般为登陆的URL(请改成自己登陆的URL)
	private static String EXCLUDE = "^/sys/userAction_dologin\\.action([?].*)?$";
	
	//private static String EXCLUDE = "^/sale/userAction_dologin\\.action([?].*)?$";
	//private static String EXCLUDE = "^/sys/(userAction_doLogin|captchaAction)\\.action?.*$";

	private static Pattern PATTERN = Pattern.compile(EXCLUDE);

	private boolean OFF = true;// true关闭jwt令牌验证功能

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getServletPath();
		if (OFF || isExcludeUrl(path)) {//isExcludeUrl排除 登陆直接放行
			chain.doFilter(request, response);
			return;
		}

		// 从客户端请求头中获得令牌并验证
		//取令牌  验证jwt令牌validateJwtToken（）
		String jwt = req.getHeader(JwtUtils.JWT_HEADER_KEY);
		Claims claims = this.validateJwtToken(jwt);
		if (null == claims) {//有问题时  如没jwt   监听了所有action请求
			// resp.setCharacterEncoding("UTF-8");
			resp.sendError(403, "JWT令牌已过期或已失效");
			return;
		} else {//当令牌有效,刷新令牌    copyJwt复制令牌  设置新的时间
			String newJwt = JwtUtils.copyJwt(jwt, JwtUtils.JWT_WEB_TTL);
			//jwt保存到响应头，返回给客户端
			resp.setHeader(JwtUtils.JWT_HEADER_KEY, newJwt);
			chain.doFilter(request, response);
		}
	}

	/**
	 * 验证jwt令牌，验证通过返回声明(包括公有和私有)，返回null则表示验证失败
	 */
	private Claims validateJwtToken(String jwt) {
		Claims claims = null;
		try {
			if (null != jwt) {
				claims = JwtUtils.parseJwt(jwt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claims;
	}

	/**
	 * 是否为排除的URL
	 * 
	 * @param path
	 * @return
	 */
	private boolean isExcludeUrl(String path) {
		Matcher matcher = PATTERN.matcher(path);
		boolean b = matcher.matches();
		if (b) {
			System.out.println("path[" + path + "]直接放行了");
		}else {
			System.out.println("path[" + path + "]需要拦截");
		}
		return b;
	}

	// public static void main(String[] args) {
	// String path = "/sys/userAction_doLogin.action?username=zs&password=123";
	// Matcher matcher = PATTERN.matcher(path);
	// boolean b = matcher.matches();
	// System.out.println(b);
	// }

}
