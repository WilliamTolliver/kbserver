var myApp = angular.module('myApp', [ 'ngRoute' ]);

myApp.config(function($routeProvider) {

	$routeProvider

	.when('/', {
		templateUrl : 'pages/main.html',
		controller : 'mainController'
	}).when('/signup', {
		templateUrl : 'pages/second.html',
		controller : 'mainController'
	}).when('/create', {
		templateUrl : 'pages/create.html',
		controller : 'createController'
	})

});

myApp.controller('mainController', ['$http', '$scope', '$log', function($http, $scope) {
	$scope.master = {};
	
	$scope.getUsers = function(){
		$http.get('http://localhost:8080/users').
			success(function(data) {
				$scope.users = data;
			});
	};	

	$scope.update = function(user) {
		//console.log(user);
		$scope.master = angular.copy(user);
	};

	$scope.reset = function() {
		$scope.user = angular.copy($scope.master);
	};

	$scope.reset();
	$scope.getUsers();
} ]);
myApp.controller('createController', ['$scope', '$http','$location', function($scope,$http,$location) {
	$scope.master = {};
	
	$scope.update = function(user) {
		$http({
			method: 'POST',
			url:'http://localhost:8080/create',
			data: {firstName : user["firstName"],
				lastName : user["lastName"],
				email : user["email"],
				username : user["username"],
				password : user["password"],
				gender : user["gender"],}
		}).then(function successCallback(response){
			console.log(response.data);
		});
		$location.path("/");
	};

} ]);