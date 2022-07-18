package com.care.cookie_session.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	@RequestMapping("cookie/index")
	public String index(HttpServletResponse response) {
//		Cookie cookie = new Cookie("cookieName", "cookieValue");
//		cookie.setMaxAge(30);
//		response.addCookie(cookie);
//		System.out.println(response);
		
		return "cookie/index";
				
	}
	
	@RequestMapping("cookie/result")
	public String result(@CookieValue(value="cookieName", required=false) Cookie clientSendCookie,
			Model model, HttpServletRequest request) {

		if (clientSendCookie == null) {
			model.addAttribute("clientSendCookie", "쿠키없음");
		}else {
			model.addAttribute("clinetSendCookie", clientSendCookie.getValue());
				
		}
		return "cookie/result";
			
	}
	
	@RequestMapping("cookie/popup")
	public void popup() {}

	@RequestMapping("cookie/closePopup")
	public void closePopup() {}
	
	@RequestMapping("cookie/addCookie")
	public void addCookie(HttpServletResponse res) {
		Cookie cookie = new Cookie("popup", "pop");
		cookie.setMaxAge(60 * 60 * 24);
		res.addCookie(cookie);
		
	}
	
	
	
}
