
//hay fabricas de este archivo que estoy usando en personaCtrl.js
//   UsersFactory


angular.module('sbAdminApp').controller('UserListCtrl', ['$scope', 'UsersFactory','UserFactory','$location',
    function ($scope, UsersFactory,UserFactory,$location) {
        
          $scope.editUser = function (userId) {
            $location.path('dashboard/user-detail/' + userId);
        };
        
         $scope.deleteUser = function (userId) {
            UserFactory.delete({id: userId});
            $scope.users = UsersFactory.query();
        };
        
         // callback for ng-click 'createUser':
        $scope.createNewUser = function () {
            $location.path('dashboard/user-creation');
        };

        $scope.users = UsersFactory.query();
    }]);

//Este controlador lo usa la pagina user-creation
angular.module('sbAdminApp').controller('UserCreationCtrl', ['$scope','personFactory', 'UsersFactory', '$location',
    function ($scope,personFactory,UsersFactory, $location) {
        
 
     
         $scope.createNewUser = function () {
           console.log($scope.user.perId);
           $scope.user.perId= $scope.pers;
           UsersFactory.create($scope.user);
           $location.path('dashboard/user-list');
       };
       
       $scope.pers = personFactory.show({id: '1'});
       console.log(JSON.stringify($scope.pers));
   
      
    }]);

angular.module('sbAdminApp').controller('UserDetailCtrl', ['$scope', '$routeParams', 'UserFactory','personFactory', '$location',
    function ($scope, $routeParams, UserFactory,personFactory, $location) {

        /* callback for ng-click 'updateUser': */
        $scope.updateUser = function () {
            UserFactory.update($scope.user);
            $location.path('dashboard/user-list');
        };

        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('dashboard/user-list');
        };
$scope.deleteUser = function (personaId) {
            
            personFactory.delete({id: personaId});
        };
        $scope.user = UserFactory.show({id: $routeParams.id});
    }]);

angular.module('sbAdminApp').factory('UsersFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/usuario', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
});



angular.module('sbAdminApp').factory('personFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/persona/:id', {}, {
         query: {method: 'GET', isArray: true},
         show: {method: 'GET'}
      
        
    });});
