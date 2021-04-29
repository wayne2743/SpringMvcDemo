package com.spring.mvc.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.demo.entity.Customer;
import com.spring.mvc.demo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		// get customer list from dao
		List<Customer> customers = customerService.getCustomers();
		
		theModel.addAttribute("test", "TestVal");
		
		
		//add the customer in the model
		theModel.addAttribute("customers", customers);
		
		return "list-customers";		
	}
	
// Should not provide to user, because user never know what actual id is
//
//	@GetMapping("/findById")
//	public String findCustomerById(@RequestParam int customerId, Model model) {
//		Customer customer = customerService.findCustomerById(customerId);
//		List<Customer> customers = new ArrayList<Customer>();
//		if(customer!=null) {
//			customers.add(customer);			
//		}
//		
//		//add the customer in the model
//		if(!customers.isEmpty()) {
//			model.addAttribute("customers", customers);			
//		}
//		return "list-customers";
//		
//	}
	
	@RequestMapping("/customerUpdatePage")
	public String toCustomerUpdatePage(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.findCustomerById(id);
		model.addAttribute("customer", customer);
		return "update-customer";
	}
	
	@RequestMapping("/customerInfoPage")
	public String toCustomerInfoPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "save-customer";
	}
	
	@PostMapping("/createCustomer")
	public String createCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult br) {
		// Need to check the data first
		if(br.hasErrors()) {
			return "save-customer";
		}
		customerService.createCustomer(customer);
		return "redirect:/customer/list";			
	}
	@PostMapping("/updateCustomer")
	public String updateCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult br) {
		// Need to check the data first
		if(br.hasErrors()) {
			return "update-customer";
		}
		customerService.updateCustomer(customer);
		return "redirect:/customer/list";			
	}	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam int customerId) {
		customerService.deleteCustomerById(customerId);
		
		return "redirect:/customer/list";
	}
}
