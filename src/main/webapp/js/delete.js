function deletes() {
	$.get("/lession/do_delete", function(resp) {
		alert(resp);
		window.loaction.href = '/lession/choiced';
	});
}
$(docution).ready(function() {
	$("href").click(deletes)
});