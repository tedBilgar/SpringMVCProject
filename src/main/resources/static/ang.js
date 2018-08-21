var app = angular.module("app",[]);

app.controller("appCtrl",function ($scope,$http) {
    $scope.products = [];

    $http.get('http://localhost:8080/rest/findAll').then(function (response) {
        $scope.products=response.data;
    });
});

app.controller("selectCtrl",function ($scope,$http) {

});
