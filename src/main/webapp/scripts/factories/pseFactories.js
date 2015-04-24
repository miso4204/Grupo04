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
    return {
        compraLista:
                [{
              "comId":"143",
             "comValor":"50,000",
              "comPais":"Colombia",
              "comCiudad":"Bogota",
              "comDireccion":"Chapinero",
              "tipoPagId":"4",
              "tarId":"234",
              
               usuId:{
                "usuId":"123",
                "usuUsuario":"@pomova",
                "usuContrasena":"q123", 
                
                 perId:{
                 "perId":"132",
                 "perTipoDocumento":"CC",
                 "perNumeroDocumento":"23434135",
                "perPrimerNombre":"Alejandro",
                 "perPrimerApelido":"Quintero",
                 "perEmail":"al1989@yahoo.com",
                 "perDireccion":"cra 120 #10-03"
             }
              },
              "perId":"504"
          }]};
          
        
    
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



