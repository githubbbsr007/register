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