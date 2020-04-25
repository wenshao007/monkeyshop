package com.swust.shop.dao;
import java.util.List;

import com.swust.shop.Beans.User;
public interface Ishopdao {

	boolean insertuer(User u);

	List queryUser(int count, int cpage, String keyword);

	int[] listPage(int count, String keyword);


}
