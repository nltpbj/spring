package com.example.dao;

import java.util.*;
import com.example.domain.*;

public interface CouDAO {
	public List<CouVO> list(QueryVO vo);
	public String getlcode(String dept);
	public void insert(CouVO vo);
	public CouVO read(String lcode);
	public void delete(String lcode);
	public void update(CouVO vo);
	public int total();
	public void updatePersons(String lcode, int amount);
}
