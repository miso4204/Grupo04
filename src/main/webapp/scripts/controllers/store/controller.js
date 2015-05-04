'use strict';

// the storeController contains two objects:
// - store: contains the product list
// - cart: the shopping cart object
var app = angular.module("sbAdminApp");

app.controller('storeController', ['$scope', 'UsuarioFactoryCompra', 'DataService', '$cookies', '$timeout',
    'TarjetaFactoryCompra','ProductosDisenadosPorCompraFactorysFactory', 'ProductosDisenadosPorCompraFactory', 'ProductoDisenadoFactory', 'CompraFactory', 'ProductoFactory', 'TarjetasFactoryCompra', 'ComprasFactory', 'ProductoDisenadosFactory', 'DisenosPorProductoDisenadoFactory', 'DisenosPorProductoDisenadosFactory', '$location', 'bancos','$rootScope',
    function ($scope, UsuarioFactoryCompra, DataService, $cookies, $timeout,
            TarjetaFactoryCompra,ProductosDisenadosPorCompraFactorysFactory, ProductosDisenadosPorCompraFactory, ProductoDisenadoFactory, CompraFactory, ProductoFactory, TarjetasFactoryCompra, ComprasFactory, ProductoDisenadosFactory, DisenosPorProductoDisenadoFactory, DisenosPorProductoDisenadosFactory, $location, bancos,$rootScope) {

        // get store and cart from service
        $scope.store = DataService.store;
        $scope.cart = DataService.cart;
        $scope.pagoTarjeta = {direccion: null};
        $scope.pagoTarjeta.usuario;
        $scope.usuarioLogin = JSON.parse($cookies.id);
        $scope.pagoTarjeta.direccion = $scope.usuarioLogin.perId.perDireccion;
        $scope.usuario = UsuarioFactoryCompra.show({id: 1});
        $scope.tipos = ["VISA", "American Express", "Master Card"];
        $scope.siguienteId = CompraFactory.nextId();
        $scope.tarjetasiguienteId = TarjetaFactoryCompra.nextId();
        $scope.productoDisenadoId = ProductoDisenadoFactory.nextId();
        $scope.disenosPorProductoId = DisenosPorProductoDisenadoFactory.nextId();
        $scope.productoDisPorCompraId = ProductosDisenadosPorCompraFactory.nextId();


        $scope.pagoPSE = {direccion: null};
        $scope.pseBanco = bancos.bancos;
        $scope.pagoPSE.direccion = $scope.usuarioLogin.perId.perDireccion;

        $scope.createAction = function () {
            var idTarjeta = '';
            var idCompra = '';
            var idProductoDisenado = '';
            var idDisenodPorProdDis = '';
            var idProductoDisPorCompra = '';
            var key = '';
            for (key in $scope.tarjetasiguienteId)
            {
                if (key === '$promise')
                    break;
                idTarjeta = idTarjeta + $scope.tarjetasiguienteId[key];
            }
            for (key in $scope.siguienteId)
            {
                if (key === '$promise')
                    break;
                idCompra = idCompra + $scope.siguienteId[key];
            }
            for (key in $scope.productoDisenadoId)
            {
                if (key === '$promise')
                    break;
                idProductoDisenado = idProductoDisenado + $scope.productoDisenadoId[key];
            }
            for (key in $scope.disenosPorProductoId)
            {
                if (key === '$promise')
                    break;
                idDisenodPorProdDis = idDisenodPorProdDis + $scope.disenosPorProductoId[key];
            }
            for (key in $scope.productoDisPorCompraId)
            {
                if (key === '$promise')
                    break;
                idProductoDisPorCompra = idProductoDisPorCompra + $scope.productoDisPorCompraId[key];
            }


            var tarjeta = {persona: null, tarNumero: null, tarFechaExpiracion: null, tarCodigoSeguridad: null, tarTipo: null,
                tarjetacreditoPK: null};
            var validaHasta = $scope.pagoTarjeta.validaHasta;
            var validaHastaArray = validaHasta.split("/");
            var validadhastaFecha = new Date("20" + validaHastaArray[1] + "-" + validaHastaArray[0] + "-01");
            tarjeta.tarTipo = $scope.pagoTarjeta.tipo;
            tarjeta.tarNumero = $scope.pagoTarjeta.numTarjeta;
            tarjeta.tarFechaExpiracion = validadhastaFecha;
            tarjeta.tarCodigoSeguridad = $scope.pagoTarjeta.cvc;
            tarjeta.persona = $scope.usuarioLogin.perId;

            tarjeta.tarjetacreditoPK = {perId: $scope.usuarioLogin.perId.perId, tarId: idTarjeta};

            TarjetasFactoryCompra.create(tarjeta);
            $timeout(function () {
                var compra = {comCiudad: null, comDireccion: null, comId: null, comPais: null, comValor: null, tarjetacredito: null,
                    tipPagId: {tipPagId: 1, tipPagNombre: "Tarjeta de CrÃ©dito"}, usuId: null};
                compra.comCiudad = $scope.pagoTarjeta.ciudad;
                compra.comDireccion = $scope.pagoTarjeta.direccion;
                compra.comPais = $scope.pagoTarjeta.pais;
                compra.comValor = $scope.cart.getTotalPrice();
                compra.tarjetacredito = tarjeta;
                compra.usuId = $scope.usuarioLogin;
                compra.comId = idCompra;
                ComprasFactory.create(compra);
                $rootScope.compraId = idCompra;
                var arreglDisenosPorProductodis = [];
                var arreglProductoDisPorCompra = [];
                var productoDisenado = $scope.cart.guardarProductoDisenado();
                // item data
                for (var i = 0; i < productoDisenado.length; i++) {
                    var item = productoDisenado[i];
                    var price = $scope.cart.getPrice(item.id);
                    var productodisenado = {"proDisCantidad": item.quantity, "proDisId": idProductoDisenado, "proDisValor": price, "proId": {"catId": {"catId": 0, "catNombre": null}, "estId": {"estId": 0, "estNombre": null}, "proCantidad": 0, "proId": item.sku, "proNombre": null, "proUrl": null, "proValor": 0}};
                    var productoDisPorCompra = {"comId": {"comCiudad": null, "comDireccion": null, "comId": idCompra, "comPais": null, "comValor": 0, "tarjetacredito": {"persona": {"perDireccion": null, "perEmail": null, "perId": 0, "perNumeroDocumento": null, "perPrimerApelido": null, "perPrimerNombre": null, "perTipoDocumento": null}, "tarCodigoSeguridad": 0, "tarFechaExpiracion": null, "tarNumero": null, "tarTipo": null, "tarjetacreditoPK": {"perId": 0, "tarId": 0}}, "tipPagId": {"tipPagId": 0, "tipPagNombre": null}, "usuId": {"perId": {"perDireccion": null, "perEmail": null, "perId": 0, "perNumeroDocumento": null, "perPrimerApelido": null, "perPrimerNombre": null, "perTipoDocumento": null}, "usuContrasena": null, "usuId": 0, "usuUsuario": null}}, "proDisId": {"proDisCantidad": 0, "proDisId": idProductoDisenado, "proDisValor": 0, "proId": {"catId": {"catId": 0, "catNombre": null}, "estId": {"estId": 0, "estNombre": null}, "proCantidad": 0, "proId": 0, "proNombre": null, "proUrl": null, "proValor": 0}}, "prodisComId": idProductoDisPorCompra};
                    arreglProductoDisPorCompra.push(productoDisPorCompra);
                    //Se almacena el producto diseñado
                    ProductoDisenadosFactory.create(productodisenado);
                    if (item.designsPro === undefined) {
                    } else {
                        for (var j = 0; j < item.designsPro.length; j++) {
                            var des = item.designsPro[j];
                            var disenosPorProductodis = {"disId": {"catId": {"catId": 0, "catNombre": null}, "disId": des.sku, "disNombre": null, "disNumeroVentas": 0, "disUrl": null, "disValor": 0, "estId": {"estId": 0, "estNombre": null}, "usuId": {"perId": {"perDireccion": null, "perEmail": null, "perId": 0, "perNumeroDocumento": null, "perPrimerApelido": null, "perPrimerNombre": null, "perTipoDocumento": null}, "usuContrasena": null, "usuId": 0, "usuUsuario": null}}, "disProdisId": idDisenodPorProdDis, "disProdisPosicion": 1, "proDisId": {"proDisCantidad": 0, "proDisId": idProductoDisenado, "proDisValor": 0, "proId": {"catId": {"catId": 0, "catNombre": null}, "estId": {"estId": 0, "estNombre": null}, "proCantidad": 0, "proId": 0, "proNombre": null, "proUrl": null, "proValor": 0}}};
                            arreglDisenosPorProductodis.push(disenosPorProductodis);
                            //DisenosPorProductoDisenadosFactory.create(disenosPorProductodis);
                            idDisenodPorProdDis = parseInt(idDisenodPorProdDis) + parseInt(1);
                        }
                    }

                    idProductoDisenado = parseInt(idProductoDisenado) + parseInt(1);
                    idProductoDisPorCompra = parseInt(idProductoDisPorCompra) + parseInt(1);
                }
                $timeout(function () {
                    for (var o = 0; o < arreglDisenosPorProductodis.length; o++) {
                        var dpp = arreglDisenosPorProductodis[o];
                        DisenosPorProductoDisenadosFactory.create(dpp);
                    }
                }, 1000);
                $timeout(function () {
                    for (var p = 0; p < arreglProductoDisPorCompra.length; p++) {
                        var pdpc = arreglProductoDisPorCompra[p];
                        ProductosDisenadosPorCompraFactorysFactory.create(pdpc);
                    }
                }, 1000);
                $scope.cart.clearItems();

            }, 1000);
            $location.path('dashboard/summary');
        };
        $scope.createbyPSE = function () {

            var idCompra = '';
            var key = '';

            for (key in $scope.siguienteId)
            {
                if (key === '$promise')
                    break;
                idCompra = idCompra + $scope.siguienteId[key];
            }

            var compra = {comCiudad: null, comDireccion: null, comId: null, comPais: null, comValor: null, tarjetacredito: null,
                tipPagId: {tipPagId: 2, tipPagNombre: "PSE"}, usuId: null};
            compra.comCiudad = $scope.pagoPSE.ciudad;
            compra.comDireccion = $scope.pagoPSE.direccion;
            compra.comPais = $scope.pagoPSE.pais;
            compra.comValor = $scope.cart.getTotalPrice();
            compra.usuId = $scope.usuarioLogin;
            compra.comId = idCompra;
            console.log('VALOR: ' + compra.comValor);
            ComprasFactory.create(compra);
            $rootScope.compraId = idCompra;
            $location.path('dashboard/summary');
            $scope.cart.clearItems();
        };



    }]);

