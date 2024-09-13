package service;

import java.util.List;

import model.Product;

public interface ProductService {
	//create
	void add(Product p);//inject 
	
//read
	List<Product> selectAll();//查全部
	List<Product> selectById(int id);
	List<Product> selectProductno(String productno);
	List<Product> selectByProductname(String productname);
	//update
	void update(Product p);
	//delete
	
	void delete(int id);
}
