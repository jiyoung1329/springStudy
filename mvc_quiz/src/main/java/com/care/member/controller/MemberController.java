package com.care.member.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member.DTO.MemberDTO;
import com.care.member.service.MemberService;


@Controller
public class MemberController {
	@Autowired MemberService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		ArrayList<MemberDTO> list = service.list();
		if (list == null || list.isEmpty()) {
			model.addAttribute("list", "등록된 정보가 없습니다.");
		} else {
			model.addAttribute("list", list);
		}
		
		return "list";
		
	}
	
	@GetMapping("register")
	public void register() {}
	
	@PostMapping("register")
	public String register(MemberDTO dto) {
		String msg = service.register(dto);
		if(msg.equals("가입완료")) {
			return "redirect:list";
		}else {
			return "register";
			
		}
				
	}
}
