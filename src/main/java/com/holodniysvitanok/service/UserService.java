package com.holodniysvitanok.service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.holodniysvitanok.dao.UserDAO;
import com.holodniysvitanok.entity.User;

@Component
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@PostConstruct
	public void postUserService() {
		User user = userDAO.getUserByLogin(GlobalConfigProject.LOGIN_ROOT);
		if (user == null) {
			user = new User();
			user.setName(GlobalConfigProject.NAME_ROOT);
			user.setLogin(GlobalConfigProject.LOGIN_ROOT);
			user.setPassword(DigestUtils.md5Hex(GlobalConfigProject.PASSWORD_ROOT));
			user.setAccessLevel(GlobalConfigProject.ACCESS_LEVEL);
			userDAO.saveUser(user);
		}
	}

	public boolean setUser(HttpServletRequest request, User user) {
		try {

			String name = request.getParameter("name");
			String login = request.getParameter("login");
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			
			int accessLevel = Integer.parseInt(request.getParameter("accessLevel"));

			if(authentication(request, ((User)request.getSession().getAttribute("user")).getAccessLevel())){
				user.setAccessLevel(accessLevel);
			}else{
				return false;
			}
			
			user.setName(name);
			user.setLogin(login);

			
			if (!password1.equals("") && !password2.equals("")) {
				if (eqPassword(password1, password2)) {
					user.setPassword(DigestUtils.md5Hex(password1));
				} else {
					return false;
				}
			}
			
			

		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public User authorization(String login, String password) {

		login = login.trim();
		password = password.trim();
		
		if (!valLogin(login) || !valPassword(password)) {
			return null;
		}

		User user = userDAO.getUserByLogin(login);

		if (user == null) {
			return null;
		}

		if (!user.getPassword().equals(DigestUtils.md5Hex(password))) {
			return null;

		}

		return user;
	}

	private boolean valLogin(String str) {
		if (str.trim().length() >= 4 && str.trim().length() <= 10) {
			return true;
		} else {
			return false;
		}
	}

	private boolean valPassword(String str) {
		if (str.trim().length() <= 10) {
			return true;
		} else {
			return false;
		}
	}

	private boolean eqPassword(String password1, String password2) {
		return password1.equals(password2);
	}

	/**
	 * авторизация пользователя из сессии
	 * */
	public boolean authentication(HttpServletRequest request, int minAccessLevel) {

		User user = (User) request.getSession(false).getAttribute("user");
		if (user.getAccessLevel() <= minAccessLevel) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * авторизация пользователя из объекта
	 * */
	public boolean authentication(User user, int minAccessLevel) {
				
		if (user.getAccessLevel() <= minAccessLevel) {
			return true;
		} else {
			return false;
		}
	}

}
