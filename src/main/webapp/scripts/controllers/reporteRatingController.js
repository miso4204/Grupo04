'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */
angular.module('sbAdminApp')
  .controller('ReporteRatingCtrl', ['$scope', '$timeout', function ($scope, $timeout) {
    $scope.selectusuarios = {usuarios:[{
                id : 0,
                nombre : "Israel Parra",
                edad : "32 años",
                estampas:[{url:'./data/Barista_T_Shirt_Design_by_pamster88.jpg',rating:10},
                    {url:'./data/Rescues_Shirt_Design_Sehenuk.jpg',rating:4}]
            },
            {
                id : 1,
                nombre : "Andrés Cuenca",
                edad : "24 años",
                estampas:[{url:'./data/Barista_T_Shirt_Design_by_pamster88.jpg',rating:10},
                    {url:'./data/Batch_2012_Shirt_Design_by_LimeX.png',rating:8}]
            },
            {
                id : 2,
                nombre : "Juan Caceres",
                edad : "28 años",
                estampas:[{url:'./data/Rescues_Shirt_Design_Sehenuk.jpg',rating:7},
                    {url:'./data/estampa-otonal.jpg',rating:3}]
            },
            {
                id : 3,
                nombre : "Pepito Pérez",
                edad : "18 años",
                estampas:[{url:'./data/Barista_T_Shirt_Design_by_pamster88.jpg',rating:10},
                    {url:'./data/estampa1.jpg',rating:2}]
            },
            {
                id : 4,
                nombre : "Manuel Diaz",
                edad : "45 años",
                estampas:[{url:'./data/Rescues_Shirt_Design_Sehenuk.jpg',rating:10},
                    {url:'./data/estampa-otonal.jpg',rating:10}]
            }
            
    ],
 filtrar : function(id){
      console.log(id);
 }}
   
    ;
    $scope.line = {
	    labels: ['Enero', 'Febrero', 'Marzo', 'Abril'],
	    series: ['Israel Parra','Andrés Cuenca','Juan Caceres', 'Pepito Pérez', 'Manuel Diaz'],
	    data: [
                   [650, 590, 500, 840, 560],
		   [280, 480, 450, 190, 160],
                   [320, 230, 800, 810, 560],
		   [280, 560, 400, 190, 830],
                   [330, 440, 570, 870, 860]
	    ],
            toggle : function () 
    	{/*
    		this.series = this.series[1];*/
		}
    };

    $scope.bar = {
	    labels: ['Enero', 'Febrero', 'Marzo', 'Abril'],
	    series: ['Israel Parra','Andrés Cuenca','Juan Caceres', 'Pepito Pérez', 'Manuel Diaz'],
	    data: [
                   [650, 590, 500, 840, 560],
		   [280, 480, 450, 190, 160],
                   [320, 230, 800, 810, 560],
		   [280, 560, 400, 190, 830],
                   [330, 440, 570, 870, 860]
	    ]
    	
    };

    $scope.donut = {
    	labels: ["Download Sales", "In-Store Sales", "Mail-Order Sales"],
    	data: [300, 500, 100]
    };

    $scope.radar = {
    	labels:["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],

    	data:[
    	    [65, 59, 90, 81, 56, 55, 40],
    	    [28, 48, 40, 19, 96, 27, 100]
    	]
    };

    $scope.pie = {
    	labels : ["Download Sales", "In-Store Sales", "Mail-Order Sales"],
    	data : [300, 500, 100]
    };

    $scope.polar = {
    	labels : ["Download Sales", "In-Store Sales", "Mail-Order Sales", "Tele Sales", "Corporate Sales"],
    	data : [300, 500, 100, 40, 120]
    };

    $scope.dynamic = {
    	labels : ["Download Sales", "In-Store Sales", "Mail-Order Sales", "Tele Sales", "Corporate Sales"],
    	data : [300, 500, 100, 40, 120],
    	type : 'PolarArea',

    	toggle : function () 
    	{
    		this.type = this.type === 'PolarArea' ?
    	    'Pie' : 'PolarArea';
		}
    };
    $scope.usuarios = [{
                id : 0,
                nombre : "Israel Parra",
                edad : "32 años"
            },
            {
                id : 1,
                nombre : "Andrés Cuenca",
                edad : "24 años"
            },
            {
                id : 2,
                nombre : "Juan Carlos",
                edad : "28 años"
            },
            {
                id : 3,
                nombre : "Pepito",
                edad : "18 años"
            },
            {
                id : 4,
                nombre : "Manuel",
                edad : "45 años"
            }
    ];
}]);