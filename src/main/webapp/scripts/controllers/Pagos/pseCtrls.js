'use strict';

angular.module('sbAdminApp').controller('pseController', ['$scope', 'pseFactory','pseFactories','listPurchase','banco','UsuarioPse','$location',
    function ($scope,pseFactory,pseFactories,listPurchase,banco,UsuarioPse,$location) {
         
         $scope.listaCompra=listPurchase.compraLista;
         
        $scope.pseBanco=banco.bancos;
        $scope.UserPse=UsuarioPse.usuario;
      
       $scope.validar=function (){
          
           if($scope.user.cedula=='11111' && $scope.user.contrasena=='Alejandro'){
               
               $location.path('dashboard/cuenta');
           }else{window.alert('datos incorrectos')};
           
       };
       
       $scope.entrarBanco= function(){
           
          if( $scope.user.debito=='2343' && 
                   $scope.user.cedula=='11111' &&
                   $scope.user.clave=='1456'){
               $location.path('dashboard/confirmacion');
                   }else{window.alert('datos incorrectos')};
       };
       
       
       $scope.summary=function (){
         $location.path('dashboard/summary')  
           
       };
  }   
        
     
                
       
        


]);
