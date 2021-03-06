<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib
	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:set var="basedir" value="${pageContext.request.contextPath}" />
<link rel="stylesheet"
	href="${basedir}/resources/css/lib/bootstrap.min.css">
<link rel="stylesheet"
	href="${basedir}/resources/css/lib/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="${basedir}/resources/css/lib/Treant.css"
	type="text/css" />
<script src="${basedir}/resources/js/lib/jquery-1.12.3.min.js"></script>
<script src="${basedir}/resources/js/lib/jquery.dataTables.min.js"></script>
<script src="${basedir}/resources/js/lib/dataTables.bootstrap.min.js"></script>
<script src="${basedir}/resources/js/lib/bootstrap.min.js"></script>
<link rel="stylesheet" href="${basedir}/resources/css/main.css">
<script src="${basedir}/resources/js/lib/jquery.validate.min.js"></script>
<script src="${basedir}/resources/js/lib/raphael.js"></script>
<script src="${basedir}/resources/js/lib/Treant.js"></script>
<script src="${basedir}/resources/js/main.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1 style="color: white;">Welcome to ORGMANAGER</h1>
			<p class="jumbotron-text">Service for managing companies</p>
		</div>
		<br>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<table id="allCompanies" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Name</th>
							<th>Earnings</th>
							<th>Type</th>
							<th>Total Earnings</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Name</th>
							<th>Earnings</th>
							<th>Type</th>
							<th>Total Earnings</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</tfoot>
					<tbody>
					</tbody>
				</table>
				<br>
				<div class="well well-sm success" id="successWell"
					style="display: none;">The company has been successfully
					added</div>
			</div>
			<div class="col-md-2"></div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-4">
				<button type="button" class="btn btn-primary" id="addCompany">
					Add company <span class="glyphicon glyphicon-plus"></span>
				</button>
			</div>
			<div class="col-md-3"></div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default" id="hideForm"
					style="display: none;">
					Hide<span class="glyphicon glyphicon-chevron-up"></span>
				</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<br> <br>
				<div class="form-group">
					<h2 id="createTitle" style="display: none;">Create company</h2>
					<h2 id="editTitle" style="display: none;">Edit company</h2>
					<form name="companyForm" class="cmxform" id="companyForm"
						style="display: none;">
						<label for="companyName">Company name:</label> <input type="text"
							class="form-control" id="companyName" name="companyName"
							minlength="2" required="" aria-required="true">
						<div class="well well-sm" id="nameError" style="display: none;">Invalid
							or non-unique name</div>
						<label for="income">Earnings:</label> <input type="number"
							class="form-control" id="income" minlength="1" required=""
							aria-required="true">
						<div class="well well-sm error" id="incomeError"
							style="display: none;">Invalid income</div>
						<div>
							<input type="checkbox" id="isSubsidiaryCompany">
							Subsidiary company
						</div>
						<div id="companiesSelect" style="display: none;">
							<label for="companiesList">Choose parent company:</label> <select
								class="form-control" id="companiesList">
								<option class="selectOptions"></option>
							</select>
						</div>
						<div class="well well-sm" id="parentIdError"
							style="display: none;">Invalid parent company</div>
						<br>
						<div>
							<button type="submit" class="btn btn-success" id="submitButton">
								Submit <span class="glyphicon glyphicon-floppy-disk"></span>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<button type="button" class="btn btn-block btn-default"
						id="hideTree">
						Hide<span class="glyphicon glyphicon-chevron-up"></span>
					</button>
				</div>
			</div>
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div id="treeChart" style="width: 335px; height: 160px"></div>
			</div>
		</div>
	</div>
	<footer class="footer">
	<div class="container">
		<div class="col-md-2"></div>
		<div class="col-md-6">
			<p class="text-muted">Email: kucheryavenko.dmtr@gmail.com</p>
		</div>
		<div class="col-md-4">
			<p class="text-muted">Skype: kucheryavenko.dmytro</p>
		</div>
	</div>
	</footer>
</body>
</html>