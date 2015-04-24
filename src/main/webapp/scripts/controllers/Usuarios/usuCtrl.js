'use strict';


angular.module('sbAdminApp').controller('newAccount', ['$scope','$timeout','profilesFactory','usersFactory','peopleFactory','userFactory','personFactory','perfilFactory','$location',
    function ($scope,$timeout,profilesFactory,usersFactory,peopleFactory,userFactory,personFactory,perfilFactory,$location) {
  
        $scope.usuariosLista=profilesFactory.query();
        
        $scope.cargarDatos=function () {
           
           $scope.userXperfil= new profilesFactory();
           
              $scope.person.perId=Math.round(Math.random()*10000);
              $scope.usuario.usuId=Math.round(Math.random()*10000);
              $scope.userXperfil.usuperId=Math.round(Math.random()*10000);
              $scope.usuario.perId=$scope.person;
              $scope.userXperfil.usuId=$scope.usuario; 
             if($scope.perfil==2)
            {
                $scope.userXperfil.perId={'perId':2,'perNombre':'cliente'};
            }
            else
            {
                if($scope.perfil==3)
                {
                    $scope.userXperfil.perId={'perId':3,'perNombre':'artista'};
                }
            }
          peopleFactory.create($scope.person);  
         
             $timeout(function() {
    if ($scope.person) {
     usersFactory.create($scope.usuario);
    } 
  }, 1000);

  $timeout(function() {
    if ($scope.usuario) {
     profilesFactory.create($scope.userXperfil);
    }
    
  }, 1000);
           
           $timeout(function() {
           $location.path('dashboard/administrador');
             }, 2000);
        };
            
        $scope.reset= function (){
            $scope.person={};
            $scope.perfil={};
            $scope.usuario={};
            $scope.user={};
        };
        
      $scope.editando=function(){
           
          $scope.pullPersona=new userFactory();
          $scope.pullPersona=userFactory.show({id:$scope.user.usuId});
   
    $timeout(function() {  
        
    $scope.user.perId.perId=$scope.pullPersona.perId.perId;
    personFactory.update({id:$scope.pullPersona.perId.perId},$scope.user.perId);
    
  }, 1000); 
          
        $timeout(function() {   
           
           userFactory.update({id:$scope.user.usuId},$scope.user);
        
        }, 2000);    
          
          $timeout(function() {
           $location.path('dashboard/administrador');
             }, 3000);
        }; 
          
       $scope.goEditar=function(userId){
           $scope.user=new userFactory();
           $scope.user.usuId=userId.usuId;
           $location.path('dashboard/adminEditar');
       };
       
       $scope.borrar=function(userId){
           $timeout(function() { 
           perfilFactory.delete({id:userId.usuperId}); 
            }, 100); 
             $timeout(function() { 
          userFactory.delete({id:userId.usuId.usuId}); 
           }, 200); 
           $timeout(function() { 
          personFactory.delete({id:userId.usuId.perId.perId});
          }, 300); 
          $timeout(function() {
          $scope.usuariosLista=profilesFactory.query();
          }, 400); 
       };
       
       
       
     
    }]);


