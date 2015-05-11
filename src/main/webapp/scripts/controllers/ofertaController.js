//Este controlador lo maneja la pagina diseno-list y 
//borra y envia a la pagina de crear y actualizar diseño
angular.module('sbAdminApp').controller('OfertaCtrl', ['$scope','$stateParams','$location','$cookies','OfertaFactory','OfertasFactory',
    function ($scope,$stateParams,$location, $cookies,OfertaFactory,OfertasFactory) {
        
        
        $scope.disabled=true;
        $scope.ofertac={};
        $scope.ofertae={};
        $scope.siguienteId = OfertaFactory.count();
        
        if($stateParams.ofeId !== null){
            
            $scope.ofertae = OfertaFactory.show({id: $stateParams.ofeId});
        }
        
        $scope.ofertas = OfertasFactory.query();
        $scope.goEdit = function (ofeId) {
            //$scope.ofertae = oferta;
            //console.log(JSON.stringify($scope.ofertae));
            $location.path('dashboard/oferta-edit/'+ofeId);
        };
        
        $scope.editAction = function (oferta) {
            $scope.ofertae=oferta;
            $location.path('dashboard/oferta-edit');
        };
        $scope.goCreate = function (oferta) {
            $scope.ofertac=oferta;
            $location.path('dashboard/oferta-create');
        };
        
        $scope.createAction = function () {
           
           
           var id = '';
           for (key in $scope.siguienteId)
           {
               if (key === '$promise')break;
               id=id+$scope.siguienteId[key];
               
           }
            
            
            $scope.ofertac.ofeId=id;
            
            
            OfertasFactory.create($scope.ofertac);
            $location.path('dashboard/oferta-list');
        };
        //$scope.diseno=$scope.disenos[0];
        /*$scope.diseno = {
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
            $scope.usuarioLogin=JSON.parse($cookies.id);
            //$scope.disenoc.usuId={"perId":{"perDireccion":"La casa de la esquina","perEmail":"cedamogue@gmail.com","perId":1,"perNumeroDocumento":"1032411208","perPrimerApelido":"MontaÃ±ez","perPrimerNombre":"CÃ©sar","perTipoDocumento":"cc"},"usuContrasena":"cmontanez","usuId":1,"usuUsuario":"cmontanez"};
            $scope.disenoc.usuId=$scope.usuarioLogin;
            console.log(JSON.stringify($scope.disenoc));
            $scope.disenoc.estId=$scope.est;
            $scope.disenoc.disNumeroVentas=0;
            
            DisenosFactory.create($scope.disenoc);
            $location.path('dashboard/diseno-list');
        };
        */
         /* callback for ng-click 'updateAction': */
        /*$scope.updateAction = function () {
            console.log("hizo update");
            DisenoFactory.update($scope.diseno);
            $scope.disabled=true;
            $location.path('dashboard/diseno-list');
        };
        
        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('dashboard/diseno-list');
        };*/
    }]);


//servicios
angular.module('sbAdminApp').factory('OfertasFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/oferta', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
});

angular.module('sbAdminApp').factory('OfertaFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/oferta/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@ofeId'}},
        delete: {method: 'DELETE', params: {id: '@id'}},
        count:{ method: 'GET', params: {id: 'count'}, isArray: false }
    });
});

/*angular.module('sbAdminApp')
    .factory('DisenoFactoryPlain', ['$http', function($http) {
    var urlBase = '/StampUreStyle2.0/webresources/diseno/';
    var dataFactory = {};

    dataFactory.count = function () {
        return $http.get(urlBase + '/count');
    };

    return dataFactory;
}]);

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
});*/