app.factory("DataService", function () {

    // create store
    var myStore = new store();

    // create shopping cart
    var myCart = new shoppingCart("AngularStore");

    // enable PayPal checkout
    // note: the second parameter identifies the merchant; in order to use the 
    // shopping cart with PayPal, you have to create a merchant account with 
    // PayPal. You can do that here:
    // https://www.paypal.com/webapps/mpp/merchant
    myCart.addCheckoutParameters("PayPal", "paypaluser@youremail.com");

    // enable Google Wallet checkout
    // note: the second parameter identifies the merchant; in order to use the 
    // shopping cart with Google Wallet, you have to create a merchant account with 
    // Google. You can do that here:
    // https://developers.google.com/commerce/wallet/digital/training/getting-started/merchant-setup
    myCart.addCheckoutParameters("Google", "xxxxxxx",
            {
                ship_method_name_1: "UPS Next Day Air",
                ship_method_price_1: "20.00",
                ship_method_currency_1: "USD",
                ship_method_name_2: "UPS Ground",
                ship_method_price_2: "15.00",
                ship_method_currency_2: "USD"
            }
    );

    // enable Stripe checkout
    // note: the second parameter identifies your publishable key; in order to use the 
    // shopping cart with Stripe, you have to create a merchant account with 
    // Stripe. You can do that here:
    // https://manage.stripe.com/register
    myCart.addCheckoutParameters("Stripe", "pk_test_xxxx",
            {
                chargeurl: "https://localhost:1234/processStripe.aspx"
            }
    );

    // return data object with store and cart
    return {
        store: myStore,
        cart: myCart
    };
});

