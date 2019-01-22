"use strict"; 

var productFactory = angular.module('productFactory', []);

productFactory.factory('productFactory', '$http', function ($http) {

    var productFactory = {};

    productFactory.products = [
        {
            productId: 1,
            name: "Product1",
            category: "Tennis",
            desc: "Lorem ipsum dolor sit amet, consecte tuer ad ipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculu.",
            image: "placeholder1.png;placeholder2.png;placeholder3.png",
            price: 30,
            qty: 6,
            variation: ""
        }
    ];

    return productFactory;
});