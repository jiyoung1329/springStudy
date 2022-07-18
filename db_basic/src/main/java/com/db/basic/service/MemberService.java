package com.db.basic.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.db.basic.dto.MemberDTO;
import com.db.basic.repository.IMemberDAO;

@Service
public class MemberService {
	@Autowired private IMemberDAO dao;
	@Autowired private HttpSession session;
	
	
	public String doubleCheck(String id) {
		if (id == null || id.isEmpty()) {
			return "input";
		}
		
		MemberDTO check = dao.login(id);
		if (check != null) {
			return "double";
		}
		
		return "pass";
		
		
	}
	
	
	public String member(MemberDTO member, String confirmPw) {
		if(member.getId() == null || member.getId().isEmpty())
			return "필수 정보 입니다.";
		if(member.getPw() == null || member.getPw().isEmpty())
			return "필수 정보 입니다.";
		if(member.getPw().equals(confirmPw) == false) {
			return "입력하신 두 비밀번호를 확인하세요";
		}
		MemberDTO check = dao.login(member.getId());
		if(check != null)
			return "다른 아이디로 가입을 시도하세요";
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		String encryptPw = encoder.encode(member.getPw());
		System.out.println(encryptPw);
		member.setPw(encryptPw);
		
		int result = dao.member(member);
		
		
		if(result != 1)
			return "가입 실패";
		return "가입 완료";
	}
	
	
	public String login(MemberDTO member) {
		if(member.getId() == null || member.getId().isEmpty()) {
			return "필수 정보입니다.";
		}
		MemberDTO check = dao.login(member.getId());
		if(check == null)
			return "아이디 또는 비밀번호를 확인 후 다시 시도하세요.";
		
		// 비빌번호 
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		encoder.matches(member.getPw(), check.getPw());
		
		if(encoder.matches(member.getPw(), check.getPw()) == false) {
			return "아이디 또는 비밀번호를 확인 후 다시 시도하세요.";
		}
		
		session.setAttribute("id", check.getId());
		session.setAttribute("name", check.getName());
		session.setAttribute("email", check.getEmail());
		return "로그인 성공";
	}

	public List<MemberDTO> list() {
		List<MemberDTO> list = dao.list();
		return list;
	}

	public String update(MemberDTO member, String confirmPw) {
		String sessionId = (String)session.getAttribute("id");
		if(sessionId == null || sessionId.isEmpty()) {
			return "로그인 후 이용하세요.";
		}
		if(member.getPw() == null || member.getPw().isEmpty())
			return "필수 정보 입니다.";
		if(member.getPw().equals(confirmPw) == false) {
			return "입력하신 두 비밀번호를 확인하세요";
		}
		member.setId(sessionId);
		dao.update(member);
		session.invalidate();
		return "수정 완료";
	}

	public String delete(String pw, String confirmPw) {
		String sessionId = (String)session.getAttribute("id");
		if(sessionId == null || sessionId.isEmpty()) {
			return "로그인 후 이용하세요.";
		}
		if(pw == null || pw.isEmpty())
			return "필수 정보 입니다.";
		if(pw.equals(confirmPw) == false) {
			return "입력하신 두 비밀번호를 확인하세요";
		}
		MemberDTO result = dao.login(sessionId);
		if(result.getPw().equals(pw) == false)
			return "비밀번호를 확인하세요.";
		
		int test_result = dao.delete(sessionId);
		session.invalidate();
		return "삭제 완료";
	}
}
