var argv = require('yargs').argv;
var path = require('path');
var webpack = require('webpack');
var dir = path.resolve();

var ExtractTextPlugin = require('extract-text-webpack-plugin');
var OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin');
//var ModernizrWebpackPlugin = require('modernizr-webpack-plugin');
var AngularCompilerPlugin = require('@ngtools/webpack');

module.exports = {
    entry: {
        bundle : [ 
            // dir + '/page/src/main/webapp/resources/js/plugins/modernizr.custom.js',
            // dir + '/page/src/main/webapp/resources/js/plugins/iesupport/respond.min.js',

            dir + '/page/src/main/webapp/resources/js/plugins/iesupport/html5shiv.js',            
            dir + '/page/src/main/webapp/resources/js/plugins/jquery/jquery-1.12.4.min.js',
            dir + '/page/src/main/webapp/resources/js/plugins/jquery/jquery.flexslider-min.js',
            dir + '/page/src/main/webapp/resources/js/plugins/angular/angular.min.js',
            dir + '/page/src/main/webapp/resources/js/plugins/angular/angular-route.min.js',
            dir + '/page/src/main/webapp/resources/js/plugins/angular/angular-resource.min.js',
            dir + '/page/src/main/webapp/resources/js/plugins/angular/angular-validator.min.js',
            dir + '/page/src/main/webapp/resources/js/plugins/angular/ngStorage.min.js',
            dir + '/page/src/main/webapp/resources/js/plugins/angular/ui-bootstrap-tpls-0.13.0.min.js',
            dir + '/page/src/main/webapp/resources/js/plugins/bootstrap/js/bootstrap.min.js',
            dir + '/page/src/main/webapp/resources/js/plugins/angular/angular-flexslider.js',
            dir + '/page/src/main/webapp/resources/js/plugins/angular/ng-device-detector.min.js',
            dir + '/page/src/main/webapp/resources/js/plugins/angular/re-tree.min.js',
            dir + '/page/src/main/webapp/resources/js/routing.js',
            dir + '/page/src/main/webapp/resources/js/productFactory.js',
            //dir + '/page/src/main/webapp/resources/js/plugins/stripe/checkout.js',
            // dir + '/page/src/main/webapp/resources/js/main.js?v=1.0'
        ]
    },
    output: {
        path: dir + "/page/src/main/webapp/resources/build",
        filename: "[name].js"
    },
    module: {

        loaders: [
            {
                test: /\.css$/,
                use: ['style-loader', {
                    loader: 'css-loader',
                    options: {
                        minimize: true
                    }
                }],
            },
            {
                test: /\.(png|jpg|gif|woff|eot|woff2|ttf|svg)$/,
                loader: 'url-loader'
            },
            {
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
            },
            {
                test: /\.html$/,
                loader: 'html-loader',
                options: {
                    minimize: true,
                    collapseWhitespace: true,
                    removeAttributeQuotes: false,
                    removeComments: false
                }
            }
        ]
    },
    devServer: {
        port: 3001,
        contentBase: dir + "/page/src/main/webapp/resources/js",
        compress: false,
        historyApiFallback: {
            disableDotRule: true
        }
    },
    plugins: [
    	//new ModernizrWebpackPlugin(),
    	new webpack.ProvidePlugin({
           $: "jquery",
           jQuery: "jquery"
        }),
        new AngularCompilerPlugin({
			"sourceMap": true,
			"tsConfigPath": helpers.root('tsconfig.webpack.json'),
			"skipCodeGeneration": true,
			"compilerOptions": {}
		}),
    ]
};

if (argv.env === 'PROD') {
    module.exports.plugins.push(
        new webpack.optimize.UglifyJsPlugin({
            minimize: true,
            compress: {
                warnings: false
            }
        }));
}
