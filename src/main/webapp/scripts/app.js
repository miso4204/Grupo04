'use strict';
/**
 * @ngdoc overview
 * @name sbAdminApp
 * @description
 * # sbAdminApp
 *
 * Main module of the application.
 */

angular
        .module('sbAdminApp', [
            'ngCookies',
            'oc.lazyLoad',
            'ui.router',
            'ui.bootstrap',
            'angular-loading-bar',
            'ngResource'
        ])
        .config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider', function ($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {

                $ocLazyLoadProvider.config({
                    debug: false,
                    events: true,
                });

                $urlRouterProvider.otherwise('/login');

                $stateProvider
                        .state('dashboard', {
                            url: '/dashboard',
                            templateUrl: 'views/dashboard/main.html',
                            resolve: {
                                loadMyDirectives: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(
                                            {
                                                name: 'sbAdminApp',
                                                files: [
                                                    'scripts/directives/header/header.js',
                                                   'scripts/directives/header/header-notification/header-notification.js',
                                                    'scripts/directives/sidebar/sidebar.js',
                                                    'scripts/directives/sidebar/sidebar-search/sidebar-search.js'
                                                ]
                                            }),
                                            $ocLazyLoad.load(
                                                    {
                                                        name: 'toggle-switch',
                                                        files: ["bower_components/angular-toggle-switch/angular-toggle-switch.min.js",
                                                            "bower_components/angular-toggle-switch/angular-toggle-switch.css"
                                                        ]
                                                    }),
                                            $ocLazyLoad.load(
                                                    {
                                                        name: 'ngAnimate',
                                                        files: ['bower_components/angular-animate/angular-animate.js']
                                                    })
                                    $ocLazyLoad.load(
                                            {
                                                name: 'ngCookies',
                                                files: ['bower_components/angular-cookies/angular-cookies.js']
                                            })
                                    $ocLazyLoad.load(
                                            {
                                                name: 'ngResource',
                                                files: ['bower_components/angular-animate/angular-animate.js']
                                            })
                                    $ocLazyLoad.load(
                                            {
                                                name: 'ngSanitize',
                                                files: ['bower_components/angular-sanitize/angular-sanitize.js']
                                            })
                                    $ocLazyLoad.load(
                                            {
                                                name: 'ngTouch',
                                                files: ['bower_components/angular-touch/angular-touch.js']
                                            })
                                }
                            }
                        })
                        .state('dashboard.home', {
                            url: '/home',
                            controller: 'MainCtrl',
                            templateUrl: 'views/dashboard/home.html',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/main.js',
                                            'scripts/directives/dashboard/stats/stats.js'
                                        ]
                                    })
                                }
                            }
                        })
                        .state('dashboard.products', {
                            templateUrl: 'views/store/products.html',
                            controller: 'storeController',
                            url: '/products',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'AngularStore',
                                        files: [
                                            'scripts/controllers/store/app.js',
                                            'scripts/controllers/store.js',
                                            'scripts/controllers/store/product.js',
                                            'scripts/controllers/store/shoppingCart.js',
                                            'scripts/controllers/store/store.js'
                                        ]
                                    })
                                }
                            }

                        })
                        .state('dashboard.cart', {
                            templateUrl: 'views/store/shoppingCart.html',
                            controller: 'storeController',
                            url: '/cart',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'AngularStore',
                                        files: [
                                            'scripts/controllers/store/app.js',
                                            'scripts/controllers/store/controller.js',
                                            'scripts/controllers/store/product.js',
                                            'scripts/controllers/store/shoppingCart.js',
                                            'scripts/controllers/store/store.js'
                                        ]
                                    })
                                }
                            }
                        })
                          .state('dashboard.designs', {
                            templateUrl: 'views/store/designs.html',
                            controller: 'designController',
                            url: '/designs/:productId',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'AngularStore',
                                        files: [
                                            'scripts/controllers/store/app.js',
                                            'scripts/controllers/store.js',
                                            'scripts/controllers/store/product.js',
                                            'scripts/controllers/store/shoppingCart.js',
                                            'scripts/controllers/store/store.js',
                                            'scripts/directives/store/designs.js',
                                            'bower_components/angular-dragdrop/angular-dragdrop.js',
                                            'bower_components/angular-dragdrop/designs.css'
                                        ]
                                    })
                                }
                            }
                        }).state('dashboard.diseno-list', {
                            templateUrl: 'views/diseno/diseno-list.html',
                            url: '/diseno-list',
                            controller: 'DisenoCtrl',
                              resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/disenoController.js'
                                        ]
                                    });
                                }
                            }
                        })
                          .state('dashboard.diseno-create', {
                            templateUrl: 'views/diseno/diseno-create.html',
                            url: '/diseno-create',
                            controller: 'DisenoCtrl',
                              resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/disenoController.js'
                                        ]
                                    });
                                }
                            }
                        }).state('dashboard.producto-list', {
                            templateUrl: 'views/producto/producto-list.html',
                            url: '/producto-list',
                            controller: 'ProductoCtrl',
                              resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/productoController.js'
                                        ]
                                    });
                                }
                            }
                        })
                          .state('dashboard.producto-create', {
                            templateUrl: 'views/producto/producto-create.html',
                            url: '/producto-create',
                            controller: 'ProductoCtrl',
                              resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/productoController.js'
                                        ]
                                    });
                                }
                            }
                        }).state('dashboard.oferta-list', {
                            templateUrl: 'views/oferta/oferta-list.html',
                            url: '/oferta-list',
                            controller: 'OfertaCtrl',
                              resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/ofertaController.js'
                                        ]
                                    });
                                }
                            }
                        }).state('dashboard.oferta-edit', {
                            templateUrl: 'views/oferta/oferta-edit.html',
                            url: '/oferta-edit',
                            controller: 'OfertaCtrl',
                              resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/ofertaController.js'
                                        ]
                                    });
                                }
                            }
                        })
                          .state('dashboard.oferta-create', {
                            templateUrl: 'views/oferta/oferta-create.html',
                            url: '/oferta-create',
                            controller: 'OfertaCtrl',
                              resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/ofertaController.js'
                                        ]
                                    });
                                }
                            }
                        })                             
                        .state('dashboard.reporte-ventas', {
                            templateUrl: 'views/reporte-ventas.html',
                            url: '/reporte-ventas',
                            controller: 'ReporteVentasCtrl',
                            resolve: {
                                loadMyFile: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(
                                            'bower_components/Chart.js/Chart.min.js'
                                            ),
                                            $ocLazyLoad.load({
                                                name: 'chart.js',
                                                files: [
                                                    'bower_components/angular-chart.js/dist/angular-chart.min.js',
                                                    'bower_components/angular-chart.js/dist/angular-chart.css'
                                                ]
                                            }),
                                            $ocLazyLoad.load({
                                                name: 'sbAdminApp',
                                                files: ['scripts/controllers/reporteVentasController.js']
                                            })
                                }
                            }
                        })
                        .state('dashboard.reporte-rating', {
                            templateUrl: 'views/reporte-rating.html',
                            url: '/reporte-rating',
                            controller: 'ReporteRatingCtrl',
                            resolve: {
                                loadMyFile: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(
                                            'bower_components/Chart.js/Chart.min.js'
                                            ),
                                            $ocLazyLoad.load({
                                                name: 'sbAdminApp',
                                                files: ['scripts/controllers/reporteRatingController.js']
                                            })
                                }
                            }
                        })
                        .state('login', {
                            templateUrl: 'views/pages/login.html',
                            url: '/login',
                            controller:'loginController',
                              resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/login.js',
                                            'scripts/factories/usuarios.js'
                                            
                                           
                                        ]
                                    })
                                }
                            }
                        })
                         .state('loginBad', {
                            templateUrl: 'views/pages/loginBad.html',
                            url: '/loginBad',
                            controller:'loginController',
                              resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/login.js',
                                            'scripts/factories/usuarios.js'
                                            
                                        ]
                                    })
                                }
                            }
                        })
                        .state('dashboard.chart', {
                            templateUrl: 'views/chart.html',
                            url: '/chart',
                            controller: 'ChartCtrl',
                            resolve: {
                                loadMyFile: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(
                                            'bower_components/Chart.js/Chart.min.js'
                                            ),
                                            $ocLazyLoad.load({
                                                name: 'chart.js',
                                                files: [
                                                    'bower_components/angular-chart.js/dist/angular-chart.min.js',
                                                    'bower_components/angular-chart.js/dist/angular-chart.css'
                                                ]
                                            }),
                                            $ocLazyLoad.load({
                                                name: 'sbAdminApp',
                                                files: ['scripts/controllers/chartContoller.js']
                                            })
                                }
                            }
                        })
                        .state('dashboard.prueba', {
                            templateUrl: 'views/prueba.html',
                            url: '/prueba',
                            controller: 'factoriaController',
                            resolve: {
                                loadMyFile: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: ['scripts/controllers/login.js']
                                    })
                                }
                            }
                        }) 
