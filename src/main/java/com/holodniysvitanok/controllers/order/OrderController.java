package com.holodniysvitanok.controllers.order;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		return "order";
	}
	
}
