//============================================================
(function () {
    angular
        .module('market-front', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })
            .when('/store', {
                templateUrl: 'store/store.html',
                controller: 'storeController'
            })
            .when('/cart', {
                templateUrl: 'cart/cart.html',
                controller: 'cartController'
            })
            .when('/orders', {
                templateUrl: 'orders/orders.html',
                controller: 'ordersController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
        if ($localStorage.springWebUser) {
            try {
                let jwt = $localStorage.springWebUser.token;
                let payload = JSON.parse(atob(jwt.split('.')[1]));
                let currentTime = parseInt(new Date().getTime() / 1000);
                if (currentTime > payload.exp) {
                    console.log("\n===== Срок действия токена истек !!! =====");
                    delete $localStorage.springWebUser;
                    $http.defaults.headers.common.Authorization = '';
                }
            } catch (e) {
            }

            if ($localStorage.springWebUser) {
                $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.springWebUser.token;
            }
        }
        if (!$localStorage.springWebGuestCartId) {
            $http.get('http://localhost:5555/cart/api/v1/cart/generate')
                .then(function successCallback(response) {
                    console.log("\n===== cart/generate =====");
                    $localStorage.springWebGuestCartId = response.data.value;
                });
        }
    }



})();


//============================================================
//============================================================
angular.module('market-front').controller('indexController', function ($scope, $rootScope, $http, $location, $localStorage) {
    // const contextPath = 'http://localhost:8189/app/api/v1/';



    //============================================================
    $scope.tryToAuth = function () {
        $http.post('http://localhost:5555/auth/auth', $scope.user)
            .then(function successCallback(response) {
                console.log("\n===== auth/auth =====");
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.springWebUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;

                    $http.get('http://localhost:5555/cart/api/v1/cart/' + $localStorage.springWebGuestCartId + '/merge')
                        .then(function successCallback(response) {
                        });

                    $location.path('/');
                }
            }, function errorCallback(response) {
            });
    };

    $rootScope.tryToLogout = function () {
        $scope.clearUser();
        $scope.user = null;
        $location.path('/');
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
/*
    $scope.showCurrentUserInfo = function () {
        $http.get('http://localhost:5555/api/api/v1/profile')
            .then(function successCallback(response) {
                // alert('MY NAME IS: ' + response.data.username);
                alert('My Name == ' + response.data.username + '\n'
                    // + 'My Role == ' + response.data.password + '\n'
                );
            }, function errorCallback(response) {
                alert('UNAUTHORIZED');
            });
    };
*/

    //============================================================
/*
    $scope.saveNewUser = function () {
        console.log($scope.newUser);
        $http.post('http://localhost:8189/app/user-registration', $scope.newUser)
            .then(function (response) {
                console.log($scope.newUser);
                // $scope.loadProduct();
            });
    }
*/

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


});