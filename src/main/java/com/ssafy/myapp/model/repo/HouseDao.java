package com.ssafy.myapp.model.repo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.myapp.model.dto.HouseDeal;
import com.ssafy.myapp.model.dto.HousePageBean;

public interface HouseDao {
//	/**
//	 * 아파트 거래 정보를 xml 파일에서 로딩하는 기능 
//	 */
//	void loadData();
//		
//	/**
//	 * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를  검색해서 반환.  
//	 * @param bean  검색 조건과 검색 단어가 있는 객체
//	 * @return 조회한 식품 목록
//	 */
//	List<HouseDeal> searchAll(Connection connection, HousePageBean  bean) throws SQLException;
//	
//	/**
//	 * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환. 
//	 * @param no	검색할 아파트 식별 번호
//	 * @return		아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
//	 */
	HouseDeal search(int no);
//
//
//	int insert(Connection connection, HouseDeal deal) throws SQLException;
//
//	int update(Connection connection, HouseDeal deal) throws SQLException;
//
//	int delete(Connection connection, int no) throws SQLException;
//
//	//List<HouseDeal> selectAll(Connection con) throws SQLException;
//
//	HouseDeal selectByNo(Connection con, int no) throws SQLException;
//	
//	int getTotalCount(Connection con, HousePageBean bean) throws SQLException;
//
//
//	List<HouseDeal> searchAll(int currentPage, int sizePerPage, Connection connection, HousePageBean bean) throws SQLException;
//
//	List<HouseDeal> selectAll(Connection con, HousePageBean bean) throws SQLException;

}
