package ru.geekbrains.samples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.geekbrains.samples.dao.NowBeanDAO;

@Controller
public class NowController {

	private final NowBeanDAO nowBeanDAO;

	@Autowired
	public NowController(NowBeanDAO nowBeanDAO){
		this.nowBeanDAO = nowBeanDAO;
	}

	@RequestMapping(value = "/now", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		model.addAttribute("now", nowBeanDAO.getNow());
		return "now";
	}

}