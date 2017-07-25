<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.dateitem.model.*"%>
<%
DateItemVO dateItemVO = (DateItemVO) request.getAttribute("dateItemVO");
%>

<html>
<head>
<title>�u�{�v�e�������|�ӫ~�W�[</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�u�{�v�e�������|�ӫ~�W�[-addDateItem.jsp</h3>
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

<form action="dateitem.do" method=post enctype="multipart/form-data">
<table>
	<tr>
		<td>��a�|���s��:<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="sellerNo" size="45" 
			 value="${param.sellerno}"/></td><td>${errorMsgs.sellerno}</td>
	</tr>
	
			<tr>
		<jsp:useBean id="restSvc" scope="page" class="com.restaurant.model.RestaurantService" />
		<td>����\�U:<font color=red><b>*</b></font></td>
		<td><select size="1" name="restListNo">
			<c:forEach var="rest" items="${restSvc.all}">
				<option value="${rest.restNo}" >${rest.restName}
			</c:forEach>
		</select></td>
	</tr>
	
		<tr>
		<td>��ܧA���d��:<font color=red><b>*</b></font></td>
		<td><select size="1" name="petno">
		
			<c:forEach var="pet" items="${myPetList}">
				<option value="${pet.petNo}" >${pet.petName}
			</c:forEach>
		</select></td>
	</tr>
	
	<tr>
		<td>���|�ӫ~���D:</td>
		<td><input type="TEXT" name="dateItemTitle" size="45"
			value="<%= (dateItemVO==null)? "" : dateItemVO.getDateItemTitle()%>" /></td>
	</tr>
	
		<tr>
		<td>���|�ӫ~�y�z:</td>
		
	<td><input type="text" name="sal" size="45"
			value="<%= (dateItemVO==null)? "" : dateItemVO.getDateItemTitle()%>" /></td>
	</tr>
	
	<tr><td><input type="datetime-local" name="dateMeetingTime"></td></tr>
	
	<tr><td><input type="file" name="dateItemImg" ></td></tr>
	<tr><td><input type="hidden" name="action" value="insert" ></td></tr>
	<tr><td><input type="submit" value="�W�[�ӫ~" ></td></tr>
	
</table>
</FORM>
</body>

</html>