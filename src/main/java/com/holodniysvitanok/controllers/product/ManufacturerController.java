package com.holodniysvitanok.controllers.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.holodniysvitanok.dao.ManufacturerDAO;
import com.holodniysvitanok.entity.Manufacturer;
import com.holodniysvitanok.entity.User;
import com.holodniysvitanok.service.ProductService;
import com.holodniysvitanok.service.GlobalConfigProject;
import com.holodniysvitanok.service.ImageBox;
import com.holodniysvitanok.service.Logger;

@Controller
public class ManufacturerController {

	@Autowired
	private ManufacturerDAO manufacturerDAO;

	@Autowired
	private ImageBox box;

	@Autowired
	private Logger logger;

	@Autowired
	private ProductService cams;
	/*
	 * 
	 * 
	 * 
	 * 
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.MANUFACTURER, method = RequestMethod.GET)
	public ModelAndView manufacturer() {
		return new ModelAndView("redirect: " + GlobalConfigProject.MANUFACTURER + "/" + GlobalConfigProject.SHOW_MANUFACTURER);
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Add
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.MANUFACTURER + "/" + GlobalConfigProject.ADD_MANUFACTURER, method = RequestMethod.GET)
	public String addManufacturer() {
		return GlobalConfigProject.ADD_MANUFACTURER;
	}


	@RequestMapping(value = "/" + GlobalConfigProject.MANUFACTURER + "/" + GlobalConfigProject.ADD_MANUFACTURER, method = RequestMethod.POST)
	public ModelAndView saveManufacturer(ModelAndView model, WebRequest request, @RequestParam("fileImage") MultipartFile file) {

		Manufacturer manufacturer = new Manufacturer();

		model.setViewName(GlobalConfigProject.ADD_MANUFACTURER);

		manufacturer.setName(request.getParameter("name"));
		manufacturer.setDescription(request.getParameter("description"));
		manufacturer.setCountry(request.getParameter("country"));

		try {
			if (file.getBytes().length != 0) {
				manufacturer.setUrlImage(file.getOriginalFilename());
				box.saveImage(file.getBytes(), file.getOriginalFilename(), GlobalConfigProject.IMAGE_BOX);
			}

			manufacturerDAO.saveOrUpdateManufacturer(manufacturer);
			logger.actionAdd(null, manufacturer);

		} catch (Exception e) {
			model.addObject("message", "не удалось добавить производителя");
			return model;
		}
		model.addObject("message", "сохранено");

		return model;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * Show
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.MANUFACTURER + "/" + GlobalConfigProject.SHOW_MANUFACTURER, method = RequestMethod.GET)
	public ModelAndView showManufacturer(ModelAndView model) {

		List<Manufacturer> manufacturer = manufacturerDAO.getAllManufacturer(9999);

		model.addObject("manufacturerList", manufacturer);
		model.setViewName(GlobalConfigProject.SHOW_MANUFACTURER);

		return model;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Del
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.MANUFACTURER + "/" + GlobalConfigProject.ACTION_DEL_MANUFACTURER, method = RequestMethod.GET)
	public ModelAndView actionDeleteManufacturer(WebRequest request, ModelAndView model) {

		String parameter = request.getParameter("id");

		model.setViewName("redirect: " + GlobalConfigProject.SHOW_MANUFACTURER);

		if (parameter.equals("")) {
			return model;

		}
		long id = Long.parseLong(parameter);

		Manufacturer manufacturer = manufacturerDAO.getManufacturer(id);
		
		
		cams.deleteImageCategoryAndManufacturer(manufacturer, manufacturerDAO);

		manufacturerDAO.deleteManufacturer(manufacturer);
		logger.actionDel(null, manufacturer);
		
		return model;
	}

	@RequestMapping(value = "/" + GlobalConfigProject.MANUFACTURER + "/" + GlobalConfigProject.DEL_MANUFACTURER, method = RequestMethod.GET)
	public ModelAndView deleteManufacturer(HttpServletRequest request, ModelAndView model) {

		String parameter = request.getParameter("id");
		
		if (parameter == null || parameter.equals("")) {
			model.setViewName("redirect: " + request.getServletContext().getContextPath());
			return model;
		}
		
		Manufacturer manufacturer = manufacturerDAO.getManufacturer(Long.parseLong(parameter));
		
		model.addObject("manufacturer", manufacturer);
		
		model.setViewName(GlobalConfigProject.DEL_MANUFACTURER);
		
		return model;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Set
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.MANUFACTURER + "/" + GlobalConfigProject.SET_MANUFACTURER, method = RequestMethod.GET)
	public ModelAndView setManufacturer(WebRequest request, ModelAndView model) {

		String parameter = request.getParameter("id");

		if (!parameter.equals("")) {
			long id = Long.parseLong(parameter);
			Manufacturer manufacturer = manufacturerDAO.getManufacturer(id);
			model.addObject("manufacturer", manufacturer);
			model.setViewName(GlobalConfigProject.SET_MANUFACTURER);
		} else {
			model.setViewName(GlobalConfigProject.MANUFACTURER);
		}

		return model;
	}


	@RequestMapping(value = "/" + GlobalConfigProject.MANUFACTURER + "/" + GlobalConfigProject.SET_MANUFACTURER, method = RequestMethod.POST)
	public ModelAndView actionSetManufacturer(WebRequest request, ModelAndView model, @RequestParam("fileImage") MultipartFile file) {

		String parameter = request.getParameter("id");

		model.setViewName(GlobalConfigProject.SET_MANUFACTURER);

		if (parameter == null || parameter.equals("")) {
			model.addObject("message", "ошибка");
			return model;
		}

		long id = Long.parseLong(parameter);

		Manufacturer manufacturer = manufacturerDAO.getManufacturer(id);
		manufacturer.setName(request.getParameter("name"));
		manufacturer.setDescription(request.getParameter("description"));
		manufacturer.setCountry(request.getParameter("country"));

		try {
			
			
			if (file.getBytes().length != 0) {
				box.deleteImage(manufacturer.getUrlImage(), GlobalConfigProject.IMAGE_BOX);
				box.saveImage(file.getBytes(), file.getOriginalFilename(), GlobalConfigProject.IMAGE_BOX);
				manufacturer.setUrlImage(file.getOriginalFilename());
			}

			manufacturerDAO.saveOrUpdateManufacturer(manufacturer);
			logger.actionAdd(null, manufacturer);
			
			
			model.addObject("message", "сохранено");
			model.addObject("manufacturer", manufacturer);

		} catch (IOException ex) {
			model.addObject("message", "ошибка");
		}

		return model;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Find
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.MANUFACTURER + "/" + GlobalConfigProject.FIND_MANUFACTURER, method = RequestMethod.GET)
	public ModelAndView findManufacturer(ModelAndView model) {

		model.setViewName(GlobalConfigProject.FIND_MANUFACTURER);

		return model;
	}
	
	/*
	 * 
	 * 
	 * 
	 * Review
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.MANUFACTURER + "/" + GlobalConfigProject.REVIEW_MANUFACTURER, method = RequestMethod.GET)
	public ModelAndView reviewManufacturer(WebRequest request, ModelAndView model) {
		
		String val = request.getParameter("id");

		if (val != null && !val.equals("")) {
			model.addObject("manufacturer", manufacturerDAO.getManufacturer(Long.parseLong(val)));
		}
		model.setViewName(GlobalConfigProject.REVIEW_MANUFACTURER);
		
		return model;
	}

}
