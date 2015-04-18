/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Este controlador lo maneja la pagina users-list y borra y envia a la pagina de crear y actualizar usuario
angular.module('sbAdminApp').controller('UserListCtrl', ['$scope', 'UsersFactory', 'UserFactory', 'PersonFactory', '$location',
    function ($scope, UsersFactory, UserFactory, PersonFactory, $location) {

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
angular.module('sbAdminApp').controller('UserCreationCtrl', ['$scope', 'PersonFactory', 'UsersFactory', '$location',
    function ($scope, PersonFactory, UsersFactory, $location) {

       
        // callback for ng-click 'createNewUser':
        $scope.createNewUser = function () {
            console.log($scope.user.perId);
            $scope.user.perId= $scope.pers;
            UsersFactory.create($scope.user);
            $location.path('dashboard/user-list');
        };
        
        $scope.pers = PersonFactory.show({id: '1'});
        console.log(JSON.stringify($scope.pers));
    }]);

angular.module('sbAdminApp').controller('UserDetailCtrl', ['$scope', '$stateParams', 'UserFactory', '$location',
    function ($scope, $stateParams, UserFactory, $location) {

        /* callback for ng-click 'updateUser': */
        $scope.updateUser = function () {
            UserFactory.update($scope.user);
            $location.path('dashboard/user-list');
        };

        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('dashboard/user-list');
        };

        $scope.user = UserFactory.show({id: $stateParams.userId});
    }]);

angular.module('sbAdminApp').factory('UsersFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/usuario', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    })
});

angular.module('sbAdminApp').factory('UserFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/usuario/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@usuId'}},
        delete: {method: 'DELETE', params: {id: '@id'}}
    })
});

angular.module('sbAdminApp').factory('PersonFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/persona/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@usuId'}},
        delete: {method: 'DELETE', params: {id: '@id'}}
    })
});