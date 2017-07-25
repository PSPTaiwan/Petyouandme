package com.dateitem.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dateitem.model.*;

public class DateItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
//		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				String str = req.getParameter("dateItemNo");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("請輸入約會編號");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/dateitem/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				Integer dateItemNo = null;
//				try {
//					dateItemNo = new Integer(str);
//				} catch (Exception e) {
//					errorMsgs.add("約會編號格式不正確");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/dateitem/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				/***************************2.開始查詢資料*****************************************/
//				DateItemService dateItemSvc = new DateItemService();
//				DateItemVO dateItemVO = dateItemSvc.getOneDateItem(dateItemNo);
//				if (dateItemVO == null) {
//					errorMsgs.add("查無資料");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/dateitem/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
//				req.setAttribute("dateItemVO", dateItemVO); // 資料庫取出的dateItemVO物件,存入req
//				String url = "/dateItem/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************其他可能的錯誤處理*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("無法取得資料:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/select_page.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("getOne_For_Update".equals(action)) { // 來自listAllDateItem.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			try {
//				/***************************1.接收請求參數****************************************/
//				Integer dateItemNo = new Integer(req.getParameter("dateItemNo"));
//				
//				/***************************2.開始查詢資料****************************************/
//				DateItemService dateItemSvc = new DateItemService();
//				DateItemVO dateItemVO = dateItemSvc.getOneDateItem(dateItemNo);
//								
//				/***************************3.查詢完成,準備轉交(Send the Success view)************/
//				req.setAttribute("dateItemVO", dateItemVO);         // 資料庫取出的dateitemVO物件,存入req
//				String url = "/dateitem/update_dateitem_input.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//				successView.forward(req, res);
//
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/dateitem/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("update".equals(action)) { // 來自update_dateitem_input.jsp的請求
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//		
//			try {
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				Integer dateItemNo = new Integer(req.getParameter("dateItemNo").trim());
//				String ename = req.getParameter("ename").trim();
//				String job = req.getParameter("job").trim();				
//				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
//
//				Double sal = null;
//				try {
//					sal = new Double(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("薪水請填數字.");
//				}
//
//				Double comm = null;
//				try {
//					comm = new Double(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}
//
//				Integer deptno = new Integer(req.getParameter("deptno").trim());
//
//      			DateItemVO dateItemVO = new DateItemVO();
//				dateItemVO.setEmpno(empno);
//				dateItemVO.setEname(ename);
//				dateItemVO.setJob(job);
//				dateItemVO.setHiredate(hiredate);
//				dateItemVO.setSal(sal);
//				dateItemVO.setComm(comm);
//				dateItemVO.setDeptno(deptno);
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("dateItemVO", dateItemVO); // 含有輸入格式錯誤的dateItemVO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //程式中斷
//				}
//				
//				/***************************2.開始修改資料*****************************************/
//				DateItemService dateItemSvc = new DateItemService();
//				dateItemVO = dateItemSvc.updateEmp(empno, ename, job, hiredate, sal,comm, deptno);
//				
//				/***************************3.修改完成,準備轉交(Send the Success view)*************/
//				req.setAttribute("dateItemVO", dateItemVO); // 資料庫update成功後,正確的的dateItemVO物件,存入req
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************其他可能的錯誤處理*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("修改資料失敗:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/update_emp_input.jsp");
//				failureView.forward(req, res);
//			}
//		}

        if ("insert".equals(action)) { // 來自addDateItem.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String memeber = req.getParameter("member").trim();
				String restno = req.getParameter("restno").trim();
				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
//				
//				Double sal = null;
//				try {
//					sal = new Double(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("薪水請填數字.");
//				}
//				
//				Double comm = null;
//				try {
//					comm = new Double(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}
//				
				Integer memno = new Integer(req.getParameter("memno").trim());

				DateItemVO dateItemVO = new DateItemVO();
				dateItemVO.setEname(ename);
				dateItemVO.setJob(job);
				dateItemVO.setHiredate(hiredate);
				dateItemVO.setSal(sal);
				dateItemVO.setComm(comm);
				dateItemVO.setDeptno(deptno);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("dateItemVO", dateItemVO); // 含有輸入格式錯誤的dateItemVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/dateitem/addDateItem.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				
				DateItemService dateItemSvc = new DateItemService();
				dateItemVO = dateItemSvc.add(ename, job, hiredate, sal, comm, deptno);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/emp/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/emp/addEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				Integer dateItemNo = new Integer(req.getParameter("dateItemNo"));
				
				/***************************2.開始刪除資料***************************************/
				DateItemService dateItemSvc = new DateItemService();
				dateItemSvc.deleteDateItem(dateItemNo);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/dateitem/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/dateitem/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