//---------------------------------------------------------------------------------------                
              // states para pagos pse @author alejandroquintero
                        .state('dashboard.compra', {
                            templateUrl: 'views/pagos/compra.html',
                            controller: 'pseController',
                            url: '/compra',
                             resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/Pagos/pseCtrls.js',
                                            'scripts/factories/pseFactories.js'
                                        ]
                                    })
                                }
                            }
                        })
                         .state('dashboard.Bankpage', {
                            templateUrl: 'views/pagos/Bankpage.html',
                            url: '/Bankpage',
                            controller:'pseController',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/Pagos/pseCtrls.js',
                                            'scripts/factories/pseFactories.js'
                                        ]
                                    })
                                }
                            }
                        })
                          .state('dashboard.info', {
                            templateUrl: 'views/pagos/info.html',
                            url: '/info'
                            
                        })
                          .state('dashboard.cuenta', {
                            templateUrl: 'views/pagos/cuenta.html',
                            url: '/cuenta',
                           controller:'pseController',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/Pagos/pseCtrls.js',
                                            'scripts/factories/pseFactories.js'
                                        ]
                                    })
                                }
                            } 
                        })
                        .state('dashboard.confirmacion', {
                            templateUrl: 'views/pagos/confirmacion.html',
                            url: '/confirmacion',
                            controller: 'pseController',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/Pagos/pseCtrls.js',
                                            'scripts/factories/pseFactories.js'
                                        ]
                                    })
                                }
                            }
                        })
                        .state('dashboard.summary', {
                            templateUrl: 'views/pagos/summary.html',
                            url: '/summary',
                            controller: 'ShareCtrl',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/shareController.js'
                                        ]
                                    });
                                }
                            }
                        })
                // fin de states para pagos pse @author alejandroquintero
