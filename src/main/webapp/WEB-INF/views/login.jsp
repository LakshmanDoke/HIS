<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<jsp:include page="header.jsp"></jsp:include>
<head>
<title>Login V4</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="/resources/login/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/resources/login/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/resources/login/css/util.css">
<link rel="stylesheet" type="text/css"
	href="/resources/login/css/main.css">
<!--===============================================================================================-->
<script>
	function myFunction() {
		window.scrollTo(0, 600);
	}
</script>
</head>
<body onload="myFunction()">

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('/resources/login/images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-49"> Login </span>

					<form:form action="logincheck" method="post"
						modelAttribute="loginform">
						<span><font color="red">${credintialscheck}</font></span>
						<div class="wrap-input100 validate-input m-b-23"
							data-validate="Username is reauired">
							<span class="label-input100">Username</span>

							<form:input path="username" class="input100"
								placeholder="Type your username" />


							<span class="focus-input100" data-symbol="&#xf206;"></span>
						</div>

						<div class="wrap-input100 validate-input"
							data-validate="Password is required">
							<span class="label-input100">Password</span>

							<form:password path="pass" class="input100"
								placeholder="Type your password" />


							<span class="focus-input100" data-symbol="&#xf190;"></span>
						</div>

						<div class="text-right p-t-8 p-b-31">
							<a href="forgotpass"> Forgot password? </a>
						</div>

						<div class="container-login100-form-btn">
							<div class="wrap-login100-form-btn">
								<div class="login100-form-bgbtn"></div>
								<button class="login100-form-btn" formaction="logincheck"
									formmethod="post">Login</button>
							</div>
						</div>
					</form:form>
					<div class="txt1 text-center p-t-54 p-b-20">
						<span> Or Sign Up Using </span>
					</div>

					<div class="flex-c-m">
						<a href="#" class="login100-social-item bg1"> <i
							class="fa fa-facebook"></i>
						</a> <a href="#" class="login100-social-item bg2"> <i
							class="fa fa-twitter"></i>
						</a> <a href="#" class="login100-social-item bg3"> <i
							class="fa fa-google"></i>
						</a>
					</div>

					<div class="flex-col-c p-t-155">
						<span class="txt1 p-b-17"> Or Sign Up Using </span> <a href="#"
							class="txt2"> Sign Up </a>
					</div>
				</form>
			</div>

		</div>

	</div>

	<div id="dropDownSelect1"></div>
	<jsp:include page="footer.jsp"></jsp:include>
	<!--===============================================================================================-->
	<script src="/resources/login/vendor/animsition/js/animsition.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.js"
		integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
		crossorigin="anonymous"></script>
	<!--===============================================================================================-->
	<script src="/resources/login/vendor/bootstrap/js/popper.js"></script>
	<!--===============================================================================================-->
	<script src="/resources/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="/resources/login/vendor/daterangepicker/moment.min.js"></script>
	<script
		src="/resources/login/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="/resources/login/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="/resources/login/js/main.js"></script>

</body>
</html>