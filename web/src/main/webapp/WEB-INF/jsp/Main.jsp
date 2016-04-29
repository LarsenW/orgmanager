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
<script src="${basedir}/resources/js/lib/angular.min.js"></script>
<script src="${basedir}/resources/js/lib/jquery-1.12.3.min.js"></script>
<script src="${basedir}/resources/js/lib/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<br>
		<div class="row">
			<div class="col-md-2">
				<ul class="nav nav-pills nav-stacked">
					<li class="active "><a href="" onclick="return false;">All
							companies</a></li>
					<li><a href="" onclick="return false;">Add new company</a></li>
				</ul>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-4">
				<div ng-app="createCompanyApp" ng-controller="createCompanyCtrl">
					<div class="form-group">
						<label for="companyName">Company name:</label> <input type="text"
							class="form-control" id="companyName" ng-model="companyName">
						<label for="income">Earnings:</label> <input type="text"
							class="form-control" id="income" ng-model="income">
						<div>
							<input type="checkbox" ng-model="isSubsidiary">
							Subsidiary company
						</div>
						<div ng-show="isSubsidiary">
							<label for="sel1">Choose parent company:</label> <select
								class="form-control" id="sel1">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
							</select>
						</div>
						<br>
						<div>
							<button ng-click="sendForm()" class="btn btn-success">
								Submit <span class="glyphicon glyphicon-floppy-disk"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<script>
		var app = angular.module('createCompanyApp', []);
		app.controller('createCompanyCtrl', function($scope, $http) {
			$scope.getCompanies = function() {
				$http.get("get_companies").then(function(response) {
					var companies = response.data;
					console.log(companies);
				});
			}
			$scope.getCompanies();
			$scope.sendForm = function() {
				var company = {
					"name" : $scope.companyName,
					"income" : $scope.income
				};
				$http.post("save_company", company).then(function(response) {
					console.log(response.status);
				});
			}

		});
	</script>
</body>
</html>