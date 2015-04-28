'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */

var app = angular.module("sbAdminApp");

app.controller('loginController', ['$scope', 'auth', 'UsersxperfilFactory','$timeout','profilesFactory','usersFactory','peopleFactory','$location',
    function ($scope, auth, UsersxperfilFactory,$timeout,profilesFactory,usersFactory,peopleFactory,$location) {
        //la función login que llamamos en la vista llama a la función
        //login de la factoria auth pasando lo que contiene el campo
        //de texto del formulario

        $scope.usersperfils = UsersxperfilFactory.query();
        $scope.login = function ()
        {
            auth.login($scope.username, $scope.password,$scope.usersperfils);

        }
        
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
    
    $scope.reset();
 
  }, 2500);       
           
        };
 
   $scope.reset= function (){
          
            $scope.person={};
              $scope.usuario={};
            
        };  
        
        $scope.refresh=function(){
          
        };
        
    }]);


app.factory('UsersxperfilFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/usuarioxperfil', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
});



app.factory('auth', function ($cookies, $cookieStore, $location)
{
    return{
        login: function (username,password,usersperfils)
        {
             $cookies.username = null,
                    
             $cookies.password = null;
             
            var key = '';
            
            for (key in usersperfils)
            {
                if (key != '$promise' && key != '$resolved') {
                    if (usersperfils[key]['usuId']['usuUsuario'] == username && usersperfils[key]['usuId']['usuContrasena'] == password) {
                        $cookies.username = username,
                     $cookies.password = password;
                      $cookieStore.put("id",usersperfils[key]['usuId']);
                       
                        break;
                    }
                }
            }
      
      if($cookies.username == username){
          $location.path("dashboard/myPerfil");
      
      }else{
          
          $location.path("/loginBad");}
        

        },
        logout: function ()
        {
            //al hacer logout eliminamos la cookie con $cookieStore.remove
            $cookieStore.remove("username"),
                    $cookieStore.remove("id"),
                    $cookieStore.remove("password");
           
            //mandamos al login
            $location.path("/login");
        },
        checkStatus: function ()
        {
            //creamos un array con las rutas que queremos controlar
            var rutasPrivadas = ["/home", "/login"];
            if (this.in_array($location.path(), rutasPrivadas) && typeof ($cookies.username) == "undefined")
            {
                $location.path("/login");
            }
           
            //en el caso de que intente acceder al login y ya haya iniciado sesión lo mandamos a la home
//            if(this.in_array("/login",rutasPrivadas) && typeof($cookies.username) != "undefined")
//            {
//                $location.path("/home");
//            }

        },
        in_array: function (needle, haystack)
        {
            var key = '';
            for (key in haystack)
            {
                if (haystack[key] == needle)
                {
                    return true;
                }
            }
            return false;
        }
    }
});
