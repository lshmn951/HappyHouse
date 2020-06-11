package com.ssafy.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.myapp.model.dto.HouseDeal;
import com.ssafy.myapp.model.dto.HouseInfo;
import com.ssafy.myapp.model.dto.UserInfo;
import com.ssafy.myapp.model.service.HouseInfoService;
import com.ssafy.myapp.model.service.HouseService;
import com.ssafy.myapp.model.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService uService;

	@Autowired
	HouseService hService;

	@Autowired
	HouseInfoService hiService;

	@RequestMapping("/")
	public String init() {
		return "initMain";
	}
	
	@RequestMapping("/QnA")
	public String qna() {
		return "index";
	}
	@RequestMapping("/detail")
	public String houseDetail(HttpServletRequest request) {
		int no = Integer.parseInt(request.getParameter("no"));
		HouseDeal housedeal = hService.search(no);
		Map<String, String> map = new HashMap<String, String>();
		map.put("dong", housedeal.getDong());
		map.put("name", housedeal.getAptName());
		HouseInfo houseinfo = hiService.search(map);
		if(houseinfo!=null) {
			request.setAttribute("src", houseinfo.getImg());
			request.setAttribute("houseinfo", houseinfo);
		}
		request.setAttribute("housedeals", housedeal);
		return "housedetail";
	}

	@RequestMapping("/user/login")
	public String login(HttpServletRequest request) {
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");

		UserInfo selected = uService.search(userId);
		System.out.println(userId+" "+userPw+" "+selected.getUserPw());
		if (selected==null) { 
			request.setAttribute("msg", "아이디/비밀번호를 확인하세요.");
		} else {
			if(!selected.getUserPw().equals(userPw)) {
				request.setAttribute("msg", "아이디/비밀번호를 확인하세요.");					
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", selected);
			}
		}
		return "initMain";
	}

	@RequestMapping("/user/mvlogin")
	public String mvlogin(HttpServletRequest request) {
		return "user/login";
	}

	@RequestMapping("/user/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("/user/mvsignup")
	public String mvsignup(HttpServletRequest request) {
		return "user/signup";
	}

	@RequestMapping("/user/signup")
	public String signup(HttpServletRequest request) {
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");
		String userName = request.getParameter("username");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		int result = 0;

		UserInfo user = new UserInfo(userId, userPw, userName, address, phone);
		result = uService.signUp(user);
		if(result==0) {
			request.setAttribute("msg", "회원가입에 실패했습니다.");
		}
		return "initMain";
	}

	@RequestMapping("/user/detail")
	public String detail(HttpServletRequest request) {
		String userId = request.getParameter("userid");

		UserInfo user = uService.search(userId);
		request.setAttribute("userInfo", user);
		return "user/detail";
	}

	@RequestMapping("/user/update")
	public String update(HttpServletRequest request) {
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");
		String userName = request.getParameter("username");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		UserInfo selected = new UserInfo(userId, userPw, userName, address, phone);
		int result =  uService.update(selected);
		if(result==0) {
			request.setAttribute("msg", "업데이트에 실패했습니다.");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", selected);
		}
		return "initMain";
	}

	@RequestMapping("/user/mvupdate/{userId}")
	public String mvupdate(HttpServletRequest request , @PathVariable String userId) {
		UserInfo user = uService.search(userId);
		request.setAttribute("userInfo", user);
		request.setAttribute("update", "update");
		return "user/detail";
	}

	@RequestMapping("/user/withdraw/{userId}")
	public String withdraw(HttpServletRequest request,@PathVariable String userId) {
		int result = uService.withdraw(userId);
		if(result==0) {
			request.setAttribute("msg", "회원 탈퇴에 실패했습니다.");
		}
		HttpSession session = request.getSession();
		session.invalidate();
		return "initMain";
	}


	@RequestMapping("/user/searchpass")
	public String searchpass(HttpServletRequest request) {
		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");

		UserInfo selected = uService.search(userId);
		if (selected==null) { 
			request.setAttribute("msg", "아이디를 확인하세요.");
		} else {
			if(!selected.getUserName().equals(userName)) {
				request.setAttribute("msg", "이름을 확인하세요.");
			}else {
				request.setAttribute("pass",selected.getUserPw());
			}
		}
		return "user/searchpass";
	}

	@RequestMapping("/user/mvsearchpass")
	public String mvsearchpass(HttpServletRequest request) {
		return "user/searchpass";
	}
}
