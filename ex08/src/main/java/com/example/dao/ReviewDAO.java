package com.example.dao;

import java.util.List;
import com.example.domain.ReivewVO;

public interface ReviewDAO {
	public List<ReivewVO> list(String gid);
	public void insert(ReivewVO vo);
	public void delete(int rid);
	public void update(ReivewVO vo);
}
