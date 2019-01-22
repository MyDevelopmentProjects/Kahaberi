<div class="content-area">
    <section class="page-section">
        <div class="container-fluid container-shop">
            <div class="row">
                <div class="col-md-12 col-lg-12 content" id="content">
                    <!-- SHOP SORTING -->
                    <div class="shop-sorting">
                        <div class="row">
                            <div class="col-sm-12 text-center">
                                <span class="hidden-xs">Sort by</span>
                                <span class="select-wrapper hidden-xs">
                                    <select data-ng-model="highPrice" class='selectClass'>
                                        <option value="name">Product Name</option>
                                        <option value="-price">HIGHEST PRICE</option>
                                        <option value="price">LOWEST PRICE</option>
                                    </select>
                                </span>

                                <span>Show me</span>
                                <span class="select-wrapper {{selectExtraClassShop}}">
                                    <select data-ng-model="showCategory" data-ng-init="all">
                                        <option value="" selected>All Products</option>
                                        <option data-ng-repeat="cat in categories" value="{{cat}}">{{cat}}</option>
                                    </select>
                                </span>
                            </div>
                        </div>
                    </div>
                    <!-- /SHOP SORTING -->

                    <!-- PRODUCT GRID -->
                    <div class="row products grid">
                        <div class="col-md-4 col-sm-6 no-padding-col" id={{product.id}} data-ng-repeat="product in products">
                            <div class="thumbnail no-border no-padding">
                                <div class="media">
                                    <a class="media-link" href="#/products/{{product.id}}">
                                        <img ng-if="product.images" ng-src="{{product.images.toArr()[0]}}" alt=""/>
                                    </a>
                                </div>
                                <div class="caption text-center">
                                    <h4 class="caption-title">{{product.locale.localized().title}}</h4>
                                    <div class="price">{{product.price}}GEL</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /PRODUCT GRID -->
                </div>
            </div>
        </div>
    </section>
</div>
