package service.impl;

import java.util.List;

import dao.impl2.OrdersDaoImpl;
import model.Orders;
import service.OrdersService;

public class OrderServiceImpl implements OrdersService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static OrdersDaoImpl mdi=new OrdersDaoImpl();

	@Override
	public void add(Orders o) {
		// TODO Auto-generated method stub
		mdi.add(o);
	}

	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return mdi.selectAll();
	
	}

	@Override
	public List<Orders> findById(int id) {
		// TODO Auto-generated method stub
		
		return mdi.selectById(id);
	}

	
	@Override
	public List<Orders> findByOrderno(String orderno) {
		// TODO Auto-generated method stub
		return mdi.selectOrderNo(orderno);
	}

	@Override
	public void update(Orders o) {
		// TODO Auto-generated method stub
		mdi.update(o);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		mdi.delete(id);
	}

	@Override
	public List<Orders> findByProductno(String productno) {
		// TODO Auto-generated method stub
		return mdi.selectByProductNo(productno);
	}
	
	
}
