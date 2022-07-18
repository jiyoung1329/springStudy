package com.db.basic.repository;

import java.util.ArrayList;

import com.db.basic.dto.AjaxDTO;

public interface IAjaxDAO {

	int insert(AjaxDTO dto);
	ArrayList<AjaxDTO> titleAll();
	ArrayList<AjaxDTO> titleSearch(String title);
	ArrayList<AjaxDTO> artistSearch(String artist);
	ArrayList<AjaxDTO> priceSearch(String price);
}
