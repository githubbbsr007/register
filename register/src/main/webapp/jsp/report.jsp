<%@ page import="register.ak.dao.ReportDAO" %>
<%@ page import="register.ak.dao.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
    ReportDAO dao= new ReportDAO();
    List<User> result=dao.getReportDAO();
    %>
   
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>User List</title>
    
</head>


    <h2>User List</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>userName</th>
                <th>Email</th>
                <th>Password</th>
                
                <!-- Add more columns based on your user data -->
            </tr>
        </thead>
        <tbody>
            <%-- Assuming userList is the list of users coming from your Java backend --%>
           <%
    for (User user : result) {
%>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getUsername() %></td>
        <td><%= user.getEmailId() %></td>
        <td><%= user.getPassword() %></td>
        <!-- Add more columns based on your user data -->
    </tr>
<%
    }
%>
        </tbody>
    </table>


    