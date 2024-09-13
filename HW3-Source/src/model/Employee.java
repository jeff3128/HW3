package model;

public class Employee {
private Integer id;
private String employeeno;
private String employeename;
private String username;
private String password;
private String address;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(String employeeno, String employeename, String username, String password, String address) {
	super();
	this.employeeno = employeeno;
	this.employeename = employeename;
	this.username = username;
	this.password = password;
	this.address = address;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getEmployeeno() {
	return employeeno;
}
public void setEmployeeno(String employeeno) {
	this.employeeno = employeeno;
}
public String getEmployeename() {
	return employeename;
}
public void setEmployeename(String employeename) {
	this.employeename = employeename;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
	
	
	
}
