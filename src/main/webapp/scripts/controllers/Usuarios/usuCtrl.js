'use strict';


angular.module('sbAdminApp').controller('newAccount', ['$scope','$rootScope','$cookies','$timeout','profilesFactory','usersFactory','peopleFactory','userFactory','personFactory','perfilFactory','$location',
    function ($scope,$rootScope,$cookies,$timeout,profilesFactory,usersFactory,peopleFactory,userFactory,personFactory,perfilFactory,$location) {
  
        $scope.usuariosLista=profilesFactory.query();
        $scope.dSerializa=JSON.parse($cookies.id);
       
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
    
  }, 2000);
     
     $timeout(function() {
    
    $scope.usuariosLista=profilesFactory.query();
  }, 2500);
    
             $timeout(function() {
    
    $scope.reset();
 
  }, 3000);
     
     
     
        };
            
        $scope.reset= function (){
          
            $scope.person={};
              $scope.usuario={};
            
        };
            $scope.resetear= function (){
            $scope.dSerializa={};
            var dusu=JSON.parse($cookies.id);
            $scope.dSerializa.usuId=dusu.usuId;
        };
        
      $scope.editando=function(){
         
        $scope.pullPersona=new userFactory();
          $scope.pullPersona=userFactory.show({id:$rootScope.editarUsuario.usuId.usuId});
          
    
    $timeout(function() {  
      
      
   $rootScope.editarUsuario.usuId.perId.perId=$scope.pullPersona.perId.perId;
   personFactory.update({id:$scope.pullPersona.perId.perId},$rootScope.editarUsuario.usuId.perId);
    
  }, 1000); 
         
        $timeout(function() {   
           
           userFactory.update({id:$rootScope.editarUsuario.usuId.usuId},$rootScope.editarUsuario.usuId);
        $scope.usuariosLista=profilesFactory.query();
        }, 2000);    
          
        
         
        }; 
       
       $scope.goEditar=function(usuario){
         $rootScope.editarUsuario=usuario;
          
         
          
 
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
       
       $scope.editandoMyCuenta=function(){
           
       
        $scope.pullMyInfo=new userFactory();
          $scope.pullMyInfo=userFactory.show({id:$scope.dSerializa.usuId});
          
    
    $timeout(function() {  
     
      
   $scope.dSerializa.perId.perId=$scope.pullMyInfo.perId.perId;
   personFactory.update({id:$scope.pullMyInfo.perId.perId},$scope.dSerializa.perId);
    
  }, 1000); 
         
        $timeout(function() {   
           
           userFactory.update({id:$scope.dSerializa.usuId},$scope.dSerializa);
        
        }, 2000);    
          
         
         
           
       };
       
     
    }]);


