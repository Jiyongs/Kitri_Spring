package com.kitri.cafe.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.cafe.board.model.ReboardDto;

@Service
public class ReboardServiceImpl implements ReboardService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int writeArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public List<ReboardDto> listArticle(Map<String, String> pamameter) {
		return null;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		return null;
	}

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public void deleteArticle(int seq) {
		
	}

}
