"use strict";

var app = angular.module('store', ['routing', 'ngStorage', 'ui.bootstrap', 'angularValidator', 'ngResource', 'angular-flexslider', 'productFactory', 'ng.deviceDetector']);

app.run(function ($rootScope) {

    //Switch this value between your test and live Publishable key
    $rootScope.key = 'pk_test_nwAgb18io4WLRQx5SNob1P8G';
    $rootScope.currentLang = "GE"
    //Change this values for your social medias
    $rootScope.facebook = 'http://facebook.com';
    $rootScope.pinterest = 'https://www.pinterest.com/';
    $rootScope.google = 'https://plus.google.com';

    //Change this value for your real email. Used to display it on confirmation page
    $rootScope.email_contact = 'info@email.com';

    $rootScope.$on('$routeChangeSuccess', function (event, current) {
        if (current.$$route.originalPath != "/" && $(window).width() < 768)
            $('.header-wrapper').addClass('mobile-top-bar');
        else
            $('.header-wrapper').removeClass('mobile-top-bar');
    });

    Array.prototype.localized = function () {
        if (!this || this.length === 0) return {}
        for (var i = 0; i < this.length; i++) {
            if (this[i].lang.shortCode === $rootScope.currentLang) {
                return this[i]
            }
        }
        return {}
    };

    Array.prototype.first = function () {
        debugger
        if (!this || this.length === 0) return null
        return this[0]
    };

    Array.prototype.firstObj = function () {
        if (!this || this.length === 0) return {}
        return this[0]
    };

    String.prototype.toObj = function () {
        if (!this || this.length === 0) return {}
        return JSON.parse(this)
    };

    String.prototype.toArr = function () {
        if (!this || this.length === 0) return []
        return JSON.parse(this)
    };
});

app.service("Global", function () {
    this.total = 0;
});


app.factory('httpInterceptor', function ($q, $rootScope, $localStorage) {
    var numLoadings = 0;
    return {
        request: function (config) {
            numLoadings++;
            $rootScope.$broadcast("loader_show");

            config.headers = config.headers || {};
            //delete $localStorage.token;
            if ($localStorage.token) {
                config.headers['Authorization'] = $localStorage.token;
                $rootScope.loggedIn = true;
            } else {
                $rootScope.loggedIn = false;
            }
            return config;
        },
        response: function (response) {
            if ((--numLoadings) === 0) {
                $rootScope.$broadcast("loader_hide");
            }
            return response || $q.when(response);
        },
        responseError: function (rejection) {
            if (!(--numLoadings)) {
                $rootScope.$broadcast("loader_hide");
            }


            // otherwise, default behaviour
            return $q.reject(rejection);
        }
    };
})
    .config(function ($httpProvider) {
        $httpProvider.interceptors.push('httpInterceptor');
    })
    .directive("loader", function ($rootScope) {
        return function ($scope, element, attrs) {
            $scope.$on("loader_show", function () {
                return element.show();
            });
            return $scope.$on("loader_hide", function () {
                return element.hide();
            });
        };
    });

