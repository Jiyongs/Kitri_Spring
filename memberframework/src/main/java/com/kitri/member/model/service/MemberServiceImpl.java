package com.kitri.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipcodeDto;
import com.kitri.member.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	// [override method]
	@Override
	public String idCheck(String id) {
		int cnt = memberDao.idCheck(id);
		JSONObject json = new JSONObject();
		json.put("idcount", cnt);
		return json.toString();		// = {"idcount" : 0}
	}

	@Override
	public String zipSearch(String doro) {
		
//		리턴해야 하는 json
//		{
//		"ziplist" : [
//		             {"zipcode" : "12345", "address" : "서울특별시 구로구 구로동 ... "},
//		             {"zipcode" : "12345", "address" : "서울특별시 구로구 구로동 ... "},
//		            ]	
//		}
		
		List<ZipcodeDto> list = memberDao.zipSearch(doro);
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray(list);
//		
//		for(ZipcodeDto zipcodeDto : list) {
//			JSONObject zipcode = new JSONObject();
//			zipcode.put("zipcode", zipcodeDto.getZipcode());
//			zipcode.put("address", zipcodeDto.getSido() + " " 
//										+ zipcodeDto.getGugun() + " " 
//										+ zipcodeDto.getUpmyun() + " " 
//										+ zipcodeDto.getDoro() + " " 
//										+ zipcodeDto.getBuildingNumber() + " " 
//										+ zipcodeDto.getSigugunBuildingName());
//			jarray.put(zipcode);
//		} // for end
//		
		json.put("ziplist", jarray);
		return json.toString();
		
	} // zipSearch() end

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		return memberDao.registerMember(memberDetailDto);
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		
//		Map<String, String> map = new HashMap<String, String>();
//		
//		map.put("userid", id);
//		map.put("userpwd", pass);
		
		return memberDao.loginMember(map);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return memberDao.getMember(id);
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		return memberDao.deleteMember(id);
	}

}
