package com.example.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;


@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserDAO dao;
	
	//사용자데이터 저장
	@PostMapping("/insert")
	public void insert(UserVO vo) {
		System.out.println(vo.toString());
		dao.insert(vo);
	}
	
	//사용자등록 페이지
	@GetMapping("/insert")
	public String insert() {
		return "/users/insert.html";
	}
	//사용자목록 페이지
	@GetMapping("/list")
	public String listPage() {
		return "/users/list.html";
	}
	
	//사용자목록 데이터 출력
	@GetMapping("")
	@ResponseBody
	public List<HashMap<String,Object>> listData(){
		return dao.list();
	}
	
}