app.service('GridManager', function ($http, $cacheFactory) {

    this.clearCache = function (q) {
        var $httpDefaultCache = $cacheFactory.get('$http');
        $httpDefaultCache.remove(q);
    };

    this.givePowerTo = function ($scope, pageSize) {
        setTimeout(function () {
            var scope = angular.element($(".top-menu-items")).scope();
            if (scope) {
                scope.app.topMenuItems = [];
            }
        }, 1100);
        $scope.AmfTable = {};
        if (pageSize != undefined) {
            $scope.AmfTable.pageSize = pageSize;
        } else {
            $scope.AmfTable.pageSize = 20;
        }
        $scope.AmfTable.openPage = this.openPage;
        $scope.AmfTable.pageChanged = this.pageChanged;
        $scope.AmfTable.sortBy = this.sortBy;
        $scope.AmfTable.reloadData = this.reloadData;
        $scope.AmfTable.invalidateCache = this.invalidateCache;
        $scope.AmfTable.textSearch = this.textSearch;
        $scope.AmfTable.textSearchExecute = this.textSearchExecute;
        $scope.AmfTable.pageSetUp = this.pageSetUp;
        $scope.AmfTable.setSelected = this.setSelected;
        $scope.AmfTable.selected = 0;
        $scope.AmfTable.scope = $scope;
        $scope.selected = 0;
        $scope.meta = [];
    };


    this.setSelected = function ($index) {
        this.scope.selected = $index;
    };

    this.pageChanged = function (page) {
        var table = this.scope;
        table.AmfTable.openPage(page - 1);
    };

    this.openPage = function (page) {
        var table = this.scope;
        table.AmfTable.page = page;
        table.AmfTable.currentPage = page + 1;
        table.AmfTable.reloadData();
    };

    this.textSearch = function (typeTimeOut) {
        var table = this.scope;
        if (typeTimeOut == undefined) {
            typeTimeOut = 300;
        }
        table.AmfTable.lastTypeTime = (new Date()).getTime();
        var searchStr = angular.copy(table.AmfTable.searchString);
        setTimeout(function () {
            table.AmfTable.textSearchExecute(table, typeTimeOut, searchStr);
        }, typeTimeOut + 50);
    };

    this.textSearchExecute = function (table, typeTimeOut, searchString) {
        if (this.searchString != searchString) return;
        var curTime = (new Date()).getTime();
        if (curTime - table.AmfTable.lastTypeTime >= typeTimeOut) {
            table.AmfTable.page = 0;
            table.AmfTable.currentPage = 1;
            table.AmfTable.reloadData();
        }
    };

    this.sortBy = function (sortBy, isAsc) {
        var table = this.scope;
        if (table.AmfTable.sortColumn == sortBy) {
            table.AmfTable.sortDir = table.AmfTable.sortDir == 'asc' ? 'desc' : 'asc';
        } else {
            table.AmfTable.sortColumn = sortBy;
            table.AmfTable.sortDir = (isAsc === undefined) ? 'asc' : (isAsc) ? 'desc' : 'asc';
        }

        table.AmfTable.page = 0;
        table.AmfTable.currentPage = 1;

        table.AmfTable.reloadData(true);
    };

    this.pageSetUp = function () {
        pageSetUp();
    };

    this.invalidateCache = function () {
        $cacheFactory.get('$http').removeAll();
    };

    this.reloadData = function (clear) {

        var table = this.scope;
        var query = [];
        query.pageNumber = table.AmfTable.page >= 0 ? table.AmfTable.page : 0;
        query.sortField = table.AmfTable.sortColumn;
        query.isAscending = (table.AmfTable.sortDir == 'asc');
        query.searchExpression = table.AmfTable.searchString === undefined ? "" : table.AmfTable.searchString;
        query.pageSize = table.AmfTable.pageSize;
        if (table.AmfTable.customFilters != undefined) {
            var customFilters = table.AmfTable.customFilters;
            for (var p in customFilters)
                query[customFilters[p].key] = customFilters[p].value;
        }
        if (clear) {
            table.data = [];
            var q = table.url;
            if (this.scope.AmfTable.customFilters != undefined) {
                var customFilters = this.scope.AmfTable.customFilters;
                q += '?';
                for (var p in customFilters)
                    q = customFilters[p].key + '=' + customFilters[p].value + '&';
            } else {
                q = q + '?';
            }
            q += 'isAscending=' + query.isAscending + '&pageNumber=' + query.pageNumber + '&pageSize=' + query.pageSize + '&sortField=' + query.sortField;
            var str = q.substr(0, q.indexOf('&sortField'));
            var cf = $cacheFactory.get('$http');
            cf.remove(q.split('?')[0]);
            cf.remove(q);
            cf.remove(str);
        }
        $http({
            url: table.url,
            method: 'GET',
            params: query
            /*cache: true */
        }).success(function (data) {
            if (data.results && data.results.length == 0 && table.AmfTable.page > 0) {
                table.AmfTable.page = 0;
                table.AmfTable.reloadData();
                if (data.results && data.results.length == 0) {

                }
            } else if (data.results && data.results.length == 0) {
                table.AmfTable.page = -1;
                table.AmfTable.totalItems = 0;
                table.data = data;
            } else {
                table.data = data;
                table.AmfTable.totalItems = data.maxPages * table.AmfTable.pageSize;
                if (table.AmfTable.doOnReload != undefined) {
                    table.AmfTable.doOnReload();
                }
                if (table.AmfTable.refreshBulkActions != undefined) {
                    table.AmfTable.refreshBulkActions();
                }
            }
            table.AmfTable.currentPage = table.AmfTable.page + 1;
        });
    };

    this.loadMetaData = function ($scope, meta) {
        if (meta)
            $scope.meta = JSON.parse(meta);
    };

});

app.service('ModalManager', function ($rootScope, $sce) {

    this.enableModals = function ($scope) {
        $scope.showSuccess = this.showSuccess;
        $scope.showError = this.showError;
    };

    this.showSuccess = function (message, notify) {
        if (notify) {
            $.notify(message, "success");
        } else {
            swal("მოთხოვნა შესრულებულია", message, "success");
        }
    };

    this.showError = function (message, notify) {
        if (notify) {
            $.notify(message, "error");
        } else {
            swal("მოთხოვნა უარყოფილია", message, "error");
        }
    };


});

