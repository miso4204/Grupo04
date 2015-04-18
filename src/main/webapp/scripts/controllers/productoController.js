//Este controlador lo maneja la pagina producto-list y 
//borra y envia a la pagina de crear y actualizar producto
angular.module('sbAdminApp').controller('ProductoCtrl', ['$scope', 
    'ProductosFactory','ProductoFactory','CategoriasFactoryP','EstilosFactoryP','$location',
    function ($scope, 
    ProductosFactory, ProductoFactory, CategoriasFactoryP,EstilosFactoryP,$location) {
        
        
        $scope.IMAGE_LOCATION = "./img/products/";
        $scope.showSelected = function(image) {
            $scope.disabled=true;
            $scope.producto = image;
        };
        $scope.disabled=true;
        $scope.productoc={disUrl:null};
       
        
        $scope.productos = ProductosFactory.query();
        //$scope.producto=$scope.productos[0];
        $scope.producto = {
                id : 4,
                nombre : "Manuel Diaz",
                edad : "45 años",
                proUrl:'FIG.jpg',
                catId: {"catId":1,"catNombre":"Fotos"}
            };
        $scope.categorias = CategoriasFactoryP.query();
        $scope.estilos = EstilosFactoryP.query();
        
        $scope.edit = function () {
           // $location.path('dashboard/diseno-detail/' + id);
            //$scope.producto = ProductoFactory.show({id: $stateParams.id});
            $scope.disabled=!$scope.disabled;
        };
        
        $scope.delete = function (id) {
           ProductoFactory.delete({id: id});//.$promise.then(function(diseno){},{});
           $scope.productos = ProductosFactory.query();
           $location.path('dashboard/producto-list');
            
        };
        
        $scope.siguienteId = ProductoFactory.nextId();
        //console.log("diseno id "+ $scope.siguienteId);
         // callback for ng-click 'createUser':
        $scope.createForm = function () {
            $location.path('dashboard/producto-create');
        };
        $scope.fileChanged = function(elm){
            $scope.productoc.proUrl=elm.files[0].name;
            $scope.$apply();
            
        };
        // callback for ng-click 'createAction':
        $scope.createAction = function () {
            //$scope.productoc.disUrl="RcdRRK7gi.png";
           
           var id = '';
           for (key in $scope.siguienteId)
           {
               if (key === '$promise')break;
               id=id+$scope.siguienteId[key];
              // console.log("key"+key); 
           }
            
            //console.log("id"+id);
            $scope.productoc.proId=id;
            $scope.productoc.catId=$scope.cat;
            $scope.productoc.usuId={"perId":{"perDireccion":"La casa de la esquina","perEmail":"cedamogue@gmail.com","perId":1,"perNumeroDocumento":"1032411208","perPrimerApelido":"MontaÃ±ez","perPrimerNombre":"CÃ©sar","perTipoDocumento":"cc"},"usuContrasena":"cmontanez","usuId":1,"usuUsuario":"cmontanez"};
            $scope.productoc.estId=$scope.est;
            
            console.log(JSON.stringify($scope.productoc));
            ProductosFactory.create($scope.productoc);
            $location.path('dashboard/producto-list');
        };
        
         /* callback for ng-click 'updateAction': */
        $scope.updateAction = function () {
            console.log("hizo update");
            ProductoFactory.update($scope.producto);
            $scope.disabled=true;
            $location.path('dashboard/producto-list');
        };
        
        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('dashboard/producto-list');
        };
    }]);


//servicios
angular.module('sbAdminApp').factory('ProductosFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/producto', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
});

angular.module('sbAdminApp').factory('ProductoFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/producto/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@disId'}},
        delete: {method: 'DELETE', params: {id: '@id'}},
        nextId:{ method: 'GET', params: {id: 'nextId'}, isArray: false }
    });
});
//

angular.module('sbAdminApp').factory('CategoriasFactoryP', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/categoria', {}, 
    {
        query: { method: 'GET', isArray: true  },
        create: { method: 'POST' }
        
    });
});
angular.module('sbAdminApp').factory('EstilosFactoryP', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/estilos', {}, 
    {
        query: { method: 'GET', isArray: true  },
        create: { method: 'POST' }
        
    });
});
