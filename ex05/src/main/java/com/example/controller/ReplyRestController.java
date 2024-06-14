package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ReplyDAO;
import com.example.domain.QueryVO;
import com.example.domain.ReplyVO;
import com.example.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyRestController {
	@Autowired
	ReplyDAO dao;
	
	@Autowired
	ReplyService service;
	
	@PostMapping("/insert")
	public void insert(@RequestBody ReplyVO vo) {
		service.insert(vo);
	}
	
	@GetMapping("/list.json/{bid}")
	public HashMap<String, Object> list(QueryVO vo, @PathVariable("bid") int bid){
		 HashMap<String, Object> map=new  HashMap<String, Object>();
		 map.put("total", dao.total(bid));
		 map.put("documents", dao.list(bid, vo));
		return map;
	}
	
	@PostMapping("/delete/{rid}")
	public void delete(@PathVariable("rid") int rid) {
		service.delete(rid);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody ReplyVO vo) {
		dao.update(vo);
	}
}
