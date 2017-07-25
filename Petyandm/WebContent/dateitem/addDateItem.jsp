<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.dateitem.model.*"%>
<%
DateItemVO dateItemVO = (DateItemVO) request.getAttribute("dateItemVO");
%>

<html>
<head>
<title>約會商品上架</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>約會商品上架-addDateItem.jsp</h3>
		</td>
		<td>
		   <a href="select_page.jsp">回首頁</a>
	    </td>
	</tr>
</table>

<h4>選擇商品內容:<font color=red><b>*</b></font>為必填欄位</h4>
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message.value}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<FORM METHOD="post" ACTION="dateitem.do" name="adddateitem">
<table border="0">

	<tr>
		<td>賣家會員編號:<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="sellerno" size="45" 
			 value="${param.sellerno}"/></td><td>${errorMsgs.sellerno}</td>
	</tr>
	<tr>
		<td>選擇餐廳:<font color=red><b>*</b></font></td>
		<td><select size="1" name="restlistno">
			<c:forEach var="restaurant" items="${restaurantSvc.all}">
				<option value="${restaurant.restno}" ${(param.restno==restaurant.restno)? 'selected':'' } >${restaurant.restno}
			</c:forEach>
		</select></td>
	</tr>
	
	
		<tr>
		<jsp:useBean id="memberSvc" scope="page" class="com.member.model.MemberService" />
		<td>選擇會員:<font color=red><b>*</b></font></td>
		<td><select size="1" name="memno">
			<c:forEach var="mem" items="${memberSvc.all}">
				<option value="${mem.memNo}" >${mem.memNo}
			</c:forEach>
		</select></td>
	</tr>
	
			<tr>
		<jsp:useBean id="restSvc" scope="page" class="com.restaurant.model.RestaurantService" />
		<td>選擇餐廳:<font color=red><b>*</b></font></td>
		<td><select size="1" name="restno">
			<c:forEach var="rest" items="${restSvc.all}">
				<option value="${rest.restNo}" >${rest.restName}
			</c:forEach>
		</select></td>
	</tr>
	
	
<!-- 	<tr> -->
<%-- 		<%java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());%> --%>
<%-- 		<c:set scope="page" var="hiredate" value="<%=date_SQL%>"></c:set> --%>
<!-- 		<td>雇用日期:<font color=red><b>*</b></font></td> -->
<!-- 		<td bgcolor="#CCCCFF"> -->
<!-- 		    <input class="cal-TextBox" -->
<%-- 			onFocus="this.blur()" size="9" readonly type="text" name="hiredate" value="${(param.hiredate==null or param.hiredate=='')? hiredate : param.hiredate }"> --%>
<!-- 			<a class="so-BtnLink" -->
<!-- 			href="javascript:calClick();return false;" -->
<!-- 			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);" -->
<!-- 			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);" -->
<!-- 			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','hiredate','BTN_date');return false;"> -->
<!-- 		    <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="開始日期"></a> -->
<%-- 		</td><td>${errorMsgs.hiredate}</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>薪水:<font color=red><b>*</b></font></td> -->
<!-- 		<td><input type="TEXT" name="sal" size="45" -->
<%-- 			 value="${param.sal}"/></td><td>${errorMsgs.sal}</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>獎金:<font color=red><b>*</b></font></td> -->
<!-- 		<td><input type="TEXT" name="comm" size="45" -->
<%-- 			 value="${param.comm}"/></td><td>${errorMsgs.comm}</td> --%>
<!-- 	</tr> -->

<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
<%-- 				<option value="${deptVO.deptno}" ${(param.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

<!-- </table> -->
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>