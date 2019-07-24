
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
<script src="/resources/js/charstatus.js"></script>

<style type="text/css">
html {
	scroll-behavior: smooth;
}
</style>
 
<script>
	function confirmDelete() {
		var status = confirm("Are you sure, you want to Delete?");
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	function confirmActivate() {
		var status = confirm("Are you sure, you want to Activate?");
		if (status) {
			return true;
		} else {
			return false;
		}
	}
</script>
<script>
$(document).ready(function(){
	window.scrollTo(0, 600);
});
</script>

</head>

<jsp:include page="header.jsp"></jsp:include>
<body >
	<section id="account" class="section-padding">
		<br>
		<div>
			<table id="accountdata" class="display">
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
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${acc }" var="accvar">
						<tr>
							<td><c:out value="${accvar.acId}"></c:out></td>
							<td><c:out value="${accvar.firstName }"></c:out></td>
							<td><c:out value="${accvar.lastName }"></c:out></td>
							<td><c:out value="${accvar.gender }"></c:out></td>
							<td class="email"><c:out value="${accvar.email }"></c:out></td>
							<td><c:out value="${accvar.dob }"></c:out></td>
							<td><c:out value="${accvar.ssnNo }"></c:out></td>
							<td><c:out value="${accvar.mobileNo }"></c:out></td>
							<td><c:out value="${accvar.role }"></c:out></td>
							<td>
								<button type="button" id="edit" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-edit"></span> Edit
								</button> 
								
								
								
								<c:if test="${accvar.status.toString() eq 'Y' }">
								
									<a href="deleteCwProfile/<c:out value="${accvar.email }"/>"
										title="Activate" onclick="return confirmDelete()">
										<button type="button" class="btn btn-default btn-sm">
											<span class="glyphicon glyphicon-trash"></span> Delete
										</button>
									</a>

								</c:if> <c:if test="${accvar.status.toString() eq 'N' }">

									<a href="activateCwProfile/<c:out value="${accvar.email }"/>"
										title="Delete" onclick="return confirmActivate()">
										<button type="button" id="activate"
											class="btn btn-default btn-sm">
											<span class="glyphicon glyphicon-tasks"></span> Activate
										</button>
									</a>
								</c:if>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>

	<button onclick="reffun();">press me</button>
	<jsp:include page="footer.jsp"></jsp:include>


</body>

</html>