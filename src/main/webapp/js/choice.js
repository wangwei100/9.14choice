function choice() {
	$.get("/lession/do_choice", function(resp) {
		alert(resp);
		window.loaction.href = '/lession/choiced';
	});
}
$(document).ready(function() {
	$("href").click(choice)
});