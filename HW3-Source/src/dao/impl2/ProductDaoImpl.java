package dao.impl2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.ProductDao;
import model.Product;

public class ProductDaoImpl implements ProductDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //新增測試
		//	new ProductDaoImpl().add(new Product("p004", "Monitor",5000));
		// 查詢測試
		//		 List<Product> l=new ProductDaoImpl().selectByProductName("Monitor"); //selectProductNo("p004"); //selectById(4); selectAll(); 
		//		for(Product p:l)
		//			{
		//			System.out.println(p.getId()+"\t"+p.getProductno()+"\t"+p.getProductname());
		//			}
		//update
		/* List<Product> l=new ProductDaoImpl().selectById(4);
	    Product p=l.get(0);
		System.out.println(p.getId()+"\t"+p.getProductname()); //update 前
		p.setProductname("鍵盤");
	    p.setPrice(800);
		new ProductDaoImpl().update(p);
		System.out.println(p.getId()+"\t"+p.getProductno()+"\t"+p.getProductname()+"\t"+p.getPrice());//update 後
			*/	 
		//delete測試
		//	 new ProductDaoImpl().delete(4);
		
	}

	@Override
	public void add(Product p) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL = "insert into Product(productno,productname,price)" + "values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getProductno());
			ps.setString(2, p.getProductname());
			ps.setInt(3, p.getPrice());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL = "select * from Product";
			List<Product> l = new ArrayList<>();
			try {
				PreparedStatement ps = conn.prepareStatement(SQL);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Product p = new Product();
					p.setId(rs.getInt("id"));
					p.setProductno(rs.getString("productno"));
					p.setProductname(rs.getString("productname"));
					p.setPrice(rs.getInt("price"));
					l.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return l;
	}

	@Override
	public List<Product> selectById(int id) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL="select * from Product where id=?";
		List<Product> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Product p = new Product();
			        p.setId(rs.getInt("id"));
				p.setProductno(rs.getString("productno"));
				p.setProductname(rs.getString("productname"));
				p.setPrice(rs.getInt("price"));
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// TODO Auto-generated method stub
		return l;
	}

	@Override
	public List<Product> selectProductNo(String productno) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="select * from Product where productno=?";
		List<Product> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, productno);
ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Product p = new Product();
			        p.setId(rs.getInt("id"));
				p.setProductno(rs.getString("productno"));
				p.setProductname(rs.getString("productname"));
				p.setPrice(rs.getInt("price"));
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// TODO Auto-generated method stub
		return l;
	}

	@Override
	public List<Product> selectByProductName(String productname) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="select * from Product where productname=?";
		List<Product> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, productname);
ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Product p = new Product();
			        p.setId(rs.getInt("id"));
				p.setProductno(rs.getString("productno"));
				p.setProductname(rs.getString("productname"));
				p.setPrice(rs.getInt("price"));
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// TODO Auto-generated method stub
		return l;
	}

	@Override
	public void update(Product p) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="update Product set productno=?,productname=?,price=? where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, p.getProductno());
			ps.setString(2, p.getProductname());
                        ps.setInt(3, p.getPrice());
			ps.setInt(4,p.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="delete from Product where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
