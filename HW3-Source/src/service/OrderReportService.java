package service;

import java.util.List;

import model.OrderReport;

public interface OrderReportService {
	//create
	//void add(OrderReport o);//inject 
	
//read
	List<OrderReport> selectAll();//查全部
	List<OrderReport> selectById(int id);
	List<OrderReport> selectOrderno(String orderno);
	List<OrderReport> selectEmployeeName(String employeename);

}
