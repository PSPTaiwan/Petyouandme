<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.dateitem.model.*"%>
<%
DateItemVO dateItemVO = (DateItemVO) request.getAttribute("dateItemVO");
%>

<html>
<head>
<title>���|�ӫ~�W�[</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>���|�ӫ~�W�[-addDateItem.jsp</h3>
		</td>
		<td>
		   <a href="select_page.jsp">�^����</a>
	    </td>
	</tr>
</table>

<h4>��ܰӫ~���e:<font color=red><b>*</b></font>���������</h4>
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
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
		<td>��a�|���s��:<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="sellerno" size="45" 
			 value="${param.sellerno}"/></td><td>${errorMsgs.sellerno}</td>
	</tr>
	<tr>
		<td>����\�U:<font color=red><b>*</b></font></td>
		<td><select size="1" name="restlistno">
			<c:forEach var="restaurant" items="${restaurantSvc.all}">
				<option value="${restaurant.restno}" ${(param.restno==restaurant.restno)? 'selected':'' } >${restaurant.restno}
			</c:forEach>
		</select></td>
	</tr>
	
	
		<tr>
		<jsp:useBean id="memberSvc" scope="page" class="com.member.model.MemberService" />
		<td>��ܷ|��:<font color=red><b>*</b></font></td>
		<td><select size="1" name="memno">
			<c:forEach var="mem" items="${memberSvc.all}">
				<option value="${mem.memNo}" >${mem.memNo}
			</c:forEach>
		</select></td>
	</tr>
	
			<tr>
		<jsp:useBean id="restSvc" scope="page" class="com.restaurant.model.RestaurantService" />
		<td>����\�U:<font color=red><b>*</b></font></td>
		<td><select size="1" name="restno">
			<c:forEach var="rest" items="${restSvc.all}">
				<option value="${rest.restNo}" >${rest.restName}
			</c:forEach>
		</select></td>
	</tr>
	
	
<!-- 	<tr> -->
<%-- 		<%java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());%> --%>
<%-- 		<c:set scope="page" var="hiredate" value="<%=date_SQL%>"></c:set> --%>
<!-- 		<td>���Τ��:<font color=red><b>*</b></font></td> -->
<!-- 		<td bgcolor="#CCCCFF"> -->
<!-- 		    <input class="cal-TextBox" -->
<%-- 			onFocus="this.blur()" size="9" readonly type="text" name="hiredate" value="${(param.hiredate==null or param.hiredate=='')? hiredate : param.hiredate }"> --%>
<!-- 			<a class="so-BtnLink" -->
<!-- 			href="javascript:calClick();return false;" -->
<!-- 			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);" -->
<!-- 			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);" -->
<!-- 			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','hiredate','BTN_date');return false;"> -->
<!-- 		    <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="�}�l���"></a> -->
<%-- 		</td><td>${errorMsgs.hiredate}</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>�~��:<font color=red><b>*</b></font></td> -->
<!-- 		<td><input type="TEXT" name="sal" size="45" -->
<%-- 			 value="${param.sal}"/></td><td>${errorMsgs.sal}</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>����:<font color=red><b>*</b></font></td> -->
<!-- 		<td><input type="TEXT" name="comm" size="45" -->
<%-- 			 value="${param.comm}"/></td><td>${errorMsgs.comm}</td> --%>
<!-- 	</tr> -->

<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>����:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
<%-- 				<option value="${deptVO.deptno}" ${(param.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

<!-- </table> -->
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>
</body>

</html>