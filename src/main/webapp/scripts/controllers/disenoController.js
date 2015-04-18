//Este controlador lo maneja la pagina diseno-list y 
//borra y envia a la pagina de crear y actualizar diseño
angular.module('sbAdminApp').controller('DisenoCtrl', ['$scope','DisenosFactory','DisenoFactory',
    'CategoriasFactoryD','EstilosFactoryD','$location',
    function ($scope, DisenosFactory, DisenoFactory, 
    CategoriasFactoryD,EstilosFactoryD,$location) {
        
        
        $scope.IMAGE_LOCATION = "./data/";
        $scope.showSelected = function(image) {
            $scope.disabled=true;
            $scope.diseno = image;
        };
        $scope.disabled=true;
        $scope.disenoc={disUrl:null};
       
        
        $scope.disenos = DisenosFactory.query();
        //$scope.diseno=$scope.disenos[0];
        $scope.diseno = {
                id : 4,
                nombre : "Manuel Diaz",
                edad : "45 años",
                disUrl:'estampa-otonal.jpg',
                catId: {"catId":1,"catNombre":"Fotos"}
            };
        $scope.categorias = CategoriasFactoryD.query();
        $scope.estilos = EstilosFactoryD.query();
        
        $scope.edit = function () {
           // $location.path('dashboard/diseno-detail/' + id);
            //$scope.diseno = DisenoFactory.show({id: $stateParams.id});
            $scope.disabled=!$scope.disabled;
        };
        
        $scope.delete = function (id) {
           DisenoFactory.delete({id: id});//.$promise.then(function(diseno){},{});
           $scope.disenos = DisenosFactory.query();
           $location.path('dashboard/diseno-list');
            
        };
        
        $scope.siguienteId = DisenoFactory.nextId();
        //console.log("diseno id "+ $scope.siguienteId);
         // callback for ng-click 'createUser':
        $scope.createForm = function () {
            $location.path('dashboard/diseno-create');
        };
        $scope.fileChanged = function(elm){
            $scope.disenoc.disUrl=elm.files[0].name;
            $scope.$apply();
            
        };
        // callback for ng-click 'createAction':
        $scope.createAction = function () {
            //$scope.disenoc.disUrl="RcdRRK7gi.png";
           
           var id = '';
           for (key in $scope.siguienteId)
           {
               if (key === '$promise')break;
               id=id+$scope.siguienteId[key];
              // console.log("key"+key); 
           }
            
            //console.log("id"+id);
            $scope.disenoc.disId=id;
            $scope.disenoc.catId=$scope.cat;
            $scope.disenoc.usuId={"perId":{"perDireccion":"La casa de la esquina","perEmail":"cedamogue@gmail.com","perId":1,"perNumeroDocumento":"1032411208","perPrimerApelido":"MontaÃ±ez","perPrimerNombre":"CÃ©sar","perTipoDocumento":"cc"},"usuContrasena":"cmontanez","usuId":1,"usuUsuario":"cmontanez"};
            $scope.disenoc.estId=$scope.est;
            $scope.disenoc.disNumeroVentas=0;
            console.log(JSON.stringify($scope.disenoc));
            DisenosFactory.create($scope.disenoc);
            $location.path('dashboard/diseno-list');
        };
        
         /* callback for ng-click 'updateAction': */
        $scope.updateAction = function () {
            console.log("hizo update");
            DisenoFactory.update($scope.diseno);
            $scope.disabled=true;
            $location.path('dashboard/diseno-list');
        };
        
        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('dashboard/diseno-list');
        };
    }]);


//servicios
angular.module('sbAdminApp').factory('DisenosFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/diseno', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
});

angular.module('sbAdminApp').factory('DisenoFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/diseno/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@disId'}},
        delete: {method: 'DELETE', params: {id: '@id'}},
        nextId:{ method: 'GET', params: {id: 'nextId'}, isArray: false }
    });
});
/*
angular.module('sbAdminApp')
    .factory('DisenoFactoryPlain', ['$http', function($http) {
    var urlBase = '/StampUreStyle2.0/webresources/diseno/';
    var dataFactory = {};

    dataFactory.count = function () {
        return $http.get(urlBase + '/count');
    };

    return dataFactory;
}]);*/

angular.module('sbAdminApp').factory('CategoriasFactoryD', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/categoria', {}, 
    {
        query: { method: 'GET', isArray: true  },
        create: { method: 'POST' }
        
    });
});
angular.module('sbAdminApp').factory('EstilosFactoryD', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/estilos', {}, 
    {
        query: { method: 'GET', isArray: true  },
        create: { method: 'POST' }
        
    });
});