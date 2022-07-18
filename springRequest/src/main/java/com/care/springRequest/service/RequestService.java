package com.care.springRequest.service;

import org.springframework.stereotype.Service;

import com.care.springRequest.dto.LoginDTO;

@Service
public class RequestService {
	public String register(LoginDTO login, String name) {
		if (login.getId() == null || login.getId().isEmpty()) {
			return "아이디를 입력하세요";
		
		} else if (login.getPw() == null || login.getPw().isEmpty()) {
			return "비밀번호를 입력하세요";
		}
		return "가입 완료";
	}
}
