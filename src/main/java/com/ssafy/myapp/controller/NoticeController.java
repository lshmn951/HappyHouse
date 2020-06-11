package com.ssafy.myapp.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.myapp.model.dto.Notice;
import com.ssafy.myapp.model.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	NoticeService nService;
 
	@RequestMapping("/notice/list")
	public String list(HttpServletRequest request) {
		Collection<Notice> notices = nService.searchAll();
		request.setAttribute("notices", notices);
		return "notice/list";
	}

	@RequestMapping("/notice/detail/{no}")
	public String detail(HttpServletRequest request,@PathVariable int no) {
			Notice notice = nService.searchByNo(no);
			request.setAttribute("notice", notice);
		return "notice/detail";
	}

	@RequestMapping("/notice/mvregist")
	public String mvregist(HttpServletRequest request) {

		return "notice/regist";
	}

	@RequestMapping("/notice/regist")
	public String regist(HttpServletRequest request) {
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int result = 0;
		Notice notice = new Notice(subject, content);
			result = nService.insert(notice);
			if(result==0) {
				request.setAttribute("msg", "공지사항 등록에 실패했습니다.");
			}
		return "redirect:/notice/list";
	}

	@RequestMapping("/notice/mvupdate/{no}")
	public String mvupdate(HttpServletRequest request,@PathVariable int no) {

			Notice notice = nService.searchByNo(no);
			request.setAttribute("notice",notice);
			request.setAttribute("update", "update");
		return "notice/detail";
	}

	@RequestMapping("/notice/update")
	public String update(HttpServletRequest request) {
		int no = Integer.parseInt(request.getParameter("no"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int result = 0;

		Notice notice = new Notice(no,subject, content);
		result = nService.update(notice);
		if(result==0) {
			request.setAttribute("msg", "공지사항 업데이트에 실패했습니다.");
		}
		else {
			request.setAttribute("msg",no+"번 공지사항을 수정했습니다.");
		}
		return "redirect:/notice/list";
	}

	@RequestMapping("/notice/delete/{no}")
	public String delete(HttpServletRequest request,@PathVariable int no) {			
			int result = nService.delete(no);
			if(result==0) {
				request.setAttribute("msg", "공지사항 삭제에 실패했습니다.");
			}else {
				request.setAttribute("msg",no+"번 공지사항을 삭제했습니다.");
			}
			
		return "redirect:/notice/list";
	}
}
