package com.swust.shop.servcie;

import java.util.List;

import com.swust.shop.Beans.User;

public interface Ishopeservice {
	 boolean insertservice(User u);

	List queryService(int count, int cpage, String keyword);

	int[] listPage(int count, String keyword);
}
