
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script src="/resources/js/jquerydatatable.js"></script>

<script>
	function myFunction() {
		window.location = "#account";
	}
</script>
</head>

<jsp:include page="header.jsp"></jsp:include>
<body onload="myFunction()">
	<section id="account" class="section-padding">
	<br>
		<div>
			<table id="table_id" class="display">
				<thead>
					<tr>
						<th>Ac Id</th>
						<th>First Name</th>
						<th>First Name</th>
						<th>Gender</th>
						<th>Email</th>
						<th>DOB</th>
						<th>SSN</th>
						<th>Mobile No</th>
						<th>Role</th>


					</tr>
				</thead>
				<tbody>
					<c:forEach items="${acc }" var="accvar">
						<tr>
							<td>${accvar.acId }</td>
							<td>${accvar.firstName }</td>
							<td>${accvar.lastName }</td>
							<td>${accvar.gender }</td>
							<td>${accvar.email }</td>
							<td>${accvar.dob }</td>
							<td>${accvar.ssnNo }</td>
							<td>${accvar.mobileNo }</td>
							<td>${accvar.role }</td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>