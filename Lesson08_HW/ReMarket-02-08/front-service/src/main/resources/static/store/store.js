angular.module('market-front').controller('storeController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:5555/core';
    const pathToCart = 'http://localhost:5555/cart';

    //============================================================
    //Page<Product> findByFilter()
    $scope.loadProducts = function (pageIndex = 1) {
        // console.log($scope.filter);
        $http({
            url: contextPath + '/api/v1/products',
            method: 'GET',
            params: {
                p: pageIndex,
                titlePart: $scope.filter ? $scope.filter.titlePart : null,
                minPrice: $scope.filter ? $scope.filter.minPrice : null,
                maxPrice: $scope.filter ? $scope.filter.maxPrice : null,
                groupPart: $scope.filter ? $scope.filter.groupPart : null
            }
        }).then(function (response) {
            // console.log(response.data);
            $scope.ProductList = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.ProductList.totalPages);
        });
    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    // $scope.loadProducts = function (pageIndex = 1) {
    //     $http({
    //         url: contextPath + '/api/v1/products',
    //         method: 'GET',
    //         params: {
    //             title_part: $scope.filter ? $scope.filter.title_part : null,
    //             min_price: $scope.filter ? $scope.filter.min_price : null,
    //             max_price: $scope.filter ? $scope.filter.max_price : null
    //         }
    //     }).then(function (response) {
    //         $scope.ProductsPage = response.data;
    //     });
    // };




    //============================================================
    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/api/v1/products/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.changePrice = function (id, newPrice) {
        $http({
            url: contextPath + '/api/v1/products/change-price',
            method: 'PATCH',
            params: {
                productId: id,
                newPrice: newPrice
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.changePriceToDelta = function (id, delta) {
        $http({
            url: contextPath + '/api/v1/products/change-price-to-delta',
            method: 'PATCH',
            params: {
                id: id,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    //============================================================
    $scope.saveNewProductFun = function () {
        console.log($scope.newProduct);
        $http.post(contextPath + '/api/v1/products', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts();
            });
    }






    //============================================================
    $scope.addToCart = function (id) {
        $http.get(pathToCart + '/api/v1/cart/' + $localStorage.springWebGuestCartId + '/add/' + id)
            .then(function (response) {
            });
    }

    // $scope.addToCart = function (productId) {
    //     $http.get(contextPath + '/api/v1/cart/add/' + productId)
    //         .then(function (response) {
    //         });
    // }


    $scope.loadProducts();
});