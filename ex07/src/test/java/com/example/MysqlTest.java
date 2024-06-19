package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.MysqlDAO;
import com.example.dao.ProDAO;
import com.example.dao.StuDAO;
import com.example.domain.QueryVO;


@SpringBootTest
public class MysqlTest {
	@Autowired
	MysqlDAO dao;
	
	@Autowired
	ProDAO pdao;
	
	@Autowired
	StuDAO sdao;
	
	@Test
	public void test() {
		sdao.getcode("93", "전기");
	}
}
