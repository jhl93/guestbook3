package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("list");

		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.getList();

		model.addAttribute("list", list);
		return "/WEB-INF/views/addList.jsp";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestAttribute GuestBookVo vo) {
		System.out.println("add");

		GuestBookDao dao = new GuestBookDao();
		dao.insert(vo);

		return "redirect:/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestAttribute GuestBookVo vo) {
		System.out.println("delete");

		GuestBookDao dao = new GuestBookDao();
		dao.delete(vo);

		return "redirect:/list";
	}

	@RequestMapping(value = "/deleteform", method = RequestMethod.GET)
	public String deleteform() {
		System.out.println("deleteform");

		return "/WEB-INF/views/deleteForm.jsp";
	}
}
