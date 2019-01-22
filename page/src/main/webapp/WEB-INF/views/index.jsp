<!DOCTYPE html>
<html lang="en" data-ng-app="store" data-ng-controller='mainController'>
<head>
    <meta charset="utf-8">
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Kahaberi.com</title>

    <!-- Favicon -->
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-144-precomposed.png">
    <link rel="shortcut icon" href="ico/favicon.ico">

    <!-- CSS Global -->
    <link rel="stylesheet" href="/js/plugins/bootstrap/css/bootstrap.min.css">
    <link href="/css/flexslider.css" rel="stylesheet">
    <link href="/js/plugins/fontawesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- Template CSS -->
    <link href="/css/template.css" rel="stylesheet">
    <!-- Head Libs -->

    <script src="/js/plugins/modernizr.custom.js"></script>

    <!--[if lt IE 9]>
    <script src="/js/plugins/iesupport/html5shiv.js"></script>
    <script src="/js/plugins/iesupport/respond.min.js"></script>
    <![endif]-->

</head>

<body id="home" class="wide">

<!-- PRELOADER -->
<div id="preloader">
    <div id="preloader-status">
        <div class="spinner">
            <div class="rect1"></div>
            <div class="rect2"></div>
            <div class="rect3"></div>
            <div class="rect4"></div>
            <div class="rect5"></div>
        </div>
        <div id="preloader-title">LOADING</div>
    </div>
</div>
<!-- /PRELOADER -->

<!-- HEADER -->
<header class="header fixed">
    <div class="header-wrapper top-bar">
        <div class="container-fluid">
            <div class="row">

                <div class="col-xs-2 col-sm-3">
                    <div class="menu-icon pull-left">
                        <a href="" data-ng-click="open_menu();">
                            <i class="fa fa-bars"></i>
                            <span class="hidden-xs">Menu</span>
                        </a>
                    </div>
                </div>

                <div class="col-xs-8 col-sm-6">
                    <!-- Logo -->
                    <div class="header-logo text-center">
                        <a href="#/" class="logo-text">
                           KAHABERI
                        </a>
                    </div>
                    <!-- /Logo -->
                </div>

                <div class="col-xs-2 col-sm-3">
                    <!-- Header shopping cart -->
                    <div class="header-cart pull-right">
                        <div class="cart-wrapper">
                            <a href="#/cart" class="">
                                <span class="cart">{{Global.total}}</span>
                                <span class="hidden-xs">Cart</span>
                            </a>
                        </div>
                    </div>
                    <!-- Header shopping cart -->
                </div>

            </div>

        </div>
    </div>
</header>
<!-- /HEADER -->

<!-- MAIN MENU OVERLAY -->
<div class="menu-overlay" data-ng-show="display_menu" data-ng-click="hide_menu()"></div>

<!-- MAIN MENU -->
<div class="main-menu" data-ng-show="display_menu">
    <div class="close-menu" data-ng-click="hide_menu()">
        <i class="fa fa-times"></i>
    </div>

    <ul>
        <li><a href="#/" data-ng-class="{ active: isActive('/') }">Home</a></li>
        <li><a href="#/shop" data-ng-class="{ active: isActive('/shop') }">Shop</a></li>
        <li><a href="#about" data-ng-class="{ active: isActive('/about') }">About</a></li>
        <li><a href="#/contact" data-ng-class="{ active: isActive('/contact') }">Contact</a></li>
    </ul>


    <ul class="submenu">
        <li><a href="">Return Policy</a></li>
        <li><a href="">Disclaimer</a></li>
    </ul>

    <div class="social-media">
        <a data-ng-href="{{facebook}}" target="_blank">
            <span><i class="fa fa-facebook"></i></span>
        </a>
        <a data-ng-href="{{pinterest}}" target="_blank">
            <span><i class="fa fa-pinterest"></i></span>
        </a>
        <a data-ng-href="{{google}}" target="_blank">
            <span><i class="fa fa-google-plus"></i></span>
        </a>
    </div>

</div>
<!-- /MAIN MENU -->

<!-- CONTENT AREA -->
<div data-ng-view class="content-area"></div>
<!-- /CONTENT AREA -->


<!-- JS -->

<script src="/js/plugins/jquery/jquery-1.12.4.min.js"></script>
<script src="/js/plugins/jquery/jquery.flexslider-min.js"></script>
<script src="/js/plugins/angular/angular.min.js"></script>
<script src="/js/plugins/angular/angular-route.min.js"></script>
<script src="/js/plugins/angular/angular-resource.min.js"></script>
<script src="/js/plugins/angular/angular-validator.min.js"></script>
<script src="/js/plugins/angular/ngStorage.min.js"></script>
<script src="/js/plugins/angular/ui-bootstrap-tpls-0.13.0.min.js"></script>
<script src="/js/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/js/plugins/stripe/checkout.js"></script>
<script src="/js/plugins/angular/angular-flexslider.js"></script>
<script src="/js/plugins/angular/ng-device-detector.min.js"></script>
<script src="/js/plugins/angular/re-tree.min.js"></script>
<script src="/js/routing.js"></script>
<script src="/js/productFactory.js"></script>
<script src="/js/main.js?v=1.0"></script>

</body>
</html>