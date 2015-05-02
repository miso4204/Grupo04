angular.module('sbAdminApp').factory('cambiaDireccion', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/changeAddress/:idPers/:newAddr', {idPers: '@idPers', newAddr:'@newAddress'}, {
      
        direChan: {method: 'POST',  params: {idPers: '@idPers', newAddr:'@newAddress'}}
    });
});


