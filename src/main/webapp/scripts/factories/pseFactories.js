'use strict';

angular.module('sbAdminApp').factory('pseFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/compra/:usuId', {}, {
  
           show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@usuId'}},
        delete: {method: 'DELETE', params: {id: '@id'}}
        
    });
});


angular.module('sbAdminApp').factory('pseFactories', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/compra ', {}, {
       query: {method: 'GET'},
        create: {method: 'POST'}
        
        
    });
});

angular.module('sbAdminApp').factory('listPurchase', function(){
     return $resource('/StampUreStyle2.0/webresources/persona', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
    
    
});
angular.module('sbAdminApp').factory('banco', function(){
    return { bancos:[{
                "nombre":"BanColombia"
            },{
                "nombre":"Davivienda"
            },{
                "nombre":"Banco De Occidente"
            },{
                "nombre":"AVvillas"
            },{
                "nombre":"Colpatria"
            },{
                "nombre":"Citibank"
            },{
                "nombre":"Banco de Bogota"
            },{
                "nombre":"Helm Bank"
            },{
                "nombre":"Scotia Bank"
            }]
        
        
        
    }});
angular.module('sbAdminApp').factory('UsuarioPse', function(){
    return { usuario:[{
                "nombre":"Alejandro",
                "contrasena":"11111"
            },{
                "nombre":"Camilo",
                "contrasena":"11111"
            },{
                "nombre":"Martin",
                "contrasena":"11111"
            },{
                "nombre":"Carlos",
                "contrasena":"11111"
            },{
                "nombre":"Andrea",
                "contrasena":"11111"
            },{
                "nombre":"Carla",
                "contrasena":"11111"
            },{
                "nombre":"Michael",
                "contrasena":"11111"
            },{
                "nombre":"Robert",
                "contrasena":"11111"
            },{
                "nombre":"Sandra",
                "contrasena":"11111"
            }]
        
        
        
    };});



