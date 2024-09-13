package service;

import java.util.List;

import model.Orders;

public interface OrdersService {
	//create
	void add(Orders o);//inject 
	
//read
	List<Orders> findAll();//查全部
	List<Orders> findById(int id);
	List<Orders> findByProductno(String productno);
	List<Orders> findByOrderno(String orderno);
	//update
	void update(Orders o);
	//delete
	
	void delete(int id);
}
