package com.example.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.DAO.UsersDAO;
import com.example.domain.UserVO;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	UsersDAO dao;
	
	//사용자목록 데이터 
	@GetMapping("")
	@ResponseBody
	public List<HashMap<String,Object>> list(){
		return dao.list();
	}
	//사용자등록화면이동
	@GetMapping("/insert")
	public String insert() {
		return "/users/insert.html";
	}
	
	//사용자등록
	@PostMapping("/insert")
	public String insert(UserVO vo) {
		System.out.println(vo.toString());
		return "redirect:/"; // insert 내용을 받아서 VO로 보내고 루트로 보냄
	}
}



