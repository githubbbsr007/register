<%@ page import="register.ak.dao.DashBoardDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
    DashBoardDAO dao= new DashBoardDAO();
    int result=dao.getDashBoardCount();
    %>
   <h1>total count user is <%=result%> 