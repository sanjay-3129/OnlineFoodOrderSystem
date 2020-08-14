<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
<title>Admin signup Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script> 
 function phonenumber()
{
 var phone = document.getElementById('phone').value;
 
  if(/^\d{10}$/.test(phone))  //(phone.length < 1) || (phone.length > 10)
        {
		document.signup-form.phone_number.focus();
      return true;
	  
        }
      else
        {
        document.getElementById("phone-error").innerHTML = "Invalid phone format";
      return false;
        }
}

  </script>
<script> 
  function emailValidation()
{
  value = document.getElementById('email_id').value;
  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(value.match(mailformat))
{
document.signup-form.email.focus();
return true;
}
 else {
	 document.getElementById("email-error").innerHTML = "Invalid mail address";
      return false;
  }
}
</script>

<script> 
function validateLogin(){  

  var str = document.getElementById("pwid").value; 
  if (str.match(/[a-z]/g) && str.match(/[A-Z]/g) && str.match(/[0-9]/g) && str.match( /[^a-zA-Z\d]/g) && str.length >= 8) {
                return true;
}
else{
document.getElementById("pw-error").innerHTML = "Invalid Password";
 return false;
  }
}  
</script>

<style>
body {
	color: #fff;
	background: #63738a;
	font-family: 'Roboto', sans-serif;
	background-image: url("<%=request.getContextPath()%>/img/bgi.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	font-size: 12px;
}

h4 {
	font-size: 2.5rem;
}

.form-control {
	height: 40px;
	box-shadow: none;
	color: #969fa4;
}

.text-center {
	color: black;
	font-size:16px;
}

.form-control:focus {
	border-color: #5cb85c;
}

.form-control, .btn {
	border-radius: 3px;
}

.signup-form {
	width: 600px;
	margin: 0 auto;
	padding: 30px 0;
}

.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	position: relative;
	text-align: center;
}

.signup-form h2:before, .signup-form h2:after {
	content: "";
	height: 2px;
	width: 30%;
	background: #d4d4d4;
	position: absolute;
	top: 50%;
	z-index: 2;
}

.signup-form h2:before {
	left: 0;
}

.signup-form h2:after {
	right: 0;
}

.signup-form .hint-text {
	color: #999;
	margin-bottom: 30px;
	text-align: center;
}

.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #f2f3f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.signup-form input[type="checkbox"] {
	margin-top: 3px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	min-width: 140px;
	outline: none !important;
}

.signup-form .row div:first-child {
	padding-right: 10px;
}

.signup-form .row div:last-child {
	padding-left: 10px;
}

.signup-form a {
	color: #fff;
	text-decoration: underline;
}

.signup-form a:hover {
	text-decoration: none;
}

.signup-form form a {
	color: #5cb85c;
	text-decoration: none;
}

.signup-form form a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="signup-form">
		<form action="signup/admin" method="post">
			<h4 class="hint-text font-italic font-weight-bold">
				Think Food</h4>
			<h2>Admin Register</h2>
			<p class="hint-text">Create your account. It only takes a minute.</p>
			<div class="form-group">
				<div class="row">
					<div class="col-xs-6">
						<input type="text" class="form-control" name="fname"
							placeholder="First Name" required="required">
					</div>
					<div class="col-xs-6">
						<input type="text" class="form-control" name="lname"
							placeholder="Last Name" required="required">
					</div>
				</div>
			</div>
			<div class="form-group">
				<input type="email" class="form-control" id="email_id" name="mail"
					placeholder="Email" required="required"
					onChange="return emailVerification()"> <span
					id="email-error"></span>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" id="pwid"
					name="password" placeholder="Password" required="required"
					onChange="validateLogin()"> <span id="pw-error"></span>
			</div>
			<div class="form-group">
				<input type="phonenumber" class="form-control" name="phone"
					id="phone" placeholder="Phone Number 10 Digits" required="required"
					onChange="return phonenumber()"> <span id="phone-error"></span>
			</div>
			<div class="form-group">
				<label class="checkbox-inline"><input type="checkbox"
					required="required"> I accept the <a href="#">Terms of
						Use</a> &amp; <a href="#">Privacy Policy</a></label>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success btn-lg btn-block">Register
					Now</button>
			</div>
		</form>
		<div class="text-center">
			Already have an account? <a
				href="<%=request.getContextPath()%>/adminlogin.jsp" style="color:black;">Log in</a>
		</div>
	</div>
</body>
</html>