package dao.impl2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.EmployeeDao;
import model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //新增測試
		// new EmployeeDaoImpl().add(new Employee("e004", "Jeff", "jeff", "777","新北市"));
		// 查詢測試
		// List<Employee> l=new EmployeeDaoImpl().selectByUsername("jeff");//selectEmployee("jeff", "777");//selectById(3);selectAll();//selectById(3); selectAll();,selectEmployee("abc", "111"); ,selectByUsername("aa")
		 //Employee em=l.get(0);
		 //System.out.println(em.getId()+"\t"+em.getEmployeename()); //update 前
		 
	    //	for(Employee e:l)
	    //	{
		//System.out.println(e.getId()+"\t"+e.getEmployeename()+"\t"+e.getAddress());
		//}
		
		//update
		 /*List<Employee> l=new EmployeeDaoImpl().selectById(3);
		 Employee em=l.get(0);
		 System.out.println(em.getId()+"\t"+em.getEmployeename()); //update 前
		 em.setEmployeename("C");
		 em.setAddress("台北市");
		 new EmployeeDaoImpl().update(em);
		 System.out.println(em.getId()+"\t"+em.getEmployeename());//update 後
		 */
		//delete測試
		//	 new EmployeeDaoImpl().delete(4);
		
		
		
		
	}

	@Override
	public void add(Employee e) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL = "insert into employee(employeeno,employeename,username,password,address)" + "values(?,?,?,?,?)";
	    
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, e.getEmployeeno());
			ps.setString(2, e.getEmployeename());
			ps.setString(3, e.getUsername());
			ps.setString(4, e.getPassword());
			ps.setString(5, e.getAddress());

			ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

	@Override
	public List<Employee> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL = "select * from Employee";
		List<Employee> l = new ArrayList<>();
		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee em = new Employee();
				em.setId(rs.getInt("id"));
				em.setEmployeeno(rs.getString("Employeeno"));
				em.setEmployeename(rs.getString("Employeename"));
				em.setUsername(rs.getString("username"));
				em.setPassword(rs.getString("password"));
                                em.setAddress(rs.getString("address"));
				l.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public List<Employee> selectById(int id) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL = "select * from Employee where id=?";
		List<Employee> l = new ArrayList<>();
		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, id);
			
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee em = new Employee();
				em.setId(rs.getInt("id"));
				em.setEmployeeno(rs.getString("Employeeno"));
				em.setEmployeename(rs.getString("Employeename"));
				em.setUsername(rs.getString("username"));
				em.setPassword(rs.getString("password"));
                em.setAddress(rs.getString("address"));
				l.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
		
		
	}

	@Override
	public List<Employee> selectEmployee(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getdb();
		String SQL = "select * from Employee where username=? and password=?";
		List<Employee> l = new ArrayList<>();
		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
              ps.setString(1, username);
  			  ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee em = new Employee();
				em.setId(rs.getInt("id"));
				em.setEmployeeno(rs.getString("Employeeno"));
				em.setEmployeename(rs.getString("Employeename"));
				em.setUsername(rs.getString("username"));
				em.setPassword(rs.getString("password"));
                em.setAddress(rs.getString("address"));
				l.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public List<Employee> selectByUsername(String username) {
		Connection conn = DbConnection.getdb();
		String SQL = "select * from Employee where username=?";
		List<Employee> l = new ArrayList<>();
		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
              ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee em = new Employee();
				em.setId(rs.getInt("id"));
				em.setEmployeeno(rs.getString("Employeeno"));
				em.setEmployeename(rs.getString("Employeename"));
				em.setUsername(rs.getString("username"));
				em.setPassword(rs.getString("password"));
                em.setAddress(rs.getString("address"));
				l.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public void update(Employee em) {
		Connection conn=DbConnection.getdb();
		String SQL="update Employee set employeename=?,address=? where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, em.getEmployeename());
			ps.setString(2, em.getAddress());
			ps.setInt(3, em.getId());
			
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
		String SQL="delete from Employee where id=?";
		
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
