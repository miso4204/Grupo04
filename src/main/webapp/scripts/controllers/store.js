/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("sbAdminApp");

app.controller('storeController',['$scope', 'ProductsFactory','$location','DataService',
    function ($scope, ProductsFactory, $location, DataService) {

   
    // get store and cart from service
    $scope.store = DataService.store;
    $scope.cart = DataService.cart;
    $scope.products = ProductsFactory.query();

    // use routing to pick the selected product
   }]);
   
app.controller('designController', ['$scope', 'DesignsFactory','$stateParams','ProductFactory', '$location',
    function ($scope, DesignsFactory, $stateParams, ProductFactory, $location) {
         
        $scope.desings = DesignsFactory.query();
        $scope.droppable = [];
        $scope.product = ProductFactory.show({id: $stateParams.productId});
        
    }]);

app.factory('ProductsFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/producto', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    })
});

app.factory('DesignsFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/diseno', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    })
});

app.factory('ProductFactory', function ($resource) {
    return $resource('/StampUreStyle2.0/webresources/producto/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@productId'}},
        delete: {method: 'DELETE', params: {id: '@id'}}
    })
});

app.factory("DataService", function () {

    // create store
    var myStore = new store();

    // create shopping cart
    var myCart = new shoppingCart("AngularStore");

    myCart.addCheckoutParameters("PayPal", "paypaluser@youremail.com");

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
