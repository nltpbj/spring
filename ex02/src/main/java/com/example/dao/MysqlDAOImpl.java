package com.example.dao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MysqlDAOImpl implements MysqlDAO{
	@Autowired  //자동으로 injax해라
	SqlSession session;
	String namespace="com.example.mapper.MysqlMapper"; //어떤 mapper를 지정할건지
	
	@Override
	public String now() {
		return session.selectOne(namespace + ".now");
		
	}

}
