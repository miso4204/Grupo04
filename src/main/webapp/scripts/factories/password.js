'use strict';

angular.module('sbAdminApp').factory('passwordChange', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/changePassword/:idUsu/:newPass', 
    {idUsu: '@idUsu', newPass:'@newPassword'}, {
       
        changePass: {method: 'POST', params:{idUsu: '@idUsu', newPass:'@newPassword'}}
    });
});