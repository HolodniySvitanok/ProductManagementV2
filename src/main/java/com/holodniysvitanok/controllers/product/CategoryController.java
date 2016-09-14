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

import com.holodniysvitanok.dao.CategoryDAO;
import com.holodniysvitanok.entity.Category;
import com.holodniysvitanok.service.ProductService;
import com.holodniysvitanok.service.GlobalConfigProject;
import com.holodniysvitanok.service.ImageBox;
import com.holodniysvitanok.service.Logger;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;

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
	 * 
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.CATEGORY, method = RequestMethod.GET)
	public ModelAndView category() {
		return new ModelAndView("redirect: " + GlobalConfigProject.CATEGORY + "/" + GlobalConfigProject.SHOW_CATEGORY);
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.CATEGORY + "/" + GlobalConfigProject.ADD_CATEGORY, method = RequestMethod.GET)
	public String addCategory() {
		return GlobalConfigProject.ADD_CATEGORY;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */

	@RequestMapping(value = "/" + GlobalConfigProject.CATEGORY + "/" + GlobalConfigProject.ADD_CATEGORY, method = RequestMethod.POST)
	public ModelAndView saveCategory(ModelAndView model, WebRequest request, @RequestParam("fileImage") MultipartFile file) throws IOException {

		Category category = new Category();

		category.setName(request.getParameter("name"));
		category.setDescription(request.getParameter("description"));
		category.setSupportFieldName1(request.getParameter("supportFieldName1"));
		category.setSupportFieldName2(request.getParameter("supportFieldName2"));
		category.setSupportFieldName3(request.getParameter("supportFieldName3"));
		category.setSupportFieldName4(request.getParameter("supportFieldName4"));
		category.setSupportFieldName5(request.getParameter("supportFieldName5"));
		category.setSupportFieldName6(request.getParameter("supportFieldName6"));
		category.setSupportFieldName7(request.getParameter("supportFieldName7"));
		category.setSupportFieldName8(request.getParameter("supportFieldName8"));
		category.setSupportFieldName9(request.getParameter("supportFieldName9"));
		category.setSupportFieldName10(request.getParameter("supportFieldName10"));

		if (file.getBytes().length != 0) {
			category.setUrlImage(file.getOriginalFilename());
			box.saveImage(file.getBytes(), file.getOriginalFilename(), GlobalConfigProject.IMAGE_BOX);
		}

		model.setViewName(GlobalConfigProject.ADD_CATEGORY);

		try {

			categoryDAO.saveOrUpdateCategory(category);
			logger.actionAdd(null, category);

		} catch (Exception e) {
			e.printStackTrace();
			model.addObject("message", "не удалось добавить категорию");
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
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.CATEGORY + "/" + GlobalConfigProject.SHOW_CATEGORY, method = RequestMethod.GET)
	public ModelAndView showCategory(ModelAndView model) {

		List<Category> allCategory = categoryDAO.getAllCategory(9999);

		model.addObject("categoryList", allCategory);
		model.setViewName(GlobalConfigProject.SHOW_CATEGORY);

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
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.CATEGORY + "/" + GlobalConfigProject.ACTION_DEL_CATEGORY, method = RequestMethod.GET)
	public ModelAndView actionDeleteCategory(WebRequest request, ModelAndView model) {

		String parameter = request.getParameter("id");

		model.setViewName("redirect: " + GlobalConfigProject.SHOW_CATEGORY);

		if (parameter.equals("")) {
			return model;
		}
		
		long id = Long.parseLong(parameter);

		Category category = categoryDAO.getCategory(id);
		
		cams.deleteImageCategoryAndManufacturer(category, categoryDAO);

		categoryDAO.deleteCategory(category);
		logger.actionDel(null, category);

		return model;
	}

	@RequestMapping(value = "/" + GlobalConfigProject.CATEGORY + "/" + GlobalConfigProject.DEL_CATEGORY, method = RequestMethod.GET)
	public ModelAndView deleteCategory(HttpServletRequest request, ModelAndView model) {

		String parameter = request.getParameter("id");
		if (parameter == null || parameter.equals("")) {
			model.setViewName("redirect: " + request.getServletContext().getContextPath());
			return model;
		}
		
		Category category = categoryDAO.getCategory(Long.parseLong(parameter));
		
		model.addObject("category", category);
		model.setViewName(GlobalConfigProject.DEL_CATEGORY);
		
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
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.CATEGORY + "/" + GlobalConfigProject.SET_CATEGORY, method = RequestMethod.GET)
	public ModelAndView setCategory(WebRequest request, ModelAndView model) {

		String parameter = request.getParameter("id");

		if (parameter != null && !parameter.equals("")) {
			long id = Long.parseLong(parameter);
			Category category = categoryDAO.getCategory(id);
			model.addObject("category", category);
			model.setViewName(GlobalConfigProject.SET_CATEGORY);
		} else {
			model.setViewName(GlobalConfigProject.CATEGORY);
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
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.CATEGORY + "/" + GlobalConfigProject.SET_CATEGORY, method = RequestMethod.POST)
	public ModelAndView actionSetCategory(WebRequest request, ModelAndView model, @RequestParam("fileImage") MultipartFile file) {

		String parameter = request.getParameter("id");
		
		model.setViewName(GlobalConfigProject.SET_CATEGORY);
		
		if(parameter == null || parameter.equals("")){
			model.addObject("message", "ошибка");
			return model;
		}
		
		long id = Long.parseLong(parameter);
		Category category = categoryDAO.getCategory(id);

		category.setName(request.getParameter("name"));
		category.setDescription(request.getParameter("description"));
		category.setSupportFieldName1(request.getParameter("supportFieldName1"));
		category.setSupportFieldName2(request.getParameter("supportFieldName2"));
		category.setSupportFieldName3(request.getParameter("supportFieldName3"));
		category.setSupportFieldName4(request.getParameter("supportFieldName4"));
		category.setSupportFieldName5(request.getParameter("supportFieldName5"));
		category.setSupportFieldName6(request.getParameter("supportFieldName6"));
		category.setSupportFieldName7(request.getParameter("supportFieldName7"));
		category.setSupportFieldName8(request.getParameter("supportFieldName8"));
		category.setSupportFieldName9(request.getParameter("supportFieldName9"));
		category.setSupportFieldName10(request.getParameter("supportFieldName10"));

		try {

			if (file.getBytes().length != 0) {
				box.deleteImage(category.getUrlImage(), GlobalConfigProject.IMAGE_BOX);
				box.saveImage(file.getBytes(), file.getOriginalFilename(), GlobalConfigProject.IMAGE_BOX);
				category.setUrlImage(file.getOriginalFilename());
			}

			categoryDAO.saveOrUpdateCategory(category);
			logger.actionSet(null, category);

			model.addObject("message", "сохранено");
			model.addObject("category", category);

		} catch (IOException ex) {
			ex.printStackTrace();
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
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.CATEGORY + "/" + GlobalConfigProject.FIND_CATEGORY, method = RequestMethod.GET)
	public ModelAndView findCategory(ModelAndView model) {

		model.setViewName(GlobalConfigProject.FIND_CATEGORY);

		return model;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Review
	 */
	@RequestMapping(value = "/" + GlobalConfigProject.CATEGORY + "/" + GlobalConfigProject.REVIEW_CATEGORY, method = RequestMethod.GET)
	public ModelAndView reviewCategory(WebRequest request, ModelAndView model) {

		String val = request.getParameter("id");

		if (val != null &&  !val.equals("")) {
			model.addObject("category", categoryDAO.getCategory(Long.parseLong(val)));
		}
		model.setViewName(GlobalConfigProject.REVIEW_CATEGORY);

		return model;
	}
}
