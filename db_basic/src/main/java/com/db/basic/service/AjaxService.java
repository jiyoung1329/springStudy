package com.db.basic.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.db.basic.dto.AjaxDTO;
import com.db.basic.repository.IAjaxDAO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class AjaxService {
	@Autowired
	private IAjaxDAO dao;

	public String insert() throws FileNotFoundException, IOException {
		ClassPathResource resource = new ClassPathResource("ex5.json");
		FileReader reader = new FileReader(resource.getFile());

		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		System.out.println(obj.getClass());

		JsonArray arr = obj.getAsJsonArray("cd");

		ArrayList<AjaxDTO> cds = new ArrayList<>();

		for (int i = 0; i < arr.size(); i++) {
			JsonObject cd = (JsonObject) arr.get(i);

			String title = cd.get("title").getAsString();
			String artist = cd.get("artist").getAsString();
			String price = cd.get("price").getAsString();

			int data = dao.insert(new AjaxDTO(title, artist, price));
			if (data == 0) {
				return i + "번째 행에서 문제가 발생하였습니다.";
			}
		}

		return "파일 -> db 이전 완료";

	}

	public String fromJson(ArrayList<AjaxDTO> list) {
		String data = "{\"cd\": [";

		for (AjaxDTO cd: list) {
			data += "{\"title\": \"" + cd.getTitle() + "\", \"artist\": \"" + cd.getArtist() + "\", \"price\": \""+ cd.getPrice() + "\"},";

		}
		if (list.size() > 0) {
			data = data.substring(0, data.length() - 1);
		}
		
		data += "]}";
		
		return data;
	}

	public String titleAll() {
		System.out.println("titleAll 1");
		ArrayList<AjaxDTO> list = dao.titleAll();
		System.out.println("titleAll 2");
		String result = fromJson(list);
		return result;

	}

	public String titleSearch(String title) {
		System.out.println("titleSearch c1");
		ArrayList<AjaxDTO> list = dao.titleSearch(title);
		System.out.println("titleSearch c2");
		String result = fromJson(list);
		return result;

	}
	
	public String search(String option, String search) {
		
		ArrayList<AjaxDTO> list = new ArrayList<>();
		if (option.equals("title")){
			list = dao.titleSearch(search);
			
		} else if (option.equals("artist")) {
			list = dao.artistSearch(search);
			
		} else {
			list = dao.priceSearch(search);
			
		}
		String result = fromJson(list);
		return result;
		
	}
}
