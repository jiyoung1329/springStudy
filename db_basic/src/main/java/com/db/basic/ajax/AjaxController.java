package com.db.basic.ajax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.basic.dto.SearchDTO;
import com.db.basic.service.AjaxService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class AjaxController {
	@GetMapping("ex1")
	public String ex1() {
		System.out.println("ex1 GET 메소드 요청");
		return "ajax/ex1";
	}

	@ResponseBody
	// produces = "text/html; charset=UTF-8" : 클라이언트에서 한글데이터 응답 시 입력
	@PostMapping(value = "ex1", produces = "text/html; charset=UTF-8")
	public String ex1Post() {
		System.out.println("AJAX POST 메소드 요청");
		return "AJAX 방식의 서버 응답 데이터";
	}

	@GetMapping("ex2")
	public String ex2() {
		System.out.println("ex1 GET 메소드 요청");
		return "ajax/ex1";
	}

	@ResponseBody
	@PostMapping(value = "ex2", produces = "text/html; charset=UTF-8")
	public String ex2Post(@RequestBody(required = false) String requestData) {
		System.out.println("AJAX POST 메소드 요청");
		return requestData;
	}
//	

	@GetMapping("ex3")
	public String ex3() {
		System.out.println("ex3 GET 메소드 요청");
		return "ajax/ex3";
	}

	@ResponseBody
	@PostMapping(value = "ex3", produces = "application/json; charset=UTF-8")
	public HashMap<String, String> ex3Post() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", "admin");
		map.put("pw", "admin1234");
		return map;
	}

	@GetMapping("ex4")
	public String ex4() {
		System.out.println("ex4 GET 메소드 요청");
		return "ajax/ex4";
	}

	@ResponseBody
	@PostMapping(value = "ex4", produces = "application/json; charset=UTF-8")
	public HashMap<String, String> ex4Post(@RequestBody(required = false) String data) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", data);
		return map;
	}

	@GetMapping("ex5")
	public String ex5() {
		System.out.println("ex5 GET 메소드 요청");
		return "ajax/ex5";
	}

	@ResponseBody
	@PostMapping(value = "ex5")
	public String ex5Post() throws FileNotFoundException, IOException {
		ClassPathResource resource = new ClassPathResource("ex5.json");
		FileReader reader = new FileReader(resource.getFile());
		BufferedReader buffer = new BufferedReader(reader);

		HashMap<String, String> map = new HashMap<String, String>();

		StringBuilder data = new StringBuilder();
		while (true) {
			String tmp = buffer.readLine();
			if (tmp == null)
				break;

			data.append(tmp);
		}
		System.out.println(data);
		buffer.close();

		return data.toString();
	}

	@GetMapping("ex6")
	public String ex6() {
		System.out.println("ex6 GET 메소드 요청");
		return "ajax/ex6";
	}

	@ResponseBody
	@PostMapping(value = "ex6")
	public String ex6Post(@RequestBody(required = false) String search) throws FileNotFoundException, IOException {
		System.out.println("search: " + search);

		ClassPathResource resource = new ClassPathResource("ex5.json");
		FileReader reader = new FileReader(resource.getFile());

		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		System.out.println(obj.getClass());

		if (search == null || search.isEmpty()) {
			return obj.toString();
		}

		String result = "{\"cd\": [";

		JsonArray arr = obj.getAsJsonArray("cd");

		ArrayList<JsonObject> searchResult = new ArrayList<JsonObject>();

		for (int i = 0; i < arr.size(); i++) {
			JsonObject cd = (JsonObject) arr.get(i);

			String jsonTitle = cd.get("title").getAsString();
			String jsonArtist = cd.get("artist").getAsString();
			String jsonPrice = cd.get("price").getAsString();
			if (jsonTitle.contains(search)) {
				result += "{\"title\": \"" + jsonTitle + "\", \"artist\": \"" + jsonArtist + "\", \"price\": \""
						+ jsonPrice + "\"},";
			}

		}
		result = result.substring(0, result.length() - 1);
		result += "]}";
		System.out.println(result);
		return result;
	}

	@GetMapping("ex7")
	public String ex7() {
		System.out.println("ex7  GET 메소드 요청");
		return "ajax/ex7";
	}

	@ResponseBody
	@PostMapping("ex7")
	public String ex7(@RequestBody(required = false) String title) {
		System.out.println("title: " + title);
		if (title == null || title.isEmpty()) {
			return service.titleAll();

		} else {
			return service.titleSearch(title);
		}
	}

	@Autowired
	private AjaxService service;

	@ResponseBody
	@PostMapping(value = "ex7Insert", produces = "text/html; charset=UTF-8")
	public String ex7Insert() throws FileNotFoundException, IOException {
		System.out.println("ex7Insert");
		String msg = service.insert();

		return msg;
	}

	@GetMapping(value="ex8")
	public String ex8() {
		System.out.println("ex8  GET 메소드 요청");
		return "ajax/ex8";
	}

	@ResponseBody
	@PostMapping(value="ex8", produces = "text/html; charset=UTF-8")
	public String ex8(@RequestBody(required = false) HashMap<String, String> searchInput) {
		String search = searchInput.get("search");
		String option = searchInput.get("option");
//		System.out.println("option: " + option + ", search: " + search);
		
		if (search == null || search.isEmpty()) {
			return service.titleAll();

		} else {
			return service.search(option, search);
		}
	}

}