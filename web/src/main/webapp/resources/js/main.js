var formState = {
	create : 0,
	update : 1
}
var currentState;
var currentCompanyId = 0;
$(document).ready(function() {
	drawTable();
	$("#addCompany").click(function() {
		resetForm();
		currentState = formState.create;
		$('h2#createTitle').show();
		$("#hideForm").show();
		drawForm();
	});
	$("#hideForm").click(function() {
		resetForm();
		$('#companyForm').hide();
		$("#hideForm").hide()
	})
	$("#isSubsidiaryCompany").change(function() {
		loadCompanies();

	});
	$('#companyForm').submit(function(event) {
		if (currentState == formState.create) {
			createCompany();
		} else if (currentState == formState.update) {
			updateCompany();
		}
		return false;
	});
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
	$('#allCompanies tbody')
			.on(
					'click',
					'button#tree',
					function() {
						var data = table.row($(this).parents('tr')).data();
						console.log(data)
						$
								.ajax({
									type : "GET",
									url : "get_company_tree_" + data.id,
									success : function(data) {
										console.log(data)
										var config = {
											container : "#treeChart"
										}
										chartConfig = [];
										chartConfig.push(config);
										addNodes(data, 0);
										var my_chart = new Treant(chartConfig);
									},
									error : function(data) {
										alert('The service is currently unavailable. Please try again later.');
									}
								});
					});
	function addNodes(treeDto, parentNode) {
		var node;
		if (parentNode == 0) {
			node = {
				text : {
					name : treeDto.company.name
				}
			};
		} else {
			node = {
				parent : parentNode,
				text : {
					name : treeDto.company.name
				}
			}
		}
		parentNode = node;
		chartConfig.push(node)
		if (treeDto.subsidiaryCompanies.length > 0) {
			for (i = 0; i < treeDto.subsidiaryCompanies.length; i++) {
				addNodes(treeDto.subsidiaryCompanies[i], parentNode);
			}
		}
	}
	$('#allCompanies tbody')
			.on(
					'click',
					'button#edit',
					function() {
						currentState = formState.update;
						var data = table.row($(this).parents('tr')).data();
						console.log(data);
						currentCompanyId = data.id;
						$
								.ajax({
									type : "GET",
									url : "get_company_" + data.id,
									success : function(data) {
										console.log(data.name)
										$('h2#createTitle').hide();
										$('h2#editTitle').show();
										$("#hideForm").show();
										drawForm();
										$('input#companyName').val(data.name);
										$('input#income').val(data.income);
										if (data.parentId != 0) {
											$('#isSubsidiaryCompany').prop(
													'checked', true);
											loadCompanies();
											$("#companiesSelect").show();

										} else {
											$('#isSubsidiaryCompany').prop(
													'checked', false);
											$("select#companiesList").prop(
													'selectedIndex', 0);
											$("#companiesSelect").hide();
										}
									},
									error : function(data) {
										alert('The service is currently unavailable. Please try again later.');
									}
								});

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
function drawForm() {
	$("#companyForm").show();
}
function hideForm() {
	$("#companyForm").hide();
}
function loadCompanies() {
	if ($("#isSubsidiaryCompany").is(":checked")) {
		$.ajax({
			type : "GET",
			url : "get_companies",
			success : function(data) {
				$.each(data, function(i, data) {
					$('#companiesList').append($('<option>', {
						value : data.id,
						text : data.name
					}));
				});
				$("#companiesSelect").show();
				$('#companiesList').val(currentCompanyId);
			}

		})

	} else {
		$("#companiesSelect").hide();
	}
}
function createCompany() {
	$
			.ajax({
				type : "POST",
				url : "save_company",
				data : {
					name : $("input#companyName").val(),
					income : $("input#income").val(),
					parentId : $("select#companiesList option:selected").val() == '' ? 0
							: $("select#companiesList option:selected").val()
				},
				success : function(data) {
					console.log(data)
					var fail = false;
					if (data.invalidName) {
						$("#nameError").show();
						fail = true;
					} else {
						$("#nameError").hide();
					}
					if (data.invalidIncome) {
						$("#incomeError").show();
						fail = true;
					} else {
						$("#incomeError").hide();
					}
					if (data.invalidParentId) {
						$("#parentIdError").show();
						fail = true;
					} else {
						$("#parentIdError").hide();
					}
					if (!fail) {
						table.ajax.reload();
						$("#successWell").show().delay(3000).fadeOut();
						resetForm();
						hideForm();
					}

				},
				error : function(data) {
					alert('The service is currently unavailable. Please try again later.');
				}
			});
}
function updateCompany() {
	console.log('update');
	$
			.ajax({
				type : "POST",
				url : "update_company_" + currentCompanyId,
				data : {
					name : $("input#companyName").val(),
					income : $("input#income").val(),
					parentId : $("select#companiesList option:selected").val() == '' ? 0
							: $("select#companiesList option:selected").val()
				},
				success : function(data) {
					console.log(data)
					var fail = false;
					if (data.invalidName) {
						$("#nameError").show();
						fail = true;
					} else {
						$("#nameError").hide();
					}
					if (data.invalidIncome) {
						$("#incomeError").show();
						fail = true;
					} else {
						$("#incomeError").hide();
					}
					if (data.invalidParentId) {
						$("#parentIdError").show();
						fail = true;
					} else {
						$("#parentIdError").hide();
					}
					if (!fail) {
						currentCompanyId = 0;
						table.ajax.reload();
						$("#successWell").show().delay(3000).fadeOut();
						resetForm();
						hideForm();
					}

				},
				error : function(data) {
					alert('The service is currently unavailable. Please try again later.');
				}
			});
}
function resetForm() {
	$("input#companyName").val('');
	$("input#income").val('');
	$('#isSubsidiaryCompany').prop('checked', false);
	$("select#companiesList").prop('selectedIndex', 0);
	$("#companiesSelect").hide();
	$('h2#createTitle').hide();
	$('h2#editTitle').hide();
	$("#hideForm").hide();
}