var app = angular.module("app",[]);

app.controller("appCtrl",function ($scope,$http) {
    $scope.products = [];
    $scope.IsVisible = false;
    $scope.currentIdForUpdate;

    //Слежение за изменением состояния products
    $scope.$watch(function () {
        return $scope.products;
    }, function (newVal,oldVal) {
        if(newVal!=oldVal){
            $http.get('http://localhost:8080/rest/findAll').then(function (response) {
                $scope.products=response.data;
            });
        }
    });

    $http.get('http://localhost:8080/rest/findAll').then(function (response) {
        $scope.products=response.data;
    });

    $scope.add = function (product) {
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

    $scope.show = function (product) {
        $scope.currentIdForUpdate = product.id;
        $scope.willBeUpdated = product.name;
        $scope.IsVisible = true;
    };

    $scope.updateProduct = function (updatedProduct) {
        var url = 'http://localhost:8080/rest/update';
        var body = {
          id: $scope.currentIdForUpdate,
          name: updatedProduct.name,
          price: updatedProduct.price,
          weight: updatedProduct.weight
        };
        $http.put(url,body)
            .then(function (response) {
                $scope.updatedProduct = response.data.name;
                $scope.IsVisible = false;
                $http.get('http://localhost:8080/rest/findAll').then(function (response) {
                    $scope.products=response.data;
                });
            });
    };

    $scope.delete = function (product) {
        var url = 'http://localhost:8080/rest/delete';
        var id = product.id;
        $http.delete(url+'/'+id)
            .then(function (response) {
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

