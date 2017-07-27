<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head><title>IBM DateItem: Home</title></head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>IBM DateItem: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for IBM DateItem: Home</p>

<h3>資料查詢:</h3>
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<ul>
  <li><a href='listAllDateItem.jsp'>List</a> all DateItems. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="dateitem.do" >
        <b>輸入員工編號 (如7001):</b>
        <input type="text" name="dateItemNo">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="dateItemSvc" scope="page" class="com.dateitem.model.DateItemService" />
   
  <li>
     <FORM METHOD="post" ACTION="dateitem.do" >
       <b>選擇員工編號:</b>
       <select size="1" name="dateItemNo">
         <c:forEach var="dateItemVO" items="${dateItemSvc.all}" > 
          <option value="${dateItemVO.dateItemNo}">${dateItemVO.dateItemNo}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="dateitem.do" >
       <b>選擇員工姓名:</b>
       <select size="1" name="dateItemNo">
         <c:forEach var="dateItemVO" items="${dateItemSvc.all}" > 
          <option value="${dateItemVO.dateItemNo}">${dateItemVO.dateItemNo}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
     </FORM>
  </li>
</ul>


<h3>員工管理</h3>


<!--   <li><a href='addDateItem.jsp'>Add</a> a new DateItem.</li> -->
<FORM METHOD="post" ACTION="dateitem.do">
<ul><li><input type="submit" value="上架約會商品"></li></ul>
<input type="hidden" name="action" value="check_Seller">
</FORM>



</body>

</html>
