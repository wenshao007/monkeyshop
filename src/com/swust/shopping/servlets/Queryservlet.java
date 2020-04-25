package com.swust.shopping.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swust.shop.servcie.Ishopeservice;
import com.swust.shop.servcie.Ishopeserviceimpl;

/**
	ִ��������Ϣ��ѯ��servlet����ѯ�Ľ��ʹ��JSTL��ǩչ������ҳ��
**/


public class Queryservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
public Queryservlet() {
    super();
}

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req,resp);
			
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ishopeservice  service = new Ishopeserviceimpl();
		List  list = null;
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("keywords");
		
		System.out.println(keyword);
		
		  /*
		   * ���ܣ������ز�ѯҳ���±���ܼ�¼�������Լ��ܹ��ж���ҳ
		   * */
		  int cpage = 1; //��ǰҳ
		  int count = 5;//ÿҳ����
		  String cp =  request.getParameter("cp"); 
		  if(cp!=null){ 
			   cpage = Integer.parseInt(cp); 
			   System.out.println(cpage);
			  }
		  
		  //���ز�ͬ�ؼ��֣���ȡ�ܼ�¼�������Լ���ҳ��ҳ��
		  int[] arr = service.listPage(count,keyword);
		  
		  if(arr!=null) {
			  request.setAttribute("cnum", arr[0]);
			  request.setAttribute("ctotal", arr[1]);
		  }else {
			  System.out.println("err!err!");
		  }
		  request.setAttribute("cpage", cpage);
		
		  
		  
		  /*
		   * ���ܣ������ز�ѯ�Ľ��
		   * */
		  //�������͵�service��ģ�Queryserviceִ�в�ѯ����������LIST����,Ҫ����ÿҳ�����͵�ǰҳ��
		  list = service.queryService(count,cpage,keyword); 
		
		  if(keyword!=null) {
			  request.setAttribute("keyword", "&keywords="+keyword);
		  }
		  
		//�����ѯ��������ص�list
		if(list!=null) {
			request.setAttribute("result", list);
			request.getRequestDispatcher("desgin.jsp").forward(request, response);
		}else
		{
			System.out.println("err");
		}
	}
}
