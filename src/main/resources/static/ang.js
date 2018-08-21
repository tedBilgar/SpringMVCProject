var app = angular.module("app",[]);

app.controller("appCtrl",function ($scope,$http) {
    $scope.products = [];

    $http.get('http://localhost:8080/rest/findAll').then(function (response) {
        $scope.products=response.data;
    });

    $scope.update = function (product) {
        var url = 'http://localhost:8080/rest/add';
        var body = product;
        $http.post(url,body)
            .then(function (response) {
                $scope.addedProduct = response.data;

                $http.get('http://localhost:8080/rest/findAll').then(function (response) {
                    $scope.products=response.data;
                });
            });
    };

});
app.controller("selectCtrl",['$scope','$http',function ($scope,$http) {
    $scope.selectedProducts = [];

   $scope.update = function (select) {
        var url = 'http://localhost:8080/rest/select';
        var price = select.sum;
        var weight = select.selectWeight;

       $http.get(url,{params:{price: price, weight: weight }})
           .then(function (response) {
            $scope.selectedProducts = response.data;
        });

   };

}]);

/*
app.controller("selectCtrl",function ($scope,$http) {
    $scope.selectedProducts = [];

    $scope.update = function (select) {
        $scope.message2 = select;
        $scope.master = angular.copy(select);
        $http.get('http://localhost:8080/rest/select?price='+select.price+'&weight='+select.selectWeight).then(function (response) {
            $scope.selectedProducts=response.data;
            $scope.message = response.data;
        });
    };
});*/
