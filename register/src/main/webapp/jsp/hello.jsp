<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Example JSP with Date</title>
</head>
<body>
<%! public static int count=100; %>.
    <%
        String name="badal";
        Date currentDate = new Date();
        out.println("Current Date and Time: " + currentDate);
    %>
    
    <h1>welcome to my jsp program  <%=name%> <%=count%><h1>
    
    
</body>
</html>
