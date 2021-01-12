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

<h3>기업 회원 정보 수정</h3>
<hr><p>

<form action="workman" method="post">
	 
	 <input type="hidden" name="command" value="companyupdate">


<table border="1">

		<tr>
			<td width=30% align=center >기업명</td>
			<td width=70%>
				<input type="text" name="companyname" value="${sessionScope.company.companyname}" readonly>
			</td>
		  </tr>
		  
		  	<tr>
			<td width=30% align=center >비밀번호</td>
			<td width=70%>
				<input type="text" name="companypw" value="${sessionScope.company.companypw}">
			</td>
		  </tr>
		  
		  <tr>
			<td width=30% align=center >업종</td>
			<td width=70%>
				<input type="text" name="category" value="${sessionScope.company.category}">
			</td>
		  </tr>
		  
		  	<tr>
			<td width=30% align=center >주소</td>
			<td width=70%>
				<input type="text" name="companyloc" value="${sessionScope.company.companyloc}">
			</td>
		  </tr>
		  
		  	<tr>
			<td width=30% align=center >전화번호</td>
			<td width=70%>
				<input type="text" name="companynum" value="${sessionScope.company.companynum}">
			</td>
		  </tr>

</table>
			<br><hr>
		  
		  <input type="submit" value="기업 회원 정보 수정"> &nbsp;
		  <input type="button" value="탈퇴" Onclick="location.href='workman?command=companydelete'">&nbsp;
 		  <input type="reset" value="변경값 초기화">

</form>

</center>
</body>
</html>