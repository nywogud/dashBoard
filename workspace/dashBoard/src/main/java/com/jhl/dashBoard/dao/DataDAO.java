package com.jhl.dashBoard.dao;

import java.util.List;

import com.jhl.dashBoard.model.DataModel;

public interface DataDAO {
	
	public List<DataModel> getData();
	
	public List<DataModel> getNumAttem();
	
	public List<DataModel> getConuntNumAttem();
	
	public List<DataModel> getSucResultNum();
	
	public List<DataModel> getNumAttemWithRowNum();
	
	public List<DataModel> getFailResultNum();
	
	public void deleteDB();
	
	public void insertCVS(DataModel dataModel);

	public void doCommit();
	
}
