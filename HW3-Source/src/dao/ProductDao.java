package dao;

import java.util.List;
import model.Product;

public interface ProductDao {

	//create
			void add(Product p);//inject 
			
	    //read
			List<Product> selectAll();//查全部
			List<Product> selectById(int id);
			List<Product> selectProductNo(String productno);
			List<Product> selectByProductName(String productname);
			//update
			void update(Product p);
			//delete
			
			void delete(int id);

	
}
