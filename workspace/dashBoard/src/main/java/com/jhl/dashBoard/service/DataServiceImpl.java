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

}
