package com.holodniysvitanok.controllers.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.holodniysvitanok.dao.UserDAO;
import com.holodniysvitanok.entity.User;
import com.holodniysvitanok.service.GlobalConfigProject;
import com.holodniysvitanok.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = GlobalConfigProject.USER, method = RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {
		
		model.setViewName("redirect: "+GlobalConfigProject.USER+"/"+GlobalConfigProject.SHOW_USER);
		
		return model;
	}

	@RequestMapping(value = GlobalConfigProject.USER + "/" + GlobalConfigProject.ADD_USER, method = RequestMethod.GET)
	public ModelAndView addUser(HttpServletRequest request, ModelAndView model) {
		
		model.addObject("accessLevel", ((User)request.getSession().getAttribute("user")).getAccessLevel());
		model.setViewName(GlobalConfigProject.ADD_USER);
		
		return model;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Add
	 */
	@RequestMapping(value = GlobalConfigProject.USER + "/" + GlobalConfigProject.ADD_USER, method = RequestMethod.POST)
	public ModelAndView saveUser(HttpServletRequest request, ModelAndView model) {

		if (!userService.authentication(request, 2)) {
			model.setViewName("redirect: " + GlobalConfigProject.ROOT_REDIRECT);
			return model;
		}

		User user = new User();
		model.setViewName(GlobalConfigProject.ADD_USER);
		model.addObject("accessLevel", ((User)request.getSession().getAttribute("user")).getAccessLevel());
		try{
		if (userService.setUser(request, user)) {
					
			if (userDAO.saveUser(user)) {
				model.addObject("message", "Сохранено");
				return model;
			}
			
		}
		}catch(Exception ex){
		}
		model.addObject("message", "Ошибка");
		model.addObject("accessLevel", ((User)request.getSession().getAttribute("user")).getAccessLevel());
		return model;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Set
	 */
	@RequestMapping(value = GlobalConfigProject.USER + "/" + GlobalConfigProject.SET_USER, method = RequestMethod.GET)
	public ModelAndView setUser(ModelAndView model, HttpServletRequest request) {
		
		model.setViewName("redirect: " + request.getServletContext().getContextPath());
		
		if (!userService.authentication(request, 2)) {
			return model;
		}
		
		String parameter = request.getParameter("id");

		if (parameter == null || parameter.equals("")) {
			return model;
		}
		
		try {
			
			User user = userDAO.getUserById(Long.parseLong(parameter));
			model.addObject("user", user);
			
			if(!userService.authentication(request, user.getAccessLevel())){
				return model;
			}
			
			model.addObject("accessLevel", ((User)request.getSession().getAttribute("user")).getAccessLevel());
			
		} catch (Exception ex) {
			return model;
		}

		model.setViewName(GlobalConfigProject.SET_USER);
		return model;
	}

	@RequestMapping(value = GlobalConfigProject.USER + "/" + GlobalConfigProject.SET_USER, method = RequestMethod.POST)
	public ModelAndView actionSetUser(ModelAndView model, HttpServletRequest request) {
		
		String idStr = request.getParameter("id");
		model.setViewName("redirect: " + request.getServletContext().getContextPath());
		
		if (idStr == null || idStr.equals("")) {
			return model;
		}
		
		try{
			
			long id = Long.parseLong(idStr);
			User user =userDAO.getUserById(id);
			model.setViewName(GlobalConfigProject.SET_USER);
			
			if(!userService.setUser(request, user)){
				model.addObject("message", "Ошибка");
				return model;
			}
			
			userDAO.saveUser(user);
			model.addObject("message", "Сохранено");
			model.addObject("user", user);
			
		}catch(Exception ex){
			model.addObject("message", "Ошибка");
		}
		
		
		return model;
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 * Exit session
	 * */
	@RequestMapping(value = GlobalConfigProject.USER + "/" + GlobalConfigProject.EXIT_USER, method = RequestMethod.GET)
	public ModelAndView exitUser(ModelAndView model, HttpServletRequest request) {
		request.getSession().invalidate();
		model.setViewName("redirect: " + request.getServletContext().getContextPath());
		return model;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * Show
	 * */
	@RequestMapping(value = GlobalConfigProject.USER + "/" + GlobalConfigProject.SHOW_USER, method = RequestMethod.GET)
	public ModelAndView showUser(ModelAndView model, HttpServletRequest request) {
		
		String startStr = request.getParameter("start");
		String maxRowsStr = request.getParameter("maxRorw");
		
		model.setViewName(GlobalConfigProject.SHOW_USER);
		
		if(maxRowsStr != null && !maxRowsStr.equals("")){
			
			int maxRows = Integer.parseInt(maxRowsStr);
			
			if(startStr != null && !startStr.equals("")){
				int start = Integer.parseInt(startStr);
				model.addObject("userList", userDAO.getAllUsers(start, maxRows));
				return model;
			}else{
				model.addObject("userList", userDAO.getAllUsers(maxRows));
				return model;
			}
		}
		
		model.addObject("userList", userDAO.getAllUsers(100));
		return model;
	}
	
	/*
	 * 
	 * 
	 * Review
	 * */
	@RequestMapping(value = GlobalConfigProject.USER + "/" + GlobalConfigProject.REVIEW_USER, method = RequestMethod.GET)
	public ModelAndView reviewUser(ModelAndView model, HttpServletRequest request) {
		
		String idStr = request.getParameter("id");
		if(idStr == null || idStr.equals("")){
			model.setViewName("redirect: " + request.getServletContext().getContextPath());
			return model;
		}
		
		try{
			long id = Long.parseLong(idStr);
			User user = userDAO.getUserById(id);
			model.addObject("user", user);
			model.setViewName(GlobalConfigProject.REVIEW_USER);
		}catch(Exception ex){
			model.setViewName("redirect: " + request.getServletContext().getContextPath());
		}
		return model;
	}
	
	/*
	 * 
	 * Find
	 * */
	@RequestMapping(value = GlobalConfigProject.USER + "/" + GlobalConfigProject.FIND_USER, method = RequestMethod.GET)
	public ModelAndView findUser(ModelAndView model) {
		
		model.setViewName(GlobalConfigProject.FIND_USER);
		return model;
	}
	
	/*
	 * 
	 * 
	 * 
	 * Del
	 * */
	@RequestMapping(value = GlobalConfigProject.USER + "/" + GlobalConfigProject.DEL_USER, method = RequestMethod.GET)
	public ModelAndView delUser(ModelAndView model, HttpServletRequest request) {
		
		 String parameter = request.getParameter("id");
		
		if(parameter == null || parameter.equals("")){
			model.setViewName("redirect: " + request.getServletContext().getContextPath());
			return model;
		}
		
		User user = userDAO.getUserById(Long.parseLong(parameter));
		
		model.addObject("user", user);

		model.setViewName(GlobalConfigProject.DEL_USER);
		
		return model;
	}
	
	
	
	@RequestMapping(value = GlobalConfigProject.USER + "/" + GlobalConfigProject.DEL_USER, method = RequestMethod.POST)
	public ModelAndView actionDelUser(ModelAndView model, HttpServletRequest request) {
		
		String isStr = request.getParameter("id");
		
		try{
			
			long id = Long.parseLong(isStr);
			User user = userDAO.getUserById(id);
			
			if(userService.authentication(request, user.getAccessLevel())){
				userDAO.deleteUser(user);
				model.setViewName("redirect: "+GlobalConfigProject.SHOW_USER);
				return model;
			}
			
		}catch(Exception ex){
		}
		model.setViewName("redirect: " + request.getServletContext().getContextPath());
		
		return model;
	}
}
