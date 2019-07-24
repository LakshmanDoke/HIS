<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>

<link href="/resources/css/styleaccpage.css" rel='stylesheet'
	type='text/css' />

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/resources/js/plandatepicker.js"></script>
<style type="text/css">
html {
	scroll-behavior: smooth;
}
</style>

<script>
	function myFunction() {

		window.scrollTo(0, 600);
	}
</script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body onload="myFunction()">


	<!--background-->
	<section id="account" class="section-padding">
		<h1>
			<font color="white">Plan Creation</font>
		</h1>

		<div class="bg-agile">
			<div class="book-appointment">
				<h2>Plan Information</h2>
				<font color="green">${msg }</font>
				<form:form action="saveplan" method="post" modelAttribute="planform">
					<div class="left-agileits-w3layouts same">
						<div class="gaps">
							<p>Plan Name</p>
							<form:input path="planName" required="true" pattern="[A-Za-z]+"
								title="First name aplhabetic only" size="20" />
						</div>
						<div class="gaps">
							<p>Select Start Date Of Plan</p>
							<form:input path="startDate" required="true" />
						</div>
						<div class="gaps">
							<p>Select End Date Of Plan</p>
							<form:input path="endDate" required="true" />
							<span class="status"></span> <span class="error"
								id="invalid_email"><font color="red">Invalid EMail</font></span>
						</div>
					</div>

					<div class="right-agileinfo same">
						<div class="gaps">
							<p>Plan Description</p>
							<form:textarea path="planDesc" required="true" />
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