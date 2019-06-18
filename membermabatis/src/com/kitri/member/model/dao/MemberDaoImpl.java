package com.kitri.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipcodeDto;
import com.kitri.sqlmap.MyBatisConfiguration;

public class MemberDaoImpl implements MemberDao{

	private final String NAME_SPACE="com.kitri.member.model.dao.MemberDao";
	
	// *[싱글톤 패턴]*
	
	// *2*
	private static MemberDao memberdao;
	
	// *3*
	static {
		memberdao = new MemberDaoImpl();
	}
	
	// *4*
	public static MemberDao getMemberdao() {
		return memberdao;
	}
	
	// *1*
	private MemberDaoImpl() {}

	
	// [override method]
	@Override
	public int idCheck(String id) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try{
			return session.selectOne(NAME_SPACE + ".idCheck", id); 
		} finally {
			session.close();
		}
	}

	@Override
	public List<ZipcodeDto> zipSearch(String doro) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try{
			return session.selectList(NAME_SPACE + ".zipSearch", doro); 
		} finally {
			session.close();
		}	
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try{
			session.insert(NAME_SPACE + ".registerMember", memberDetailDto);
			session.commit(); //자동 커밋이 안 됨
			return 1;
		} finally {
			session.close();
		}	
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try{
			return session.selectOne(NAME_SPACE + ".loginMember", map); 
		} finally {
			session.close();
		}
	}

	@Override
	public MemberDetailDto getMember(String id) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try{
			return session.selectOne(NAME_SPACE + ".getMember", id); 
		} finally {
			session.close();
		}
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		return 0;
	}

	// <탈퇴> 메소드
	@Override
	public int deleteMember(String id) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try{
			session.delete(NAME_SPACE + ".deleteMember", id);
			session.commit(); //자동 커밋이 안 됨
			return 1;
		} finally {
			session.close();
		}
	}
		


}
