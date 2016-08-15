(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams', '$location'];

    function MovieDetailController(movieService, $routeParams, $location) {
        var movieVm = this;

        init();

        movieVm.logout = logout;
        movieVm.movielist = movielist;

        function init() {
            movieService
                .getMovie($routeParams.id)
                .then(function(data) {
                    console.log(data);
                    movieVm.movie = data;
                }, function(error) {
                    console.log(error);
                });
        }

        function logout(){
            userglobalid=null;
            $location.path('/login');
        }

        function movielist(){
            $location.path('/movie-list');
        }
    }
})();