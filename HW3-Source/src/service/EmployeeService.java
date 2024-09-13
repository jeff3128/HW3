package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
	//create
	void add(Employee em);//inject 
	
//read
	List<Employee> selectAll();//查全部
	List<Employee> selectById(int id);
	List<Employee> selectEmployee(String username,String password);
	List<Employee> selectByUsername(String username);
	//update
	void update(Employee em);
	//delete
	
	void delete(int id);
}
