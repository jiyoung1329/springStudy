package com.care.member.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.care.member.DAO.MemberDAO;
import com.care.member.DTO.MemberDTO;

@Service
public class MemberService {
	private MemberDAO dao;
	
	public MemberService() {
		dao = new MemberDAO();
	}
	
	
	public ArrayList<MemberDTO> list(){
		ArrayList<MemberDTO> list = dao.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
			
	}

	public String register(MemberDTO dto) {
		if (dto.getId() == null || dto.getId().isEmpty()) {
			return "아이디를 입력하세요";
		}
		int returnData = dao.register(dto);
		if (returnData == 1) {
			return "가입완료";
		} else {
			return "가입실패";
		}
	}
}
