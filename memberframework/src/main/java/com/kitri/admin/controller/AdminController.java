package com.kitri.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.admin.model.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/mvmemberlist.kitri")
	public String memberList() {
		return "admin/member/memberList";
	}
	
	@RequestMapping("/memberlist.kitri")
	public @ResponseBody String getMemberList(@RequestParam Map<String, String> map, Model model) {
		String json = adminService.getMemberList(map);
		return json;
	}
	
}
