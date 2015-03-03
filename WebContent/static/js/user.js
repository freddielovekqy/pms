$(function(){
	$(".form-control").blur(function() {
		if ($(this).val() == "") {
			$(this).parent().addClass("has-error");
			$(this).next().addClass("glyphicon-remove");
		}
	});
	
	$(".form-control").focus(function() {
		$(this).parent().removeClass("has-error");
		$(this).next().removeClass("glyphicon-remove");
	});
	
	$(".btn-link").click(function() {
		location.href = "../user/register";
	});
	
	$("#register").click(function() {
		var email = $("#email").val();
		var name = $("#name").val();
		var password = $("#password").val();
		$.ajax({
			type: "post",
			url: "../user/saveUser",
			data: {
				"email": email,
				"name": name,
				"password": password
				},
			success: function(data) {
				if (data != null) {
					// TODO
				}
			}
		});
	});
	
	$(".btn.btn-primary").click(function() {
		var email = $("#email").val();
		var password = $("#password").val();
		$.ajax({
			type: "post",
			url: "../user/checkUser",
			data: {
				"email": email,
				"password": password
				},
			success: function(data) {
				alert(data);
			}
		});
	});
});