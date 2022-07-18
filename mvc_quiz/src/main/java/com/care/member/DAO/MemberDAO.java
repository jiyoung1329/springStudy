package com.care.member.DAO;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.member.DTO.MemberDTO;

@Repository
public class MemberDAO {
	private ArrayList<MemberDTO> list;
	
	public MemberDAO() {
		list = new ArrayList<>();
	}
	
	public ArrayList<MemberDTO> list() {
		return list;
	}
	
	public int register(MemberDTO member) {
		boolean tmp = list.add(member);
		if (tmp == true) {
			return 1;
			
		}
		return 0;
	}
}
