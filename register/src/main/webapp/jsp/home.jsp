<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
    String user = request.getParameter("username");
        Date currentDate = new Date();
    %>

<!DOCTYPE html>

<head>
<style>
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Success</title>
	<link rel="stylesheet" href="/register/css/home.css">
	<script src="/register/js/script.js"></script>
	<!-- Include SweetAlert CSS and JavaScript files -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>

<body>
	<header style="position: relative;">
		<!-- Set the header to relative positioning -->
		<h1>
			<!-- Include an icon with the organization name -->
			<p><i class="fas fa-building"></i> Welcome to my home page</p>
		</h1>
		<div id="user-info">
			<!-- Include an icon with the username -->
			Logged in as: <i class="fas fa-user"> <%=user%></i> 
		</div>
		<div class="logout-button-container">
			<!-- Add a cool log-out icon to the "Logout" button -->
			<button id="logout-button" class="button"><i class="fas fa-sign-out-alt"></i> <a
					href="/register/logout">Logout</a></button>
		</div>

	</header>
	<div class="container">
		<div class="sidebar">
			<h3>Menu</h3>
			<ul>
				<li><a href="#" onclick="loadContent('/register/jsp/dashboard.jsp');" class="button"><i class="fas fa-chart-bar"></i>
						Dashboard</a></li>
				<li><a href="#" onclick="loadContent('/visitorForm');" class="button"><i class="fas fa-users"></i>
						Visitors Registration</a></li>
				<li><a href="#" onclick="loadContent('/register/jsp/report.jsp');" class="button"><i class="fas fa-file-alt"></i>
						Report</a></li>
				<li><a href="#" onclick="loadContent('/studentRegisterFrom');" class="button"><i
							class="fas fa-graduation-cap"></i> Student Management</a></li>
				<li><a href="#" onclick="loadContent('/teacherRegisterForm');" class="button"><i
							class="fas fa-chalkboard-teacher"></i> Teacher Management</a></li>
				<li><a href="#" onclick="loadContent('/coursesFrom');" class="button"><i class="fas fa-book"></i> Course
						Management</a></li>
				<li><a href="#" onclick="loadContent('/customStudentReport');" class="button"><i
							class="fas fa-file"></i> Custom Student Report</a></li>
				<li>
					<a href="#" onclick="loadContent('/showExpenseFrom');" class="button">
						<i class="fas fa-money-bill"></i> Expense Management
					</a>
				</li>
				<li>
					<a href="#" onclick="loadContent('/imageCompressor');" class="button">
						<i class="fas fa-file-alt"></i> Manage Documents
					</a>

				</li>


			</ul>
		</div>
		<div class="content">
			<div id="dynamic-content">
				<!-- Dynamic content will be loaded here -->
			</div>
		</div>
	</div
	<footer>
		&copy; 2023 Piersqure. All rights reserved.
	</footer>
</body>

</html>
