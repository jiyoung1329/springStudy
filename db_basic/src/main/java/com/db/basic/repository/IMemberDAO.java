package com.db.basic.repository;

import java.util.List;

import com.db.basic.dto.MemberDTO;

public interface IMemberDAO {
	int member(MemberDTO member);
	
	MemberDTO login(String id);
	
	List<MemberDTO> list();
	
	int update(MemberDTO member);
	
	int delete(String sessionId);
}
