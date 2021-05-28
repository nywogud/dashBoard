package com.jhl.dashBoard.service;

import java.util.List;

import com.jhl.dashBoard.model.DataModel;

public interface DataService {
	
	public List<DataModel> getData() throws Exception;
	
	public List<DataModel> getNumAttem() throws Exception;

}
