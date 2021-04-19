<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
<br><br><br>
<center>

<h3>구인글 정보 수정</h3>
<hr><p>

<form action="${pageContext.request.contextPath}/workman" method="post">
	 
	 <input type="hidden" name="command" value="ptlistupdate">


<table border="1">

		<tr>
			<td width=30% align=center >글번호</td>
			<td width=70%>
				<input type="text" name="listnum" value="${sessionScope.ptlist.listnum}" readonly>
			</td>
		  </tr>
		  
		  	<tr>
			<td width=30% align=center >근무시간</td>
			<td width=70%>
				<input type="text" name="worktime" value="${sessionScope.ptlist.worktime}">
			</td>
		  </tr>
		  
		  <tr>
			<td width=30% align=center >시급</td>
			<td width=70%>
				<input type="text" name="hourlywage" value="${sessionScope.ptlist.hourlywage}">
			</td>
		  </tr>
		  
		  	<tr>
			<td width=30% align=center >근무기간</td>
			<td width=70%>
				<input type="text" name="workperiod" value="${sessionScope.ptlist.workperiod}">
			</td>
		  </tr>
		  
		  	<tr>
			<td width=30% align=center >목적</td>
			<td width=70%>
				<input type="text" name="objective" value="${sessionScope.ptlist.objective}">
			</td>
		  </tr>

</table>
			<br><hr>
		  
		  <input type="submit" value="구인글 정보 수정"> &nbsp;
		  <input type="button" value="돌아가기" Onclick="location.href='plview.jsp'">&nbsp;
 		  <input type="reset" value="변경값 초기화">

</form>

</center>
</body>
</html>