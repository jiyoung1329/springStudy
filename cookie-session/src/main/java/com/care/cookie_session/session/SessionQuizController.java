package com.care.cookie_session.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionQuizController {
	
	@GetMapping("session/login")
	public void login() {}
	
	@PostMapping("session/login")
	public String login(HttpServletRequest req, HttpSession session) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		System.out.println("id: " + id + ", pw: " + pw);
		if (id.equals("admin") && pw.equals("1234")) {
			session.setAttribute("id", "admin");
		} else {
			return "redirect:login";
		}
		return "redirect:index";
		
		
		
	}
	
	@RequestMapping("session/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
	
	@RequestMapping("session/index")
	public void index() {}
}
