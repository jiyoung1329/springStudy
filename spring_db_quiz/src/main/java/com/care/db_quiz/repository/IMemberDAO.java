package com.care.db_quiz.repository;

import java.util.List;

import com.care.db_quiz.dto.MemberDTO;

public interface IMemberDAO {
	int insert(MemberDTO member);
	
	MemberDTO selectMember(String id);
	
	List<MemberDTO> selectAllMember();
	
	int update(MemberDTO member);
	
	int delete(MemberDTO memeber);
	
	
}
