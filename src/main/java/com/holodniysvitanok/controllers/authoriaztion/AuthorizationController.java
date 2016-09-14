package com.holodniysvitanok.controllers.authoriaztion;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.holodniysvitanok.entity.User;
import com.holodniysvitanok.service.GlobalConfigProject;
import com.holodniysvitanok.service.UserService;

@Controller
public class AuthorizationController {
	
	@Autowired
	private UserService userService;
	
	

	@RequestMapping(value = GlobalConfigProject.AUTHORIZATION, method = RequestMethod.GET)
	public ModelAndView authorization(ModelAndView model) {
		
		model.setViewName(GlobalConfigProject.AUTHORIZATION);
		
		return model;
	}
	
	
	
	@RequestMapping(value = GlobalConfigProject.AUTHORIZATION, method = RequestMethod.POST)
	public ModelAndView authorizationUser(HttpServletRequest request, ModelAndView model) {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User user = userService.authorization(login, password);
		
		if(user == null || !userService.authentication(user, 2)){
			model.setViewName(GlobalConfigProject.AUTHORIZATION);
			model.addObject("message", "Ошибка авторизации");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			
			return model;
		}
		
		request.getSession(true).setAttribute("user", user);
		
		model.setViewName(GlobalConfigProject.ROOT_REDIRECT);
		
		return model;
	}
	
}
