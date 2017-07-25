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
		
		
//		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//				String str = req.getParameter("dateItemNo");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("�п�J���|�s��");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/dateitem/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				Integer dateItemNo = null;
//				try {
//					dateItemNo = new Integer(str);
//				} catch (Exception e) {
//					errorMsgs.add("���|�s���榡�����T");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/dateitem/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				/***************************2.�}�l�d�߸��*****************************************/
//				DateItemService dateItemSvc = new DateItemService();
//				DateItemVO dateItemVO = dateItemSvc.getOneDateItem(dateItemNo);
//				if (dateItemVO == null) {
//					errorMsgs.add("�d�L���");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/dateitem/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
//				req.setAttribute("dateItemVO", dateItemVO); // ��Ʈw���X��dateItemVO����,�s�Jreq
//				String url = "/dateItem/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************��L�i�઺���~�B�z*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("�L�k���o���:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/select_page.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllDateItem.jsp���ШD
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			try {
//				/***************************1.�����ШD�Ѽ�****************************************/
//				Integer dateItemNo = new Integer(req.getParameter("dateItemNo"));
//				
//				/***************************2.�}�l�d�߸��****************************************/
//				DateItemService dateItemSvc = new DateItemService();
//				DateItemVO dateItemVO = dateItemSvc.getOneDateItem(dateItemNo);
//								
//				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
//				req.setAttribute("dateItemVO", dateItemVO);         // ��Ʈw���X��dateitemVO����,�s�Jreq
//				String url = "/dateitem/update_dateitem_input.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_emp_input.jsp
//				successView.forward(req, res);
//
//				/***************************��L�i�઺���~�B�z**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/dateitem/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("update".equals(action)) { // �Ӧ�update_dateitem_input.jsp���ШD
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//		
//			try {
//				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//				Integer dateItemNo = new Integer(req.getParameter("dateItemNo").trim());
//				String ename = req.getParameter("ename").trim();
//				String job = req.getParameter("job").trim();				
//				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("�п�J���!");
//				}
//
//				Double sal = null;
//				try {
//					sal = new Double(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("�~���ж�Ʀr.");
//				}
//
//				Double comm = null;
//				try {
//					comm = new Double(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("�����ж�Ʀr.");
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
//					req.setAttribute("dateItemVO", dateItemVO); // �t����J�榡���~��dateItemVO����,�]�s�Jreq
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //�{�����_
//				}
//				
//				/***************************2.�}�l�ק���*****************************************/
//				DateItemService dateItemSvc = new DateItemService();
//				dateItemVO = dateItemSvc.updateEmp(empno, ename, job, hiredate, sal,comm, deptno);
//				
//				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
//				req.setAttribute("dateItemVO", dateItemVO); // ��Ʈwupdate���\��,���T����dateItemVO����,�s�Jreq
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************��L�i�઺���~�B�z*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/update_emp_input.jsp");
//				failureView.forward(req, res);
//			}
//		}

        if ("insert".equals(action)) { // �Ӧ�addDateItem.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
				String memeber = req.getParameter("member").trim();
				String restno = req.getParameter("restno").trim();
				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("�п�J���!");
//				}
//				
//				Double sal = null;
//				try {
//					sal = new Double(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("�~���ж�Ʀr.");
//				}
//				
//				Double comm = null;
//				try {
//					comm = new Double(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("�����ж�Ʀr.");
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
					req.setAttribute("dateItemVO", dateItemVO); // �t����J�榡���~��dateItemVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/dateitem/addDateItem.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				
				DateItemService dateItemSvc = new DateItemService();
				dateItemVO = dateItemSvc.add(ename, job, hiredate, sal, comm, deptno);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/emp/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/emp/addEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer dateItemNo = new Integer(req.getParameter("dateItemNo"));
				
				/***************************2.�}�l�R�����***************************************/
				DateItemService dateItemSvc = new DateItemService();
				dateItemSvc.deleteDateItem(dateItemNo);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/dateitem/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/dateitem/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
