package service.impl;

import model.Member;
import service.MemberService;

import java.util.List;

import dao.impl2.MemberDaoImpl;


public class MemberServiceImpl implements MemberService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new MemberServiceImpl().Login("abc","111"));
		//System.out.println(new MemberServiceImpl().findByUsername("jeff") );
		
		
		//Member m=new Member("m004","Jeff","jeff","新北市","1234");
		//new MemberServiceImpl().addMember(m);
	}

	private static MemberDaoImpl mdi=new MemberDaoImpl();
	
	@Override
	public Member Login(String username, String password) {
		// TODO Auto-generated method stub
		List<Member> l=mdi.selectMember(username, password);
		Member m=null;
		if(l.size()!=0)
		{
			m=l.get(0);
		}
		
		return m;
	}

	@Override
	public boolean findByUsername(String username) {
		List<Member> l=mdi.selectByUsername(username);
		boolean x=false;
		if(l.size()!=0)
		{
			x=true;
		}
		
		return x;
	}

	@Override
	public void addMember(Member m) {
		// TODO Auto-generated method stub
		mdi.add(m);
	}

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return mdi.selectAll();
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		mdi.update(m);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		mdi.delete(id);
	}



}
