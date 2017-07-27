<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.dateitem.model.*"%>
<%@ page import="com.restaurant.model.*" %>
<%@ page import="com.member.model.*" %>
<%@ page import="java.util.*"%>

<%@ include file="header.file"%>


<%
	MemberService mSvc = new MemberService();
    DateItemService dSvc = new DateItemService();
    List<DateItemVO> dlist = dSvc.getAllItems();
    pageContext.setAttribute("dlist",dlist);
%>



<html>
<head><title>IBM DateItem: Home</title></head>
<body bgcolor='white'>

<%@ include file="nav.file"%>
<%@ include file="sidelist.file"%>

<div class="col-sm-offset-1 col-sm-8">
<table class="table">
<tr><td> <select class="w3-select selectpicker" name="option">
    <option value="" disabled selected>�п�ܦa�I</option>
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    <option value="3">Option 3</option>
  </select></td>
  <td><select class="w3-select selectpicker" name="option">
    <option value="" disabled selected>�п�ܥD�H</option>
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    <option value="3">Option 3</option>
  </select></td>
  <td><select class="w3-select selectpicker" name="option">
    <option value="" disabled selected>�п���d��</option>
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    <option value="3">Option 3</option></select>
  </td>
  <td><button class="btn btn-lg btn-warning glyphicon glyphicon-search"> </button>
  </td></tr>
  
  
  
	<tr>
		<th>�Ϥ�</th>
<!-- 	<th>�|���ʺ�</th> -->
		<th>���|�s��</th>
		<th>�ɶ�</th>
		<th>��a�s��</th>
		<th>����</th>
		<th>�\�U</th>
	</tr>
<c:forEach var="dateitem" items="${dlist}">
	<tr align='center' valign='middle'>
		<td><img id="allitemsimg" src="<%=request.getContextPath()%>/ImgReader?dateitemNo=${dateitem.dateItemNo}"></td>
			<td>${dateitem.dateItemNo}</td>
			<td>${dateitem.dateMeetingTime}</td>
			<td>${dateitem.sellerNo}</td>
			<td>${dateitem.dateItemPrice}</td>
			<td>${dateitem.restListNo}</td>
		</tr>
  </c:forEach>
</table>
</div>


<%@ include file="footer.file"%>





