package com.kitri.cafe.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.cafe.board.model.BbsDto;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int writeArticle(BbsDto bbsDto) {
		return 0;
	}

	@Override
	public List<BbsDto> listArticle(Map<String, String> pamameter) {
		return null;
	}

	@Override
	public BbsDto viewArticle(int seq) {
		return null;
	}

	@Override
	public int modifyArticle(BbsDto bbsDto) {
		return 0;
	}

	@Override
	public void deleteArticle(int seq) {

	}

}
