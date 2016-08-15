(function() {
    'use strict';
    angular
        .module('movieflix')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q'];

    function movieService($http, $q) {
        var self = this;

        self.getMovies = getMovies;
        self.getMovie = getMovie;

        function getMovies() {
            return $http.get('http://localhost:8080/movieflix-server/api/movies/')
                .then(successFn, errorFn);
        }

        function getMovie(id) {
            return $http.get('http://localhost:8080/movieflix-server/api/movies/' + id)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data; //RESOLVE
        }

        function errorFn(response) {
            return $q.reject(error.status); //REJECT
        }
    }
})();