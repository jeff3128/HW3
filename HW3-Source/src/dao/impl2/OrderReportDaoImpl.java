package dao.impl2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.OrderReportDao;
import model.OrderReport;

public class OrderReportDaoImpl implements OrderReportDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 查詢測試
				 List<OrderReport> l=new OrderReportDaoImpl().selectByMemberName("John");  // selectByProductName("Lcd"); //selectByEmployeeName("B"); //selectByOrderNo("o003");//selectById(3);//selectAll();selectOrderNo("o004");selectById(3);selectAll();
				for(OrderReport o:l)
				{
				System.out.println(o.getId()+"\t"+o.getOrderno()+"\t"+o.getProductname());
				}
	}

	@Override
	public List<OrderReport> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL = "select * from order_report";
			List<OrderReport> l = new ArrayList<>();
			try {

				PreparedStatement ps = conn.prepareStatement(SQL);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					OrderReport o = new OrderReport();
					o.setId(rs.getInt("id"));
					o.setOrderno(rs.getString("orderno"));
					o.setEmployeename(rs.getString("employeename"));
					o.setProductname(rs.getString("productname"));
					o.setMembername(rs.getString("membername"));
					o.setSum(rs.getDouble("sum"));
					l.add(o);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return l;
	}

	@Override
	public List<OrderReport> selectById(int id) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL = "select * from order_report where id=?";
		
		List<OrderReport> l = new ArrayList<>();
			try {

				PreparedStatement ps = conn.prepareStatement(SQL);
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					OrderReport o = new OrderReport();
					o.setId(rs.getInt("id"));
					o.setOrderno(rs.getString("orderno"));
					o.setEmployeename(rs.getString("employeename"));
					o.setProductname(rs.getString("productname"));
					o.setMembername(rs.getString("membername"));
					o.setSum(rs.getDouble("sum"));
					l.add(o);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return l;
	}

	@Override
	public List<OrderReport> selectByOrderNo(String orderno) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="select * from Order_Report where orderno=?";
		List<OrderReport> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, orderno);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				OrderReport o = new OrderReport();
				o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setEmployeename(rs.getString("employeename"));
				o.setProductname(rs.getString("productname"));
				o.setMembername(rs.getString("membername"));
				o.setSum(rs.getDouble("sum"));
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<OrderReport> selectByEmployeeName(String employeename) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="select * from Order_Report where employeename=?";
		List<OrderReport> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, employeename);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				OrderReport o = new OrderReport();
				o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setEmployeename(rs.getString("employeename"));
				o.setProductname(rs.getString("productname"));
				o.setMembername(rs.getString("membername"));
				o.setSum(rs.getDouble("sum"));
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<OrderReport> selectByProductName(String productname) {
		Connection conn=DbConnection.getdb();
		String SQL="select * from Order_Report where productname=?";
		List<OrderReport> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, productname);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				OrderReport o = new OrderReport();
				o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setEmployeename(rs.getString("employeename"));
				o.setProductname(rs.getString("productname"));
				o.setMembername(rs.getString("membername"));
				o.setSum(rs.getDouble("sum"));
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<OrderReport> selectByMemberName(String membername) {
		Connection conn=DbConnection.getdb();
		String SQL="select * from Order_Report where membername=?";
		List<OrderReport> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, membername);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				OrderReport o = new OrderReport();
				o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setEmployeename(rs.getString("employeename"));
				o.setProductname(rs.getString("productname"));
				o.setMembername(rs.getString("membername"));
				o.setSum(rs.getDouble("sum"));
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

}
