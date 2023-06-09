angular.module('market-front').controller('cartController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadCart = function () {
        $http({
            url: contextPath + '/api/v1/cart',
            method: 'GET'
        }).then(function (response) {
            $scope.cart = response.data;
        });
    };

/*
    $scope.loadCart = function () {
        $http.get('http://localhost:8189/app/api/v1/cart')
            .then(function (response) {
                $scope.Cart = response.data;
            });
    }
*/


    $scope.disabledCheckOut = function () {
        alert("Для оформления заказа необходимо войти в учётную запись");
    }

    $scope.clearCart = function () {
        $http.get(contextPath + '/api/v1/cart/clear')
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.checkOut = function () {
        $http({
            url: contextPath + '/api/v1/orders',
            method: 'POST',
            data: $scope.orderDetails
        }).then(function (response) {
            $scope.loadCart();
            $scope.orderDetails = null
            $location.path('/orders');
        });
    };

    $scope.loadCart();
});