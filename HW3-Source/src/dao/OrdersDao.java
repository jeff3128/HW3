package dao;

import java.util.List;
import model.Orders;

public interface OrdersDao {

	//create
			void add(Orders o);//inject 
			
	    //read
			List<Orders> selectAll();//查全部
			List<Orders> selectById(int id);
			List<Orders> selectOrderNo(String orderno);
			List<Orders> selectByProductNo(String productno);
			//update
			void update(Orders o);
			//delete
			
			void delete(int id);

	
}
