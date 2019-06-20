package com.kitri.member.model.service;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;

public interface MemberService {

	String idCheck(String id);
	String zipSearch(String doro);
	int registerMember(MemberDetailDto memberDetailDto);
	MemberDto loginMember(String id, String pass);
	
	//혼자 해보기!!
	MemberDetailDto getMember(String id);  // 회원 1명 정보 얻어오기 (정보 수정 화면에 뿌릴 것들)
	int modifyMember(MemberDetailDto memberDetailDto);   // return 0 : 수정 없음 / !=0 : 수정 함
	int deleteMember(String id);   // return 0 : 삭제 안됨 / !=0 : 삭제 함
	
}
