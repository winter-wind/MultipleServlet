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
		//doGet����ΪĬ�Ϸ���
		doPost(request, response);//����doPost����
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();//��ȡServlet·��
		String methodpath = path.substring(1,path.length()-7);//�Ե�ַ���вü�
		//System.out.println(methodpath);
		
		
		try {
			//ͨ�������ȡ������                              ���˽�з���
			Method method = getClass().getDeclaredMethod(methodpath, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);//ͨ��������÷���
			             //����    ����1    ����2
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
