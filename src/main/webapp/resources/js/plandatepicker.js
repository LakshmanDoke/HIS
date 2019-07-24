$(function() {
	$("#startDate").datepicker({
		dateFormat : 'yy-mm-dd',
	});
});

$(function() {
	$("#endDate").datepicker({
		dateFormat : 'yy-mm-dd',
	});
	 
});

$(function() {
	$(".error").hide();
	 $("form").submit(function(e){
						var startdate = $('#startDate').val();
						var endDate = $('#endDate').val();
						if (new Date(endDate) < new Date(startdate)) {
							$(".status")
									.html(
											"<font color='red'><br> End Date should not be before of Start Date !!</font>");
							$("#endDate").focus();
							 e.preventDefault();

						} else {
							$(".error").hide();
						}

					});
});	