//-------------------------------------------------------------------------------------------------------                          
                //inicio states para crud de usuario @author alejandroquintero
                    
                  
                        .state('dashboard.myPerfil', {
                            templateUrl: 'views/Usuarios/myPerfil.html',
                            url: '/myPerfil',
                            controller: 'newAccount',
                             resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/factories/usuarios.js',
                                            'scripts/factories/password.js',
                                            'scripts/factories/direccion.js',
                                            'scripts/controllers/login.js',
                                            'scripts/controllers/Usuarios/usuCtrl.js',
                                            'scripts/controllers/updateProfile/passCtrl.js',
                                            'scripts/controllers/updateProfile/direCtrl.js'
                                        ]
                                    })
                                }
                            }
                        })
                                .state('dashboard.adminListar', {
                            templateUrl: 'views/adminUsuarios/listar.html',
                            url: '/administrador',
                             controller: 'newAccount',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/Usuarios/usuCtrl.js',
                                            'scripts/factories/usuarios.js',
                                            'scripts/controllers/login.js'
                                        ]
                                    })
                                }
                            }
                        })
                         
                           
                        
          //fin de states para crud de usuario @author alejandroquintero
//--------------------------------------------------------------------------------------------------------          
                        .state('dashboard.panels-wells', {
                            templateUrl: 'views/ui-elements/panels-wells.html',
                            url: '/panels-wells'

                        })
                        .state('dashboard.user-list', {
                            templateUrl: 'views/user-list.html',
                            url: '/user-list',
                            controller: 'UserListCtrl',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/controllers.js'
                                        ]
                                    })
                                }
                            }
                        })
                        .state('dashboard.user-creation', {
                            templateUrl: 'views/user-creation.html',
                            url: '/user-creation',
                            controller: 'UserCreationCtrl',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/controllers.js'
                                        ]
                                    })
                                }
                            }
                        })
                        .state('dashboard.user-detail', {
                            templateUrl: 'views/user-detail.html',
                            url: '/user-detail/:userId',
                            controller: 'UserDetailCtrl',
                            resolve: {
                                loadMyFiles: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        name: 'sbAdminApp',
                                        files: [
                                            'scripts/controllers/controllers.js'
                                        ]
                                    })
                                }
                            }
                        })

                        .state('dashboard.buttons', {
                            templateUrl: 'views/ui-elements/buttons.html',
                            url: '/buttons'
                        })
                        .state('dashboard.notifications', {
                            templateUrl: 'views/ui-elements/notifications.html',
                            url: '/notifications'
                        })
                        .state('dashboard.typography', {
                            templateUrl: 'views/ui-elements/typography.html',
                            url: '/typography'
                        })
                        .state('dashboard.icons', {
                            templateUrl: 'views/ui-elements/icons.html',
                            url: '/icons'
                        })
                        .state('dashboard.grid', {
                            templateUrl: 'views/ui-elements/grid.html',
                            url: '/grid'
                        });
            }]);


