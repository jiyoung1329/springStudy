package com.db.basic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.basic.dto.MemberDTO;
import com.db.basic.service.MemberService;

@Controller
public class MemberController {
	@Autowired private MemberService service;
	
	@RequestMapping("index")
	public String index() {
		return "member/index";
	}
	@GetMapping("member")
	public String member() {
		return "member/member";
	}
	@PostMapping("member")
	public String member(MemberDTO member, String confirmPw, Model model) {
		String msg = service.member(member, confirmPw);
		model.addAttribute("msg", msg);
		if(msg.equals("가입 완료"))
			return "member/index";
		return "member/member";
	}
	
	@ResponseBody
	@PostMapping("double_check")
	public String member(@RequestBody String id) {
		return service.doubleCheck(id);
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	@PostMapping("login")
	public String login(MemberDTO member, Model model) {
		String msg = service.login(member);
		model.addAttribute("msg", msg);
		if(msg.equals("로그인 성공"))
			return "member/index";
		return "member/login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/index";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("list", service.list());
		return "member/list";
	}
	@GetMapping("update")
	public String update() {
		return "member/update";
	}
	@PostMapping("update")
	public String update(MemberDTO member, String confirmPw) {
		service.update(member, confirmPw);
		return "member/index";
	}
	@GetMapping("delete")
	public String delete() {
		return "member/delete";
	}
	@PostMapping("delete")
	public String delete(String pw, String confirmPw) {
		String msg = service.delete(pw, confirmPw);
		return "member/index";
	}
}
