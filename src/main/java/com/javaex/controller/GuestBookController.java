package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {

	@Autowired
	private GuestBookDao dao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("list");

		List<GuestBookVo> list = dao.getList();

		model.addAttribute("list", list);
		return "/WEB-INF/views/addList.jsp";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute GuestBookVo vo) {
		System.out.println("add");

		dao.insert(vo);

		return "redirect:/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute GuestBookVo vo) {
		System.out.println("delete");

		dao.delete(vo);

		return "redirect:/list";
	}

	@RequestMapping(value = "/deleteform", method = RequestMethod.GET)
	public String deleteform() {
		System.out.println("deleteform");

		return "/WEB-INF/views/deleteForm.jsp";
	}
}
