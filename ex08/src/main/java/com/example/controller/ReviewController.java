package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ReviewDAO;
import com.example.domain.ReivewVO;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	ReviewDAO dao;
		
		@GetMapping("list/{gid}")
		public List<ReivewVO> list (@PathVariable("gid") String gid){
			return dao.list(gid);
		}
		
		
		@PostMapping("/insert")
		public void insert(@RequestBody ReivewVO vo) {
			dao.insert(vo);
		}
		@PostMapping("/update")
		public void update(@RequestBody ReivewVO vo) {
			dao.update(vo);
		}
		
		@PostMapping("/delete/{rid}")
		public void delete(@PathVariable("rid") int rid) {
			dao.delete(rid);
		}
			
		
	
}
