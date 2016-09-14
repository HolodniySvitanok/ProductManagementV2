package com.holodniysvitanok.dao;

import java.util.List;

import com.holodniysvitanok.entity.Record;

public interface RecordDAO {

	List<Record> getAllRecord(int count);

	Record getRecord(long id);

	void saveRecord(Record record);

	void deleteRecord(Record record);

}
