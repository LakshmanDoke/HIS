<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<style type="text/css">
html {
  scroll-behavior: smooth;
}
</style>
<link href="/resources/css/styleaccpage.css" rel='stylesheet'
	type='text/css' />

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="/resources/js/ajaxemail.js"></script>
<script src="/resources/js/datepicker.js"></script>
<script src="/resources/js/emailvalidation.js"></script>

<script>
function myFunction() {
	 window.scrollTo(0, 700);
}
</script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body onload="myFunction()">


	<!--background-->
	<section id="account" class="section-padding">
		<h1>
			<font color="white">Account Creation Form</font>
		</h1>

		<div class="bg-agile">
			<div class="book-appointment">
				<h2>Personal Information</h2>
				<font color="green">${id }</font>
				<form:form action="saveacc" method="post"
					modelAttribute="accountform">
					<div class="left-agileits-w3layouts same">
						<div class="gaps">
							<p>First Name</p>
							<form:input path="firstName" required="true" pattern="[A-Za-z]+"
								title="First name aplhabetic only" size="20" />
						</div>
						<div class="gaps">
							<p>Last Name</p>
							<form:input path="lastName" required="true" pattern="[A-Za-z]+"
								title="Last name aplhabetic only" size="20" />
						</div>
						<div class="gaps">
							<p>Gender</p>
							<form:select path="gender" class="form-control" required="true">
								<form:option value="male">Male</form:option>
								<form:option value="female">Female</form:option>
							</form:select>
						</div>
						<div class="gaps">
							<p>Select Date Of Birth</p>
							<form:input path="dob" required="true" />
						</div>
					</div>
					<div class="right-agileinfo same">
						<div class="gaps">
							<p>Email</p>
							<form:input path="email" required="true" />
							<span class="status"></span> <span class="error"
								id="invalid_email"><font color="red">Invalid EMail</font></span>

						</div>

						<div class="gaps">
							<p>Password</p>
							<form:password path="password" required="true" />
						</div>
						<div class="gaps">
							<p>SSN No</p>
							<form:input path="ssnNo" required="true" maxlength="10"
								pattern="[0-9]{10}" title="Ten letter Numeric  ssn code" />
						</div>
						<div class="gaps">
							<p>Mobile No</p>
							<form:input path="mobileNo" required="true" maxlength="10"
								pattern="[0-9]{10}" title="Ten letter Numeric  mobile  number" />
						</div>

						<div class="gaps">
							<p>Role</p>
							<form:select path="role" class="form-control" required="true">
								<form:options items="${role}" />
							</form:select>

						</div>

					</div>
					<div class="clear"></div>
					<input type="submit" value="Submit">
				</form:form>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>