(function() {
    'use strict';

    angular
        .module('movieflix')
        .service('ratingService', ratingService);

    ratingService.$inject = ['$http', '$q'];

    function ratingService($http, $q) {
        var self = this;

        self.getRating = getRating;
        self.createRating = createRating;

        function getRating(userid, movieid) {
            return $http.get('http://localhost:8080/movieflix-server/api/userRatings/'+userid+'&'+movieid)
                .then(successFn, errorFn);
        }

        function createRating(rating){
            return $http.post('http://localhost:8080/movieflix-server/api/userRatings/', rating)
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