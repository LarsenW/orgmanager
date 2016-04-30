$(document).ready(function() {
	drawTable();
});
function drawTable() {
	table = $('#allCompanies').DataTable({
		ajax : {
			url : 'get_companies',
			dataSrc : ''
		},
		columns : [ {
			data : 'name'
		}, {
			data : 'income'
		} ]
	}

	)
}