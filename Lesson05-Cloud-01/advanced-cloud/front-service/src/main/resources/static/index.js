angular.module('app', []).controller('indexController', function ($scope, $http) {
    // const accessTokenUrlFull = 'http://localhost:8888/auth/realms/cloud/protocol/openid-connect/token';
    // const accessTokenUrl = 'http://localhost:5555/auth/realms/cloud/protocol/openid-connect/token';
    // const clientId = 'cloudapp';
    // const clientSecret = '447f6abb-1dae-4942-a865-9b83138f6445';
    // const grant_type = 'password';
    // const scope = 'profile';
    //
    // $scope.tryToAuth = function () {
    //     $http({
    //         url: accessTokenUrl,
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/x-www-form-urlencoded'
    //         },
    //         params: {
    //             'client_id': clientId,
    //             'client_secret': clientSecret,
    //             'grant_type': grant_type,
    //             'scope': scope,
    //             'username': 'user',
    //             'password': '100'
    //         }
    //     }).then(function successCallback(response) {
    //         console.log(response);
    //     }, function errorCallback(response) {
    //     });
    // };

    // const token = 'eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJDV1hyYkw2U216dG1mUGk3NWk0WTF4U002RHl0RnpBc2MxR3ZNUzVFN1A0In0.eyJleHAiOjE2MjY0MjM3ODIsImlhdCI6MTYyNjQyMzQ4MiwianRpIjoiNTQ2NTFiNWItMmMzYi00YmM2LWE0MmMtOGNkNzJhNjJhYTE2IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4ODg4L2F1dGgvcmVhbG1zL2Nsb3VkIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjI4YzIzYzg4LTI3OGEtNDEyYy04OTU4LTg0MThlZmY2MzE2MyIsInR5cCI6IkJlYXJlciIsImF6cCI6ImNsb3VkYXBwIiwic2Vzc2lvbl9zdGF0ZSI6IjM0YWRmYTAyLWY4NTMtNDYzYi05NjU3LWVkNmI3MDJlOTg4OCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovLzEyNy4wLjAuMTozMDAwLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJ1c2VyIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ1c2VyIn0.Wz8zO_ID63ulGXkvEvnyoCEBxfVeR1353WkTImvwmaUETaQHaak0ho2V7DqiTSNnon4EOU3bTNUDAQARCaQeX4-u7goyE09dGaJcvRJryrBqWgB8vdgS6ha5Re1YoVbCG7gM4TBpUQSDX0ZG9qw8KO6hG1C9iiinzVSDlemic_zzM2XgTrgXvc-XlDlzJR7gusyd_pvKgtnExSZjjPx9RjEv-VVlwrNS3xUplO8RTcQn_9aYOvV-DLVkYg4k6C-NsLQENMvt2b_hZ8An-1ylix0yIPfb_i1_h5XcTOf2_N77W_8l1Jl3gsj5gRfCjFImV6vIh1ux2OkumiwajQ5DWQ';
    // $http.defaults.headers.common.Authorization = 'Bearer ' + token;

    $scope.loadProducts = function () {
        $http({
            url: 'http://localhost:5555/product-service/api/v1/products',
            method: 'GET'
        }).then(function (response) {
            $scope.products = response.data;
        });
    }

    $scope.loadProducts();
});