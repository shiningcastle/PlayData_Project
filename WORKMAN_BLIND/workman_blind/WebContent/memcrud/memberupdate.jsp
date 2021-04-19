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

<h3>일반 회원 정보 수정</h3>
<hr><p>

<form action="workman" method="post">
	 
	 <input type="hidden" name="command" value="memberupdate">


<table border="1">

		<tr>
			<td width=30% align=center >ID</td>
			<td width=70%>
				<input type="text" name="userid" value="${sessionScope.member.userid}" readonly>
			</td>
		  </tr>
		  
		  	<tr>
			<td width=30% align=center >비밀번호</td>
			<td width=70%>
				<input type="text" name="userpw" value="${sessionScope.member.userpw}">
			</td>
		  </tr>
		  
		  <tr>
			<td width=30% align=center >이름</td>
			<td width=70%>
				<input type="text" name="username" value="${sessionScope.member.username}">
			</td>
		  </tr>
		  		  
		  	<tr>
			<td width=30% align=center >전화번호</td>
			<td width=70%>
				<input type="text" name="usernum" value="${sessionScope.member.usernum}">
			</td>
		  </tr>

</table>
			<br><hr>
		  
		  <input type="submit" value="일반회원 정보 수정"> &nbsp;
		  <input type="button" value="탈퇴" Onclick="location.href='workman?command=memberdelete'">&nbsp;
 		  <input type="reset" value="변경값 초기화">

</form>

</center>
</body>
</html>