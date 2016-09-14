package com.holodniysvitanok.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.holodniysvitanok.dao.FileDublicate;
import com.holodniysvitanok.dao.ProductDAO;
import com.holodniysvitanok.entity.Category;
import com.holodniysvitanok.entity.ImageFile;
import com.holodniysvitanok.entity.Manufacturer;
import com.holodniysvitanok.entity.Product;

@Component
public class ProductService {

	@Autowired
	private ImageBox box;

	public void deleteImageCategoryAndManufacturer(ImageFile imageFile, FileDublicate fileDublicate) {

		if (imageFile.getUrlImage() != null) {
			if (fileDublicate.getCountDuplicateFiles(imageFile.getUrlImage()) <= 1) {
				box.deleteImage(imageFile.getUrlImage(), GlobalConfigProject.IMAGE_BOX);
			}
		}
	}

	public void deleteImageProduct(ProductDAO productDAO, Product product) {
		if (product.getUrlImage1() != null) {
			if (productDAO.getCountDuplicateFiles(product.getUrlImage1(), 1) <= 1) {
				box.deleteImage(product.getUrlImage1(), GlobalConfigProject.IMAGE_BOX);
			}
		}
		if (product.getUrlImage2() != null) {
			if (productDAO.getCountDuplicateFiles(product.getUrlImage2(), 2) <= 1) {
				box.deleteImage(product.getUrlImage2(), GlobalConfigProject.IMAGE_BOX);
			}
		}
		if (product.getUrlImage3() != null) {
			if (productDAO.getCountDuplicateFiles(product.getUrlImage3(), 3) <= 1) {
				box.deleteImage(product.getUrlImage3(), GlobalConfigProject.IMAGE_BOX);
			}
		}
	}

	public void setProductObject(WebRequest request, Product product) {

		String basePrice = request.getParameter("basePrice");
		String kPrice = request.getParameter("kPrice");
		String count = request.getParameter("count");
		String mainDescription = request.getParameter("mainDescription");
		String manufacturer = request.getParameter("manufacturer");
		String show = request.getParameter("show");
		String stock = request.getParameter("stock");
		String category = request.getParameter("category");

		String field1 = request.getParameter("field1");
		String field2 = request.getParameter("field2");
		String field3 = request.getParameter("field3");
		String field4 = request.getParameter("field4");
		String field5 = request.getParameter("field5");
		String field6 = request.getParameter("field6");
		String field7 = request.getParameter("field7");
		String field8 = request.getParameter("field8");
		String field9 = request.getParameter("field9");
		String field10 = request.getParameter("field10");

		if (basePrice != null && !basePrice.equals("")) {
			product.setBasePrice(Integer.parseInt(basePrice));
		}

		if (kPrice != null && !kPrice.equals("")) {
			product.setkPrice(Integer.parseInt(request.getParameter("kPrice")));
		}

		if (count != null && !count.equals("")) {
			product.setCount(Integer.parseInt(request.getParameter("count")));
		}

		if (category != null && !category.equals("")) {
			System.err.println("category  " + category);
			product.setCategory(new Category(Long.parseLong(category)));
		}

		product.setMainDescription(mainDescription);
		product.setManufacturer(new Manufacturer(Long.parseLong(manufacturer)));
		product.setSupportField1(field1);
		product.setSupportField2(field2);
		product.setSupportField3(field3);
		product.setSupportField4(field4);
		product.setSupportField5(field5);
		product.setSupportField6(field6);
		product.setSupportField7(field7);
		product.setSupportField8(field8);
		product.setSupportField9(field9);
		product.setSupportField10(field10);
		product.setShow(checkboxString(show));
		product.setStock(checkboxString(stock));

	}

	public void saveImages(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {

		if (file1.getBytes().length != 0) {
			product.setUrlImage1(file1.getOriginalFilename());
			box.saveImage(file1.getBytes(), file1.getOriginalFilename(), GlobalConfigProject.IMAGE_BOX);
		}

		if (file2.getBytes().length != 0) {
			product.setUrlImage2(file2.getOriginalFilename());
			box.saveImage(file2.getBytes(), file2.getOriginalFilename(), GlobalConfigProject.IMAGE_BOX);
		}

		if (file3.getBytes().length != 0) {
			product.setUrlImage3(file3.getOriginalFilename());
			box.saveImage(file3.getBytes(), file3.getOriginalFilename(), GlobalConfigProject.IMAGE_BOX);
		}
	}

	public boolean checkboxString(String checkboxParameter) {
		if (checkboxParameter != null) {
			return true;
		}
		return false;
	}
}
