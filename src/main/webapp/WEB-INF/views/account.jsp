<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Medical Emergency Form a Responsive Widget Template ::
	w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Medical Emergency Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs Sign up Web Templates, 
 Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free web designs for Nokia, Samsung, LG, SonyEricsson, Motorola web design">
<!-- Custom Theme files -->
<link href="/resources/css/styleaccpage.css" rel='stylesheet'
	type='text/css' />
<!--fonts-->
<link href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Droid+Sans:400,700"
	rel="stylesheet">
<!--//fonts-->




<script>
	function myFunction() {
		window.location = "http://localhost:8080/his/acregister#account";
	}
</script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body onload="myFunction()">

	
	<!--background-->
	<section id="account" class="section-padding">
	<h1>Account Creation Form</h1>
	
	<div class="bg-agile">
		<div class="book-appointment">
			<h2>Personal Information</h2>
			<form:form action="saveacc" method="post"
				modelAttribute="accountform">
				<div class="left-agileits-w3layouts same">
					<div class="gaps">
						<p>First Name</p>
						<!-- <input type="text" name="First Name" placeholder="" required="" /> -->
						<form:input path="firstName" />
					</div>
					<div class="gaps">
						<p>Last Name</p>
						<!-- 	<input type="text" name="Last Name" placeholder="" required="" /> -->
						<form:input path="lastName" />
					</div>
					<div class="gaps">
						<p>Gender</p>
						<form:select path="gender" class="form-control">
							<form:option value="male">Male</form:option>
							<form:option value="female">Female</form:option>
						</form:select>
					</div>
					<div class="gaps">
						<p>Select Date Of Birth</p>
						<form:input path="dob" />
					</div>
				</div>
				<div class="right-agileinfo same">
					<div class="gaps">
						<p>Email</p>
						<form:input path="email" />
					</div>
					<div class="gaps">
						<p>Password</p>
						<form:password path="password" />
					</div>
					<div class="gaps">
						<p>SSN No</p>
						<form:input path="ssnNo" />
					</div>
					<div class="gaps">
						<p>Mobile No</p>
						<form:input path="mobileNo" />
					</div>

					<div class="gaps">
						<p>Role</p>
						<form:select path="role" class="form-control">
							<form:options items="${role}" />
						</form:select>

					</div>

				</div>
				<div class="clear"></div>
				<input type="submit" value="Submit">
			</form:form>
		</div>
	</div>









	<!--copyright-->
	<div class="copy w3ls">
		<p>
			&copy; 2017. Medical Emergency Form . All Rights Reserved | Design by
			<a href="http://w3layouts.com/" target="_blank">W3layouts</a>
		</p>
	</div>
	</section>
	<!--//copyright-->
	<script type="text/javascript" src="/resources/js/jquery-2.1.4.min.js"></script>
	<!-- Calendar -->
	<link rel="stylesheet" href="/resources/css/jquery-ui.css" />
	<script src="/resources/js/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker,#datepicker1,#datepicker2,#datepicker3")
					.datepicker();
		});
	</script>
	<!-- //Calendar -->

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>