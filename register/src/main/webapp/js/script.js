function validateRegister() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var emailid = document.getElementById("emailId1").value;
	var msgDiv = document.getElementById("msg");
	// Basic validation, you can add more specific checks
	if (username === '' || password === '' || emailid === '') {
		msgDiv.innerHTML = 'All fields must be filled out';
		return;
	}


	// Convert form data to URL-encoded string
	var formData = new URLSearchParams();
	formData.append('username', username);
	formData.append('password', password);
	formData.append('emailId', emailid);

	// Make API call using Fetch API
	fetch('/register/registerUser', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded', // Set content type to form-urlencoded
		},
		body: formData.toString(), // Convert form data to string
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Registration failed');
			}

			return response.text(); // Treat the response as text
		})
		.then(data => {
			// Handle success or failure
			msgDiv.innerHTML = data;
		})
		.catch(error => {
			// Handle failure
			msgDiv.innerHTML = 'Registration failed';
		});
}


function login() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var errorUserDiv = document.getElementById("msg");
	if (username === '') {
		errorUserDiv.innerHTML = 'username cannot be empty';
		return;
	}
	if (password === '') {
		errorUserDiv.innerHTML = 'password cannot be empty';
		return;
	}
	// Convert form data to URL-encoded string
	var formData = new URLSearchParams();
	formData.append('username', username);
	formData.append('password', password);
	// Make API call using Fetch API
	fetch('/register/SignIn', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded', // Set content type to form-urlencoded
		},
		body: formData.toString(), // Convert form data to string
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Login failed');
			}

			return response.text(); // Treat the response as text
		})
		.then(data => {
			// Handle success or failure
			errorUserDiv.innerHTML = data;
		})
		.catch(error => {
			// Handle failure
			errorUserDiv.innerHTML = 'Login failed';
		});
} 

function loadContent(url) {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				var dynamicContent = xhr.responseText;
				document.getElementById('dynamic-content').innerHTML = dynamicContent;
			} else {
				console.error('API request failed with status: ' + xhr.status);
			}
		}
	};
	xhr.send();
}
function validatedStudentInfo(){
	var name = document.getElementById("name").value;
	var address =document.getElementById("adress").value;
	var emailId = document.getElementById("emailId").value;
	var age = document.getElementById("age").value;
	var dob  = document.getElementById("DOB").value;
	var msgDiv =document.getElementById("msg")
	if(name ==''|| address ==''|| emailId==''|| age =='' || dob == ''){
		msgDiv.innerHTML = 'All values must be filled';
		
		return;
		
	}
	var formData = new URLSearchParams();
	formData.append('name', name);
	formData.append('adress', address);
	formData.append('emailId', emailId);
	formData.append('age', age); 
	formData.append('DOB', dob);
	fetch('/register/savestudents', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded', // Set content type to form-urlencoded
		},
		body: formData.toString(), // Convert form data to string
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Login failed');
			}

			return response.text(); // Treat the response as text
		})
		.then(data => {
			// Handle success or failure
			errorUserDiv.innerHTML = data;
		})
		.catch(error => {
			// Handle failure
			errorUserDiv.innerHTML = 'Login failed';
		});
}
       