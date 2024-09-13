package dao.impl2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		 //新增測試
	//	new MemberDaoImpl().add(new Member("m004", "Jeff", "jeff", "taipei", "777"));

		// 查詢測試
	// List<Member> l=new MemberDaoImpl().selectByUsername("jeff");//selectById(3); selectAll();,selectMember("abc", "111"); ,selectByUsername("aa")
	//for(Member m:l)
	//{
	//	System.out.println(m.getId()+"\t"+m.getMembername()+"\t"+m.getAddress());
	//}
		 /*update
		 List<Member> l=new MemberDaoImpl().selectById(4);
		 Member m=l.get(0);
		 System.out.println(m.getId()+"\t"+m.getMembername()); //update 前
		 m.setMembername("Jeff Chen");
		 m.setAddress("新北市");
		 new MemberDaoImpl().update(m);
		 System.out.println(m.getId()+"\t"+m.getMembername());//update 後
		 */
		//delete測試
					// new MemberDaoImpl().delete(9);
					 
		
		
	}

	@Override
	public void add(Member m) {
		Connection conn = DbConnection.getdb();
		String SQL = "insert into member(memberno,membername,username,address,password)" + "values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, m.getMemberno());
			ps.setString(2, m.getMembername());
			ps.setString(3, m.getUsername());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getPassword());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@Override
	public List<Member> selectAll() {
		Connection conn = DbConnection.getdb();
		String SQL = "select * from member";
		List<Member> l = new ArrayList<>();
		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setMembername(rs.getString("membername"));
				m.setUsername(rs.getString("username"));
				m.setAddress(rs.getString("address"));
				m.setPassword(rs.getString("password"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public List<Member> selectById(int id) {
		Connection conn = DbConnection.getdb();
		String SQL="select * from member where id=?";
		List<Member> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setMembername(rs.getString("membername"));
				m.setUsername(rs.getString("username"));
				m.setAddress(rs.getString("address"));
				m.setPassword(rs.getString("password"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// TODO Auto-generated method stub
		return l;
	}

	@Override
	public List<Member> selectMember(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="select * from member where username=? and password=?";
		List<Member> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2,password);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setMembername(rs.getString("membername"));
				m.setUsername(rs.getString("username"));
				m.setAddress(rs.getString("address"));
				m.setPassword(rs.getString("password"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Member> selectByUsername(String username) {
		Connection conn=DbConnection.getdb();
		String SQL="select * from member where username=?";
		List<Member> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setMembername(rs.getString("membername"));
				m.setUsername(rs.getString("username"));
				m.setAddress(rs.getString("address"));
				m.setPassword(rs.getString("password"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="update member set memberno=?,membername=?,address=?,password=? where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getMemberno());
			ps.setString(2, m.getMembername());
			ps.setString(3, m.getAddress());
			ps.setString(4, m.getPassword());
			ps.setInt(5,m.getId());
			
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
		String SQL="delete from member where id=?";
		
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
