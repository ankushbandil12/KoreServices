app.controller("myCtrl", function($scope, $http) {
    $scope.name = "Kore Services";
    $scope.mySupervisor = "";
    $scope.demoData = {
    		'name' : 'Ankush',
    		'empID' : '929739'
    };
    
	$scope.demoFun = function() {
		console.log("hi");
		$http({
	        method : "POST",
	        url : "rest/testService",
	        data: $scope.demoData
	    }).success(function(response) {
	    	console.log(response);
	        $scope.mySupervisor = response.supervisor_name;
	    }).error(function(response) {
	    	console.log(response);
	        $scope.mySupervisor = response.statusText;
	    });
	};
	
});