var userglobalid;
(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['userService', '$location'];

    function LoginController(userService, $location) {
        var loginVm = this;

        loginVm.addUser = addUser;
        loginVm.login = login;
        init();


        function init() {
            console.log('in LoginController');
        }

        function login(){
            userService
                .getUserByUsername(loginVm.checkUser.username)
                .then(function(data) {
                    loginVm.currentUser = data;
                    if(loginVm.currentUser.password == loginVm.checkUser.password) {
                        loginVm.currentUser.password="";
                        loginVm.checkUser.password="";
                        userglobalid = loginVm.currentUser.user.id;
                        $location.path('/movie-list');
                    }
                    else {
                        alert("Incorrect password");
                    }
                }, function(error) {
                    console.log(error);
                });
        }

        function addUser() {
            userService
                .createUser(loginVm.newUser)
                .then(function(data) {
                    loginVm.newUser.password ="";
                    $location.path('/movie-list');
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();