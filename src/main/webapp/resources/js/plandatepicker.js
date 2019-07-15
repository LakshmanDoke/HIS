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
	$("#endDate")
			.on(
					'keypress blur click mouseleave mousedown mouseup submit',
					(function() {
						var startdate = $('#startDate').val();
						var endDate = $('#endDate').val();
						if (endDate > startdate) {
							$(".status")
									.html(
											"<font color='red'><br> End Date should not be before of Start Date !!</font>");
							$("#endDate").focus();

						} else {
							$(".error").hide();
						}

					}));
});