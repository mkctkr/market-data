<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Life and Stock</title>
</head>
<script type="text/javascript">
</script>
<style type="text/css">
table.type02 {
    border-collapse: separate;
    border-spacing: 0;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    border-left: 1px solid #ccc;
    margin : 20px 10px;
}
table.type02 th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    border-top: 1px solid #fff;
    border-left: 1px solid #fff;
    background: #eee;
}
table.type02 td {
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
</style>
<body>
	<table class="type02">
		<tr>
			<td> 1. Date </td> <td>2017-04-28</td>
		</tr>
		<tr>
			<td> 2. Tag </td> <td>${my_keyword}</td> 
		</tr>
		<tr>
			<td>3. Market</td><td>${my_market}</td> 
		</tr>
		<tr>
			<td>4. Code</td><td>${my_stock}</td> 
		</tr>
		<tr>
			<td>5. Name</td><td>${my_name}</td> 
		</tr>
		<tr>
			<td>6. Price</td><td>${my_price}</td> 
		</tr>
	</table>
</body>
</html>