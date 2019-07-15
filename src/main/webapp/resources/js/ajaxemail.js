$(function() {
	$(".error").hide();
	$("#email").blur(function() {
		var uemail = $('#email').val();
		if (uemail.length >= 3) {
			$(".status").html("<font> Checking availability Of Email...</font>");
			$.ajax({
				type : "POST",
				url : "/his/exist/" + uemail,
				success : function(msg) {
					$(".status").html(msg);
				}
			});
		}

		if (IsEmail(uemail) == false) {
			$("#email").focus();
			$(".error").show();
			
		}else {
			$(".error").hide();
		}
	});
});
function IsEmail(email) {
	  var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  if(!regex.test(email)) {
	    return false;
	  }else{
	    return true;
	  }	
	}