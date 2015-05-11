//Este controlador lo maneja la pagina diseno-list y 
//borra y envia a la pagina de crear y actualizar diseño
angular.module('sbAdminApp').controller('ReporteVentasCTRL', ['$scope','ReporteVentasFactory','$location','$cookies',
    function ($scope, ReporteVentasFactory,$location, $cookies) {
        
        
        
        $scope.repventas = ReporteVentasFactory.query();
        
        $scope.tab = true ;
        
        $scope.setTab = function(newValue){
            $scope.tab = newValue;
          };
          
         
        
        /*
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
         $scope.meses = [ {"num": 1, "mes": 'Enero'},
                          {"num": 2, "mes": 'Febrero'},
                          {"num": 3, "mes": 'Marzo'},
                          {"num": 4, "mes": 'Abril'},
                          {"num": 5, "mes": 'Mayo'},
                          {"num": 6, "mes": 'Junio'},
                          {"num": 7, "mes": 'Julio'},
                          {"num": 8, "mes": 'Agosto'},
                          {"num": 9, "mes": 'Septiembre'},
                          {"num": 10, "mes": 'Octubre'},
                          {"num": 11, "mes": 'Noviembre'},
                          {"num": 12, "mes": 'Diciembre'}];
         
         /*
        $scope.updateAction = function () {
            console.log("hizo update");
            DisenoFactory.update($scope.diseno);
            $scope.disabled=true;
            $location.path('dashboard/diseno-list');
        };
        
        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('dashboard/diseno-list');
        }; */
    }]);


//servicios
angular.module('sbAdminApp').factory('ReporteVentasFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/ventas', {}, 
    {
        query: { method: 'GET', isArray: true  }
        
    });
});

angular.module('sbAdminApp').filter('monthName', [function() {
    return function (monthNumber) { //1 = January
        var monthNames = [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre' ];
        return monthNames[monthNumber - 1];
    }
}]);


