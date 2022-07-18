package com.care.mvc_quiz.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.care.mvc_quiz.dto.MemberDTO;
import com.care.mvc_quiz.dto.repository.MemberRepository;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	public MemberService() {
		memberRepository = new MemberRepository();
	}
	
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
			if (memberRepository.selectMember(dto.getId()) == null) {
				memberRepository.insert(dto);
				return "회원가입 성공";
				
			}else {
				
				return "중복 아이디";
			}
		} else {
			return "비밀번호 틀림";
			
		}
	}

	public String login(String id, String pw) {
		MemberDTO member = memberRepository.selectMember(id);
		if (member == null) {
			return "아이디 없음";
		} else if(member.getPwd1().equals(pw)) {
			return "로그인 성공";
		} else {
			return "비밀번호 틀림";
		}
	}
	
	public MemberDTO selectMember(String id) {
		return memberRepository.selectMember(id);
	}
	
	public ArrayList<MemberDTO> selectAllMember(){
		return memberRepository.selectAllMember();
	}
	
	
	public String update(MemberDTO dto) {
		MemberDTO oldDto = memberRepository.selectMember(dto.getId());
		if (dto.getPwd1().equals(dto.getPwd2())) {
			boolean result = memberRepository.update(dto);
			
			if (result) return "업데이트 완료";
			else return " 업데이트 실패";
			
		} else {
			return "두 비밀번호 불일치";
		}
	}
	
	public String delete(MemberDTO dto) {
		MemberDTO oldDto = memberRepository.selectMember(dto.getId());
		if (dto.getPwd1().equals(dto.getPwd2())) {
			if (dto.getPwd1().equals(oldDto.getPwd1())) {
				boolean result = memberRepository.delete(dto);
				
				if (result) return "회원삭제 완료";
				else return "회원삭제 실패";
				
			} else {
				return "비밀번호 불일치";
			}
			
		} else {
			return "두 비밀번호 불일치";
		}
	}

}

