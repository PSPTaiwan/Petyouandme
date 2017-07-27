package com.dateitem.controller;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.dateitem.model.*;
import com.dateitem.model.DateItemService;
import com.dateitem.model.DateItemVO;
import com.member.model.MemberService;
import com.pet.model.Pet;
import com.restaurant.model.Restaurant;
import com.restaurant.model.RestaurantService;
@MultipartConfig(fileSizeThreshold =500* 1024 * 1024, maxFileSize = 500 * 1024 * 1024, maxRequestSize = 5 * 500 * 1024 * 1024)
public class DateItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=Big5");
		String action = req.getParameter("action");
		
		
		if ("check_Seller".equals(action)) { // 來自select_page.jsp上架約會商品
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			
			System.out.println("確認賣家是否有寵物");
			MemberService memSvc = new MemberService();
			List<Pet> myPetList = new ArrayList<Pet>();
			myPetList = memSvc.getPetsByMemNo(5001);
			System.out.println(myPetList.size());
			
			
			req.setAttribute("myPetList", myPetList);         
			String url = "/dateitem/addDateItem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
										
		}
		
            if ("insert".equals(action)) { // 來自addDateItem.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				
				String htmltime = req.getParameter("time");
				System.out.println(htmltime);
				
				Timestamp dateMeetingTime = getTimestamp(htmltime);
				System.out.println(getTimestamp(htmltime));
				Timestamp dateItemTime = new Timestamp(System.currentTimeMillis());
				
				String sellerNo = req.getParameter("sellerNo");
				if (sellerNo == null || (sellerNo.trim()).length() == 0) {
					errorMsgs.add("請輸入賣家");
				}
				// Send the use back to the form, if there were errors
				
				String dateItemTitle = req.getParameter("dateItemTitle");
				if (dateItemTitle == null || (dateItemTitle.trim()).length() == 0) {
					errorMsgs.add("請輸入標題");
					dateItemTitle = "";
				}
				// Send the use back to the form, if there were errors
				
				String dateItemText = req.getParameter("dateItemText");
				if (dateItemText == null || (dateItemText.trim()).length() == 0) {
					errorMsgs.add("請輸入內容");
					dateItemText = "";
				}
				// Send the use back to the form, if there were errors
						
				//驗證圖片跟日期=====================================================
				byte[] dateItemImg= null;
				String fileName=null;
				Part part = req.getPart("dateItemImg");
				
				
				
				try {
					if(part.getSize()!=0){
						fileName = getFileNameFromPart(part);
						System.out.println(part.equals(null));
						if(getServletContext().getMimeType(fileName).substring(0,5).equals("image")){
							dateItemImg = getByteArrayImg(part);
							System.out.println("圖片格式正確!");
						}
					}
				} catch (Exception e) {
					errorMsgs.add("請輸入內容");
					System.out.println("上傳約會圖片錯誤");
					e.printStackTrace();
				}
				
				
				

		        //============================================================================		
				
				//如果錯誤回傳一個VO=====================================
				

				DateItemVO dateItemVO = new DateItemVO();
				dateItemVO.setSellerNo(Integer.parseInt(sellerNo));
				dateItemVO.setRestListNo(Integer.parseInt(req.getParameter("restListNo")));
				dateItemVO.setPetNo(Integer.parseInt(req.getParameter("petNo")));
				dateItemVO.setDateItemTitle(dateItemTitle);
				dateItemVO.setDateItemText(dateItemText);
				dateItemVO.setDateItemPrice(Integer.parseInt(req.getParameter("dateItemPrice")));
			
				
				
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("dateItemVO", dateItemVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/dateitem/addDateItem.jsp");
					failureView.forward(req, res);
					return;
				}
				

				
				/***************************2.開始新增資料***************************************/
				//sellerno轉型
				
				int sellerno = Integer.parseInt(sellerNo);
				int restListNo = Integer.parseInt(req.getParameter("restListNo"));
				int petNo = Integer.parseInt(req.getParameter("petNo"));
				int dateItemPeople = Integer.parseInt(req.getParameter("dateItemPeople"));
				Boolean hasMate = Boolean.parseBoolean((req.getParameter("hasMate")));
				int dateItemPrice = Integer.parseInt(req.getParameter("dateItemPrice"));
				int dateItemStatus = 0 ;
				int dateItemShow = 0;
				int dateItemViewer = 0;
				int buyerNo = 5006 ;
				boolean isQRCChecked = false;
				int buyerRep = 0 ;
				int sellerRep = 0 ;
				boolean isInstantDate = false;
				
				System.out.println(sellerno);
				System.out.println(restListNo);
				System.out.println(dateItemTitle);
				System.out.println(dateItemText);
				System.out.println(dateItemTime);
				System.out.println(dateMeetingTime);
				System.out.println(dateItemPeople);
				System.out.println(hasMate);
				System.out.println(dateItemPrice);
				System.out.println(dateItemStatus);
				System.out.println("===================");
				System.out.println(dateItemShow);
				System.out.println(dateItemViewer);
				System.out.println(buyerNo);
				System.out.println(isQRCChecked);
				System.out.println(buyerRep);
				System.out.println(sellerRep);
				System.out.println(isInstantDate);
				System.out.println(petNo);
				
				
				RestaurantService rSvc = new RestaurantService();
				Restaurant restaurant = rSvc.getOneRest(Integer.parseInt(req.getParameter("restListNo"))); 
				String dateItemLocate = (restaurant.getRestAdd()).substring(0, 3);
				System.out.println(dateItemLocate);
				
				
				DateItemService dateItemSvc = new DateItemService();
				System.out.println("準備新增");
				dateItemVO = dateItemSvc.addDateItem(sellerno, restListNo, dateItemTitle, dateItemImg, dateItemText, dateItemTime, dateMeetingTime, dateItemLocate, dateItemPeople, hasMate, dateItemPrice, dateItemStatus, dateItemShow, dateItemViewer, buyerNo, isQRCChecked, buyerRep, sellerRep, isInstantDate, petNo);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/dateitem/select_page.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("錯在哪");
				RequestDispatcher failureView = req
						.getRequestDispatcher("/dateitem/addDateItem.jsp");
				failureView.forward(req, res);
			}
		}
	}
	
	public byte[] getByteArrayImg(Part part){
		
		ByteArrayOutputStream diaimg=null;
		try{
			java.io.InputStream in =part.getInputStream(); 
			diaimg = new ByteArrayOutputStream();
			byte[] buffer = new byte[8192];
			int i;
			while ((i = in.read(buffer)) != -1) {
				diaimg.write(buffer, 0, i);
			}
			diaimg.close();
			in.close();
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return diaimg.toByteArray();
	}
	
	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		String filename = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}
	
	//將Html5 date轉為Timestamp的Method
	
	public Timestamp getTimestamp(String dateStr){	
		int yyyy= Integer.parseInt((dateStr.substring(0, 4)));
		int mm= Integer.parseInt((dateStr.substring(5, 7)));
		int dd= Integer.parseInt((dateStr.substring(8, 10)));
		int hh= Integer.parseInt((dateStr.substring(11, 13)));
		int minute= Integer.parseInt((dateStr.substring(14, 16)));
	GregorianCalendar cal = new GregorianCalendar(yyyy,mm-1,dd,hh,minute,0);
	java.util.Date ud = cal.getTime();
	Timestamp ts= new Timestamp(ud.getTime());
	return ts;	
	}
}
