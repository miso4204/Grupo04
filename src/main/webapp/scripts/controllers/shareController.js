/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('sbAdminApp').controller('ShareCtrl', ['$sce','$scope','ShareFactory','$cookies','CompraSummaryFactory','$rootScope',
    function ($sce, $scope, ShareFactory, $cookies, CompraSummaryFactory,$rootScope) {
        $scope.disabled=true;
        $rootScope.compraId = 3;
        $scope.compra = CompraSummaryFactory.get({id:1});
        $scope.texto = ShareFactory.get({id:$scope.compraId});
        $scope.getInfo = function () {
            $scope.sharePost = $sce.trustAsHtml($scope.texto.text);
        };
    }]);

angular.module('sbAdminApp').factory('ShareFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/comparte/social/:id', {}, {
        get: {method: 'GET', params: {id: '@id'}, isArray: false}
    });
});

angular.module('sbAdminApp').factory('CompraSummaryFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/compra/:id', {}, {
        get: {method: 'GET', params: {id: '@id'}},        
    });
});