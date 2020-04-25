package com.swust.shop.servcie;

import java.util.List;

import com.swust.shop.Beans.User;
import com.swust.shop.dao.Ishopdao;
import com.swust.shop.dao.shopdapimpl;

public class Ishopeserviceimpl implements Ishopeservice {
	private Ishopdao dao;
	public Ishopeserviceimpl() {
		 dao = new shopdapimpl();
	}
	public boolean insertservice(User u) {
		boolean flag =  dao.insertuer(u);
		return flag;
	}
	@Override
	public List queryService(int count, int cpage,String keyword) {
		List list = dao.queryUser(count,cpage,keyword);
		return list;
	}
	@Override
	public int[] listPage(int count,String keyword) {
		int[] arr = dao.listPage(count,keyword);
		return arr;
	}

}
