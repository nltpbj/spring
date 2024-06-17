package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.MessageMapper";
	
	@Override
	public void insert(MessageVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public MessageVO readSend(int mid) {
		return session.selectOne(namespace + ".readSend", mid);
	}

	@Override
	public MessageVO readReceive(int mid) {
		return session.selectOne(namespace + ".readReceive", mid);
	}

	@Override
	public void updateReadDate(int mid) {
		session.update(namespace + ".updateReadDate", mid);
	}

	@Override
	public List<MessageVO> listSend(String sender) {
		return session.selectList(namespace + ".listSend", sender);
	}

	@Override
	public List<MessageVO> listReceive(String receiver) {
		return session.selectList(namespace + ".listReceive", receiver);
	}

}
