package com.care.mvc_quiz;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.mvc_quiz.dto.MemberDTO;
import com.care.mvc_quiz.service.MemberService;

@Controller
public class MemberController {
@Autowired MemberService memberService;
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}

	@PostMapping("login")
	public String login(RedirectAttributes rttr, HttpSession session, MemberDTO dto, Model model) {
		String msg = memberService.login(dto.getId(), dto.getPwd1());
		
		if (msg.equals("로그인 성공")) {
			session.setAttribute("id", dto.getId());
			rttr.addFlashAttribute("msg", msg);
			return "redirect:index";
			
		} else {
			model.addAttribute("msg", msg);
			return "member/login";
		}
	}
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("register")
	public String register(RedirectAttributes rttr, MemberDTO dto, Model model) {
		String msg = memberService.register(dto);
		
		if (msg.equals("회원가입 성공")){
			rttr.addFlashAttribute("msg", msg);
			return "redirect:login";
		} else {
			model.addAttribute("msg", msg);
			return "member/register";
		}
	}
	
	@GetMapping("logout")
	public String logout(RedirectAttributes rttr, HttpSession session) {
		session.invalidate();
		rttr.addFlashAttribute("msg", "로그아웃");
		return "redirect:index";
	}
	
	@RequestMapping("member_list")
	public String memberList(Model model) {
		model.addAttribute("members", memberService.selectAllMember());
		return "member/memberInfo";
	}
	
	@GetMapping("user_info")
	public String userInfo(Model model, @RequestParam String id) {
		MemberDTO member = memberService.selectMember(id);
		if (member == null) {
			return "redirect:memberList";
			
		} else {
			model.addAttribute("member", member);
			return "member/userInfo";
			
		}
	}
	
	@GetMapping("update")
	public String update(@RequestParam String id, HttpSession session, Model model) {
		MemberDTO member = memberService.selectMember((String) session.getAttribute("id"));
		String msg = "";
		
		if (member == null) {
			msg = "로그인 필요";
			model.addAttribute("msg", msg);
			
		} else {
			model.addAttribute("msg", msg);
			model.addAttribute("member", member);
		}
		return "member/update";
				
	}
	
	@PutMapping("update")
	public String update(RedirectAttributes rttr, HttpSession session, MemberDTO dto, Model model) {
		System.out.println("update id: " + dto.getId());
		String msg = memberService.update(dto);
		System.out.println("update: " + msg);
		if (msg.equals("업데이트 완료")) {
			rttr.addFlashAttribute("msg", msg);
			return "redirect:index";
		}else {
			model.addAttribute("member", dto);
			model.addAttribute("msg", msg);
			return "member/update";
		}
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam String id, HttpSession session) {
		return "member/delete";
	}
	
	@DeleteMapping("delete")
	public String delete(RedirectAttributes rttr, HttpSession session, MemberDTO dto, Model model) {
		String msg = memberService.delete(dto);
		
		if (msg.equals("회원삭제 완료")) {
			rttr.addFlashAttribute("msg", msg);
			return "redirect:index";
		}else {
			model.addAttribute("member", dto);
			model.addAttribute("msg", msg);
			return "member/delete";
		}
	}
	
	
	
	
	
	
	
}
