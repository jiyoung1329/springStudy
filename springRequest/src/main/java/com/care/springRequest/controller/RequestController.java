package com.care.springRequest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.springRequest.dto.LoginDTO;
import com.care.springRequest.service.RequestService;

@Controller
public class RequestController {
	@Autowired private RequestService service;
	
	@RequestMapping("index")
	public void index() {}
	
	// 만약 jsp 파일명과 mapping 주소명이 동일하면 return "login" 생략 가능
	@GetMapping("login")
	public void login() {
		System.out.println("get 요청의 login 메소드 실행");
	}
	
	@PostMapping("login")
//	public void login(String id, String pw) {
//	public void login(HttpServletRequest req) {
//	public void login(@RequestParam("id")String id, @RequestParam("pw")String pw) {
	public String login(LoginDTO login, Model model) {
//		System.out.println("id: " + id);
//		System.out.println("pw: " + pw);
		
//		System.out.println("id: " + req.getParameter("id"));
//		System.out.println("pw: " + req.getParameter("pw"));
		
		System.out.println("id: " + login.getId());
		System.out.println("pw: " + login.getPw());
		// model 생명주기 존재
		model.addAttribute("id", login.getId());
		model.addAttribute("pw", login.getPw());
		model.addAttribute("login", login);
//		return "index";
		// return "index": viewReselver에게 전달하여 jsp파일을 찾아 실행 후 결과를 클라이언트에게 응답
		// return "redirect:index": 응답으로 요청 경로를 제공함, 요청 경로를 받은 클라이언트가 서버에 재요청함
		// return "forward:index": 요청경로를 서버 내부에서 요청함, 서버 내부에서 Mapping을 찾아 메소드 실행
		return "redirect:index";
//		return "forward:index";
		
	}

	@GetMapping("register")
	public void getRegister() {}
	
	@PostMapping("register")
	public String postRegister(LoginDTO login, String name,
			Model model, RedirectAttributes ra) {
		
		
		String result = service.register(login ,name);
		if (result == "가입 완료") {
			// RedirectAttributes: redirect시 데이터를 담아 전달하기 위해서 사용하는 객체
			ra.addFlashAttribute("msg", result);
			return "redirect:index";
		} 
		model.addAttribute("msg", result);
		return "register";
	}
}
