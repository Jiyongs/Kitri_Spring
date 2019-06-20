package com.kitri.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.admin.model.dao.AdminDao;
import com.kitri.member.model.MemberDetailDto;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	// DB에서 회원 목록 얻어오기
	@Override
	public String getMemberList(String key, String word) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		List<MemberDetailDto> list = adminDao.getMemberList(map);
		
		// 얻어온 값으로 XML 만듦
		String result = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
		result += "<memberlist>\n";
		for(MemberDetailDto memberDetailDto : list) {
			result += "	<member>\n";
			result += "		<id>" + memberDetailDto.getId() + "</id>\n";
			result += "		<name>" + memberDetailDto.getName() + "</name>\n";
			result += "		<email>" + memberDetailDto.getEmailId() + "@" + memberDetailDto.getEmailDomain() + "</email>\n";
			result += "		<tel>" + memberDetailDto.getTel1() + "-" + memberDetailDto.getTel2() + "-" + memberDetailDto.getTel3() + "</tel>\n";
			result += "		<address><![CDATA[" + memberDetailDto.getZipcode() + " " + memberDetailDto.getAddress() + "]]></address>\n";
			result += "		<joindate>" + memberDetailDto.getJoindate() + "</joindate>\n";
			result += "	</member>\n";
		}
		result += "</memberlist>";
		
		return result;
	}

}
