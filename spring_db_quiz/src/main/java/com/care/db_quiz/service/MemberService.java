package com.care.db_quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.db_quiz.dto.MemberDTO;
import com.care.db_quiz.repository.IMemberDAO;

@Service
public class MemberService {
	
	@Autowired private IMemberDAO dao;
	
	public String register(MemberDTO dto) {
		
		// 아이디 체크
		if (dto.getId() == null) {
			return "아이디 없음";
		}
		// 비밀번호 체크
		if (dto.getPwd1() == null) {
			return "비밀번호 확인";
			
		// 비밀번호 일치여부 확인
		} else if (dto.getPwd1().equals(dto.getPwd2())) {
			// 중복체크
			if (dao.selectMember(dto.getId()) == null) {
				dao.insert(dto);
				return "회원가입 성공";
				
			}else {
				
				return "중복 아이디";
			}
		} else {
			return "비밀번호 틀림";
			
		}
	}

	public String login(String id, String pw) {
		MemberDTO member = dao.selectMember(id);
		System.out.println("id: " + member.getId() + ", pw1: " +  member.getPwd1() + ", pwd2: " + member.getPwd2() );
		if (member == null) {
			return "아이디 없음";
		}
		if(member.getPwd1().equals(pw)) {
			return "로그인 성공";
		} else {
			return "비밀번호 틀림";
		}
	}
	
	public MemberDTO selectMember(String id) {
		return dao.selectMember(id);
	}
	
	public List<MemberDTO> selectAllMember(){
		return dao.selectAllMember();
	}
	
	
	public String update(MemberDTO dto) {
		MemberDTO oldDto = dao.selectMember(dto.getId());
		if (dto.getPwd1().equals(dto.getPwd2())) {
			int result = dao.update(dto);
			
			if (result == 1) return "업데이트 완료";
			else return " 업데이트 실패";
			
		} else {
			return "두 비밀번호 불일치";
		}
	}
	
	public String delete(MemberDTO dto) {
		MemberDTO oldDto = dao.selectMember(dto.getId());
		if (dto.getPwd1().equals(dto.getPwd2())) {
			if (dto.getPwd1().equals(oldDto.getPwd1())) {
				int result = dao.delete(dto);
				
				if (result == 1) return "회원삭제 완료";
				else return "회원삭제 실패";
				
			} else {
				return "비밀번호 불일치";
			}
			
		} else {
			return "두 비밀번호 불일치";
		}
	}

}

