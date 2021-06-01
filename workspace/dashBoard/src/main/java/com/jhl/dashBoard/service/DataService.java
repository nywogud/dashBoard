package com.jhl.dashBoard.service;

import java.util.List;

import com.jhl.dashBoard.model.DataModel;

public interface DataService {
	
	public List<DataModel> getData() throws Exception;
	
	public List<DataModel> getNumAttem() throws Exception;
	
	public List<DataModel> getConuntNumAttem() throws Exception;
	
	public List<DataModel> getSucResultNum() throws Exception;
	
	public List<DataModel> getNumAttemWithRowNum() throws Exception;
	
	public List<DataModel> getFailResultNum() throws Exception;
	
	public void deleteDB() throws Exception;
	
	public void insertCVS(DataModel dataModel) throws Exception;

	public void doCommit() throws Exception;

}
