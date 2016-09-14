package com.holodniysvitanok.service;

public interface GlobalConfigProject {

	String ROOT_REDIRECT = "order"; // переадресация при корневом переходе
	
	/*
	 * Image setting
	 * */
	String IMAGE_BOX = "E:/imgbox/";
	String IMAGE_BOX_URL = "imgbox";
	int height = 200;
	int width = 200;
	
	/*
	 * 
	 *Root setting 
	 * */
	String NAME_ROOT = "root";
	String LOGIN_ROOT = "root";
	String PASSWORD_ROOT = "root";
	int ACCESS_LEVEL = 1;
	
	/*
	 * 
	 * Logger
	 * */
	boolean LOGGER_ON = false;
	
	/*
	 * Authorization
	 * */
	String AUTHORIZATION = "authorization";
	
	
	/*
	 * 
	 * Min access level
	 * */
	int MIN_ACCESS_LEVEL = 5;
	
	
	/*
	 * 
	 * Category
	 * 
	 * */
	String ADD_CATEGORY = "addCategory";
	String DEL_CATEGORY = "delCategory";
	String SET_CATEGORY = "setCategory";
	String ACTION_DEL_CATEGORY = "actionDelCategory";
	String SHOW_CATEGORY = "showCategory";
	String FIND_CATEGORY = "findCategory";
	String CATEGORY = "category";
	String REVIEW_CATEGORY = "reviewCategory";
	
	
	/*
	 * 
	 * Product
	 * 
	 * */
	String ADD_PRODUCT = "addProduct";
	String ACTION_DEL_PRODUCT = "actionDelProduct";
	String DEL_PRODUCT = "delProduct";
	String SET_PRODUCT = "setProduct";
	String SHOW_PRODUCT = "showProduct";
	String FIND_PRODUCT = "findProduct";
	String PRODUCT = "product";
	String REVIEW_PRODUCT = "reviewProduct";
	
	
	/*
	 * 
	 * Manufacturer
	 * 
	 * */
	String ADD_MANUFACTURER = "addManufacturer";
	String SHOW_MANUFACTURER = "showManufacturer";
	String ACTION_DEL_MANUFACTURER = "actionDelManufacturer";
	String DEL_MANUFACTURER = "delManufacturer";
	String SET_MANUFACTURER = "setManufacturer";
	String FIND_MANUFACTURER = "findManufacturer";
	String MANUFACTURER = "manufacturer";
	String REVIEW_MANUFACTURER = "reviewManufacturer";
	
	
	/*
	 * 
	 * User
	 * */
	String USER = "user";
	String ADD_USER = "addUser";
	String FIND_USER = "findUser";
	String SHOW_USER = "showUser";
	String SET_USER = "setUser";
	String DEL_USER = "delUser";
	String EXIT_USER = "exitUser";
	String REVIEW_USER = "reviewUser";
	
	/*
	 * 
	 * Order
	 * */
	String ORDER = "order";
}
