<div class="content-area">
    <section class="page-section">
        <div class="container-fluid full-height">
            <div class="row product-single full-height">
                <a href="#/shop">
                    <div class="all_products">
                        <span class="glyphicon glyphicon-th"></span>
                    </div>
                </a>

                <div class="col-md-6 text-center full-height relative min-height">
                    <div class="images-wrapper">
                        <img ng-if="productDetail.images" ng-src="{{imageUrl}}" alt="" class="imgdetail"/>
                        <div class="row">
                            <div class="hidden-xs col-sm-3"></div>
                            <div class="col-xs-4 col-sm-2" data-ng-repeat='img in productDetail.images.toArr()'>
                                <div class="img-product-detail">
                                    <a href="">
                                        <img class="full-width" data-ng-src="{{img}}" alt="" data-ng-click='setImage(img)' />
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 full-height filters-shop min-height">
                    <div class="product-name">
                        <h2 class="product-title">{{productDetail.locale.localized().title}}</h2>
                        <div class="product-price">{{productDetail.price}} GEL</div>
                    </div>
                    <div class="wrapper-info">
                        <div class="product-text">
                            {{productDetail.locale.localized().description}}
                        </div>
                        <div class="buttons relative">
                            <div>
                                <span class="select-wrapper-size">
                                    <select class="form-control size-select"
                                            ng-class='validate_category'
                                            ng-options="item.id as item.size for item in productDetail.sq"
                                            ng-model='selectedSQ'>
                                        <option value='' selected="selected">- Select Size -</option>
                                    </select>
                                </span>

                                <span class="input-group-btn" ng-if="isinstock(selectedSQ)">
                                    <button class="btn-theme btn-detail" data-ng-click="addProductDetails(productDetail)">Add to cart</button>
                                </span>
                            </div>
                            <label ng-if="!isinstock(selectedSQ)" class="out-stock-label">Out Stock</label>
                        </div>
                        <div data-ng-model="message" data-ng-show="showMessage" class="message fadein fadeout">{{message}}</div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

