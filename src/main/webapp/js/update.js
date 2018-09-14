function update() {
	var oldPassword = $("#txt_oldPassword").val();
	var newPassword = $("#txt_newPassword").val();
	var newPassword_confirm = $("#txt_newPassword_confirm").val();
	var params = {
		"oldPassword" : oldPassword,
		"newPassword" : newPassword,
		"newPassword_confirm" : newPassword_confirm
	};
	$.get("/user/do_update", params, function(resp) {
		alert(resp);
		window.location.href = '/user/login';
	});
}
$(document).ready(function() {
	$("#txt_amend").click(update);
});