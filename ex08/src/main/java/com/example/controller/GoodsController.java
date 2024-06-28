package com.example.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.GoodsDAO;
import com.example.domain.AttachVO;
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
	
	//관련상품목록
		@GetMapping("/related/list/{gid}")
		public List<HashMap<String,Object>> listRealated(@PathVariable("gid") String gid){
			return dao.listRelated(gid);
		}
		
		//관련상품등록
		@PostMapping("/related/insert")
		public int insertRelated(@RequestBody HashMap<String,Object> map) {
			String rid=map.get("rid").toString();
			String gid=map.get("gid").toString();
			System.out.println("................." + gid + "................" + rid);
			return service.insertRelated(gid, rid);
		}
		
		
		//관련상품삭제
		@PostMapping("/related/delete")
		public void deleteRelated(@RequestBody HashMap<String,Object> map) {
			String rid=map.get("rid").toString();
			String gid=map.get("gid").toString();
			System.out.println("................." + gid + "................" + rid);
			dao.deleteRelated(gid, rid);
		}
	
	
	//첨부파일삭제
	@PostMapping("/attach/delete") // /display?file=
	public void deleteAttach(@RequestBody AttachVO vo) {
		try {
			String displayName=vo.getFilename();
			int index = displayName.indexOf("=");
			String fileName=displayName.substring(index + 1);
			
			
			File file=new File("c:" + fileName);
			if(file.exists()) file.delete();
			dao.deleteAttach(vo.getAid());
		}catch(Exception e) {
			System.out.println("첨부파일삭제:" + e.toString());
		}
	}

	
	@GetMapping("/attach/{gid}") // /goods/attach/82693768242
	public List<AttachVO> listAttach(@PathVariable("gid") String gid){
		return dao.listAttach(gid);
	}
	
	@PostMapping("/update/contents")
	public void updateContents(@RequestBody GoodsVO vo) {
		dao.updateContents(vo);
	}
	//이미지업로드
	@PostMapping("/update/image/{gid}")
	public void updateImage(@PathVariable("gid") String gid, 
			MultipartHttpServletRequest multi)throws Exception {
		
		//파일업로드
		MultipartFile file=multi.getFile("byte");
		String filePath="/upload/mall/";
		String fileName=gid + ".jpg";
		
		
		//파일이 존재하면 삭제
		File oldFile=new File(filePath + fileName);
		if(oldFile.exists()) {
			oldFile.delete();
		}else {
			//이미지이름변경
			GoodsVO vo=new GoodsVO();
			vo.setGid(gid);
			vo.setImage("/display?file=" + filePath + fileName);
			dao.updateImage(vo);
		}
		file.transferTo(new File("c:" + filePath + fileName));
	}
	
	
	@GetMapping("/read/{gid}")
	public GoodsVO read(@PathVariable("gid") String gid) {
		return dao.read(gid);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody GoodsVO vo) {
		dao.update(vo);
	}
	
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
	
	//Attach 파일을 업로드
	@PostMapping("/attach/{gid}")
	public void attach(@PathVariable("gid") String gid, MultipartHttpServletRequest multi) {
		try {
			String filePath="/upload/mall/" + gid + "/";
			File folder = new File("C:" + filePath);
			if(!folder.exists()) folder.mkdir();
			
			List<MultipartFile> files=multi.getFiles("bytes");
			
			for(MultipartFile file:files) {
				String fileName = UUID.randomUUID().toString()+".jpg";
				file.transferTo(new File("c:" + filePath + fileName));
				
				AttachVO vo=new AttachVO();
				vo.setGid(gid);
				vo.setFilename("/display?file=" + filePath + fileName);
				dao.insertAttach(vo);
			}
			
		} catch (Exception e) {
			System.out.println("Attach 파일업로드:" +  e.toString());
		}
	}
	
}
