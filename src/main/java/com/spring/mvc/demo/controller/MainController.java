package com.spring.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.demo.entity.User;

import javassist.expr.NewArray;

@Controller
public class MainController {
	@RequestMapping("/")
	public String mainPage(Model model) {
		return "index";
	}
	
	@RequestMapping("/footer")
	public String footerPage() {
		return "footer";
	}
}
