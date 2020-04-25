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
	执行所有信息查询的servlet，查询的结果使用JSTL标签展现在网页上
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
		   * 功能：，返回查询页面下标的总记录条数，以及总共有多少页
		   * */
		  int cpage = 1; //当前页
		  int count = 5;//每页条数
		  String cp =  request.getParameter("cp"); 
		  if(cp!=null){ 
			   cpage = Integer.parseInt(cp); 
			   System.out.println(cpage);
			  }
		  
		  //返回不同关键字，获取总记录条数，以及分页的页数
		  int[] arr = service.listPage(count,keyword);
		  
		  if(arr!=null) {
			  request.setAttribute("cnum", arr[0]);
			  request.setAttribute("ctotal", arr[1]);
		  }else {
			  System.out.println("err!err!");
		  }
		  request.setAttribute("cpage", cpage);
		
		  
		  
		  /*
		   * 功能：，返回查询的结果
		   * */
		  //将请求传送到service层的，Queryservice执行查询操作，返回LIST集合,要传入每页条数和当前页数
		  list = service.queryService(count,cpage,keyword); 
		
		  if(keyword!=null) {
			  request.setAttribute("keyword", "&keywords="+keyword);
		  }
		  
		//处理查询结果，返回的list
		if(list!=null) {
			request.setAttribute("result", list);
			request.getRequestDispatcher("desgin.jsp").forward(request, response);
		}else
		{
			System.out.println("err");
		}
	}
}