app.controller('homeController', ['$scope', function ($scope) {

    //Replace each url with your images path to be use on the slider
    $scope.sliders = [
        {url: '/img/slider1.jpg'},
        {url: '/img/slider2.jpg'},
        {url: '/img/slider3.jpg'}
    ];

}]);

app.controller('mainController',
    ['$scope', '$localStorage', '$rootScope', 'Global', '$location', 'deviceDetector', '$http',
        function ($scope, $localStorage, $rootScope, Global, $location, deviceDetector, $http) {

            $rootScope.display_menu = false;

            $scope.facebook = $rootScope.facebook;
            $scope.pinterest = $rootScope.pinterest;
            $scope.google = $rootScope.google;

            $scope.open_menu = function () {
                $rootScope.display_menu = true;
            };

            $scope.hide_menu = function () {
                $rootScope.display_menu = false;
            };

            $scope.isActive = function (viewLocation) {
                var active = (viewLocation === $location.path());
                return active;
            };

            $scope.Global = Global;
            $scope.Global.total = $localStorage.myTotal || 0;

            $scope.cart = $localStorage.myObj || [];

            $scope.products = [];
            $scope.categories = [];
            $scope.newestProduct = [];
            $scope.clientId = $rootScope.clientId;
            $scope.highPrice = 'name';


            $('#preloader').delay(200).fadeOut(200);

            $scope.loadimage = function (img) {
                var res = img;
                if (typeof (img) !== 'undefined' && img !== '') {
                    var list = img.split(';');

                    if (list.length > 0)
                        res = list[0];
                    return "/img/" + res;
                }
            };

            $scope.changeQty = function (qty, index) {
                $scope.allCart = $localStorage.myObj;
                $scope.Global.total = $localStorage.myTotal;
                $scope.otroTotal = 0;

                if ($scope.allCart[index].productQty > 0) {
                    for (var i = 0; i < $scope.allCart.length; i++) {
                        $scope.otroTotal += $scope.allCart[i].productPrice * $scope.allCart[i].productQty;
                        $localStorage.myTotal = $scope.otroTotal;
                    }
                } else {
                    $scope.allCart[index].productQty = 1;
                    return false;
                }
                $scope.Global.total = $scope.otroTotal;
            };

            var vm = this;
            vm.data = deviceDetector;
            vm.allData = JSON.stringify(vm.data, null, 2);

            $scope.selectExtraClassDetail = '';
            $scope.selectExtraClassShop = '';

            if (vm.data.device === "iphone" || vm.data.device === "ipad") {
                $scope.selectExtraClassDetail = 'selectExtraClassDetail';
                $scope.selectExtraClassShop = 'selectExtraClassShop';
            }

            $http.get('/menu-item/list').success(function (response) {
                $scope.products = response.content;
            })

        }]);

app.controller('cartController', ['$scope', '$localStorage', 'Global', '$rootScope', '$window', function ($scope, $localStorage, Global, $rootScope, $window) {

    $('.header-wrapper').addClass('top-bar');

    $scope.Global = Global;
    $scope.Global.total = $localStorage.myTotal || 0;
    $scope.allCart = $localStorage.myObj || '';

    $scope.countCart = $scope.allCart.length;

    if ($scope.countCart === 1) {
        $scope.customColumn = 'col-md-offset-3 col-md-6';
    } else if ($scope.countCart === 2) {
        $scope.customColumn = 'col-md-6';
    } else {
        $scope.customColumn = 'col-md-4';
    }

    $scope.counterPlus = function (qty, index) {
        $scope.otroTotal = 0;
        $scope.allCart[index].productQty = qty + 1;

        for (var i = 0; i < $scope.allCart.length; i++) {
            $scope.otroTotal += $scope.allCart[i].productPrice * $scope.allCart[i].productQty;
            $localStorage.myTotal = $scope.otroTotal;
        }
        $scope.Global.total = $scope.otroTotal;
    };

    $scope.counterMinus = function (qty, index) {

        $scope.otroTotal = 0;
        $scope.allCart[index].productQty = qty - 1;

        if ($scope.allCart[index].productQty > 0) {
            for (var i = 0; i < $scope.allCart.length; i++) {
                $scope.otroTotal += $scope.allCart[i].productPrice * $scope.allCart[i].productQty;
                $localStorage.myTotal = $scope.otroTotal;
            }
        } else {
            $scope.allCart[index].productQty = 1;
            return false;
        }
        $scope.Global.total = $scope.otroTotal;
    };


    $scope.deleteProductCart = function (index, price, qty) {

        $scope.allCart = $localStorage.myObj;
        $scope.allCart.splice(index, 1);


        $scope.Global.total -= price * qty;
        $localStorage.myTotal = $scope.Global.total;

        if ($scope.allCart.length === 0) {
            $scope.myCart = false;
            $scope.message = true;
        } else {
            $scope.myCart = true;
            $scope.message = false;
        }
    };

    if (typeof ($scope.allCart) === 'undefined' || $scope.allCart.length === 0) {
        $scope.myCart = false;
        $scope.message = true;
    } else {
        $scope.myCart = true;
        $scope.message = false;
    }

    $scope.stripePayment = function () {

        $scope.key = $rootScope.key;
        $scope.totalStripe = Global.total * 100;

        var handler = StripeCheckout.configure({
            key: $scope.key,
            image: '',
            locale: 'auto',
            token: function (token) {

                var dataStripe = {
                    tokenId: token.id,
                    email: token.email,
                    amount: $scope.totalStripe
                };

                $.ajax({
                    url: 'stripeIntegration/stripe.php',
                    data: dataStripe
                })
                    .done(function (res) {
                        try {
                            var data = JSON.parse(res);
                            if (data.status === 1) {
                                $window.location.href = '#/confirmation';
                            }
                        }
                        catch (e) {
                            return false;
                        }

                    })
                    .fail(function (error) {
                        console.log(error);
                    })
            }
        });

        handler.open({
            name: 'KAHABERI SHOP',
            amount: $scope.totalStripe
        });

        $(window).on('popstate', function () {
            handler.close();
        });
    };


}]);

