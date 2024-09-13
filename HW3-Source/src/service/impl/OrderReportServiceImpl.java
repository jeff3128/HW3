package service.impl;

import java.util.List;

import dao.impl2.OrderReportDaoImpl;
import model.OrderReport;
import service.OrderReportService;

public class OrderReportServiceImpl implements OrderReportService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static OrderReportDaoImpl odi=new OrderReportDaoImpl();
	

	@Override
	public List<OrderReport> selectAll() {
		// TODO Auto-generated method stub
		return odi.selectAll();
		
	}

	@Override
	public List<OrderReport> selectById(int id) {
		// TODO Auto-generated method stub
		return odi.selectById(id);
			}

	@Override
	public List<OrderReport> selectOrderno(String orderno) {
		// TODO Auto-generated method stub
		return odi.selectByOrderNo(orderno);
	}

	@Override
	public List<OrderReport> selectEmployeeName(String employeename) {
		// TODO Auto-generated method stub
		return odi.selectByEmployeeName(employeename);
		
	}



}
