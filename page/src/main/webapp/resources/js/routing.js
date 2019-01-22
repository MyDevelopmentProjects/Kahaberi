"use strict"; 

angular.module('routing', ['ngRoute'])

.config(function ($routeProvider) {
	$routeProvider
		.when('/', {
			controller: 'homeController',
			templateUrl: 'page/home'
		})
		.when('/shop', {
			templateUrl: 'page/shop'
		})
		.when('/products/:productId', {
			controller:'productDetail',
			templateUrl: 'page/product-detail'
		})
		.when('/cart', {
			controller:'cartController',
			templateUrl: 'page/cart'
		})
		.when('/about', {
			controller:'aboutController',
			templateUrl: 'page/about'
		})
		.when('/contact', {
			controller:'contactController',
			templateUrl: 'page/contact'
		})
		.when('/confirmation', {
			controller:'confirmationController',
			templateUrl: 'page/confirmation'
		})
		.otherwise({
			redirecTo: '/'
		});
    
})