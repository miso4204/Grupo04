'use strict';
/**.perPrimerNombre
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 * 
 */

var app = angular.module("sbAdminApp");

app.controller('ReporteRatingCtrl', ['$scope', 'DisenosPorProductoDisenadosFactory', '$timeout', '$window',
    function ($scope, DisenosPorProductoDisenadosFactory) {

        $scope.disenosPorProDis = DisenosPorProductoDisenadosFactory.query();

        $scope.disenosVendidos = function () {
                $scope.disenosVen = [];
                $scope.autores = [];
            if ($scope.disenosVen.length === 0) {
                var found = true;
                var foundAutor = true;
                for (var i = 0; i < $scope.disenosPorProDis.length; i++) {
                    found = true;
                    foundAutor = true;
                    var dppd = $scope.disenosPorProDis[i];
                    var id = dppd.disId.disId;
                    var nombre = dppd.disId.disNombre;
                    var cantidad = dppd.proDisId.proDisCantidad;
                    var autor = dppd.disId.usuId.perId.perPrimerNombre + " " + dppd.disId.usuId.perId.perPrimerApelido;
                    var idAutor = dppd.disId.usuId.perId.perId;
                    var url = dppd.disId.disUrl;
                    for (var j = 0; j < $scope.disenosVen.length; j++) {
                        var dis = $scope.disenosVen[j];
                        if (dis.id === id) {
                            found = false;
                            dis.cantidad = (dis.cantidad + cantidad);
                        }
                    }
                    for (var k = 0; k < $scope.autores.length; k++) {
                        var aut = $scope.autores[k];
                        if (aut.idAutor === idAutor) {
                            foundAutor = false;
                        }
                    }

                    if (foundAutor) {
                        var author = {"idAutor": idAutor, "autor": autor};
                        $scope.autores.push(author);
                    }

                    if (found) {

                        var diseno = {"id": id, "nombre": nombre, "cantidad": cantidad, "idAutor": idAutor, "autor": autor, "url": url};
                        $scope.disenosVen.push(diseno);
                    }
                    // var diseno = new addDiseno(dppd.disId.disId);
                }
            }
        };

    }
]);

//Diseños por producto diseñado
app.factory('DisenosPorProductoDisenadosFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/disenosxproddis', {},
            {
                query: {method: 'GET', isArray: true},
                create: {method: 'POST'}

            });
});

app.factory('DisenosPorProductoDisenadoFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/disenosxproddis/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@disId'}},
        delete: {method: 'DELETE', params: {id: '@id'}},
        nextId: {method: 'GET', params: {id: 'nextId'}, isArray: false}
    });
});