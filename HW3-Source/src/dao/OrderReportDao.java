package dao;

import java.util.List;

import model.OrderReport;

public interface OrderReportDao {

	 //read
	List<OrderReport> selectAll();//查全部
	List<OrderReport> selectById(int id);
	List<OrderReport> selectByOrderNo(String orderno);
	List<OrderReport> selectByEmployeeName(String employeename);
	List<OrderReport> selectByProductName(String productname);
	List<OrderReport> selectByMemberName(String membername);
}
