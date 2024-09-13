package dao.impl2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.OrdersDao;
import model.Orders;

public class OrdersDaoImpl implements OrdersDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //新增測試
		//	new OrdersDaoImpl().add(new Orders("o004", "e002", "p002", "m003",10));
		// 查詢測試
		// List<Orders> l=new OrdersDaoImpl().selectByProductNo("p002"); // selectOrderNo("o004");selectById(3);selectAll();
		//for(Orders o:l)
		//{
		//System.out.println(o.getId()+"\t"+o.getOrderno()+"\t"+o.getProductno());
		//}
		//update
		/* List<Orders> l=new OrdersDaoImpl().selectById(4);
		 Orders o=l.get(0);
		 System.out.println(o.getId()+"\t"+o.getOrderno()); //update 前
		 o.setOrderno("o004");
		 o.setProductno("p002");
		 o.setMemberno("m003");
		 new OrdersDaoImpl().update(o);
		 System.out.println(o.getId()+"\t"+o.getOrderno()+"\t"+o.getProductno()+"\t"+o.getMemberno());//update 後
		 */
		
		//delete測試
		//	 new OrdersDaoImpl().delete(4);
	}

	@Override
	public void add(Orders o) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL = "insert into Orders(orderno,employeeno,productno,memberno,amount)" + "values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, o.getOrderno());
			ps.setString(2, o.getEmployeeno());
			ps.setString(3, o.getProductno());
			ps.setString(4, o.getMemberno());
			ps.setInt(5, o.getAmount());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@Override
	public List<Orders> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL = "select * from Orders";
			List<Orders> l = new ArrayList<>();
			try {

				PreparedStatement ps = conn.prepareStatement(SQL);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Orders o = new Orders();
					o.setId(rs.getInt("id"));
					o.setOrderno(rs.getString("orderno"));
					o.setEmployeeno(rs.getString("employeeno"));
					o.setProductno(rs.getString("productno"));
					o.setMemberno(rs.getString("memberno"));
					o.setAmount(rs.getInt("amount"));
					l.add(o);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return l;
	}

	@Override
	public List<Orders> selectById(int id) {
		Connection conn = DbConnection.getdb();
		String SQL="select * from Orders where id=?";
		List<Orders> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Orders o = new Orders();
				o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setEmployeeno(rs.getString("employeeno"));
				o.setProductno(rs.getString("productno"));
				o.setMemberno(rs.getString("memberno"));
				o.setAmount(rs.getInt("amount"));
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// TODO Auto-generated method stub
		return l;
	}

	@Override
	public List<Orders> selectOrderNo(String orderno) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="select * from Orders where orderno=?";
		List<Orders> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, orderno);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Orders o = new Orders();
				o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setEmployeeno(rs.getString("employeeno"));
				o.setProductno(rs.getString("productno"));
				o.setMemberno(rs.getString("memberno"));
				o.setAmount(rs.getInt("amount"));
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Orders> selectByProductNo(String productno) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="select * from Orders where productno=?";
		List<Orders> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, productno);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Orders o = new Orders();
				o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setEmployeeno(rs.getString("employeeno"));
				o.setProductno(rs.getString("productno"));
				o.setMemberno(rs.getString("memberno"));
				o.setAmount(rs.getInt("amount"));
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="delete from Orders where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void update(Orders o) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="update Orders set orderno=?,productno=?,memberno=? where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, o.getOrderno());
			ps.setString(2, o.getProductno());
            ps.setString(3, o.getMemberno());
			ps.setInt(4,o.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
