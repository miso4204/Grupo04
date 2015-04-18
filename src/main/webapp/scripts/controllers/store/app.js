'use strict';

// App Module: the name AngularStore matches the ng-app attribute in the main <html> tag
// the route provides parses the URL and injects the appropriate partial page
var storeApp = angular.module('AngularStore', []).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/store', {
        templateUrl: 'partials/store.html',
        controller: storeController 
      }).
      when('/products/:productSku', {
        templateUrl: 'partials/product.html',
        controller: storeController
      }).
      when('/cart', {
        templateUrl: 'partials/shoppingCart.html',
        controller: storeController
      }).
      otherwise({
        redirectTo: '/store'
      });
}]);

