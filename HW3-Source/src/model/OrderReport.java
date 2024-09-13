package model;

public class OrderReport {
private Integer id;
private String orderno;
private String employeename;
private String productname;
private String membername;
private Double sum;
public OrderReport() {
	super();
	// TODO Auto-generated constructor stub
}
public OrderReport(String orderno, String employeename, String productname, String membername, Double sum) {
	super();
	this.orderno = orderno;
	this.employeename = employeename;
	this.productname = productname;
	this.membername = membername;
	this.sum = sum;
}

public void setId(Integer id) {
	this.id = id;
}
public void setOrderno(String orderno) {
	this.orderno = orderno;
}
public void setEmployeename(String employeename) {
	this.employeename = employeename;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public void setMembername(String membername) {
	this.membername = membername;
}
public void setSum(Double sum) {
	this.sum = sum;
}
public Integer getId() {
	return id;
}
public String getOrderno() {
	return orderno;
}
public String getEmployeename() {
	return employeename;
}
public String getProductname() {
	return productname;
}
public String getMembername() {
	return membername;
}
public Double getSum() {
	return sum;
}
	
	
}
