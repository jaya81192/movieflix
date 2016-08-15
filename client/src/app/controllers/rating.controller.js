(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('RatingController', RatingController);

    RatingController.$inject = ['ratingService', '$location', '$routeParams'];


    function RatingController(ratingService, $location, $routeParams) {
        var ratingVm = this;

        ratingVm.logout = logout;
        ratingVm.movielist = movielist;
        ratingVm.rate = rate;

        ratingVm.addRating = addRating;
        ratingVm.getRating = getRating;


        ratingVm.hideParam = false;
        ratingVm.showParam = true;


        init();
        function init() {
            console.log('in RatingController');
        }

        function getRating(){
            ratingService
                .getRating(userglobalid,$routeParams.id)
                .then(function (data) {
                    ratingVm.foundData = data;
                    ratingVm.hideParam = false;
                    ratingVm.showParam = false;
                },
                function (error) {
                    ratingVm.hideParam = true;
                    ratingVm.showParam = true;

                });
        }

        function rate(){
            var user = {};
            user.id = userglobalid;
            var movie = {};
            movie.id = $routeParams.id;
            ratingVm.rating.user = user;
            ratingVm.rating.movie = movie;
            console.log(ratingVm.rating);
            JSON.stringify(ratingVm.rating)

            addRating();
        }

        function addRating() {
            ratingService
                .createRating(ratingVm.rating)
                .then(function(data) {
                    $location.path('/movie-list');
                }, function(error) {
                    console.log(error);
                })
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