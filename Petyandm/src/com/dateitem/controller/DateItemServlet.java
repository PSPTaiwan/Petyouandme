package com.dateitem.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dateitem.model.*;
import com.member.model.MemberService;
import com.pet.model.Pet;

public class DateItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("check_Seller".equals(action)) { // �Ӧ�select_page.jsp�W�[���|�ӫ~
			System.out.println("�T�{��a�O�_���d��");
			MemberService memSvc = new MemberService();
			List<Pet> myPetList = new ArrayList<Pet>();
			myPetList = memSvc.getPetsByMemNo(5001);
			System.out.println(myPetList.size());
			
			req.setAttribute("myPetList", myPetList);         
			String url = "/dateitem/addDateItem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_emp_input.jsp
			successView.forward(req, res);
				
			String time =req.getParameter("time");			
			System.out.println(time);
		}
	}
}