app.controller('productDetail', function ($scope, $http, $routeParams, $localStorage, $rootScope, $timeout) {

    $scope.productDetail = {};
    $scope.selectedSQ = 0;

    $scope.isinstock = function (sqid) {
        if (!$scope.productDetail || !$scope.productDetail.sq) return false;
        var sqs = $scope.productDetail.sq;
        for (var i = 0; i < sqs.length; i++) {
            if (sqs[i].id === parseInt(sqid)) {
                return sqs[i].quantity > 0
            }
        }
        return false
    };

    $scope.gocart = function () {
        window.location.href = '/#/cart';
    };

    $scope.setImage = function (img) {
        $scope.imageUrl = img;
    };

    if ($scope.cart.length > 0)
        $scope.showcart = true;
    else
        $scope.showcart = false;

    $scope.addProductDetails = function (product) {

        var price = product.price;
        var id = product.id;
        var name = product.locale.localized().title;
        var path = $scope.imageUrl;

        $scope.showcart = true;
        $scope.Global.total += price;
        $localStorage.myTotal = $scope.Global.total;
        $scope.flag = true;


        if ($scope.cart.length > 0) {

            for (var i = 0; i < $scope.cart.length; i++) {
                if ($scope.cart[i].productId === id) {
                    $scope.cart[i].productQty++;
                    $scope.flag = false;
                    break;
                }
            }

            if ($scope.flag === true) {
                $localStorage.myObj.push({
                    productPrice: price,
                    productId: id,
                    productName: name,
                    productImage: path,
                    productQty: 1
                });
            }

        }
        else {
            $scope.cart.push({
                productPrice: price,
                productId: id,
                productName: name,
                productImage: path,
                productQty: 1
            });
            $localStorage.myObj = $scope.cart;
        }

        $scope.message = 'Product Added To Cart';
        $scope.showMessage = true;

        $timeout(function () {
            $scope.showMessage = false;
        }, 3000);

    };

    $http.get('/menu-item/detail?id=' + $routeParams.productId).success(function (response) {
        $scope.productDetail = response;
        $scope.setImage($scope.productDetail.images.toArr()[0])
    })

});

app.controller('aboutController', ['$scope', "$rootScope", function ($scope, $rootScope) {

    $scope.facebook = $rootScope.facebook;
    $scope.pinterest = $rootScope.pinterest;
    $scope.google = $rootScope.google;

}]);

app.controller('contactController', ['$scope', "$http", function ($scope, $http) {

    $scope.submitMyForm = function () {

        $http({
            method: 'POST',
            url: '../../mail/contact_form.php',
            data: $.param($scope.form),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function (data) {
            if (data.success === true) {
                $scope.msg_error = 'msg_true';
            } else {
                $scope.msg_error = 'msg_false';
            }
            $scope.message = data.message;
            $scope.contactForm.reset();
        })
            .error(function (e) {
                console.log(e);
            });
    };

}]);

app.controller('confirmationController', function ($scope, $rootScope) {

    $scope.email_confirmation = $rootScope.email_contact;

});








