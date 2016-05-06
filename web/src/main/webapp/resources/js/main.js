$(document)
		.ready(
				function() {
					drawTable();
					$("#addCompany").click(function() {
						drawForm();
					});
					$("#isSubsidiaryCompany").change(
							function() {
								loadCompanies();
							
							});
					$('#companyForm')
							.submit(
									function(event) {
										$
												.ajax({
													type : "POST",
													url : "save_company",
													data : {
														name : $(
																"input#companyName")
																.val(),
														income : $(
																"input#income")
																.val(),
														parentId : $(
																"select#companiesList option:selected")
																.val() == '' ? 0
																: $(
																		"select#companiesList option:selected")
																		.val()
													},
													success : function(data) {
														console.log(data)
														var fail = false;
														if (data.invalidName) {
															$("#nameError")
																	.show();
															fail = true;
														} else {
															$("#nameError")
																	.hide();
														}
														if (data.invalidIncome) {
															$("#incomeError")
																	.show();
															fail = true;
														} else {
															$("#incomeError")
																	.hide();
														}
														if (data.invalidParentId) {
															$("#parentIdError")
																	.show();
															fail = true;
														} else {
															$("#parentIdError")
																	.hide();
														}
														if (!fail) {
															table.ajax.reload();
															$(
																	"input#companyName")
																	.val('');
															$("input#income")
																	.val('');
															hideForm();
															$(
																	'#isSubsidiaryCompany')
																	.prop(
																			'checked',
																			false);
															$(
																	"select#companiesList")
																	.prop(
																			'selectedIndex',
																			0);
															$(
																	"#companiesSelect")
																	.hide();
															$("#successWell")
																	.show()
																	.delay(3000)
																	.fadeOut();
														}

													},
													error : function(data) {
														alert('The service is currently unavailable. Please try again later.');
													}
												});
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
	$('#allCompanies tbody').on('click', 'button#tree', function() {
		var data = table.row($(this).parents('tr')).data();
		console.log(data);
	});
	$('#allCompanies tbody')
			.on(
					'click',
					'button#edit',
					function() {

						var data = table.row($(this).parents('tr')).data();
						console.log(data);
						$
								.ajax({
									type : "GET",
									url : "get_company_" + data.id,
									success : function(data) {
										// table.ajax.reload();
										console.log(data.name)
										drawForm();
										$('input#companyName').val(data.name);
										$('input#income').val(data.income);
										if (data.parentId != 0) {
											$('#isSubsidiaryCompany').prop(
													'checked', true);
											$("#companiesSelect").show();
											loadCompanies();
											//$("#companiesList").val(1);
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
function loadCompanies(){
	if ($("#isSubsidiaryCompany").is(":checked")) {
		$.ajax({
			type : "GET",
			url : "get_companies",
			success : function(data) {
				$.each(data, function(i, data) {
					$('#companiesList').append(
							$('<option>', {
								value : data.id,
								text : data.name
							}));
				});
			}
		})
		$("#companiesSelect").show();
	} else {
		$("#companiesSelect").hide();
	}
}