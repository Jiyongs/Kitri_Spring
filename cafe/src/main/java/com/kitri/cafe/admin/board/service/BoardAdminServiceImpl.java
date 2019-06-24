package com.kitri.cafe.admin.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.cafe.admin.board.dao.BoardAdminDao;
import com.kitri.cafe.admin.board.model.BoardListDto;
import com.kitri.cafe.admin.board.model.BoardTypeDto;
import com.kitri.cafe.admin.board.model.CategoryDto;

@Service
public class BoardAdminServiceImpl implements BoardAdminService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardListDto> getBoardMenuList(int ccode) {
		return sqlSession.getMapper(BoardAdminDao.class).getBoardMenuList(ccode);
	}

	@Override
	public List<CategoryDto> getCategoryList() {
		return null;
	}

	@Override
	public void makeCategory(CategoryDto categoryDto) {

	}

	@Override
	public List<BoardTypeDto> getBoardTypeList() {
		return null;
	}

	@Override
	public void makeBoard(BoardListDto boardListDto) {

	}

}
