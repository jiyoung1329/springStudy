package com.db.basic.controller;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.basic.service.MailService;

@RestController
public class EmailController {
	@Autowired private MailService service;
	private String number;
	
	@PostMapping("sendAuth")
	public String sendAuth(@RequestBody(required=false) String email) {
		System.out.println("email: " + email);
		Random r = new Random();
		r.nextInt(1000000);
		number = String.format("%06d", r.nextInt(1000000));
		System.out.println(number);
		service.sendMail(email, "인증번호: ", number);
		return "success";
	}
	
	@PostMapping("checkAuth")
	public String checkAuth(@RequestBody(required=false) String authNumber) {
		System.out.println("인증번호: " + authNumber);
		if (authNumber == null || authNumber.isEmpty()) {
			return "empty";
		}
		if (authNumber.equals(number) == false) {
			return "fail";
		}
		return "success";
		
	}
}
