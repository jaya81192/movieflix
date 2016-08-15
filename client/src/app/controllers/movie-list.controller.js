(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('MovieListController', MovieListController);

    MovieListController.$inject = ['movieService', '$location'];

    function MovieListController(movieService, $location) {
        var movieListVm = this;

        movieListVm.logout = logout;

        init();
        function init() {
            console.log('in MovieListController');

            movieListVm.sorter = {
                sortBy: 'title',
                sortOrder: false
            };

            movieService.getMovies()
                .then(function(data) {
                    movieListVm.movies = data;
                })
                .catch(function(error) {
                    console.log(error);
                });
        }

        function logout(){
            userglobalid=null;
            $location.path('/login');
        }
    }
})();