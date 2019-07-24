<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<style type="text/css">
html {
	scroll-behavior: smooth;
}
</style>
<script>
	$(document).ready(function() {
		window.scrollTo(0, 600);
	});
</script>
<script>
	$(document).ready(function() {
		$('#applicationdatatable').DataTable({});
	});
</script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<br> Search Between From
	<input type="date"> To
	<input type="date">
	<button>Search</button>
	<br>
	<table id="applicationdatatable" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>Application Id</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Gender</th>
				<th>Date Of Birth</th>
				<th>Email</th>
				<th>SSN No</th>
				<th>MobileNo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${data }" var="datavar">
				<tr>
					<th>${datavar.applicationId}</th>
					<th>${datavar.firstName}</th>
					<th>${datavar.lastName}</th>
					<th>${datavar.firstName}</th>
					<th>${datavar.dob}</th>
					<th>${datavar.email}</th>
					<th>S${datavar.ssnNo}</th>
					<th>S${datavar.mobileNo}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>