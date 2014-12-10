<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>

<form action="HelloServlet">			
		 <b>Result</b>  <br>
		 <% String fibNum = request.getParameter("fibNum"); %>	
		  <input type="text" name="fibNum" value="<%=fibNum%>" size="40px" style="font-size:30pt;height:60px">
		 <br>
		<br>
		<a href="home.jsp">Return to Main</a>
			
		</form>	

</body>
</html>