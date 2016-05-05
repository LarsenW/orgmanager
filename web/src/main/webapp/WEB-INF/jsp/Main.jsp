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
<script src="${basedir}/resources/js/lib/jquery-1.12.3.min.js"></script>
<script src="${basedir}/resources/js/lib/jquery.dataTables.min.js"></script>
<script src="${basedir}/resources/js/lib/dataTables.bootstrap.min.js"></script>
<script src="${basedir}/resources/js/lib/bootstrap.min.js"></script>
<link rel="stylesheet" href="${basedir}/resources/css/main.css">
<script src="${basedir}/resources/js/lib/jquery.validate.min.js"></script>
<script src="${basedir}/resources/js/main.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
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
				<div class="well well-sm" id="successWell" style="display: none;">The
					company has been successfully added</div>
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
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<br> <br>
				<div class="form-group">
					<form name="companyForm" class="cmxform" id="companyForm"
						style="display: none;">
						<label for="companyName">Company name:</label> <input type="text"
							minlength="2" required="" aria-required="true"
							class="form-control" id="companyName" name="companyName">
						<label for="income">Earnings:</label> <input type="number" minlength="1" required="" aria-required="true"
							class="form-control" id="income">
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
	</div>
</body>
</html>