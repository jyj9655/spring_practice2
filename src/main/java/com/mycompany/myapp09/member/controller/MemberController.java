package com.mycompany.myapp09.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.myapp09.member.model.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public String idCheck(@RequestParam("id") String id) {
		String result = null;
		try {
			int result2 = memberService.idCheck(id);
			if (result2 > 0) {
				result = "false";
			} else {
				result = "true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
