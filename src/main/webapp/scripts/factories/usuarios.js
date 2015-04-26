'use strict';

angular.module('sbAdminApp').factory('profilesFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/usuarioxperfil', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
});

angular.module('sbAdminApp').factory('usersFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/usuario', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
});

angular.module('sbAdminApp').factory('peopleFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/persona', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
});

angular.module('sbAdminApp').factory('profileFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/perfil/:id', {}, {
        show: {method: 'GET'}
    });
});

angular.module('sbAdminApp').factory('userFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/usuario/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@usuId'}},
        delete: {method: 'DELETE', params: {id: '@id'}}
    });
});

angular.module('sbAdminApp').factory('personFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/persona/:id', {}, {
         show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@usuId'}},
        delete: {method: 'DELETE', params: {id: '@id'}}
    });
});

angular.module('sbAdminApp').factory('perfilFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/usuarioxperfil/:id', {}, {
          show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@usuId'}},
        delete: {method: 'DELETE', params: {id: '@id'}}
    });
});