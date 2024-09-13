package service;

import java.util.List;

import model.Member;

public interface MemberService {
	Member Login(String username,String password);//登入
	boolean findByUsername(String username);
	List<Member> selectAll();//查全部
	void addMember(Member m);
	//update
		void update(Member m);
		//delete
		
		void delete(int id);
		
	
}
