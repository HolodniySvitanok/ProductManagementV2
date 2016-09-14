package com.holodniysvitanok.dao;

import java.util.List;

import com.holodniysvitanok.entity.Manufacturer;

public interface ManufacturerDAO extends FileDublicate {

	List<Manufacturer> getAllManufacturer(int count);

	Manufacturer getManufacturer(long id);

	void saveOrUpdateManufacturer(Manufacturer manufacturer);

	void deleteManufacturer(Manufacturer manufacturer);
	
}
