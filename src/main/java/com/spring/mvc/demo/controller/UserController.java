package com.spring.mvc.demo.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mvc.demo.entity.User;
import com.spring.mvc.demo.services.UserService;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/user")
@SessionAttributes("loginInfo")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String userLogin(Model model) {
		model.addAttribute("loginUser", new User());
		return "login";
		
	}
	
	@RequestMapping("/toRegitration")
	public String toRegistrationPage(Model model) {
		model.addAttribute("loginUser", new User());
		return "save-user";
	}
	
	
	
	@RequestMapping("/checkUser") 
	public String checkUser(@Valid @ModelAttribute("loginUser")User user, BindingResult br, Model model) {		
		if(br.hasErrors()) {
			return "login";
		}
		
		User verifiedUser = userService.verifyAccounts(user.getUserName(), user.getPassword());
		model.addAttribute("loginInfo", verifiedUser);
		if(verifiedUser!=null) {
			return "index";
		}
		model.addAttribute("errMsg", "Account or Password is not correct");
		return "login";
	}
	
	@RequestMapping("logout")
	public String logout(Model model) {
		User loginUser = (User) model.getAttribute("loginInfo");
		if(loginUser !=null) {
			model.addAttribute("loginInfo", null);
		}
		return "redirect:/user/login";
	}
	
	@RequestMapping("/save")
	public String createUser(@Valid @ModelAttribute("loginUser")User user, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "save-user";
		}
		user.setRegDate(new Date());
		userService.createUser(user);
		return "index";
	}
}
