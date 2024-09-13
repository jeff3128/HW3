package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDao {

	//create
			void add(Employee e);//inject 
			
	    //read
			List<Employee> selectAll();//查全部
			List<Employee> selectById(int id);
			List<Employee> selectEmployee(String username,String password);
			List<Employee> selectByUsername(String username);
			//update
			void update(Employee e);
			//delete
			
			void delete(int id);

	
}
