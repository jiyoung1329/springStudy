package com.care.mvc_quiz.dto.repository;

import java.util.ArrayList;

import com.care.mvc_quiz.dto.MemberDTO;

public class MemberRepository {
	private ArrayList<MemberDTO> db;
	
	public MemberRepository() {
		db = new ArrayList<MemberDTO>();
	}
	
	/*
	 * header.jsp에서 페이지 매핑
	 * register 기능 구현(Controller => Service => Repository)
	 * login 기능 구현(Controller => Service => Repository)
	 * 
	 */
	
	public boolean insert(MemberDTO dto) {
		 return db.add(dto);
	}
	
	public MemberDTO selectMember(String id) {
		for (MemberDTO dto: db) {
			if (dto.getId().equals(id)) {
				return dto;
			}
		}
		return null;
	}
	
	public ArrayList<MemberDTO> selectAllMember(){
		return db;
	}
	
	public boolean update(MemberDTO dto) {
		System.out.println("update: " + dto.getPwd1());
		for (int i=0; i<db.size(); i++) {
			System.out.println(db.get(i).getId() + " "+ dto.getId() +" " +  db.get(i).getId().equals(dto.getId()));
			if (db.get(i).getId().equals(dto.getId())) {
				db.set(i, dto);
				return true;
			}
		}
		return false;
			
	}
	
	public boolean delete(MemberDTO dto) {
		for (int i=0; i<db.size(); i++) {
			if (db.get(i).getId().equals(dto.getId())) {
				db.remove(i);
				return true;
			}
		}
		return false;
	}
}
