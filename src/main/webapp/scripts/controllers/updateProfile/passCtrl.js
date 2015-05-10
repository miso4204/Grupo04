'use strict';

angular.module('sbAdminApp').controller('passCtrl', ['$scope','passwordChange','auth','$timeout',
    function ($scope,passwordChange,auth,$timeout) {
        
      $scope.Logout= function(){
          
          var chanPassw=new passwordChange();
          console.log($scope.OnePass);
       chanPassw.$changePass({idUsu:$scope.dSerializa.usuId, newPass:$scope.OnePass});  
        $timeout(function() {  
        auth.logout();    
          }, 1500); 
               
    };
     
 }   
]);
