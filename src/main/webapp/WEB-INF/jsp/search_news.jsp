<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>News Search</title>
</head>

<script type="text/javascript">
	var json = ${docs};	
	alert(json);
</script>

<body>
<div id="newsView">
	<!-- 뉴스 리스트 -->
	<table style="width:100%" id="newsTbl">
		<tr>
			<th>No.</th>
			<th>게시자</th>
			<th>제목</th>
		</tr>
		
		<c:forEach begin="0" end="${docs.length() -1}" var="index">
		<c:set var="data" value="${docs.getJSONObject(index) }"></c:set>
		<c:set var="title" value="${data.getString('title') }"></c:set>
		
		<tr>
			<th class="no">${index+1}</th>
			<th class="publisher">${data.getString("publisher")}</th>
			<th class="title"><a href=${data.getString("content_url")} target="_blank">${title}</a></th>
		</tr>
		
		</c:forEach>
	</table>
	<!-- //뉴스 리스트 -->
</div>
</body>
</html>