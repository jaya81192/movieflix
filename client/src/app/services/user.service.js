(function() {
    'use strict';

    angular
        .module('movieflix')
        .service('userService', userService);

    userService.$inject = ['$http', '$q'];

    function userService($http, $q) {
        var self = this;

        self.getUsers = getUsers;
        self.getUser = getUser;
        self.getUserByUsername = getUserByUsername;
        self.createUser = createUser;

        function getUsers() {
            return $http.get('http://localhost:8080/movieflix-server/api/login/')
                .then(successFn, errorFn);
        }

        function getUser(id) {
            return $http.get('http://localhost:8080/movieflix-server/api/login/' + id)
                .then(successFn, errorFn);
        }

        function getUserByUsername(username) {
            return $http.get('http://localhost:8080/movieflix-server/api/login/' + username)
                .then(successFn, errorFn);
        }

        function createUser(user) {
            return $http.post('http://localhost:8080/movieflix-server/api/login/', user)
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