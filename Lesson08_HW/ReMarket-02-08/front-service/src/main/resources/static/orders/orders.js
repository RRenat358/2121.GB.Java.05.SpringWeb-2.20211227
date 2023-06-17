angular.module('market-front').controller('ordersController', function ($scope, $http) {
    // const contextPath = 'http://localhost:8189/app';
    // const contextPathApi = 'http://localhost:8189/app/api/v1';
    const contextPath = 'http://localhost:5555/core/api/v1';

    $scope.loadOrders = function () {
        $http.get(contextPath + '/orders')
            .then(function (response) {
                $scope.MyOrders = response.data;
            });
    }


    $scope.loadOrders();

});