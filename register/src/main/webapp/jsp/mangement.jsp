<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login Page</title>
	<link rel="stylesheet" href="/register/css/Student.css">
	<script src="/register/js/script.js"></script>
</head>

<body>
	<div class="login-container">
		<form class="login-form">
			<h2>Registration form</h2>
			<div class="input-group">
				<label for="name">name</label>
				<input type="text" id="name" name="name">
			</div>
			<div class="input-group">
				<label for="adress">adress</label>
				<input type="text" id="adress" name="adress">
			</div>
			<div class="input-group">
				<label for="emailId">EmailId</label>
				<input type="text" id="emailId" name="emailId">
			</div>
			<div class="input-group">
				<label for="age">AGE</label>
				<input type="text" id="age" name="age">
			</div>
			<div class="input-group">
				<label for="dob">DOB</label>
				<input type="date" id="DOB" name="DOB">
			</div>
			<button type="button" onclick="validatedStudentInfo()">save</button>
			
		</form>
		<div id="msg">
		</div>
	</div>
</body>

</html>