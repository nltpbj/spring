package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.ReivewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO{

	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.ReviewMapper";
	
	@Override
	public List<ReivewVO> list(String gid) {
		return session.selectList(namespace + ".list", gid);
	}

	@Override
	public void insert(ReivewVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public void delete(int rid) {
		session.delete(namespace + ".delete", rid);
	}

	@Override
	public void update(ReivewVO vo) {
		session.update(namespace + ".update", vo);
	}
	
}
