package com.isooou.multipleServlet_easy;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.isooou")
public class MultipleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet（）为默认方法
		doPost(request, response);//调用doPost方法
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();//获取Servlet路径
		String methodpath = path.substring(1,path.length()-7);//对地址进行裁剪
		//System.out.println(methodpath);
		
		
		try {
			//通过反射获取方法名                              获得私有方法
			Method method = getClass().getDeclaredMethod(methodpath, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);//通过反射调用方法
			             //本类    参数1    参数2
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	@SuppressWarnings("unused")
	private  void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete");
		
	}


	@SuppressWarnings("unused")
	private void query(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("query");
		
	}


	@SuppressWarnings("unused")
	private void add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("add");
		
	}

}
