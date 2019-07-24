/**
 * 
 */

$(function() {
	$(".error").hide();
	$("#email").blur(function() {
		var uemail = $('#email').val();
		if (IsEmail(uemail) == false) {
			$(".error").hide();
		} else {
			$(".error").show();
		}
	});
});

function IsEmail(email) {
	var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return !regex.test(email);
}