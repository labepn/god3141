var app = angular.module("aplikacija", ['ngRoute']);

app.controller("lordCtrl", function($scope, $http, $location){
	var baseUrl = "/api/lords";
	var baseUrlP = "/api/planets";
	$scope.lords = [];
	
	var getLords = function(){
		$http.get(baseUrl).then(
				function success(res){
					$scope.lords = res.data;
				},
				function error(res){
					alert("Something went wrong");
				}
		);
	}
	getLords();
	
	$scope.planets = [];
	
	var getPlanets = function(){
		$http.get(baseUrlP).then(
				function success(res){
					$scope.planets = res.data;
				},
				function error(res){
					alert("Something went wrong");
				}
		);
	}
	getPlanets();
	
	
	$scope.newLord = {};
	$scope.newLord.name = "";
	$scope.newLord.age = "";
	$scope.newLord.planetaId = "";
	
	$scope.dodaj = function(){
		$http.post(baseUrl, $scope.newLord).then(
				function success(res){
					getLords();
				},
				function error(res){
					alert("Something went wrong");
				}
		);
	}
	
	$scope.top10 = function(){
		$http.get(baseUrl+"/top10").then(
				function success(res){
					$scope.lords = res.data
				},
				function error(res){
					alert("Something went wrong");
				}
		);
		
	}
	
	$scope.unemployed = function(){
		$http.get(baseUrl+"/unemployed").then(
				function success(res){
					$scope.lords = res.data
				},
				function error(res){
					alert("Something went wrong");
				}
		);
		
	}
	
	$scope.reset = function(){
		getLords();
		getPlanets();	
	}
	
	
	
	
});

app.controller("planetCtrl", function($scope, $http, $location){
	
	var baseUrl = "/api/planets";
	var baseUrlL = "/api/lords";
	
	$scope.planets = [];
	
	var getPlanets = function(){
		$http.get(baseUrl).then(
				function success(res){
					$scope.planets = res.data;
				},
				function error(res){
					alert("Something went wrong");
				}
		);
	}
	getPlanets();
	
	$scope.obrisi = function(id){
		$http.delete(baseUrl+"/"+id).then(
				function success(res){
					console.log(id);
					getPlanets();
				},
				function error(res){
					alert("Something went wrong");
				}
		);
	}
	
	
	
	$scope.lords = [];
	
	var getLords = function(){
		$http.get(baseUrlL).then(
				function success(res){
					$scope.lords = res.data;
				},
				function error(res){
					alert("Something went wrong");
				}
		);
	}
	getLords();
	
	$scope.newPlanet = {};
	$scope.newPlanet.name = "";
	$scope.newPlanet.lordId = "";
	
	$scope.dodaj = function(){
		$http.post(baseUrl, $scope.newPlanet).then(
				function success(res){
					getPlanets();
				},
				function error(res){
					alert("Something went wrong");
				}
		);
	}
	
	$scope.role = function(id){
		$http.put(baseUrl+"/"+id, $scope.editPlanet).then(
			function success(res){
				getPlanets();
			},
			function error(res){
				alert("Something went wrong");
			}
		);
	}
	$scope.editPlanet = {};
	$scope.editPlanet.id = "";
	$scope.editPlanet.name = "";
	$scope.editPlanet.lordId = "";
	
	var getPlanet = function(id){
		$http.get(baseUrl+"/"+id).then(
				function success(res){
					$scope.editPlanet = res.data;
					console.log($scope.editPlanet);
				},
				function error(res){
					alert("Something went wrong");
				}
		);
	}
	
	$scope.enrole = function(id){
		getPlanet(id);	
	}
});

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/home.html',
		})
		.when('/planets', {
			templateUrl : '/app/html/planets.html',
		})
		.when('/lords', {
			templateUrl : '/app/html/lords.html',
		})
		.otherwise({
			redirectTo: '/'
		});
}]);

