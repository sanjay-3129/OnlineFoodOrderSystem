<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Customer login</title>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
	rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script> 
 function userValidation()
{
  username = document.getElementById('userid').value;
  
  if (username == ' '){
      document.getElementById("user-error").innerHTML = "Username must not be empty";
      return false;
  }else{
  return false;
  }
function validateLogin(){  

  var str = document.getElementById("t1").value; 
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
	font-family: 'Varela Round', sans-serif;
	background-image: url("<%=request.getContextPath()%>/img/img10.jpg");
	background-repeat: no-repeat;
	background-size: 1720px 880px;
}

.modal-login {
	color: #636363;
	width: 350px;
	margin: 80px auto 0;
}

.modal-login .modal-content {
	padding: 20px;
	border-radius: 5px;
	border: none;
}

.modal-login .modal-header {
	border-bottom: none;
	position: relative;
	justify-content: center;
}

.modal-login h4 {
	text-align: center;
	font-size: 26px;
	margin: 30px 0 -15px;
}

.modal-login .form-control:focus {
	border-color: #70c5c0;
}

.modal-login .form-control, .modal-login .btn {
	min-height: 40px;
	border-radius: 3px;
}

.modal-login .close {
	position: absolute;
	top: -5px;
	right: -5px;
}

.modal-login .modal-footer {
	background: #ecf0f1;
	border-color: #dee4e7;
	text-align: center;
	justify-content: center;
	margin: 0 -20px -20px;
	border-radius: 5px;
	font-size: 13px;
}

.modal-login .modal-footer a {
	color: #999;
}

.modal-login .avatar {
	position: absolute;
	margin: 0 auto;
	left: 0;
	right: 0;
	top: -70px;
	width: 95px;
	height: 95px;
	border-radius: 50%;
	z-index: 9;
	background: #60c7c1;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}

.modal-login .avatar img {
	width: 100%;
}

.modal-login .btn {
	color: #fff;
	border-radius: 4px;
	background: #60c7c1;
	text-decoration: none;
	transition: all 0.4s;
	line-height: normal;
	border: none;
}

.modal-login .btn:hover, .modal-login .btn:focus {
	background: #45aba6;
	outline: none;
}

.trigger-btn {
	display: inline-block;
	margin: 100px auto;
}
</style>
</head>
<body>

	<!-- <div class="text-center"> -->
	<!-- <!-- Button HTML (to Trigger Modal) -->
	-->
	<!-- <a href="#myModal" class="trigger-btn" data-toggle="modal">Click to Open Login Modal</a> -->
	<!-- </div> -->
	<!-- Modal HTML -->
	<!-- <div  class="modal fade"> -->
	<div class="modal-dialog modal-login">
		<div class="modal-content">
			<div class="modal-header">
				<%-- <div class="avatar">
					<i class="fa fa-user-o" aria-hidden="true"></i>
					<img src="<%=request.getContextPath()%>/icons/avatar.png"
						alt="Avatar">
				</div> --%>
				<h4 class="modal-title">Customer Login</h4>
				<!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
			</div>
			<div class="modal-body">
				<form action="<%=request.getContextPath()%>/customer/login" method="post">
					<div class="form-group">
						<input type="text" class="form-control" name="username"
							id="userid" placeholder="Username" required="required"
							onChange="userValidation()"> <span id="user-error"></span>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="t1"
							name="password" placeholder="Password" required="required"
							onChange="validateLogin()"> <span id="pw-error"></span>
					</div>
					<div class="form-group">
						<button type="submit"
							class="btn btn-primary btn-lg btn-block login-btn">Login</button>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<a href="<%=request.getContextPath()%>/forgetPassword.jsp">Forgot Password?</a>
			</div>
		</div>
	</div>
	<!-- </div>      -->
</body>
</html>