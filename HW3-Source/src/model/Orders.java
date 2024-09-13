package model;

public class Orders {
private Integer id;
private String orderno;
private String employeeno;
private String productno;
private String memberno;
private Integer amount;
public Orders() {
	super();
	// TODO Auto-generated constructor stub
}
public Orders(String orderno, String employeeno, String productno, String memberno, Integer amount) {
	super();
	this.orderno = orderno;
	this.employeeno = employeeno;
	this.productno = productno;
	this.memberno = memberno;
	this.amount = amount;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getOrderno() {
	return orderno;
}
public void setOrderno(String orderno) {
	this.orderno = orderno;
}
public String getEmployeeno() {
	return employeeno;
}
public void setEmployeeno(String employeeno) {
	this.employeeno = employeeno;
}
public String getProductno() {
	return productno;
}
public void setProductno(String productno) {
	this.productno = productno;
}
public String getMemberno() {
	return memberno;
}
public void setMemberno(String memberno) {
	this.memberno = memberno;
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}

}
