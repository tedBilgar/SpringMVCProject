'use strict';

// Register `phoneList` component, along with its associated controller and template
angular.
module('phoneList').
component('phoneList', {
    template:
        '<ul>' +
            '<li ng-repeat="product in $ctrl.products">' +
                '<span>{{product.name}}</span>' +
                '<p>{{product.price}}</p>' +
            '</li>' +
        '</ul>',
    controller: function PhoneListController($http) {
        this.products = [];

         $http.get('http://localhost:8080/rest/findAll').then(function (response) {
            this.products = response.data;
        });
    }
});