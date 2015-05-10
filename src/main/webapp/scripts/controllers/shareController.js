/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('sbAdminApp').controller('ShareCtrl', ['$sce','$scope','ShareFactory','$rootScope',
    function ($sce, $scope, ShareFactory,$rootScope) {
        
        $scope.disabled=true;      
        $scope.compra = $rootScope.compra;//CompraSummaryFactory.get({id:$scope.compraId});
        $scope.texto = ShareFactory.get({id:$scope.compra.comId});
        $scope.getInfo = function () {
            $scope.sharePost = $sce.trustAsHtml($scope.texto.text);
        };
        $scope.shareAction = function(){
            ShareFactory.update({id:$scope.compra.comId})
        }
    }]);

angular.module('sbAdminApp').factory('ShareFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/comparte/:id', {}, {
        get: {method: 'GET', params: {id: '@id'}, isArray: false},
        update: {method: 'PUT', params: {id: '@id'}}
    });
});