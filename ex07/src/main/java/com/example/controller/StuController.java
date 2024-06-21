package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.StuDAO;
import com.example.domain.QueryVO;
import com.example.domain.StuVO;
import com.example.service.StuService;

@RestController
@RequestMapping("/stu")
public class StuController {
	@Autowired
	StuDAO dao;
	
	@Autowired
	StuService service;
	
	@PostMapping("/insert")
	public void insert(@RequestBody StuVO vo) {
		service.insert(vo);
	}
	
	@GetMapping("") //테스트 /stu?page=1&size=2&key=pname&word=이재광
	public HashMap<String,Object> list(QueryVO vo){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("total", dao.total(vo));
		map.put("list", dao.list(vo));
		return map;
	}
	
	@GetMapping("/{scode}") //테스트 /stu/92414029
	public StuVO read(@PathVariable("scode") String scode) {
		return dao.read(scode);
	}
	
	@PostMapping("/delete/{scode}") //테스트 /stu/delete/92414029
	public void delete(@PathVariable("scode") String scode) {
		dao.delete(scode);
	}
	@PostMapping("/update")
	public void update(@RequestBody StuVO vo) {
		dao.update(vo);
	}
	
	@PostMapping("/updatePhoto")
	public void updatePhoto(@RequestBody StuVO vo) {
		dao.updatePhoto(vo);
	}
}
