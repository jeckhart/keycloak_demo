(function() {
    'use strict';

    angular.element(document).ready(function () {
        var keycloakAuth = new Keycloak('keycloak.json');

        keycloakAuth.init({ onLoad: 'check-sso' }).success(function () {
            angular
                .module('cortex')
                .factory('Auth', function() {
                    return keycloakAuth;
                });
            angular.bootstrap(document, ["cortex"]);
        }).error(function () {
                window.location.reload();
            });

    });

    angular
        .module('cortex')
        .run(['$rootScope', '$location', 'Auth', runBlock]);

    /** @ngInject */
    function runBlock($rootScope, $location, Auth) {
        $rootScope.$on( "event:auth-loginRequired", function() {
            Auth.login();
        });
    }


})();
