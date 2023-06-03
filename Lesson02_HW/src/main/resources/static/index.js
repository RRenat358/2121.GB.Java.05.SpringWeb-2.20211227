angular.module('market-front', ['ngStorage']).controller('indexController', function ($scope, $rootScope, $http, $localStorage) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    if ($localStorage.springWebUser) {
        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.springWebUser.token;
    }



    //============================================================
    $scope.tryToAuth = function () {
        $http.post('http://localhost:8189/app/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.springWebUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(response) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        if ($scope.user.username) {
            $scope.user.username = null;
        }
        if ($scope.user.password) {
            $scope.user.password = null;
        }
    };

    $scope.clearUser = function () {
        delete $localStorage.springWebUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $rootScope.isUserLoggedIn = function () {
        if ($localStorage.springWebUser) {
            return true;
        } else {
            return false;
        }
    };

    //============================================================
    $scope.showCurrentUserInfo = function () {
        $http.get('http://localhost:8189/app/api/v1/profile')
            .then(function successCallback(response) {
                // alert('MY NAME IS: ' + response.data.username);
                alert('My Name == ' + response.data.username + '\n'
                    // + 'My Role == ' + response.data.password + '\n'
                );
            }, function errorCallback(response) {
                alert('UNAUTHORIZED');
            });
    }

    //============================================================
    // $scope.saveNewUser = function () {
    //     console.log($scope.newUser);
    //     $http.post('http://localhost:8189/app/user-registration', $scope.newUser)
    //         .then(function (response) {
    //             console.log($scope.newUser);
    //             // $scope.loadProduct();
    //         });
    // }

/*
    $scope.saveNewUser = function (name, password, email) {
        console.log($scope.newUser);
        $http({
            url: 'http://localhost:8189/app/user-registration',
            method: 'POST',
            params: {
                name: name,
                password: password,
                email: email
            }
        })
            .then(function (response) {
                console.log($scope.newUser);
                // $scope.loadProduct();
            });
    }
*/

    //============================================================






    //============================================================


    $scope.loadProduct();
    $scope.loadCart();
    $scope.loadOrders();
});