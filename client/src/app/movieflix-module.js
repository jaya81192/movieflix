(function() {
    'use strict';

    angular
        .module('movieflix', ['ngMessages', 'ngRoute'])
        .config(moduleConfig)
        .run(moduleRun);

    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/movie-list', {
                templateUrl: 'app/views/movie-list.tmpl.html',
                controller: 'MovieListController',
                controllerAs: 'movieListVm'
            })
            .when('/movie-detail/:id', {
                templateUrl: 'app/views/movie-detail.tmpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieVm'
            })
            .when('/login', {
                templateUrl: 'app/views/login-signup.tmpl.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'
            })
            .when('/rating/:id', {
                templateUrl: 'app/views/movie-rating.tmpl.html',
                controller: 'RatingController',
                controllerAs: 'ratingVm'
            })
            .otherwise({
                redirectTo: '/login'
            });
    }
    moduleRun.$inject = [];
    function moduleRun() {
        console.log('App Started');
    }
})();