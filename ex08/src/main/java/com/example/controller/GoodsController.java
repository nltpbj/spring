package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.GoodsDAO;
import com.example.domain.GoodsVO;
import com.example.domain.NaverAPI;
import com.example.domain.QueryVO;
import com.example.service.GoodsService;

@RestController
@RequestMapping("/goods")

public class GoodsController {
	@Autowired
	GoodsService service;
	
	@Autowired
	GoodsDAO dao;
	
	@PostMapping("/delete/{gid}")
	public void delete(@PathVariable("gid") String gid) {
		dao.delete(gid);
	}
	
	@GetMapping("/list") //테스트 /goods/list?page=1&size=3
	public HashMap<String,Object> list(QueryVO vo){
		return service.list(vo);
	}
	
	@PostMapping("/insert")
	public int insert(@RequestBody GoodsVO vo) {
		return service.insert(vo);
	}
	
	@GetMapping("/search") //테스트 /goods/search?query=노트북&page=1
	public String search(@RequestParam("query") String query, 
			@RequestParam("page") int page, @RequestParam("size") int size) {
		String result="";
		result=NaverAPI.search(query, page, size);
		return result;
		
	}
	
}
