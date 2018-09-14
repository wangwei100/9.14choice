function insert() {
	var name = $("#txt_name").val();
	var classroom_name = $("#txt_classroom_name").val();
	var max_number = $("#txt_max_number").val();
	var remain = $("#txt_remain").val();
	var teacher_id = $("#teacher_id").val();
	var classroom_id = $("#classroom_id").val();
	var type = $("#type").val();
	var params = {
		"name" : name,
		"classroom_name" : classroom_name,
		"max_number" : max_number,
		"remain" : remain,
		"teacher_id" : teacher_id,
		"classroom_id" : classroom_id,
		"type" : type
	};
	$.get("/lession/do_insert", params, function(resp) {
//		alert(resp);
		window.location.href = '/user/first';
	});
}

function initTeacherList() {
	$.get("/teacher/getTeacherList", function(data) {
		// console.info(data);
		for ( var i in data) {
			// console.info(data[i]);
			var teacher = data[i];
			var option = '<option value="' + teacher.id + '">' + teacher.name
					+ '</option>';
			$("#teacher_id").append(option);
		}
	});
}
function initClassroomList() {
	$.get("/classroom/getClassroomList", function(data) {
		for ( var j in data) {
			var classroom = data[j];
			var option = '<option value="' + classroom.id + '">'
					+ classroom.name + '</option>';
			$("#classroom_id").append(option);
		}
	});
}
$(document).ready(function() {
	$("#btn_insert").click(insert);
	initTeacherList();
	initClassroomList();
});