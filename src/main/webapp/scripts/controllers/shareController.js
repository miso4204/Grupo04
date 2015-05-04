/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('sbAdminApp').controller('ShareCtrl', ['$scope','ShareFactory','$cookies',
    function ($scope, ShareFactory, $cookies) {
        $scope.disabled=true;
        $scope.compraId=1;
        $scope.modal="Aca va lo que va a cargar";
        $scope.getInfo = function (id) {
           $scope.modal = ShareFactory.get({id: id});
        };
    }]);

angular.module('sbAdminApp').factory('ShareFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/comparte/social/:id', {}, {
        get: {method: 'GET', params: {id: '@id'}}
    });
});