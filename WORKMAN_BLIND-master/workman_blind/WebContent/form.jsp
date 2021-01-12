<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="workman.model.dto.ParttimeEval" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="0">
<c:forEach items="${requestScope.add}" var="eval">
	<tr>
		<td>${eval.proscons}</td>
		<td>${eval.wagedelay}</td>
		<td>${eval.environment}</td>
		<td>${eval.incline}</td>
	</tr>
</c:forEach>
</table>