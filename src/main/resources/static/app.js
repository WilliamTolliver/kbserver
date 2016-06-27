var myApp = angular.module('myApp', [ 'ngRoute' ]);

myApp.config(function($routeProvider) {

	$routeProvider

	.when('/', {
		templateUrl : 'pages/main.html',
		controller : 'mainController'
	}).when('/signup', {
		templateUrl : 'pages/second.html',
		controller : 'mainController'
	})

});

myApp.controller('mainController', [ '$scope', '$log', function($scope) {
	$scope.master = {};

	$scope.update = function(user) {
		console.log(user);
		$scope.master = angular.copy(user);
	};

	$scope.reset = function() {
		$scope.user = angular.copy($scope.master);
	};

	$scope.reset();
} ]);
