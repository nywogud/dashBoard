package com.jhl.dashBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhl.dashBoard.dao.DataDAO;
import com.jhl.dashBoard.model.DataModel;

@Service
public class DataServiceImpl implements DataService{
	
	@Autowired
	private DataDAO dataDAO;
	
	@Override
	public List<DataModel> getData() throws Exception{
		
		return dataDAO.getData();
		 
	}
	
	@Override
	public List<DataModel> getNumAttem() throws Exception{
		return dataDAO.getNumAttem();
	}
	
	@Override
	public List<DataModel> getConuntNumAttem() throws Exception{
		return dataDAO.getConuntNumAttem();
	}
	
	@Override
	public List<DataModel> getSucResultNum() throws Exception{
		return dataDAO.getSucResultNum();
	}
	
	@Override
	public List<DataModel> getNumAttemWithRowNum() throws Exception{
		return dataDAO.getNumAttemWithRowNum();
	}
	
	@Override
	public List<DataModel> getFailResultNum() throws Exception{
		return dataDAO.getFailResultNum();
	}
	
	@Override
	public void deleteDB() throws Exception{
		dataDAO.deleteDB();
	}
	
	@Override
	public void insertCVS(DataModel dataModel) throws Exception{
		dataDAO.insertCVS(dataModel);
	}
	
	@Override
	public void doCommit() throws Exception{
		dataDAO.doCommit();
	}
	
	

}
