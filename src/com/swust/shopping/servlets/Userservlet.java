package com.swust.shopping.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swust.shop.Beans.User;
import com.swust.shop.servcie.Ishopeservice;
import com.swust.shop.servcie.Ishopeserviceimpl;

/**
 * Servlet implementation class Userservlet
 */
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				//��ȡҳ���ύ������
				System.out.println("�ύ��USERSER");
				String name = request.getParameter("USER_NAME");
				String password = request.getParameter("USER_PASSWORD");
				String sex = request.getParameter("USER_SEX");
				String birthday = request.getParameter("USER_BIRTHDAY");
				String email = request.getParameter("USER_EMAIL");
				String mobile = request.getParameter("USER_MOBILE");
				String address = request.getParameter("USER_ADDRESS");
				
				//����Ϣ�ŵ�һ��User����
				User user = new User(null,name,password,sex,birthday,null,email,mobile,address,"2");
				
				//��user����service���service �����н��д���
				Ishopeservice service = new Ishopeserviceimpl();
				boolean flag = service.insertservice(user);
				
	}




}
