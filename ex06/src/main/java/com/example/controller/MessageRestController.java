package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.MessageDAO;
import com.example.domain.MessageVO;
import com.example.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageRestController {
	@Autowired
	MessageDAO dao;
	
	@Autowired
	MessageService service;
	
	@PostMapping("/insert")
	public void insert(@RequestBody MessageVO vo) {
		service.insert(vo);
	}
	
	@GetMapping("/send/{mid}")
	public MessageVO readSend(@PathVariable("mid") int mid) {
		return dao.readSend(mid);
	}
	
	@GetMapping("/receive/{mid}")
	public MessageVO readReceive(@PathVariable("mid") int mid) {
		return service.readReceive(mid);
	}
	
	@GetMapping("/send.json/{sender}")
	public List<MessageVO> listSend(@PathVariable("sender") String sender){
		return dao.listSend(sender);
	}
	
	@GetMapping("/receive.json/{receiver}")
	public List<MessageVO> listReceive(@PathVariable("receiver") String receiver){
		return dao.listReceive(receiver);
	}
}
