package com.holodniysvitanok.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.holodniysvitanok.dao.RecordDAO;
import com.holodniysvitanok.entity.Record;
import com.holodniysvitanok.entity.User;


@Component
public class Logger {

	@Autowired
	private RecordDAO recordDAO;
	
	
	
	
	public void actionAdd(User user, Object object){
		record(user, "add object", object);
	}
	
	public void actionDel(User user, Object object){
		record(user, "del object", object);
	}
	
	public void actionSet(User user, Object object){
		record(user, "set object", object);
	}
	
	
	
	
	
	private void record(User user, String action, Object object){
	
		if(!GlobalConfigProject.LOGGER_ON){
			return;
		}
		
		Record record = new Record();
		
		record.setStringObject(object.toString());
		record.setAction(action);
		record.setDate(new Date());
		record.setUserName(user.getName());
		
		recordDAO.saveRecord(record);
		
	}
	
	public List<Record> getRecords(int count){
		return recordDAO.getAllRecord(count);
	}
	
}
