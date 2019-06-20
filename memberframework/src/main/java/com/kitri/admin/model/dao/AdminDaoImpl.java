package com.kitri.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.sqlmap.MyBatisConfiguration;

@Repository
public class AdminDaoImpl implements AdminDao{

	private final String NAME_SPACE="com.kitri.admin.model.dao.AdminDao";
	
	@Override
	public List<MemberDetailDto> getMemberList(Map<String, String> map) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try{
			return session.selectList(NAME_SPACE + ".getMemberList", map);
		} finally {
			session.close();
		}	
	}

}
