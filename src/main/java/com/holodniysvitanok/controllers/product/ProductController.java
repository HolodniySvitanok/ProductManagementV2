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
import com.holodniysvitanok.dao.ManufacturerDAO;
import com.holodniysvitanok.dao.ProductDAO;
import com.holodniysvitanok.entity.Category;
import com.holodniysvitanok.entity.Manufacturer;
import com.holodniysvitanok.entity.Product;
import com.holodniysvitanok.entity.User;
import com.holodniysvitanok.service.GlobalConfigProject;
import com.holodniysvitanok.service.ImageBox;
import com.holodniysvitanok.service.Logger;
import com.holodniysvitanok.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ImageBox box;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ManufacturerDAO manufacturerDAO;

	@Autowired
	private Logger logger;
	
	@Autowired
	private ProductService productService;
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
	 * Переадрисация при заходе на путь ПРОДУКТА на под страничку продукта
	 */
	@RequestMapping(value = "/" + GlobalConfigProject.PRODUCT, method = RequestMethod.GET)
	public ModelAndView product() {
		return new ModelAndView("redirect: " + GlobalConfigProject.PRODUCT + "/" + GlobalConfigProject.SHOW_PRODUCT);
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
	 * ADD
	 */
	@RequestMapping(value = "/" + GlobalConfigProject.PRODUCT + "/" + GlobalConfigProject.ADD_PRODUCT, method = RequestMethod.GET)
	public ModelAndView addProduct(ModelAndView model, WebRequest request) {

		String parameter = request.getParameter("category");

		model.setViewName(GlobalConfigProject.ADD_PRODUCT);

		if (parameter == null) {
			List<Category> allCategory = categoryDAO.getAllCategory(9999);
			model.addObject("categoryList", allCategory);
			model.addObject("showCategory", true);
			return model;
		}

		long id = Long.parseLong(parameter);

		List<Manufacturer> allManufacturer = manufacturerDAO.getAllManufacturer(9999);
		Category category = categoryDAO.getCategory(id);

		model.addObject("manufacturerList", allManufacturer);
		model.addObject("category", category);

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
	 * Save
	 */
	@RequestMapping(value = "/" + GlobalConfigProject.PRODUCT + "/" + GlobalConfigProject.ADD_PRODUCT, method = RequestMethod.POST)
	public ModelAndView saveProduct(ModelAndView model, WebRequest request, @RequestParam("fileImage1") MultipartFile file1,
			@RequestParam("fileImage2") MultipartFile file2, @RequestParam("fileImage3") MultipartFile file3) {

		Product product = new Product();

		try {
			productService.setProductObject(request, product);
			productService.saveImages(product, file1, file2, file3);
			productDAO.saveOrUpdateProduct(product);
			logger.actionAdd(null, product);
			
		} catch (IOException ex) {
			// Добавить сообщение об ошибке
		}
		model.setViewName("redirect: "+GlobalConfigProject.ADD_PRODUCT);

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
	 * Show
	 */
	@RequestMapping(value = "/" + GlobalConfigProject.PRODUCT + "/" + GlobalConfigProject.SHOW_PRODUCT, method = RequestMethod.GET)
	public ModelAndView showProduct(ModelAndView model) {

		List<Product> allProducts = productDAO.getAllProducts(9999);
		
		model.addObject("productList", allProducts);
		
		model.setViewName(GlobalConfigProject.SHOW_PRODUCT);

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
	 * Delete
	 */
	@RequestMapping(value = "/" + GlobalConfigProject.PRODUCT + "/" + GlobalConfigProject.ACTION_DEL_PRODUCT, method = RequestMethod.GET)
	public ModelAndView actionDeleteProduct(HttpServletRequest servletRequest, WebRequest request, ModelAndView model) {

		String parameter = request.getParameter("id");
		model.setViewName("redirect: " + GlobalConfigProject.SHOW_PRODUCT);

		if (parameter.length() == 0) {
			return model;
		}

		long id = Long.parseLong(parameter);

		Product product = productDAO.getProduct(id);

		productService.deleteImageProduct(productDAO, product);
		
		productDAO.deleteProduct(product);
		logger.actionDel(new User("test"), product);
		

		return model;
	}

	@RequestMapping(value = "/" + GlobalConfigProject.PRODUCT + "/" + GlobalConfigProject.DEL_PRODUCT, method = RequestMethod.GET)
	public ModelAndView deleteProduct(HttpServletRequest request, ModelAndView model) {

		String parameter = request.getParameter("id");
		
		if (parameter == null || parameter.equals("")) {
			model.setViewName("redirect: " + request.getServletContext().getContextPath());
			return model;
		}
			
		Product product = productDAO.getProduct(Long.parseLong(parameter));
		
		model.addObject("product", product);
		model.setViewName(GlobalConfigProject.DEL_PRODUCT);
		
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
	 * Set
	 */
	@RequestMapping(value = "/" + GlobalConfigProject.PRODUCT + "/" + GlobalConfigProject.SET_PRODUCT, method = RequestMethod.GET)
	public ModelAndView setProduct(WebRequest request, ModelAndView model) {

		String parameter = request.getParameter("id");

		if (parameter.length() != 0) {
			long id = Long.parseLong(parameter);
			
			Product product = productDAO.getProduct(id);
			List<Manufacturer> manufacturerList = manufacturerDAO.getAllManufacturer(9999);
			
			model.addObject("product", product);
			model.addObject("manufacturerList", manufacturerList);
			model.addObject("category", product.getCategory());
			
			model.setViewName(GlobalConfigProject.SET_PRODUCT);
		} else {
			model.setViewName(GlobalConfigProject.PRODUCT);
		}

		return model;
	}

	@RequestMapping(value = "/" + GlobalConfigProject.PRODUCT + "/" + GlobalConfigProject.SET_PRODUCT, method = RequestMethod.POST)
	public ModelAndView actionSetProduct(ModelAndView model, WebRequest request, @RequestParam("fileImage1") MultipartFile file1,
			@RequestParam("fileImage2") MultipartFile file2, @RequestParam("fileImage3") MultipartFile file3){
		
		long id = Long.parseLong(request.getParameter("id"));
		
		model.setViewName(GlobalConfigProject.SET_PRODUCT);
		
		Product product = productDAO.getProduct(id);
		List<Manufacturer> manufacturerList = manufacturerDAO.getAllManufacturer(9999);
		try {
			
			productService.setProductObject(request , product);
			productService.saveImages(product, file1, file2, file3);
			
			model.addObject("message", "Сохранено");
			model.addObject("product", product);
			model.addObject("manufacturerList", manufacturerList);
			
			productDAO.saveOrUpdateProduct(product);
			logger.actionSet(null, product);
			
		} catch (IOException e) {
			model.addObject("message", "Ошибка");
			e.printStackTrace();
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
	 * Find
	 */
	@RequestMapping(value = "/" + GlobalConfigProject.PRODUCT + "/" + GlobalConfigProject.FIND_PRODUCT, method = RequestMethod.GET)
	public ModelAndView findProduct(ModelAndView model) {

		model.setViewName(GlobalConfigProject.FIND_PRODUCT);

		return model;
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 * Review
	 * */
	@RequestMapping(value = "/" + GlobalConfigProject.PRODUCT + "/" + GlobalConfigProject.REVIEW_PRODUCT, method = RequestMethod.GET)
	public ModelAndView reviewProduct(WebRequest request, ModelAndView model) {
		
		String val = request.getParameter("id");

		if (val != null && !val.equals("")) {
			model.addObject("product", productDAO.getProduct(Long.parseLong(val)));
		}
		
		
		model.setViewName(GlobalConfigProject.REVIEW_PRODUCT);
		
		return model;
	}

	

	
	
}
