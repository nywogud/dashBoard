//package com.jhl.dashBoard.dao;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.jhl.dashBoard.model.DataModel;
//
//public class DataDAOImp implements DataDAO  {
//	
//	private static final String NameSpace = "com.jhl.dashBoard.mybatis.mapper";
//
//	@Autowired
//	SqlSession sqlSession;
//	
//	public List<DataModel> getData() throws Exception{
//		return sqlSession.selectList(NameSpace+".getData");
//	}
//}
