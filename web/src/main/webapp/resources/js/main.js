$(document).ready(function() {
	drawTable();
});
var table;
function drawTable() {
	table = $('#allCompanies')
			.DataTable(
					{
						ajax : {
							url : 'get_companies',
							dataSrc : ''
						},
						columns : [
								{
									data : 'name'
								},
								{
									data : 'income'
								},
								{
									data : 'companyType'
								},
								{
									data : 'totalIncome'
								},
								{
									"targets" : -1,
									orderable : false,
									data : null,
									defaultContent : '<button type="button" id="tree" class="btn btn-info '
											+ 'glyphicon glyphicon-info-sign"></button>'
								},
								{
									orderable : false,
									data : null,
									defaultContent : '<button type="button" id="edit" class="btn btn-primary '
											+ 'glyphicon glyphicon-pencil"></button>'
								},
								{
									orderable : false,
									data : null,
									defaultContent : '<button type="button" id="delete" class="btn btn-danger '
											+ 'glyphicon glyphicon-trash"></button>'
								} ]
					}

			)
	$('#allCompanies tbody').on('click', 'button#tree', function() {
		var data = table.row($(this).parents('tr')).data();
		console.log(data);
	});
	$('#allCompanies tbody').on('click', 'button#edit', function() {
		var data = table.row($(this).parents('tr')).data();
		console.log(data);
	});
	$('#allCompanies tbody')
			.on(
					'click',
					'button#delete',
					function() {
						var data = table.row($(this).parents('tr')).data();
						$
								.ajax({
									type : "POST",
									url : "delete_" + data.id,
									data : {
										old_password : $("#old_password").val(),
										new_password : $("#new_password").val()
									},
									success : function(data) {
										table.ajax.reload();
									},
									error : function(data) {
										alert('The service is currently unavailable. Please try again later.');
									}
								});
						return false;
					});

}
