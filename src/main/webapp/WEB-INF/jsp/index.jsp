<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#tabs").tabs();
	$("#accordion_0428").accordion({
		active:false,
		collapsible:true
	});
//	$("#accordion_0427").accordion({
//		active:false,
//		collapsible:true
//	});
});
</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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
<title>우리조</title>
</head>
<body>

<header>
	<h1>
	<div class="header" style="height:63px;text-align:center;vertical-align:middle;background-color:#f36f31;">
		<span style="color:white;">koscom</span>
	</div>
	</h1>
</header>

<div id="tabs">
  <ul>
    <li><a href="#tab_SNS">My SNS Topics</a></li>
    <li><a href="#tab_SearchNews">News Search</a></li>
  </ul>
  <div id="tab_SNS">
  	<h2>2017년 4월 28일</h2>
  	<div id="accordion_0428">
	  <h3>박보검 (47 hits)</h3>
	  <div>
	  	<div class="widget">
	  		<form action="/Search/IssueMaster" target="_blank">
		  		<span style="font-weight:bold">${req_item}</span>
		  		<input type="submit" value="상세조회">
	  		</form>
	  	</div>
	  	<br />
<!-- 	  	
	  	<div class="widget">
	  		<span style="font-weight:bold">농심</span>
	  		<input type="submit" value="상세조회">
	  	</div>
-->	  	
	  	<br />
	  </div>
<!-- 
	  <h3>???</h3>
	  <div>
	    <p>
	    </p>
	  </div>
-->
	</div>
<!-- 
	<h2>2017년 4월 27일</h2>
  	<div id="accordion_0427">
	  <h3>??? (32 hits)</h3>
	  <div>
	  	<div class="widget">
	  		<span style="font-weight:bold">LG 생활건강</span>
	  		<input type="submit" value="상세조회">
	  	</div>
	  	<br />
	  	
	  	<div class="widget">
	  		<span style="font-weight:bold">???</span>
	  		<input type="submit" value="상세조회">
	  	</div>
	  	<br />
	  </div>
	  <h3>???</h3>
	  <div>
	    <p>
	    </p>
	  </div>
	</div>
-->
  </div>
  <div id="tab_SearchNews">
  	<fieldset>
  		<form method="GET" action="/Search/News" target="_blank">
 	    <div class="news_category">
	      
	      <input type="checkbox" name="politics" value="politics" checked="true" id="cat_1">
	      <label for="cat_1">politics</label>	
	      
	      <input type="checkbox" name="economy" value="economy" checked="true" id="cat_2">
	      <label for="cat_2">economy</label>	
	      
	      <input type="checkbox" name="society" value="society" checked="true" id="cat_3">
	      <label for="cat_3">society</label>
	      	
	      <input type="checkbox" name="culture" value="culture" id="cat_4">
	      <label for="cat_4">culture</label>
	      
	      <input type="checkbox" name="world" value="world" id="cat_5">
	      <label for="cat_5">world</label>	
	      
	      <input type="checkbox" name="tech" value="tech" id="cat_6">
	      <label for="cat_6">tech</label>	
	      
	      <input type="checkbox" name="opinion" value="opinion" id="cat_7">
	      <label for="cat_7">opinion</label><br />	
	    </div>

	    
	    <label for="cat_query">검색어:</label>
	    <input type="text" id="cat_query" name="query" value="삼성전자">
	    
	    <input type="submit" id="search_news" value="조회">
	    </form>
	    </fieldset>
  </div>
</div>


</body>
</html>