app.factory('UsuarioFactoryCompra', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/usuario/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@disId'}},
        delete: {method: 'DELETE', params: {id: '@id'}}
    });
});
app.factory('TarjetasFactoryCompra', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/tarjetacredito', {},
            {
                query: {method: 'GET', isArray: true},
                create: {method: 'POST'}

            });
});
app.factory('TarjetaFactoryCompra', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/tarjetacredito/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@disId'}},
        delete: {method: 'DELETE', params: {id: '@id'}},
        nextId: {method: 'GET', params: {id: 'nextId'}, isArray: false}
    });
});
app.factory('ComprasFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/compra', {},
            {
                query: {method: 'GET', isArray: true},
                create: {method: 'POST'}

            });
});
app.factory('CompraFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/compra/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@disId'}},
        delete: {method: 'DELETE', params: {id: '@id'}},
        nextId: {method: 'GET', params: {id: 'nextId'}, isArray: false}
    });
});

app.factory('bancos', function () {
    return {bancos: [{
                "nombre": "Bancolombia"
            }, {
                "nombre": "Davivienda"
            }, {
                "nombre": "Banco De Occidente"
            }, {
                "nombre": "AVvillas"
            }, {
                "nombre": "Colpatria"
            }, {
                "nombre": "Citibank"
            }, {
                "nombre": "Banco de Bogota"
            }, {
                "nombre": "Helm Bank"
            }, {
                "nombre": "Scotia Bank"
            }]



    }
});

//Producto diseñado
app.factory('ProductoDisenadosFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/productodisenado', {},
            {
                query: {method: 'GET', isArray: true},
                create: {method: 'POST'}

            });
});

app.factory('ProductoDisenadoFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/productodisenado/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@disId'}},
        delete: {method: 'DELETE', params: {id: '@id'}},
        nextId: {method: 'GET', params: {id: 'nextId'}, isArray: false}
    });
});

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

//ProDis por compra
app.factory('ProductosDisenadosPorCompraFactorysFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/proddisxcompra', {},
            {
                query: {method: 'GET', isArray: true},
                create: {method: 'POST'}

            });
});

app.factory('ProductosDisenadosPorCompraFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/proddisxcompra/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@disId'}},
        delete: {method: 'DELETE', params: {id: '@id'}},
        nextId: {method: 'GET', params: {id: 'nextId'}, isArray: false}
    });
});

//Producto
app.factory('ProductoFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/producto/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@proId'}},
        delete: {method: 'DELETE', params: {id: '@id'}},
        nextId: {method: 'GET', params: {id: 'nextId'}, isArray: false}
    });
});
