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
		
		
		if ("check_Seller".equals(action)) { // 來自select_page.jsp上架約會商品
			System.out.println("確認賣家是否有寵物");
			MemberService memSvc = new MemberService();
			List<Pet> myPetList = new ArrayList<Pet>();
			myPetList = memSvc.getPetsByMemNo(5001);
			System.out.println(myPetList.size());
			
			req.setAttribute("myPetList", myPetList);         
			String url = "/dateitem/addDateItem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
				
			String time =req.getParameter("time");			
			System.out.println(time);
		}
	}
}
