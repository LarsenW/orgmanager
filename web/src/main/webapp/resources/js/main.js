$(document).ready(function() {
	drawTable();
});
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
									data : null,
									defaultContent : '555'
								},
								{
									data : null,
									defaultContent : '555'
								},
								{
									orderable : false,
									data : null,
									defaultContent : '<button type="button" class="btn btn-info '
											+ 'glyphicon glyphicon-info-sign"></button>'
								},
								{
									orderable : false,
									data : null,
									defaultContent : '<button type="button" class="btn btn-primary '
											+ 'glyphicon glyphicon-pencil"></button>'
								},
								{
									orderable : false,
									data : null,
									defaultContent : '<button type="button" class="btn btn-danger '
											+ 'glyphicon glyphicon-trash"></button>'
								} ]
					}

			)
}