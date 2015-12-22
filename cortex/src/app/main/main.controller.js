(function() {
    'use strict';

    angular
        .module('cortex')
        .controller('MainController', ['Auth', '$scope', MainController]);

    /** @ngInject */
    function MainController(Auth, $scope) {
        $scope.logout = Auth.logout;

        $scope.isLoggedIn = function() {
            return Auth.authenticated;
        };
    }
})();
