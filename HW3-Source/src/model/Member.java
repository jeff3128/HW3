package model;

import java.io.Serializable;

public class Member  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Integer id;
private String memberno;
private String membername;
private String username;
private String address;
private String password;
public Member() {
	super();
	// TODO Auto-generated constructor stub
}

public Member(String memberno, String membername, String username, String address, String password) {
	super();
	this.memberno = memberno;
	this.membername = membername;
	this.username = username;
	this.address = address;
	this.password = password;
}
public Member(Integer id, String memberno, String membername, String username, String address, String password) {
	// TODO Auto-generated constructor stub
	super();
	this.id= id;
	this.memberno = memberno;
	this.membername = membername;
	this.username = username;
	this.address = address;
	this.password = password;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getMemberno() {
	return memberno;
}
public void setMemberno(String memberno) {
	this.memberno = memberno;
}
public String getMembername() {
	return membername;
}
public void setMembername(String membername) {
	this.membername = membername;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
