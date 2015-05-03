'use strict';


angular.module('sbAdminApp').controller('addressChange', ['$scope','$timeout','cambiaDireccion','auth',
    function ($scope,$timeout,cambiaDireccion,auth) {
        
        
        $scope.updateAddress=function(){
      var direCh= new cambiaDireccion();
       console.log($scope.dire);
      direCh.$direChan({idPers:$scope.dSerializa.perId.perId,newAddr:$scope.dire});
       
            
        }
    }]);