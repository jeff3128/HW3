package service.impl;

import java.util.List;

import dao.impl2.ProductDaoImpl;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static ProductDaoImpl pdi=new ProductDaoImpl();
	@Override
	public void add(Product p) {
		// TODO Auto-generated method stub
		pdi.add(p);
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return pdi.selectAll();
	}

	@Override
	public List<Product> selectById(int id) {
		// TODO Auto-generated method stub
		return pdi.selectById(id);
	}

	@Override
	public List<Product> selectProductno(String productno) {
		// TODO Auto-generated method stub
		return pdi.selectProductNo(productno);
	}

	@Override
	public List<Product> selectByProductname(String productname) {
		// TODO Auto-generated method stub
		return pdi.selectByProductName(productname);
	}

	@Override
	public void update(Product p) {
		// TODO Auto-generated method stub
		pdi.update(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pdi.delete(id);
	}

}
