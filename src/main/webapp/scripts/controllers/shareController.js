/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('sbAdminApp').controller('ShareCtrl', ['$sce','$scope','ShareFactory','$cookies','CompraSummaryFactory','$rootScope',
    function ($sce, $scope, ShareFactory, $cookies, CompraSummaryFactory,$rootScope) {
        $scope.disabled=true;
        $scope.compra = CompraSummaryFactory.get({id:$rootScope.compraId});
        $scope.texto = ShareFactory.get({id:$scope.compraId});
        $scope.getInfo = function () {
            $scope.sharePost = $sce.trustAsHtml($scope.texto.text);
        };
        $scope.shareAction = function(){
            ShareFactory.update({id:$rootScope.compraId})
        }
    }]);

angular.module('sbAdminApp').factory('ShareFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/comparte/:id', {}, {
        get: {method: 'GET', params: {id: '@id'}, isArray: false},
        update: {method: 'PUT', params: {id: '@id'}}
    });
});

angular.module('sbAdminApp').factory('CompraSummaryFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/compra/:id', {}, {
        get: {method: 'GET', params: {id: '@id'}},        
    });
});